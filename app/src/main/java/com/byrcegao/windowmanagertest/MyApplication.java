package com.byrcegao.windowmanagertest;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class MyApplication extends Application {
  @Override public void onCreate() {
    super.onCreate();
    initLifyCycle();
  }

  private void initLifyCycle() {
    this.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
      @Override public void onActivityCreated(final Activity activity, Bundle bundle) {
        View view = LayoutInflater.from(activity)
            .inflate(R.layout.layout_window_alert, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.topMargin = 300;
        layoutParams.leftMargin = 0;

        view.setOnClickListener(new View.OnClickListener() {
          @Override public void onClick(View view) {
            Intent intent = new Intent(activity, MainActivity.class);
            intent.putExtra("fromBaidu", true);
            activity.startActivity(intent);
          }
        });
        ((FrameLayout) activity.getWindow().getDecorView()).addView(view, layoutParams);
      }

      @Override public void onActivityStarted(Activity activity) {

      }

      @Override public void onActivityResumed(Activity activity) {

      }

      @Override public void onActivityPaused(Activity activity) {

      }

      @Override public void onActivityStopped(Activity activity) {

      }

      @Override public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

      }

      @Override public void onActivityDestroyed(Activity activity) {

      }
    });
  }
}
