package com.xiangshike.easyuti;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
public class MainActivity extends Activity {
    TextView helloView;
    @NullOrFormate(notNull = "Jack")
    String jack;
    @NullOrFormate(timeFormate = "HH:mm", isTime = true)
    String timeStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InjectViewParser.inject(this);
        NullOrFormateParser.check(this);

    }
}
