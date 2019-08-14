package com.mustafa.sayed.fitness;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainMenuAdd extends AppCompatActivity {
EditText id1,id2,wight1,wight2,lenght1,lenght2,instance1,instance2,
        data1,data2;
    ex1 db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu_add);
        db=new ex1(this);
        id1=(EditText)findViewById(R.id.edit_id3);
        id2=(EditText)findViewById(R.id.edit_id4);
        wight1=(EditText)findViewById(R.id.edit_wight1);
        wight2=(EditText)findViewById(R.id.edit_wight2);
        lenght1=(EditText)findViewById(R.id.edit_lenght1);
        lenght2=(EditText)findViewById(R.id.edit_lenght2);
        instance1=(EditText)findViewById(R.id.edit_instance1);
        instance2=(EditText)findViewById(R.id.edit_instance2);
        data1=(EditText)findViewById(R.id.edit_data1);
        data2=(EditText)findViewById(R.id.edit_data2);


    }

    public void AddResult(View view)
    {
        try{
            db.insertResult(data1.getText().toString(),Integer.parseInt(wight1.getText().toString()),Integer.parseInt(lenght1.getText().toString()),instance1.getText().toString());
           Toast.makeText(this,"تم حفظ البيانات ",Toast.LENGTH_SHORT).show();
            data1.setText("");
            wight1.setText("");
            lenght1.setText("");
          instance1.setText("");
        }
        catch (Exception e)
        {
            Toast.makeText(this,"يوجد مشكلة ما ",Toast.LENGTH_SHORT).show();
        }
    }

      public void upadateResult(View view)
      {
     boolean b=db.updateResult(id1.getText().toString(),data2.getText().toString(),Integer.parseInt(wight2.getText().toString()),Integer.parseInt(lenght2.getText().toString()),instance2.getText().toString());
        if(b)
        {
            Toast.makeText(this,"تم تعديل البيانات ",Toast.LENGTH_SHORT).show();
            id1.setText("");
            data2.setText("");
            wight2.setText("");
            lenght2.setText("");
            instance2.setText("");

        }
        else
            Toast.makeText(this,"يوجد مشكلة ما ",Toast.LENGTH_SHORT).show();

      }

      public void DeleteResult(View view)
      {
      int i=db.DeleteFResult(id2.getText().toString());
          if(i!=0)
          {
              Toast.makeText(this,"تم خذف البيانات ",Toast.LENGTH_SHORT).show();
              id2.setText("");
          }
        else
            Toast.makeText(this,"يوجد مشكلة ما ",Toast.LENGTH_SHORT).show();
    }
}
