package com.ironman.autotestappium;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * create by ironman 2018/8/7
 */
public class Case1Activity extends AppCompatActivity {

    private RadioGroup mRadioGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private TextView tvFavoriteFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case1_view);
        initView();
        iniListener();
    }

    private void iniListener() {
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb1:
                        tvFavoriteFood.setText(rb1.getText());
                        tvFavoriteFood.setTextColor(getResources().getColor(R.color.red_fa3649));
                        break;
                    case R.id.rb2:
                        tvFavoriteFood.setText(rb2.getText());
                        tvFavoriteFood.setTextColor(getResources().getColor(R.color.red_fa3649));
                        break;
                    case R.id.rb3:
                        tvFavoriteFood.setText(rb3.getText());
                        tvFavoriteFood.setTextColor(getResources().getColor(R.color.red_fa3649));
                        break;
                    case R.id.rb4:
                        tvFavoriteFood.setText(rb4.getText());
                        tvFavoriteFood.setTextColor(getResources().getColor(R.color.green_1cce18));
                        break;

                }
            }
        });
    }

    private void initView() {
        mRadioGroup = findViewById(R.id.mRadioGroup);
        tvFavoriteFood = findViewById(R.id.tvFavoriteFood);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);
    }
}
