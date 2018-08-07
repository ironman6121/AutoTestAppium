package com.ironman.autotestappium;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * create by ironman 2018/8/7
 */
public class MainActivity extends AppCompatActivity {
    private TextView tvCase1;

    private TextView tvJump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvCase1 = findViewById(R.id.tvCase1);
        tvCase1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.tvCase1:
                        Intent case1Intent = new Intent(MainActivity.this, Case1Activity.class);
                        startActivity(case1Intent);
                        break;
                }
            }
        });

        tvJump = findViewById(R.id.tvJump);
        tvJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWechatApi();
            }
        });
    }

    /**
     * 跳转到微信
     */
    private void getWechatApi() {
        try {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            ComponentName cmp = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI");
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setComponent(cmp);
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
        }
    }
}
