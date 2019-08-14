package com.mustafa.sayed.fitness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Result_table extends AppCompatActivity {
TextView inst,dat,len,we;
    ex1 db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_table);
        inst=(TextView)findViewById(R.id.instanceResult);
        dat=(TextView)findViewById(R.id.dataResult);
        len=(TextView)findViewById(R.id.lenghtResult);
        we=(TextView)findViewById(R.id.wightResult);
        db=new ex1(this);
       db.showResult(dat,we,len,inst);
    }
}
