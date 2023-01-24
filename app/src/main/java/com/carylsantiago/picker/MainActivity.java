package com.carylsantiago.picker;

import androidx.appcompat.app.AppCompatActivity;


import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;

import android.app.DatePickerDialog;
import android.app.AlertDialog;

import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Button btnPickDate, datebtn, timebtm;
    private TextView txtDate, tvTime;
    private DatePickerDialog datePickerDialog;
    TimePickerDialog picker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPickDate = findViewById(R.id.button);
        txtDate = findViewById(R.id.textview);

        datebtn = findViewById(R.id.dtPickerButton);
        initDatePicker();

        timebtm = findViewById(R.id.buttonTime);
        tvTime = findViewById(R.id.textviewTime);
    }

    //TIME PICKER
    public void onClickTime(View view)
    {
        final Calendar cal=Calendar.getInstance();
        int hour=cal.get(Calendar.HOUR_OF_DAY);
        int min=cal.get(Calendar.MINUTE);

        picker = new TimePickerDialog(MainActivity.this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tvTime.setText(hourOfDay+":"+ minute);

                    }
                }, hour,min,false);
        picker.show();

    }



    //DATE PICKER SPINNER
    private void initDatePicker()
    {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month=month+1;
                String date=makeDateString(day, month, year);
                datebtn.setText(date);
                txtDate.setText(date);
            }
        };
        final Calendar cal = Calendar.getInstance();

        int year = cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH);
        int day=cal.get(Calendar.DAY_OF_MONTH);
        int style = AlertDialog.THEME_HOLO_LIGHT;
        datePickerDialog= new DatePickerDialog(this, style, dateSetListener, year, month, day);
    }
    private String makeDateString(int day, int month, int year){
        return getMonthFormat(month) + " " + day + " " + year;
    }
    private String getMonthFormat(int month)
    {
        if (month==1)
            return "JAN";
        if (month==2)
            return "FEB";
        if (month==3)
            return "MAR";
        if (month==4)
            return "APR";
        if (month==5)
            return "MAY";
        if (month==6)
            return "JUN";
        if (month==7)
            return "JUL";
        if (month==8)
            return "AUG";
        if (month==9)
            return "SEP";
        if (month==10)
            return "OCT";
        if (month==11)
            return "NOV";
        if (month==12)
            return "DEC";
        return "JAN";
    }
    public void onDatePickerz(View view)
    {
        datePickerDialog.show();
    }

            public void onClickDate(View view){
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int monthofyear, int dayofmonth) {
                    txtDate.setText(dayofmonth + " - " + (monthofyear+1) + " - " + year);
                }
            },
                    year, month, day
            );
            datePickerDialog.show();
        }

}