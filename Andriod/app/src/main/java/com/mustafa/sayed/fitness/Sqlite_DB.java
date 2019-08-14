package com.mustafa.sayed.fitness;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by SaYeD on 8/25/2017.
 */

public class Sqlite_DB extends SQLiteOpenHelper
{
    public Sqlite_DB(Context context) {
        super(context, "FITNESS", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE FAVORITE (ID INTEGER PRIMARY KEY AUTOINCREMENT ,TYPE TEXT , NOCOLORIES TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS FAVORITE");
        onCreate(db);
    }



    public void insertFood(String type ,int nocolor)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("TYPE",type);
        contentValues.put("NOCOLORIES",nocolor);
        db.insertOrThrow("FAVORITE",null,contentValues);
    }
    public boolean updatefood(String id,String type ,String nocolor)
    {

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("TYPE",type);
        contentValues.put("NOCOLORIES",nocolor);
        db.update("FAVORITE",contentValues,"ID=?",new String[]{id});
        if(id==""||type==""||nocolor=="")
            return  false;
            else
        return  true;
    }
    public Integer Delete(String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete("FAVORITE","ID=?",new String []{id});
    }
    public void showFood(TextView  textView)
    {
        SQLiteDatabase db=this.getReadableDatabase();

            Cursor cursor = db.rawQuery("SELECT * FROM FAVORITE ",null);
        textView.setText("");
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false)
        {
            String t1=cursor.getString(0);
            String t2=cursor.getString(1);
            String t3=cursor.getString(2);

            textView.append("رقم الصف :  "+t1+"     النوع  : "+t2+"      عدد السعرات :   "+t3+"\n");
            cursor.moveToNext();
        }
    }
}
