package sg.edu.rp.c346.id22011117.demotimeanddateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    DatePicker dp;
    TimePicker tp;
    Button btnDisplayDate;
    Button btnDisplayTime;
    TextView tvDisplay;
    Button btnReset;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnDisplayDate = findViewById(R.id.buttonDisplayDate);
        btnDisplayTime = findViewById(R.id.buttonDisplayTime);
        tvDisplay = findViewById(R.id.textViewDisplay);
        btnReset = findViewById(R.id.buttonReset);


        tp.setIs24HourView(true);
        btnDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour = tp.getCurrentHour();
                int min = tp.getCurrentMinute();

                // Format the time as "H:m"
                String formattedTime = String.format(Locale.getDefault(), "%02d:%02d", hour, min);

                // Update the text view with the formatted time
                tvDisplay.setText("Time is " + formattedTime);

            }
        });
        btnDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int year = dp.getYear();  // Get the selected year from the DatePicker
                int month = dp.getMonth();  // Get the selected month from the DatePicker
                int monthDay = dp.getDayOfMonth();  // Get the selected day from the DatePicker

                // Format the date as "yyyy-MM-dd" or any other desired format
                String formattedDate = String.format(Locale.getDefault(), "%02d/%02d/%04d", monthDay, month + 1, year);

                // Update the text view with the formatted date
                tvDisplay.setText("Date is " + formattedDate);
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Set TimePicker to 12AM
                tp.setCurrentHour(0);
                tp.setCurrentMinute(0);

                // Set DatePicker to January 1, 2020
                dp.updateDate(2020, 0, 1);


            }
        });
    }}




