package com.example.ashra.realproject.Activites;

import android.content.Intent;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.balysv.materialripple.MaterialRippleLayout;
import com.example.ashra.realproject.R;

 public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout bottom=findViewById(R.id.bottomsheet);
        BottomSheetBehavior bottomSheetBehavior=BottomSheetBehavior.from(bottom);
        MaterialRippleLayout morning=findViewById(R.id.wake);
        MaterialRippleLayout night=findViewById(R.id.night);
        MaterialRippleLayout exit=findViewById(R.id.exit);
        MaterialRippleLayout maspha=findViewById(R.id.maspha);
        morning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
startActivity(new Intent(MainActivity.this,Wake.class));
            }
        });
        night.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Night.class));
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              finish();
            }
        });
        maspha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Masbaha.class));
            }
        });
    }
}
