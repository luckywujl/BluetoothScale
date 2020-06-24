package com.haxxj.bluetoothscale.DBUtils;

import android.content.Context;

import com.haxxj.bluetoothscale.greendao.DaoMaster;
import com.haxxj.bluetoothscale.greendao.DaoSession;

import org.greenrobot.greendao.database.Database;

/*
 *将常用方法进行封装，便于使用
 */
public class DataBaseUtils {
    private static final String DATA_BASE_NAME = "scale.db";//数据库名称
    private static DaoSession mDaoSession;

    private DataBaseUtils(){//私有化，没有实例

    }

    public static void initDataBase(Context context){
        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(context,DATA_BASE_NAME);
        Database db =  openHelper.getWritableDb();
        DaoMaster daoMaster = new DaoMaster(db);
        mDaoSession = daoMaster.newSession();
        System.out.println("建库成功");
    }

    public static DaoSession getDaoSession(){
        if (mDaoSession != null){
            return mDaoSession;
        }else {
            throw new IllegalStateException("DaoSession not initialized");
        }
    }
}