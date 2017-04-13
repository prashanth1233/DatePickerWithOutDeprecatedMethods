package com.example.prasanth.datepickerwithoutdeprecated;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, View.OnClickListener {


    private TextView birthDate, birthMonth, birthYear;
    private Button calenderShowingButton, dataClearButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calenderShowingButton = (Button) findViewById(R.id.dateButton);
        dataClearButton = (Button) findViewById(R.id.clearButton);
        birthDate = (TextView) findViewById(R.id.date);
        birthMonth = (TextView) findViewById(R.id.month);
        birthYear = (TextView) findViewById(R.id.year);
        dataClearButton.setOnClickListener(this);
        calenderShowingButton.setOnClickListener(this);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int date) {
        if (date < 10) {
            birthDate.setText(new StringBuilder().append("0" + date));
        } else {
            birthDate.setText(new StringBuilder().append(date));
        }
        if (month < 10) {
            birthMonth.setText(new StringBuilder().append("0" + ++month));
        } else {
            birthMonth.setText(new StringBuilder().append(++month));

        }
        birthYear.setText(new StringBuilder().append(year));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dateButton:
                DatePickerFragment datePickerFragment = new DatePickerFragment();
                datePickerFragment.show(getFragmentManager(), "datePicker");
                break;
            case R.id.clearButton:
                clearData();
        }

    }

    private void clearData() {
        birthDate.setText("00");
        birthMonth.setText("00");
        birthYear.setText("0000");
    }
}
