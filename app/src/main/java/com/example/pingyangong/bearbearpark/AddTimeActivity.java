package com.example.pingyangong.bearbearpark;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;

public class AddTimeActivity extends Activity implements View.OnClickListener {

    DatabaseHelper myDB;
    private NumberPicker hourpicker = null;
    private NumberPicker minutepicker = null;
    private Button btnAddTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hourpicker = (NumberPicker)findViewById(R.id.hourPicker);
        minutepicker = (NumberPicker)findViewById(R.id.minutePicker);
        btnAddTime = (Button)findViewById(R.id.addtime);

        hourpicker.setMinValue(0);
        hourpicker.setMaxValue(24);
        hourpicker.setWrapSelectorWheel(false);

        minutepicker.setMinValue(0);
        minutepicker.setMaxValue(60);
        minutepicker.setWrapSelectorWheel(false);

        hourpicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldVal, int newVal) {

            }
        });

        minutepicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldVal, int newVal) {

            }
        });

        btnAddTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour = hourpicker.getValue();
                int min = minutepicker.getValue();

                String strhour = Integer.toString(hour);
                String strmin = Integer.toString(min);

                AddTime (strhour,strmin);
            }
        });

    }

    public void AddTime (String newEntry1, String newEntry2){
        boolean insertData = myDB.addTime(newEntry1, newEntry2);

        if (insertData==true){
            Toast.makeText(AddTimeActivity.this,"Successfully Entered Data!",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(AddTimeActivity.this,"Something went wrong :(.",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View view) {

    }
}