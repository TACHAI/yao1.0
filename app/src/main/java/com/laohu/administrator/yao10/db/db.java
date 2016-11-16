package com.laohu.administrator.yao10.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/9/28.
 */

public class db extends SQLiteOpenHelper {
    //String name   "DRUG" 数据库的名字
    //SQLiteDatabase.CursorFactory factory   查询结果的对象 指针
    //int version 数据库存储的版本
    public db(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "DRUG", null, 1);
    }
    //创建数据库的结构
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
