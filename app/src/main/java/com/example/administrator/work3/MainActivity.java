package com.example.administrator.work3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        tv1=new TextView(this);
        tv1.setText("");
        setContentView(tv1);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_HOME:SetMessage("按下Home键");break;
            case KeyEvent.KEYCODE_MENU:SetMessage("按下Menu键");break;
            case KeyEvent.KEYCODE_BACK:SetMessage("按下Back键");break;
            case KeyEvent.KEYCODE_VOLUME_UP:SetMessage("加大音量");break;
            case KeyEvent.KEYCODE_VOLUME_DOWN:SetMessage("减小音量");break;
            default:SetMessage("按下了："+keyCode);
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_HOME:SetMessage("放开Home键");break;
            case KeyEvent.KEYCODE_MENU:SetMessage("放开Menu键");break;
            case KeyEvent.KEYCODE_BACK:SetMessage("放开Back键");break;
            case KeyEvent.KEYCODE_VOLUME_UP:SetMessage("加大音量");break;
            case KeyEvent.KEYCODE_VOLUME_DOWN:SetMessage("减小音量");break;
            default:SetMessage("按下了："+keyCode);
        }

        return super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        SetMessage("长按中");
        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        SetMessage("返回");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int act=event.getAction();
        if(act==MotionEvent.ACTION_CANCEL||act==MotionEvent.ACTION_DOWN||act==MotionEvent.ACTION_MOVE){
            return false;
        }
        String x=String.valueOf(event.getX());
        String y=String.valueOf(event.getY());
        SetMessage("点中（"+x+","+y+")");
        return super.onTouchEvent(event);
    }
    public void SetMessage(String str){
        String old1=tv1.getText().toString();
        String new1=old1+"\n"+str;
        tv1.setText(new1);
    }
}
