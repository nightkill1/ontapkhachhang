package com.example.ulti;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;

import java.util.Calendar;

public class MydateDialog {
    Calendar calendar;
    OnMydateChangeListener onmydateChangeListener;
    Context context;

    public MydateDialog(Context context, OnMydateChangeListener onmydateChangeListener, Calendar calendar) {
        this.calendar = calendar;
        this.onmydateChangeListener = onmydateChangeListener;
        this.context = context;
    }

    public  void showDateDialog(){
        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set( year , month, dayOfMonth);
                onmydateChangeListener.dateUpdate(calendar);
            }
        };
        DatePickerDialog datePickerDialog = new DatePickerDialog(context, listener, calendar.get(calendar.YEAR),calendar.get(calendar.MONTH),calendar.get(calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }
    public static interface OnMydateChangeListener{
        public void dateUpdate(Calendar newDate);
    }
}
