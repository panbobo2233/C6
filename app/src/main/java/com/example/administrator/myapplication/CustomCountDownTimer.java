package com.example.administrator.myapplication;


import android.os.Handler;

/**
 * Created by Administrator on 2019/11/9.
 */

public class CustomCountDownTimer implements Runnable{
    private int time;
    private int countDowntime;
    private boolean isRun;
    private final ICountDownHandler countDownHandler;
    private final Handler handler;
    //1、实时回调这个时候是什么时间，倒计时是几秒 观察者设计模式
    //2、支持动态传入总时间
    //3、每过一秒总秒数减一
    //4、总时间倒计时为0时，要回调完成的状态

    //小技巧：抽取成员变量： ctrl+alt+f

    public CustomCountDownTimer(int time,ICountDownHandler countDownHandler){
        handler  = new Handler();
        this.time = time;
        this.countDowntime = time;
        this.countDownHandler = countDownHandler;
    }

    //开启倒计时
    public void start(){
        isRun = true;
        handler.post(this);
    }

    //跳出循环 终止
    public void cancel(){
        isRun = false;
        handler.removeCallbacks(this);
    }

    //实现的具体逻辑
    @Override
    public void run() {
        if (isRun){
            if (countDownHandler !=null){
                countDownHandler.onTicker(countDowntime);
            }
            if (countDowntime == 0){
                if (countDownHandler!=null){
                    countDownHandler.onFinish();
                }
            }else {
                countDowntime = time--;
                handler.postDelayed(this,1000);
            }
        }
    }

    //观察者回调接口 （IOC数据回调）
    public interface ICountDownHandler{
        //倒计时回调
        void onTicker(int time);

        //c完成时回调
        void onFinish();
    }

}
