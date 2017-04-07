package com.example.administrator.gesture;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Jinx on 2017/4/6 11:07.
 */

public class WeChatView extends ListView
{
    private GestureDetector gestureDetector;
    private onFlingListener monFlingListener;
    private Context context;

    class mGestureListener extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY)
        {
            if(e1.getX()-e2.getX()>50)
            {
                //monFlingListener.onFlingLeft();
                Toast.makeText(context,"left",Toast.LENGTH_LONG).show();
            }
            else if (e2.getX()-e1.getX()>50)
            {
                //monFlingListener.onFlingRight();
                Toast.makeText(context,"right",Toast.LENGTH_LONG).show();
            }
            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }
    public WeChatView(Context context)
    {
        super(context);
        this.context=context;
        gestureDetector=new GestureDetector(context,new mGestureListener());
        init();

    }

    public WeChatView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        this.context=context;
        gestureDetector=new GestureDetector(context,new mGestureListener());
        init();
    }

    public WeChatView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        this.context=context;
        gestureDetector=new GestureDetector(context,new mGestureListener());
        init();
    }

    public void setonFlingListener(onFlingListener monFlingListener)
    {
        this.monFlingListener = monFlingListener;
    }

    public interface onFlingListener
    {
        void onFlingRight();
        void onFlingLeft();
    }
    private void init()
    {
        this.setOnTouchListener(new OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                if(event!=null)
                gestureDetector.onTouchEvent(event);
                return true;
            }
        });
    }
}
