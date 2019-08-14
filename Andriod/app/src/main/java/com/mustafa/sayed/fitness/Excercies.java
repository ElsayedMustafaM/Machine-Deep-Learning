package com.mustafa.sayed.fitness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Excercies extends AppCompatActivity {
String []list1;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercies);
        ListView list11=(ListView)findViewById(R.id.list1);
        list1=getResources().getStringArray(R.array.ecerlist);
        ArrayAdapter<String>arrayAdapter=new ArrayAdapter<String>(this,R.layout.row_layout,R.id.textView2,list1);
        list11.setAdapter(arrayAdapter);
        list11.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                        i=new Intent(Excercies.this,Back.class);
                        startActivity(i);
                        break;
                    case 1:
                        i=new Intent(Excercies.this,Shoulder.class);
                        startActivity(i);
                        break;
                    case 2:
                         i=new Intent(Excercies.this,Apps.class);
                        startActivity(i);
                        break;
                    case 3:
                        i=new Intent(Excercies.this,Bodice.class);
                        startActivity(i);
                        break;
                    case 4:
                        i=new Intent(Excercies.this,Bay.class);
                        startActivity(i);
                        break;
                    case 5:
                         i=new Intent(Excercies.this,Tray.class);
                        startActivity(i);
                        break;
                    case 6:
                        i=new Intent(Excercies.this,Leg.class);
                        startActivity(i);
                        break;
                    case 7:
                        i=new Intent(Excercies.this,home.class);
                        startActivity(i);
                        break;


                }
            }
        });
    }
}
