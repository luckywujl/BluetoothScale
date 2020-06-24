package com.haxxj.bluetoothscale.DBUtils;

import com.haxxj.bluetoothscale.greendao.Item_infoDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;

public class DbBaseDAO {
    //private static final String TAG = "DbBaseDao";

    /*
     * 插入
     * @param item_info
     */
    public static void insert_item_info(Item_info item_info) {
        try {
            DataBaseUtils.getDaoSession().getItem_infoDao().insert(item_info);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*
     * 根据item_id查找主表(返回单个结果）
     */
    public static Item_info query_item_info(String item_id) {
        QueryBuilder<Item_info> qb = DataBaseUtils.getDaoSession().getItem_infoDao().queryBuilder();
        //  ArrayList<Student> list = (ArrayList<Student>)qb.where(StudentDao.Properties.Name.eq(name)).list();
        Item_info info = qb.where(Item_infoDao.Properties.Item_id.eq(item_id)).unique();
        System.out.println("完成查询");
        return info;
        // System.out.println(student1.getAge());
    }

    /*
     * 根据item_id查找表并以item_id升序排列(返回数组）
     */
    public static ArrayList<Item_info> query_item_info_list(Integer item_status) {
        QueryBuilder<Item_info> qb = DataBaseUtils.getDaoSession().getItem_infoDao().queryBuilder();
        ArrayList<Item_info> list = (ArrayList<Item_info>) qb.where(Item_infoDao.Properties.Item_id.eq(item_status)).orderAsc(Item_infoDao.Properties.Item_id).list();
        //  Label_info info = (Label_info) qb.where(Label_infoDao.Properties.Label_id.eq(label_id)).unique();
        System.out.println("完成查询");
        return list;
        // System.out.println(student1.getAge());
    }

    /*
     * 根据item_id和item_name多条件查找表(返回单个结果）
     */
    public static Item_info query_item_info(String item_id, String item_name) {
        QueryBuilder<Item_info> qb = DataBaseUtils.getDaoSession().getItem_infoDao().queryBuilder();
        //  ArrayList<Student> list = (ArrayList<Student>)qb.where(StudentDao.Properties.Name.eq(name)).list();
        Item_info result = qb.where(Item_infoDao.Properties.Item_id.eq(item_id), Item_infoDao.Properties.Item_name.eq(item_name)).unique();
        return result;

    }



    /*
     *根据view_id删除明细表中的数据
     */
    public static Boolean delete_item_info(Item_info item_info) {
        try {
            DataBaseUtils.getDaoSession().getItem_infoDao().delete(item_info);
            //  Log.i(TAG,"数据删除成功");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            //   Log.e(TAG,"删除数据失败"+e.getMessage());
        }
        return false;
    }

    /*
     *update主表
     */
    public static void update_item_info(Item_info item_info) {
        try {
            DataBaseUtils.getDaoSession().getItem_infoDao().update(item_info);
            // Log.i(TAG,"数据更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            // Log.e(TAG,"更新数据失败"+e.getMessage());
        }
    }



}


