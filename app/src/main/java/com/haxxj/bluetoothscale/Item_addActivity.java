package com.haxxj.bluetoothscale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.haxxj.bluetoothscale.DBUtils.DataBaseUtils;
import com.haxxj.bluetoothscale.DBUtils.DbBaseDAO;
import com.haxxj.bluetoothscale.DBUtils.Item_info;
import com.haxxj.bluetoothscale.greendao.Item_infoDao;

import java.text.SimpleDateFormat;

public class Item_addActivity extends AppCompatActivity {
    private TextView btn_save,btn_back;
    private EditText item_id,item_code,item_name,item_unit,item_spection,item_counting_base_number,item_expiration_date,item_sn,item_step_number,item_batch_number;
    private EditText item_GB,item_product_code,item_price,item_discount,item_member_price,item_set_number,item_upper,item_downward,item_bill_id,item_up_bill_id;
    private EditText item_down_bill_id,item_label_id,item_up_lable_id,item_down_lable_id,item_remark,item_explain;
    private EditText item_custom1,item_custom2,item_custom3,item_custom4,item_custom5;
    private String id;//用于存放从上一界面传送过来的商品主ID
    private Long pid;//根据不同情况给Pimid赋值
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_add);
        init();
    }

    private void init() {
        item_id = findViewById(R.id.item_id);
        item_code = findViewById(R.id.item_code);
        item_name = findViewById(R.id.item_name);
        item_unit = findViewById(R.id.item_unit);
        item_spection = findViewById(R.id.item_spection);
        item_counting_base_number = findViewById(R.id.item_counting_base_number);
        item_expiration_date = findViewById(R.id.item_expiration_date);
        item_sn = findViewById(R.id.item_sn);
        item_step_number = findViewById(R.id.item_step_number);
        item_batch_number = findViewById(R.id.item_batch_number);
        item_GB = findViewById(R.id.item_GB);
        item_product_code = findViewById(R.id.item_product_code);
        item_price = findViewById(R.id.item_price);
        item_discount = findViewById(R.id.item_discount);
        item_member_price = findViewById(R.id.item_member_price);
        item_set_number = findViewById(R.id.item_set_number);
        item_upper = findViewById(R.id.item_upper);
        item_downward = findViewById(R.id.item_downward);
        item_bill_id = findViewById(R.id.item_bill_id);
        item_up_bill_id = findViewById(R.id.item_up_bill_id);
        item_down_bill_id = findViewById(R.id.item_down_bill_id);
        item_label_id = findViewById(R.id.item_label_id);
        item_up_lable_id = findViewById(R.id.item_up_label_id);
        item_down_lable_id = findViewById(R.id.item_down_label_id);
        item_remark = findViewById(R.id.item_remark);
        item_explain = findViewById(R.id.item_explain);
        item_custom1 = findViewById(R.id.item_custom1);
        item_custom2 = findViewById(R.id.item_custom2);
        item_custom3 = findViewById(R.id.item_custom3);
        item_custom4 = findViewById(R.id.item_custom4);
        item_custom5 = findViewById(R.id.item_custom5);
        btn_back = findViewById(R.id.back_btn);
        btn_save = findViewById(R.id.save_btn);
        Intent intent = getIntent();
        id = intent.getStringExtra("Primid");
        if ("-1".equals(id)){
            pid = null;

        } else {
            pid = Long.valueOf(id);
            Item_info item_info = (Item_info) DataBaseUtils.getDaoSession().getItem_infoDao().queryBuilder().where(Item_infoDao.Properties.Primid.eq(pid)).unique();
            item_id.setText(item_info.getItem_id());
            item_code.setText(item_info.getItem_code());
            item_name.setText(item_info.getItem_name());
            item_unit.setText(item_info.getItem_unit());
            item_spection.setText(item_info.getItem_spection());
            item_counting_base_number.setText(String.valueOf(item_info.getItem_counting_base_number()));
            item_expiration_date.setText(item_info.getItem_expiration_date());
            item_sn.setText(String.valueOf(item_info.getItem_sn()));
            item_step_number.setText(String.valueOf(item_info.getItem_step_number()));
            item_batch_number.setText(item_info.getItem_batch_number());
            item_GB.setText(item_info.getItem_GB());
            item_product_code.setText(item_info.getItem_product_code());
            item_price.setText(String.valueOf(item_info.getItem_price()));
            item_discount.setText(String.valueOf(item_info.getItem_discount()));
            item_member_price.setText(String.valueOf(item_info.getItem_member_price()));
            item_set_number.setText(String.valueOf(item_info.getItem_set_number()));
            item_upper.setText(String.valueOf(item_info.getItem_upper()));
            item_downward.setText(String.valueOf(item_info.getItem_downward()));
            item_bill_id.setText(item_info.getItem_bill_id());
            item_up_bill_id.setText(item_info.getItem_up_bill_id());
            item_down_bill_id.setText(item_info.getItem_down_bill_id());
            item_label_id.setText(item_info.getItem_label_id());
            item_up_lable_id.setText(item_info.getItem_up_label_id());
            item_down_lable_id.setText(item_info.getItem_down_label_id());
            item_remark.setText(item_info.getItem_remark());
            item_explain.setText(item_info.getItem_explain());
            item_custom1.setText(item_info.getItem_custom1());
            item_custom2.setText(item_info.getItem_custom2());
            item_custom3.setText(item_info.getItem_custom3());
            item_custom4.setText(item_info.getItem_custom4());
            item_custom5.setText(item_info.getItem_custom5());
        }
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
                if (item_id.getText().toString().trim().equals("")){
                    Toast.makeText(Item_addActivity.this, "产品编号不能为空", Toast.LENGTH_SHORT).show();
                    item_id.setFocusable(true);
                    item_id.requestFocus();
                    item_id.setFocusableInTouchMode(true);
                    item_id.requestFocusFromTouch();
                    return;
                }
                if (item_name.getText().toString().trim().equals("")){
                    Toast.makeText(Item_addActivity.this, "产品名称不能为空", Toast.LENGTH_SHORT).show();
                    item_name.setFocusable(true);
                    item_name.requestFocus();
                    item_name.setFocusableInTouchMode(true);
                    item_name.requestFocusFromTouch();
                    return;
                }
                if (item_unit.getText().toString().trim().equals("")){
                    Toast.makeText(Item_addActivity.this, "单位不能为空", Toast.LENGTH_SHORT).show();
                    item_unit.setFocusable(true);
                    item_unit.requestFocus();
                    item_unit.setFocusableInTouchMode(true);
                    item_unit.requestFocusFromTouch();
                    return;
                }

                if (item_price.getText().toString().trim().equals("")){
                    Toast.makeText(Item_addActivity.this, "产品价格为空", Toast.LENGTH_SHORT).show();
                    item_price.setText("0.00");
                   // return;
                }
                if (item_counting_base_number.getText().toString().trim().equals("")){
                    Toast.makeText(Item_addActivity.this, "计数基数为空", Toast.LENGTH_SHORT).show();
                    item_counting_base_number.setText("1");
                   // return;
                }
                if (item_sn.getText().toString().trim().equals("")){
                    Toast.makeText(Item_addActivity.this, "流水号为空", Toast.LENGTH_SHORT).show();
                    item_sn.setText("1");
                  //  return;
                }
                if (item_step_number.getText().toString().trim().equals("")){
                    Toast.makeText(Item_addActivity.this, "增长步长为空", Toast.LENGTH_SHORT).show();
                    item_step_number.setText("1");
                   // return;
                }
                if (item_discount.getText().toString().trim().equals("")){
                    Toast.makeText(Item_addActivity.this, "产品折扣为空", Toast.LENGTH_SHORT).show();
                    item_discount.setText("1");
                  //  return;
                }
                if (item_member_price.getText().toString().trim().equals("")){
                    item_member_price.setText(item_price.getText().toString());
                }
                if (item_set_number.getText().toString().trim().equals("")){
                    Toast.makeText(Item_addActivity.this, "预设值为空", Toast.LENGTH_SHORT).show();
                    item_set_number.setText("0");
                  //  return;
                }
                if (item_upper.getText().toString().trim().equals("")){
                    Toast.makeText(Item_addActivity.this, "上允差为空", Toast.LENGTH_SHORT).show();
                    item_upper.setText("0");
                 //   return;
                }
                if (item_downward.getText().toString().trim().equals("")){
                    Toast.makeText(Item_addActivity.this, "下允差为空", Toast.LENGTH_SHORT).show();
                    item_downward.setText("0");
                  //  return;
                }


                SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                String date = sDateFormat.format(new java.util.Date());
                Item_info item_info = new Item_info(pid,item_id.getText().toString(),item_code.getText().toString(),item_name.getText().toString(),item_unit.getText().toString(),item_spection.getText().toString(),"计重",Integer.valueOf(item_counting_base_number.getText().toString()),item_expiration_date.getText().toString(),Integer.valueOf(item_sn.getText().toString()),Integer.valueOf(item_step_number.getText().toString()),item_batch_number.getText().toString(),item_GB.getText().toString(),item_product_code.getText().toString(),Double.valueOf(item_price.getText().toString()),Double.valueOf(item_discount.getText().toString()),Double.valueOf(item_member_price.getText().toString()),Double.valueOf(item_set_number.getText().toString()),Double.valueOf(item_upper.getText().toString()),Double.valueOf(item_downward.getText().toString()),"稳定",item_bill_id.getText().toString(),item_up_bill_id.getText().toString(),item_down_bill_id.getText().toString(),item_label_id.getText().toString(),item_up_lable_id.getText().toString(),item_down_lable_id.getText().toString(),item_remark.getText().toString(),item_explain.getText().toString(),item_custom1.getText().toString(),item_custom2.getText().toString(),item_custom3.getText().toString(),item_custom4.getText().toString(),item_custom5.getText().toString(),date,date,null,0);
                DbBaseDAO.insert_item_info(item_info);
                Toast.makeText(Item_addActivity.this, "添加成功！", Toast.LENGTH_SHORT).show();

            }

        });
    }
}