package com.example.pingyangong.bearbearpark;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScanActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    DatabaseHelper myDB;
    private ZXingScannerView zXingScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_scan);

    }

    public void scanLat(View view) {
        zXingScannerView = new ZXingScannerView(getApplicationContext());
        setContentView(zXingScannerView);
        zXingScannerView.setResultHandler(this);
        zXingScannerView.startCamera();
    }

    public void scanLong(View view) {
        zXingScannerView = new ZXingScannerView(getApplicationContext());
        setContentView(zXingScannerView);
        zXingScannerView.setResultHandler(this);
        zXingScannerView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        zXingScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result result) {
        Toast.makeText(getApplicationContext(), result.getText(), Toast.LENGTH_SHORT).show();
        zXingScannerView.resumeCameraPreview(this);
        AddLat(result.getText());
        AddLong(result.getText());
    }

    public void AddLat (String newEntry1){
        boolean insertData = myDB.addLat(newEntry1);

        if (insertData==true){
            Toast.makeText(ScanActivity.this,"Successfully Entered Data!",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(ScanActivity.this,"Something went wrong :(.",Toast.LENGTH_LONG).show();
        }

    }

    public void AddLong (String newEntry1){
        boolean insertData = myDB.addLong(newEntry1);

        if (insertData==true){
            Toast.makeText(ScanActivity.this,"Successfully Entered Data!",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(ScanActivity.this,"Something went wrong :(.",Toast.LENGTH_LONG).show();
        }
    }
}
