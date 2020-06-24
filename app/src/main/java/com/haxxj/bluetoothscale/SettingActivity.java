package com.haxxj.bluetoothscale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.DefaultDatabaseErrorHandler;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.haxxj.bluetoothscale.Utils.ButtonDelayUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView btn_back;
    private GridView gv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initview();
    }

    private void initview() {
        //返回按钮
        btn_back = (TextView)findViewById(R.id.back_btn);
        //构建列表
        gv = (GridView) findViewById(R.id.gridView1);
        List<HashMap<String, Object>> gridSettingList = new ArrayList<HashMap<String, Object>>();

        HashMap<String, Object> gridItem = new HashMap<String, Object>();
        gridItem.put("listImage", R.drawable.s1);
        gridItem.put("listText", ("打印机设置" ));
        gridItem.put("itemNo", "0");
        gridSettingList.add(gridItem);

        HashMap<String, Object> gridItem1 = new HashMap<String, Object>();
        gridItem1.put("listImage", R.drawable.s2);
        gridItem1.put("listText", ("磅单设置" ));
        gridItem1.put("itemNo", "1");
        gridSettingList.add(gridItem1);

        HashMap<String, Object> gridItem2 = new HashMap<String, Object>();
        gridItem2.put("listImage", R.drawable.s2);
        gridItem2.put("listText", ("标签设置" ));
        gridItem2.put("itemNo", "2");
        gridSettingList.add(gridItem2);

        HashMap<String, Object> gridItem3 = new HashMap<String, Object>();
        gridItem3.put("listImage", R.drawable.s3);
        gridItem3.put("listText", ("电子秤蓝牙设置" ));
        gridItem3.put("itemNo", "3");
        gridSettingList.add(gridItem3);

        HashMap<String, Object> gridItem4 = new HashMap<String, Object>();
        gridItem4.put("listImage", R.drawable.s4);
        gridItem4.put("listText", ("电子秤通讯协议设置" ));
        gridItem4.put("itemNo", "4");
        gridSettingList.add(gridItem4);

        HashMap<String, Object> gridItem5 = new HashMap<String, Object>();
        gridItem5.put("listImage", R.drawable.s4);
        gridItem5.put("listText", ("商品PLU设置" ));
        gridItem5.put("itemNo", "5");
        gridSettingList.add(gridItem5);

        SimpleAdapter simpleAdapter_t = new SimpleAdapter(this,
                gridSettingList,
                R.layout.gridview_setting,
                new String[] { "listImage","listText" },
                new int[] {  R.id.imageview, R.id.textvew1 });
        // 指定适配器
        gv.setAdapter(simpleAdapter_t);
        //设定列数
        gv.setNumColumns(1);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (ButtonDelayUtils.isFastDoubleClick()) {//如果双击则不动作
                    return;
                }
                switch (position){
                    case 0:
                        Toast.makeText(SettingActivity.this, "打印机设置", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(SettingActivity.this, "磅单设置", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(SettingActivity.this, "标签设置", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(SettingActivity.this, "电子秤设置", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(SettingActivity.this, "通讯协议", Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Toast.makeText(SettingActivity.this, "商品PLU设置", Toast.LENGTH_SHORT).show();
                        Intent item_info_intent = new Intent(SettingActivity.this,Item_infoActivity.class);
                        startActivity(item_info_intent);
                        break;
                    default:
                        break;

                }

            }
        });
        btn_back.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (ButtonDelayUtils.isFastDoubleClick()) {//如果双击则不动作
            return;
        }
        switch (view.getId()) {
            case R.id.back_btn:
                // 返回主界面
                finish();
                break;
            default:
                break;
        }


    }
}
