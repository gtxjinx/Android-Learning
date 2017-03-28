package com.example.jinx.file;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity
{
    private TextView tv;
    private EditText et;
    private Button write;
    private Button read;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv= (TextView) findViewById(R.id.tv);
        et= (EditText) findViewById(R.id.et);
        read= (Button) findViewById(R.id.bt_read);
        write= (Button) findViewById(R.id.bt_write);
        write.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String text=et.getText().toString();
                WriteText(text);
            }
        });
        read.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String text=Read();
                tv.setText(text);
            }
        });

//        File file=new File("/mmt/sdcard/test");
//        if(!file.exists())
//        {
//            Toast.makeText(MainActivity.this,"good!",Toast.LENGTH_SHORT).show();
//            try
//            {
//                file.createNewFile();
//            } catch (IOException e)
//            {
//                e.printStackTrace();
//            }
//        }
//        else
//        {
//            Toast.makeText(MainActivity.this,"good!",Toast.LENGTH_SHORT).show();
//        }
//
//        File file1 =this.getFilesDir();//获取当前程序默认的数据存储目录
//        Log.d("Jinx",file1.toString());
//        File file2 =this.getCacheDir(); //默认的缓存文件存储位置
//        Log.d("Jinx",file2.toString());
//        File file3=this.getDir("test",MODE_PRIVATE);    //在存储目录下创建该文件
//        Log.d("Jinx",file3.toString());
//        File file4=this.getExternalFilesDir(Environment.DIRECTORY_MUSIC);   //获取外部存储文件
//        Log.d("Jinx",file4.toString());
//        File file5=this.getExternalCacheDir();  //获取外部缓存文件
//        Log.d("Jinx",file5.toString());
    }

    private void WriteText(String text)
    {
        try
        {
            FileOutputStream fos=openFileOutput("a.txt",MODE_APPEND);   //获取FileOutputStream对象
            fos.write(text.getBytes()); //写入字节
            fos.close();    //关闭文件流
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private String Read()
    {
        String text=null;
        try
        {
            FileInputStream fis=openFileInput("a.txt"); //获取FileInputStream对象
            //ByteArrayOutputStream来存放获取到的数据信息
            ByteArrayOutputStream baos=new ByteArrayOutputStream();

            byte [] buffer=new byte[1024];  //创建byte数组，分多次获取数据
            int len=0;
            while ((len=fis.read(buffer))!=-1)  //通过FileInputStream的read方法来读取信息
            {
                baos.write(buffer,0,len);   //ByteArrayOutputStream的write方法来写入读到的数据
            }
            text=baos.toString();
            fis.close();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return text;
    }

}
