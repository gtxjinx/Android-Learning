package com.example.jinx.broadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    private Button normal;
    private Button ordered;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        normal= (Button) findViewById(R.id.normal_bt);
        ordered= (Button) findViewById(R.id.order_bt);
        IntentFilter intentFilter = new IntentFilter("NORMAL");
        BC2 bc2 = new BC2();
        registerReceiver(bc2,intentFilter);
        normal.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent();
                intent.putExtra("test","普通广播");
                intent.setAction("NORMAL"); //设定广播的Action，用于过滤
                sendBroadcast(intent);
            }
        });
        ordered.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent();
                intent.putExtra("test","有序广播");
                intent.setAction("NORMAL"); //设定广播的Action，用于过滤
                sendOrderedBroadcast(intent,null);
            }
        });
    }
}
