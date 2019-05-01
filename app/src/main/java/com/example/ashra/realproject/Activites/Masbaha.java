package com.example.ashra.realproject.Activites;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.balysv.materialripple.MaterialRippleLayout;
import com.example.ashra.realproject.R;

import java.util.ArrayList;
import java.util.List;

public class Masbaha extends AppCompatActivity {
    MaterialRippleLayout count;
    TextView show_count;
    Spinner spinner;
    Toolbar toolbar;
    int x=0;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masbaha);
        count=findViewById(R.id.count);
        show_count=findViewById(R.id.show_count);
        spinner=findViewById(R.id.spinner);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
        getSupportActionBar().setTitle("");
        List<String>list=new ArrayList<>();
        String [] zkr={"سبحان الله","الحمد لله","لا اله الا الله ","الله أكبر","لا حول ولا قوة الا بالله ","استغفر الله العظيم"};
        for (int i=0;i<zkr.length;i++)
        {
            list.add(zkr[i]);
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);



        count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              x = Integer.parseInt(show_count.getText().toString());
                if(x<100)
                {
                    x+=1;
                    show_count.setText(String.valueOf(x));
                }else {
                    Toast.makeText(Masbaha.this, "finish....", Toast.LENGTH_SHORT).show();
                    show_count.setText("0");
                }
            }
        });
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
