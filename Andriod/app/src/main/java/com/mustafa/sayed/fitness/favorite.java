package com.mustafa.sayed.fitness;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class favorite extends AppCompatActivity {

    EditText type,nocolor,id;
    Sqlite_DB db;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        db=new Sqlite_DB(this);
        type=(EditText)findViewById(R.id.edit_type);
        id=(EditText)findViewById(R.id.edit_id);
        nocolor=(EditText)findViewById(R.id.edit_nocolor);
        textView=(TextView)findViewById(R.id.showdatafood);
        db.showFood(textView);

    }

    public void modify(View view)
    {
    boolean b= db.updatefood(id.getText().toString(),type.getText().toString(),(nocolor.getText().toString()));
        if(b)

            Toast.makeText(this,"تم التعديل ",Toast.LENGTH_SHORT).show();

        else
            Toast.makeText(this,"يوجد مشكلة ما او لم تقم بادخال البيانات ",Toast.LENGTH_SHORT).show();
        id.setText("");
        type.setText("");
        nocolor.setText("");
        db.showFood(textView);
    }

    public void delete(View view)
    {
        int b=db.Delete(id.getText().toString());
        if(b!=0)
            Toast.makeText(this,"تم الخذف ",Toast.LENGTH_SHORT).show();

        else
            Toast.makeText(this,"يوجد مشكلة ما او لم تقوم بادخال رقم الصف  ",Toast.LENGTH_SHORT).show();
        id.setText("");
        type.setText("");
        nocolor.setText("");
        db.showFood(textView);
    }
}
