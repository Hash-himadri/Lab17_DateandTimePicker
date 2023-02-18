package com.example.lab17_dateandtimepicker_d;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity
        implements DatePickerDialog.OnDateSetListener,
        TimePickerDialog.OnTimeSetListener {

    TextView tvLong, tvFormat1, tvformat2, tvFormat3, tvFormat4,
            tvFormat5, tvFormat6, tvFormat7;
    Button btnSelect;

    int day, month, year, hour, minute;
    int myDay, myMonth, myYear, myHour, myMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvLong = findViewById(R.id.tvLong);
        tvFormat1 = findViewById(R.id.tvFormat1);
        tvformat2 = findViewById(R.id.tvFormat2);
        tvFormat3 = findViewById(R.id.tvFormat3);
        tvFormat4 = findViewById(R.id.tvFormat4);
        tvFormat5 = findViewById(R.id.tvFormat5);
        tvFormat6 = findViewById(R.id.tvFormat6);
        tvFormat7 = findViewById(R.id.tvFormat7);

        btnSelect = findViewById(R.id.btnSelect);

        //in onCreate()
        Long dateValueIntLong = System.currentTimeMillis();
        tvLong.setText(dateValueIntLong.toString());

        String dateTime;
        Calendar calendar;
        java.text.SimpleDateFormat simpleDateFormat;

        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss aaa z");
        dateTime = simpleDateFormat.format(calendar.getTime()).toString();
        tvFormat1.setText(dateTime);


        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss aaa z");
        dateTime = simpleDateFormat.format(calendar.getTime()).toString();
        tvformat2.setText(dateTime);

        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss aaa z");
        dateTime = simpleDateFormat.format(calendar.getTime()).toString();
        tvFormat3.setText(dateTime);


        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("dd.LLL.yyyy HH:mm:ss aaa z");
        dateTime = simpleDateFormat.format(calendar.getTime()).toString();
        tvFormat4.setText(dateTime);


        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("dd.LLLL.yyyy HH:mm:ss aaa z");
        dateTime = simpleDateFormat.format(calendar.getTime()).toString();
        tvFormat5.setText(dateTime);


        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("E.LLLL.yyyy HH:mm:ss aaa z");
        dateTime = simpleDateFormat.format(calendar.getTime()).toString();
        tvFormat6.setText(dateTime);


        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("EEEE.LLLL.yyyy HH:mm:ss aaa z");
        dateTime = simpleDateFormat.format(calendar.getTime()).toString();
        tvFormat7.setText(dateTime);


        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog =
                        new DatePickerDialog(MainActivity.this,
                                MainActivity.this, year, month, day);
                datePickerDialog.show();
            }
        });

    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        myYear = year;
        myMonth = month+1;
        myDay = dayOfMonth;

        Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR);
        minute = c.get((Calendar.MINUTE));
        TimePickerDialog timePickerDialog =
                new TimePickerDialog(MainActivity.this, MainActivity.this,
                        hour, minute, DateFormat.is24HourFormat(this));
        timePickerDialog.show();
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minuteofDay) {
        myHour = hourOfDay;
        myMinute = minuteofDay;
        String currDate = myDay+"\\"+myMonth+"\\"+myYear+"\\"+myHour+"\\"+myMinute;
        tvLong.setText(currDate);
    }
}