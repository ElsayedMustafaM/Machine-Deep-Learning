package com.mustafa.sayed.fitness;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by SaYeD on 8/24/2017.
 */

public class food2 extends AppCompatActivity
{
    Sqlite_DB db;
    EditText type,nocolor;
    ImageView imageView;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food2_layout);
        type=(EditText)findViewById(R.id.type);
        nocolor=(EditText)findViewById(R.id.nocolories);
        Bundle bundle=getIntent().getExtras();
        int nolist=bundle.getInt("no");

         db=new Sqlite_DB(this);

        //عرض الصور
        imageView=(ImageView)findViewById(R.id.imageview);
        switch (nolist)
        {
            case 0:
                imageView.setImageResource(R.drawable.a1);
                break;
            case 1:
                imageView.setImageResource(R.drawable.a2);
                break;
            case 2:
                imageView.setImageResource(R.drawable.a3);
                break;
            case 3:
                imageView.setImageResource(R.drawable.a4);
                break;
            case 4:
                imageView.setImageResource(R.drawable.a5);
                break;
            case 5:
                imageView.setImageResource(R.drawable.a6);
                break;
            case 6:
            imageView.setImageResource(R.drawable.a7);
            break;
            case 7:
                imageView.setImageResource(R.drawable.a8);
                break;
            case 8:
                imageView.setImageResource(R.drawable.a9);
                break;
            case 9:
                imageView.setImageResource(R.drawable.a10);
                break;
            case 10:
                imageView.setImageResource(R.drawable.a11);
                break;
            case 11:
                imageView.setImageResource(R.drawable.a12);
                break;
            case 12:
                imageView.setImageResource(R.drawable.a13);
                break;
            case 13:
                imageView.setImageResource(R.drawable.a14);
                break;
            case 14 :
            imageView.setImageResource(R.drawable.a15);
            break;
            case 15:
            imageView.setImageResource(R.drawable.a16);
            break;
            case 16:
                imageView.setImageResource(R.drawable.a17);
                break;
            case 17:
                imageView.setImageResource(R.drawable.a18);
                break;
            case 18:
                imageView.setImageResource(R.drawable.a19);
                break;
            case 19:
                imageView.setImageResource(R.drawable.a20);
                break;
            case 20:
                imageView.setImageResource(R.drawable.a21);
                break;
            case 21:
                imageView.setImageResource(R.drawable.a22);
                break;
            case 22:
                imageView.setImageResource(R.drawable.a23);
                break;
            case 32:
                imageView.setImageResource(R.drawable.a24);
                break;
            case 24:
                imageView.setImageResource(R.drawable.a25);
                break;
            case 25:
                imageView.setImageResource(R.drawable.a26);
                break;
            case 26:
                imageView.setImageResource(R.drawable.a27);
                break;
            case 27:
                imageView.setImageResource(R.drawable.a28);
                break;


        }
    }

    public void AddToFavorite(View view)
    {
        try {
            db.insertFood(type.getText().toString(),Integer.parseInt(nocolor.getText().toString()));

            type.setText("");
            nocolor.setText("");
            Toast.makeText(this,"تم الحفظ بنجاح  ",Toast.LENGTH_SHORT).show();
        }
      catch (Exception e)
      {
          Toast.makeText(this,"يوجد مشكلة ما حاول مجددا  ",Toast.LENGTH_SHORT).show();
      }

    }
}
