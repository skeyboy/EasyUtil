package com.xiangshike.easyutil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xiangshike.easyuti.ToastUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ToastUtils.showToast(this, "Hello World");
    }
}
