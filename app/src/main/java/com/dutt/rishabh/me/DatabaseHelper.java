package com.dutt.rishabh.me;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Rishabh on 24-09-2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="resume.db";
    public static final String TABLE_NAME="tab1";
    public static final int DATABASE_VERSION=1;
    public static final String COL_1="ID";
    public static final String COL_2="NAME";
    public static final String COL_3="DOB";
    public static final String COL_4="ABOUT";
    public static final String COL_5="SKILLS";
    public static final String COL_6="ACHIEVEMENTS";
    public static final String COL_7="EXPERIENCE";
    public static final String COL_8="WHY_ANDROID";
    public static final String COL_9="DREAM_PROJECT";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create="create table "+TABLE_NAME+"("+COL_1+" INTEGER PRIMARY KEY AUTOINCREMENT,"+COL_2+" TEXT NOT NULL,"+COL_3+" TEXT NOT NULL,"+COL_4+" TEXT,"+COL_5+" TEXT,"+COL_6+" TEXT,"+COL_7+" TEXT,"+COL_8+" TEXT,"+COL_9+" TEXT)";
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String upgrade="Drop table if exists "+TABLE_NAME;
        db.execSQL(upgrade);
        onCreate(db);
    }
    public boolean addData(String name,String date,String info,String skills,String achievement,String experience,String android,String dream){
        SQLiteDatabase myDB=this.getWritableDatabase();
        ContentValues content=new ContentValues();
        content.put(COL_2,name);
        content.put(COL_3,date);
        content.put(COL_4,info);
        content.put(COL_5,skills);
        content.put(COL_6,achievement);
        content.put(COL_7,experience);
        content.put(COL_8,android);
        content.put(COL_9,dream);
        long result=myDB.insert(TABLE_NAME,null,content);
        if(result==-1){
            return false;
        }
        else{
            return true;
        }
    }
    public Cursor view(int id){
        SQLiteDatabase myDB=this.getReadableDatabase();
        Cursor cursor=myDB.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE ID=?",new String[]{String.valueOf(id)});
        return cursor;
    }
}
