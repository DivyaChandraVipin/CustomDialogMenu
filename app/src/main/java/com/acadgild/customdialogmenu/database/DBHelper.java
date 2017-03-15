package com.acadgild.customdialogmenu.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DivyaVipin on 3/14/2017.
 */

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context,Constants.DB_NAME,null,Constants.DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try
        {
            sqLiteDatabase.execSQL(Constants.CREATE_TB);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(Constants.DROP_TB);
        onCreate(sqLiteDatabase);


    }


}
