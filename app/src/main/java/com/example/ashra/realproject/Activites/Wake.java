package com.example.ashra.realproject.Activites;


import android.annotation.SuppressLint;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.balysv.materialripple.MaterialRippleLayout;
import com.example.ashra.realproject.R;

public class Wake extends AppCompatActivity {
    Toolbar toolbar;
TextView text_page,text_cont,text_show;
MaterialRippleLayout button_mave,button_back;
LinearLayout touch;
ScrollView touch2;
 int x_move=0;
 int p_count=1;
  int count=0;


    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wake);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
        getSupportActionBar().setTitle("");
        text_page=findViewById(R.id.text_page);
        text_cont=findViewById(R.id.text_click);
        text_show=findViewById(R.id.txt_show);
        button_mave=findViewById(R.id.riple_move);
        button_back=findViewById(R.id.riple_back);
        touch=findViewById(R.id.continers);
        touch2=findViewById(R.id.touch);


        final     String s[]=getResources().getStringArray(R.array.moring);

        text_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              click();
            }
        });

        touch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              click();
            }
        });



        text_show.setText(s[x_move]);
        text_cont.setText(String.valueOf(p_count));

        button_mave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_cont.setText("1");
               p_count=p_count+1;
               if (p_count<s.length+1) {
                  text_page.setText(String.valueOf(p_count));
               }else {
                   Toast.makeText(Wake.this, "لقد انتهيت", Toast.LENGTH_SHORT).show();
               }
                x_move=x_move+1;
                if(x_move<s.length)
                {
                    text_show.setText(s[x_move]);
                }else {
                    Toast.makeText(Wake.this, "لقد انتهيت", Toast.LENGTH_SHORT).show();
                    button_mave.setVisibility(View.INVISIBLE);
                    button_back.setVisibility(View.VISIBLE);
                    p_count=p_count-1;

                }

            }
        });
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_mave.setVisibility(View.VISIBLE);
                text_cont.setText("1");
                int i = Integer.parseInt(text_page.getText().toString());
                p_count = p_count - 1;

                if (p_count >=1) {
                    text_page.setText(String.valueOf(p_count));
                }else if(i==1){
                    Toast.makeText(Wake.this, "لقد انتهيت........", Toast.LENGTH_SHORT).show();
                    button_back.setVisibility(View.VISIBLE);
                    button_mave.setVisibility(View.VISIBLE);
                    p_count=p_count+1;
                }

                else  {
                    Toast.makeText(Wake.this, "لقد انتهيت", Toast.LENGTH_SHORT).show();
                    button_back.setVisibility(View.INVISIBLE);
                    button_mave.setVisibility(View.VISIBLE);
                    p_count=p_count+1;
                }

                if (x_move >0) {
                    x_move = x_move - 1;

                    text_show.setText(s[x_move]);

                } else  {
                   // Toast.makeText(Wake.this, "لقد انتهيت", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
    public void click()
    {
        count=Integer.parseInt( text_cont.getText().toString());
        if(x_move==1||x_move==2||x_move==3||x_move==6||x_move==10||x_move==13||x_move==14||x_move==15||x_move==17)
        {
            if(count<3) {
                count = count + 1;
                text_cont.setText(String.valueOf(count));
            }else {
                Toast.makeText(Wake.this, "finish.", Toast.LENGTH_SHORT).show();
                text_cont.setText("1");
            }
        }
        else if(x_move==7) {

            if (count < 4)
            {
                count = count + 1;
                text_cont.setText(String.valueOf(count));
            } else
            {
                Toast.makeText(Wake.this, "finish.", Toast.LENGTH_SHORT).show();
                text_cont.setText("1");
            }
        }else if(x_move==9)
        {
            if (count < 7)
            {
                count = count + 1;
                text_cont.setText(String.valueOf(count));
            } else
            {
                Toast.makeText(Wake.this, "finish.", Toast.LENGTH_SHORT).show();
                text_cont.setText("1");
            }
        }

        else if(x_move==19||x_move==20||x_move==21)
        {
            if (count<100)
            {
                count=count+1;
                text_cont.setText(String.valueOf(count));
            }else {
                Toast.makeText(Wake.this, "finish.", Toast.LENGTH_SHORT).show();
                text_cont.setText("1");
            }
        }else {

            count=Integer.parseInt( text_cont.getText().toString());
            if(count==1)
            {

                Toast.makeText(Wake.this, "انتهى هنا", Toast.LENGTH_SHORT).show();
                text_cont.setText("1");

            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
