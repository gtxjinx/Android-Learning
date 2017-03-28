package com.example.jinx.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Jinx on 2017/3/28 20:48.
 * 邮箱：gtxmiracle@buaa.edu.cn
 */
public class BC2 extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        String text=intent.getStringExtra("test");
        Bundle bundle=getResultExtras(true);
        String s=bundle.getString("test");
        Toast.makeText(context,"BC2"+text+s,Toast.LENGTH_SHORT).show();

    }
}
