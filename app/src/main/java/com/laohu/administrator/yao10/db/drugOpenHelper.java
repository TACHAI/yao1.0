package com.laohu.administrator.yao10.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/9/23.
 */

public class drugOpenHelper extends SQLiteOpenHelper{
    /*
    DRUG_CLASS建表语句
     */
    public static final String CREATE_DRUG_CLASS="create table DRUG_CLASS("
            +"id integer primary key autoincrement,"
            +"class_name text,"
            +"class_code text)";
    /*
    DRUG_SUBCLASS建表语句
     */
   public static final String CREATE_DRUG_SUBCLASS="create table DRUG_SUBCLASS("
            +"id integer primary key autoincrement,"
            +"subclass_name text,"
            +"subclass_code text,"
            +"class_id integer)";
    /*
    drug建表语句
     */
    public static final String CREATE_DRUG_DRUG="create table DRUG("
            +"id integer primary key autoincrement,"
            +"drug_name text,"
            +"drug_code text,"
            +"subclass_id integer)";

   public drugOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
       super(context,name,factory,version);
    }

    public void  onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_DRUG_CLASS);
        db.execSQL(CREATE_DRUG_SUBCLASS);
        db.execSQL(CREATE_DRUG_DRUG);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
