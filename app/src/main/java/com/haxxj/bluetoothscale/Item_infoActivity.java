package com.haxxj.bluetoothscale;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.haxxj.bluetoothscale.DBUtils.DataBaseUtils;
import com.haxxj.bluetoothscale.DBUtils.DbBaseDAO;
import com.haxxj.bluetoothscale.DBUtils.Item_info;
import com.haxxj.bluetoothscale.greendao.Item_infoDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import adapter.Adapter;


public class Item_infoActivity extends AppCompatActivity implements Adapter.IonSlidingViewClickListener {
    private TextView btn_back,btn_add;  //返回,添加按钮
    private RecyclerView lRecyclerView;  //定义回收视图控件
    private Adapter lAdapter;  //定义适配器
    private List<HashMap<String,Object>> itemList = new ArrayList<HashMap<String,Object>>(); //定义数据集
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_info);
        init();
        getdata();
        setAdapter();
    }

    /**
     * 获取数据源
     */
    private void getdata() {
        itemList.clear();
        ArrayList<Item_info> item_info = (ArrayList<Item_info>) DataBaseUtils.getDaoSession().getItem_infoDao().queryBuilder().where(Item_infoDao.Properties.Item_status.eq(0)).orderAsc(Item_infoDao.Properties.Item_id).list();
        for (i = 0; i < item_info.size(); i++) {
            HashMap<String, Object> recycleItem = new HashMap<String, Object>();//定义一个哈西数组，用于存储一行记录
            recycleItem.put("_id", item_info.get(i).getPrimid());
            recycleItem.put("item_id", item_info.get(i).getItem_id());
            recycleItem.put("item_name", item_info.get(i).getItem_name());
            recycleItem.put("item_unit", item_info.get(i).getItem_unit());
            recycleItem.put("item_spection", item_info.get(i).getItem_spection());
            recycleItem.put("item_scale_model", item_info.get(i).getItem_scale_model());
            recycleItem.put("item_create_time", item_info.get(i).getItem_create_time());
            recycleItem.put("item_modify_time", item_info.get(i).getItem_modify_time());
            recycleItem.put("item_remark", item_info.get(i).getItem_remark());
            itemList.add(recycleItem);
        }
        //完成数据装载
        // Toast.makeText(context, "完成装载数据"+i, Toast.LENGTH_SHORT).show();

    }
    /**
     * 设置适配器方法
     */
    private void setAdapter() {
        //设置列表布局管理
        lRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //设置适配器
        lRecyclerView.setAdapter(lAdapter = new Adapter(this, (ArrayList<HashMap<String, Object>>) itemList));
        //设置列表中子项的动画
        //recyclerView.setItemAnimator(new DefaultItemAnimator());
        //adapter.setmIdeleteBtnClickListener(Item_infoActivity.this);


    }

    private void init() {
        lRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        btn_back = (TextView)findViewById(R.id.back_btn);
        btn_add = (TextView)findViewById(R.id.add_btn);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent add_intent = new Intent(Item_infoActivity.this,Item_addActivity.class);
                add_intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                add_intent.putExtra("Primid","-1");
                startActivity(add_intent);
                finish();

            }
        });
    }

    @Override
    public void onItemClick(View view, int position) {
        if (lAdapter.menuIsOpen()){
            lAdapter.closeMenu();
        }

    }

    @Override
    public void onDeleteBtnCilck(View view, int position) {
        deleteitem(position);
        lAdapter.removeData(position);


    }

    @Override
    public void onDetailBtnClick(View view, int position) {
        Intent detail_intent = new Intent(Item_infoActivity.this,Item_addActivity.class);
        detail_intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        detail_intent.putExtra("Primid", itemList.get(position).get("_id").toString());
        startActivity(detail_intent);
        Toast.makeText(this, "进入查看详情页", Toast.LENGTH_SHORT).show();

    }

    /**
     * 删除数据
     */
    private void deleteitem(int position) {
        Item_info item_info = DataBaseUtils.getDaoSession().getItem_infoDao().load((Long) itemList.get(position).get("_id"));
        item_info.setItem_status(1);
        DataBaseUtils.getDaoSession().getItem_infoDao().update(item_info);
    }

}