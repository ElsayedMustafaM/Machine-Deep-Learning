package com.mustafa.sayed.fitness;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

/**
 * Created by SaYeD on 8/26/2017.
 */

public class ex1 extends SQLiteOpenHelper {
    public ex1(Context context) {
        super(context,"Resltdatabase",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE MYR (ID INTEGER PRIMARY KEY AUTOINCREMENT ,DATA TEXT , WEIGHT INTEGER,LENGHT INTEGER,INSTANCE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS MYR");
        onCreate(db);
    }

    public void insertResult(String Data,int weight ,int lenght,String instance)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("DATA",Data);
        contentValues.put("WEIGHT",weight);
        contentValues.put("LENGHT",lenght);
        contentValues.put("INSTANCE",instance);
        db.insertOrThrow("MYR",null,contentValues);
    }

    public boolean updateResult(String id,String Data,int weight ,int lenght,String instance)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("DATA",Data);
        contentValues.put("WEIGHT",weight);
        contentValues.put("LENGHT",lenght);
        contentValues.put("INSTANCE",instance);

        db.update("MYR",contentValues,"ID=?",new String[]{id});
        if(Data==""||instance==""||weight==0||lenght==0)
            return  false;
        else
            return  true;
    }
    public Integer DeleteFResult(String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete("MYR","ID=?",new String []{id});
    }
    public void showResult(TextView textView1,TextView textView2,TextView textView3,TextView textView4)
    {
        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM MYR ",null);
        textView1.setText("");
        textView2.setText("");
        textView3.setText("");
        textView4.setText("");
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false)
        {
            String t1=cursor.getString(1);
            String t2=cursor.getString(2);
            String t3=cursor.getString(3);
            String t4=cursor.getString(4);
            textView1.append(t1+"\n\n");
            textView2.append(t2+"\n\n");
            textView3.append(t3+"\n\n");
            textView4.append(t4+"\n\n");
            cursor.moveToNext();
        }
    }




}
