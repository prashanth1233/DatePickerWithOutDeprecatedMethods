package com.example.prasanth.datepickerwithoutdeprecated;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

public class DatePickerFragment extends DialogFragment{

    private int year,month,date;
    @RequiresApi(api = Build.VERSION_CODES.N)
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        Calendar calendar=Calendar.getInstance();
        year=calendar.get(Calendar.YEAR);
        month=calendar.get(Calendar.MONTH);
        date=calendar.get(Calendar.DATE);
        return new DatePickerDialog(getActivity(),(MainActivity)getActivity(),year,month,date);
    }
}
