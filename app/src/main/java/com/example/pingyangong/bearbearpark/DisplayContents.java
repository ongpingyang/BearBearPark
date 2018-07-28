package com.example.pingyangong.bearbearpark;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayContents extends AppCompatActivity {

    DatabaseHelper myDB;

    @Override
    protected void onCreate (@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);

        TextView textView = (TextView) findViewById(R.id.hourdisplay);
        TextView textView1 = (TextView) findViewById(R.id.minutedisplay);

        myDB = new DatabaseHelper(this);

        Cursor data = myDB.getListContents();

        if (data.getCount() != 0){
            textView.setText(data.getString(1));
            textView1.setText(data.getString(2));
        }
    }
}
