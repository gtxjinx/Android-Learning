package com.example.administrator.service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private Button start;
    private Button stop;
    private Intent startintent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start= (Button) findViewById(R.id.start_bt);
        stop= (Button) findViewById(R.id.stop_bt);
    }

    public void doClick(View view)
    {
        switch (view.getId())
        {
            case R.id.start_bt:
                startintent=new Intent(MainActivity.this,StartService.class);
                startService(startintent);
                break;
            case R.id.stop_bt:
                stopService(startintent);
                break;
        }
    }
}
