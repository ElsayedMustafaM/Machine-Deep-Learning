package com.mustafa.sayed.fitness;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Devicies2 extends AppCompatActivity {


    ImageView imageView;
    int []images={R.drawable.zxc1,R.drawable.zxc2,R.drawable.zxc3,R.drawable.zxc4,R.drawable.zxc5,
            R.drawable.zxc6,R.drawable.zxc7,R.drawable.zxc8,R.drawable.zxc9};
    int n=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devicies2);

        imageView=(ImageView)findViewById(R.id.image1);
    }



    public void back1(View view)
    {
        if(n>0)
            n--;
        imageView.setImageResource(images[n]);

    }

    public void next1(View view)
    {
        if(n<8)
            n++;
        imageView.setImageResource(images[n]);
    }
}
