package com.byrcegao.windowmanagertest;

import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    findViewById(R.id.btn_window).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        showWindow();
      }
    });

    findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
      }
    });
  }

  @Override protected void onNewIntent(Intent intent) {
    super.onNewIntent(intent);

    if (intent.getBooleanExtra("fromBaidu", false)) {
      finish();
    }
  }

  private void showWindow() {
    WindowManager.LayoutParams wmParamsDu = new WindowManager.LayoutParams();
    WindowManager windowManager = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
    if (Build.VERSION.SDK_INT > 24) {
      wmParamsDu.type = WindowManager.LayoutParams.TYPE_PHONE;
    } else {
      wmParamsDu.type = WindowManager.LayoutParams.TYPE_TOAST;
    }

    wmParamsDu.width = WindowManager.LayoutParams.WRAP_CONTENT;
    wmParamsDu.height = WindowManager.LayoutParams.WRAP_CONTENT;
    //初始化坐标
    wmParamsDu.x = 0;
    wmParamsDu.y = 800;
    //弹窗类型为系统Window
    //以左上角为基准
    wmParamsDu.gravity = Gravity.START | Gravity.TOP;
    wmParamsDu.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
            | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;;
    //如果不加,背景会是一片黑色。
    wmParamsDu.format = PixelFormat.RGBA_8888;

    View view = LayoutInflater.from(this).inflate(R.layout.layout_window_alert,
        null, false);
    windowManager.addView(view, wmParamsDu);
  }
}
