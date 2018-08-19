package com.byrcegao.windowmanagertest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

public class SecondActivity extends Activity {
  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_second_main);

    findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        Intent intent = new Intent(SecondActivity.this, SecondActivity.class);
        startActivity(intent);
      }
    });
  }
}
