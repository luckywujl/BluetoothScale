package com.haxxj.bluetoothscale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.haxxj.bluetoothscale.DBUtils.DbBaseDAO;
import com.haxxj.bluetoothscale.DBUtils.Item_info;

import java.text.SimpleDateFormat;

public class Item_addActivity extends AppCompatActivity {
    private TextView btn_save,btn_back;
    private EditText item_id,item_code,item_name,item_unit,item_spection,item_counting_base_number,
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_add);
        init();
    }

    private void init() {
        btn_back = (TextView)findViewById(R.id.back_btn);
        btn_save = (TextView)findViewById(R.id.save_btn);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent item_info_intent = new Intent(Item_addActivity.this,Item_infoActivity.class);
                startActivity(item_info_intent);
                finish();
            }
        });
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                String date = sDateFormat.format(new java.util.Date());
                Item_info item_info = new Item_info(null,"01001","30504","土豆","千克","精品","计重",0,"7",0,1,"20200625","QB2006051","生产编号",2.60,0.75,2.40,2.50,0.5,0.5,"稳定","01","01","01","01","01","01","好吃得很","说明",null,null,null,null,null,date,date,null,0);
                DbBaseDAO.insert_item_info(item_info);
                Toast.makeText(Item_addActivity.this, "添加成功！", Toast.LENGTH_SHORT).show();

            }

        });
    }
}