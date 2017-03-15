package com.acadgild.customdialogmenu.database;

/**
 * Created by DivyaVipin on 3/14/2017.
 */

public class Constants {
    //COLUMNS
    public  static final String ROW_ID="id";
    static final String NAME="person_name";
    static final String PHONENO ="phone_no";
    static final String BIRTH_DATE="birth_date";
    //DB
    public static final String DB_NAME="PERS_DB";
    public static final String TB_NAME="PERSON_TB";
    static final int DB_VERSION=1;

    //CREATE TB
    static final String CREATE_TB="CREATE TABLE PERSON_TB(id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "person_name TEXT NOT NULL ,"+"phone_no INTEGER NOT NULL,"+"birth_date TEXT NOT NULL);";

    //DROP TB
    static final String DROP_TB="DROP TABLE IF EXISTS "+TB_NAME;
}
