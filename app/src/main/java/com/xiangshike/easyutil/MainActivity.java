package com.xiangshike.easyutil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.xiangshike.easyuti.InjectView;
import com.xiangshike.easyuti.InjectViewParser;
import com.xiangshike.easyuti.ToastUtils;
import com.xiangshike.easyuti.Util;
import com.xiangshike.easyuti.ViewUtils;

public class MainActivity extends AppCompatActivity {
    @InjectView(id=R.id.hello)
    TextView helloView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InjectViewParser.inject(this);

        ToastUtils.showToast(this, "Hello World");
        ViewUtils.find(this, R.id.hello);
        Util.isEmulator(this);
        helloView.setText("InjectView");
    }
}
