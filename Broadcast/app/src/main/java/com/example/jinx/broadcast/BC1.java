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
public class BC1 extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        String text=intent.getStringExtra("test");
        Toast.makeText(context,"BC1"+text,Toast.LENGTH_SHORT).show();
        //abortBroadcast();
        Bundle bundle =new Bundle();
        bundle.putString("test","修改");
        setResultExtras(bundle);
    }
}
