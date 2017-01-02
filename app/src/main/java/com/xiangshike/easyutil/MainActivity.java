package com.xiangshike.easyutil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.xiangshike.easyuti.ToastUtils;
import com.xiangshike.easyuti.Util;
import com.xiangshike.easyuti.ViewUtis;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ToastUtils.showToast(this, "Hello World");
        ViewUtis.find(this, R.id.hello);
        Util.isEmulator(this);
    }
}
