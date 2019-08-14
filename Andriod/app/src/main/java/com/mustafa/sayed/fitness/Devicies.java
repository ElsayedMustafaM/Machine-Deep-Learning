package com.mustafa.sayed.fitness;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Devicies extends AppCompatActivity {

    ImageView imageView;
    int []images={R.drawable.asd1,R.drawable.asd2,R.drawable.asd6,R.drawable.asd7,R.drawable.asd8,
            R.drawable.asd9,R.drawable.asd10,R.drawable.asd11,R.drawable.asd12,R.drawable.asd13,R.drawable.asd14,R.drawable.asd15,R.drawable.asd16,
            R.drawable.asd17,R.drawable.asd18,R.drawable.asd19,R.drawable.asd20,R.drawable.asd21,R.drawable.asd22,R.drawable.asd23,R.drawable.asd24,
            R.drawable.asd25,R.drawable.asd26,R.drawable.asd27,R.drawable.asd28,R.drawable.asd29,R.drawable.asd30,R.drawable.asd31,R.drawable.asd32,
            R.drawable.asd33,R.drawable.asd34,R.drawable.asd35,R.drawable.asd36,R.drawable.asd37,R.drawable.asd38,R.drawable.asd39,R.drawable.asd40,
            R.drawable.asd41,R.drawable.asd42,R.drawable.asd43,R.drawable.asd44,R.drawable.asd45,R.drawable.asd3,R.drawable.asd4,R.drawable.asd5,
            R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,
                    R.drawable.e,R.drawable.ff};
    int n=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devicies);
        imageView=(ImageView)findViewById(R.id.image);
    }

    public void back(View view)
    {
        if(n>0)
            n--;
        imageView.setImageResource(images[n]);

    }

    public void next(View view)
    {
        if(n<50)
            n++;
        imageView.setImageResource(images[n]);
    }
}
