package com.acadgild.customdialogmenu.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by DivyaVipin on 3/14/2017.
 */

public class DBAdapter {Context c;
    SQLiteDatabase db;
    DBHelper helper;
    public DBAdapter(Context c) {
        this.c = c;
        helper=new DBHelper(c);
    }

    //OPEN DB
    public void openDB()
    {
        try
        {
            db=helper.getWritableDatabase();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //CLOSE
    public void closeDB()
    {
        try
        {
            helper.close();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //INSERT DATA
    public boolean add(String name,int phoneno,String birthdate)
    {
        try
        {
            ContentValues cv=new ContentValues();
            cv.put(Constants.NAME,name);
            cv.put(Constants.PHONENO,phoneno);
            cv.put(Constants.BIRTH_DATE,birthdate);
            db.insert(Constants.TB_NAME,null, cv);//If inserted return long value

            return true;

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }
    //RETRIEVE DATA AND FILTER
    public Cursor retrieve()
    {
        String[] columns={Constants.ROW_ID,Constants.NAME,Constants.PHONENO,Constants.BIRTH_DATE
        };
        Cursor c=null;
        c=db.query(Constants.TB_NAME,columns,null,null,null,null,null);
        return c;
    }
    public int updateRecords(String table, ContentValues values,
                             String whereClause, String[] whereArgs) {
        int a = db.update(table, values, whereClause, whereArgs);
        return a;
    }




    public void deleteRecords(String table, String whereClause, String[] whereArgs){
        db.delete(table, whereClause, whereArgs);
    }

    public void delete(SQLiteDatabase db)
    {
        db.execSQL(Constants.DROP_TB);
    }
}
