package com.mustafa.sayed.fitness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class food extends AppCompatActivity {
    String []list22;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        ListView list2=(ListView)findViewById(R.id.list2);
        list22=getResources().getStringArray(R.array.food);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,R.layout.row2,R.id.textView5,list22);
        list2.setAdapter(arrayAdapter);

        intent=new Intent(food.this,food2.class);
        list2.setOnItemClickListener(new AdapterView.OnItemClickListener()

        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {


                switch (position)
                {
                    case 0:
                        intent.putExtra("no",0);
                        startActivity(intent);
                        break;
                    case 1:
                        intent.putExtra("no",1);
                        startActivity(intent);
                        break;
                    case 2:
                        intent.putExtra("no",2);
                        startActivity(intent);
                        break;
                    case 3:
                        intent.putExtra("no",3);
                        startActivity(intent);
                        break;
                    case 4:
                        intent.putExtra("no",4);
                        startActivity(intent);
                        break;
                    case 5:
                        intent.putExtra("no",5);
                        startActivity(intent);
                        break;
                    case 6:
                        intent.putExtra("no",6);
                        startActivity(intent);
                        break;
                    case 7:
                        intent.putExtra("no",7);
                        startActivity(intent);
                        break;
                    case 8:
                        intent.putExtra("no",8);
                        startActivity(intent);
                        break;
                    case 9:
                        intent.putExtra("no",9);
                        startActivity(intent);
                        break;
                    case 10:
                        intent.putExtra("no",10);
                        startActivity(intent);
                        break;
                    case 11:
                        intent.putExtra("no",11);
                        startActivity(intent);
                        break;
                    case 12:
                        intent.putExtra("no",12);
                        startActivity(intent);
                        break;
                    case 13:
                        intent.putExtra("no",13);
                        startActivity(intent);
                        break;
                    case 14:
                        intent.putExtra("no",14);
                        startActivity(intent);
                        break;
                    case 15:
                        intent.putExtra("no",15);
                        startActivity(intent);
                        break;
                    case 16:
                        intent.putExtra("no",16);
                        startActivity(intent);
                        break;
                    case 17:
                        intent.putExtra("no",17);
                        startActivity(intent);
                        break;
                    case 18:
                        intent.putExtra("no",18);
                        startActivity(intent);
                        break;
                    case 19:
                        intent.putExtra("no",19);
                        startActivity(intent);
                        break;
                    case 20:
                        intent.putExtra("no",20);
                        startActivity(intent);
                        break;
                    case 21:
                        intent.putExtra("no",21);
                        startActivity(intent);
                        break;
                    case 22:
                        intent.putExtra("no",22);
                        startActivity(intent);
                        break;
                    case 23:
                        intent.putExtra("no",23);
                        startActivity(intent);
                        break;
                    case 24:
                        intent.putExtra("no",24);
                        startActivity(intent);
                        break;
                    case 25:
                        intent.putExtra("no",25);
                        startActivity(intent);
                        break;
                    case 26:
                        intent.putExtra("no",26);
                        startActivity(intent);
                        break;
                    case 27:
                        intent.putExtra("no",27);
                        startActivity(intent);
                        break;


                }
            }
        });
    }

}
