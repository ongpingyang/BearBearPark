package com.example.pingyangong.bearbearpark;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;

public class AddTimeFragment extends Fragment implements View.OnClickListener {
    private NumberPicker hrPicker = null;
    private NumberPicker minPicker = null;
    DatabaseHelper myDB;

    public AddTimeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_addtime,container,false);

        hrPicker = (NumberPicker)v.findViewById(R.id.hourPicker);
        hrPicker.setMaxValue(23);
        hrPicker.setMinValue(0);
        hrPicker.setWrapSelectorWheel(true);

        minPicker = (NumberPicker)v.findViewById(R.id.minutePicker);
        minPicker.setMaxValue(59);
        minPicker.setMinValue(0);
        minPicker.setWrapSelectorWheel(true);


        Button btnAddTime = (Button)v.findViewById(R.id.addtime);
        btnAddTime.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.addtime){
            Toast.makeText(getActivity(),R.string.success_toast, Toast.LENGTH_SHORT).show();
        }
    }
}