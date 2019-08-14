package com.mustafa.sayed.fitness;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Intent ii;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






        Toast toast=new Toast(this);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,0);
        LayoutInflater ly=getLayoutInflater();
        View view1=ly.inflate(R.layout.toaststyle,(ViewGroup)findViewById(R.id.lay));
        TextView textView=(TextView)view1.findViewById(R.id.txt);
        textView.setText("  شكرا لاستخدامك التطبيق الخاص  بنا");

        toast.setView(view1);
        toast.show();
    }

    public void exercies(View view)
    {
        Intent i=new Intent(MainActivity.this,Excercies.class);
        startActivity(i);
    }

    public void Device(View view)
    {
        Intent i=new Intent(MainActivity.this,Devicies.class);
        startActivity(i);
    }

    public void food(View view)
    {
        Intent i=new Intent(MainActivity.this,food.class);
        startActivity(i);
    }

    public void resulttable(View view)
    {
        Intent i=new Intent(MainActivity.this,Result_table.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.mainmenu:
                 ii =new Intent(MainActivity.this,MainMenuAdd.class);
                startActivity(ii);
                break;
            case R.id.mainmenufavorite:
                ii=new Intent(MainActivity.this,favorite.class);
                startActivity(ii);
                break;
            case R.id.mainmenuprotins:
                ii=new Intent(MainActivity.this,Protins.class);
                startActivity(ii);
                break;
            case R.id.mainmenufood:
                ii=new Intent(MainActivity.this,Devicies2.class);
                startActivity(ii);
                break;
        }
        return true;
    }

    public void shareApp(View view)
    {
        String txt ="Fitness ";
        String shareLink="http://plat.google.com/store/apps/details?id=com.mustafa.sayed.fitness";
        Intent share=new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT,txt+"\n"+shareLink);
        startActivity(share);
    }

    public void sendEmail(View view)
    {
        try {
         String txt="راي في البرنامج : ";
            Intent send=new Intent(Intent.ACTION_SEND);
            send.setData(Uri.parse("mailto:"));
            send.setType("message/rfc822");
            send.putExtra(Intent.EXTRA_EMAIL,"sm518717@gmail.com");
            send.putExtra(Intent.EXTRA_SUBJECT,"");
            send.putExtra(Intent.EXTRA_TEXT,txt);
   startActivity(send);
        }
        catch (Exception e )
        {

        }
    }

    public void outApp(View view)
    {
   finish();
    }
}
