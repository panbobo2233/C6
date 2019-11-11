package com.example.administrator.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

/**
 * Created by Administrator on 2019/11/9.
 */

public class FullScreenVideoView extends VideoView {
    //要求实现构造方法，选了前三个

    //主要用于直接new出来的对象
    public FullScreenVideoView(Context context) {
        super(context);
    }

    //用于xml文件中，支持自定义属性
    public FullScreenVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    //用于xml文件中，支持自定义属性，同样支持样式
    public FullScreenVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // widthMeasureSpec包含两个主要内容：1、测量模式 2、测量大小
        int width = getDefaultSize(0,widthMeasureSpec);
        int height = getDefaultSize(0,heightMeasureSpec);
        //直接不使用super的onmeasure里面的一系列的兼容性改动，直接全屏
        setMeasuredDimension(width,height);
        //看一下这个onmeasure的代码

//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
