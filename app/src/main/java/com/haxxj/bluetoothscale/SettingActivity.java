package com.haxxj.bluetoothscale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.haxxj.bluetoothscale.Utils.ButtonDelayUtils;

import java.util.UUID;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initview();
    }

    private void initview() {
        btn_back = (TextView)findViewById(R.id.back_btn);
        btn_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (ButtonDelayUtils.isFastDoubleClick()) {//如果双击则不动作
            return;
        }
        switch (view.getId()) {
            case R.id.back_btn:
                // 进入设置页面
                Intent mainintent = new Intent(SettingActivity.this, MainActivity.class);
                mainintent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(mainintent);
                finish();
                break;
            default:
                break;
        }


    }
}
