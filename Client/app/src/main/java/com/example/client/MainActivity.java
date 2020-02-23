package com.example.client;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean wifi = false;
    boolean compLvl2 = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Switch wifiSwitch = (Switch)  findViewById(R.id.switchWifi);
        wifiSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                wifi = isChecked;
            }
        });


        Switch compLvlSwitch = (Switch)  findViewById(R.id.switchCompLvl);
        compLvlSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                compLvl2 = isChecked;
            }
        });
    }

    public void start(View view) {
        boolean connectedToCenter = false;
        //while(!connectedToCenter){
            // TODO Data Transfer
        //}

        double c = 0;
        if(compLvl2){
            for (int i = 0; i < 3; i++){
                c += calculation();
            }
        } else {
            c = calculation();
        }
        Toast.makeText(MainActivity.this,"Calculation Result: " + c, Toast.LENGTH_LONG).show();
    }

    public double calculation() {
        long LoopEnd = 10000000;
        double start = 123456789.123456789;
        double tanSum = 0;
        final long startTime = System.currentTimeMillis();
        for (int i = 0; i < LoopEnd; i++) {
            double local = Math.tan(Math.atan(Math.tan(Math.atan(Math.tan(Math.atan(start))))));
            Math.cbrt(local);
            tanSum += local;
        }
        final long endTime = System.currentTimeMillis();
        Toast.makeText(MainActivity.this, "Total execution time: " + (endTime - startTime) + " milliseconds", Toast.LENGTH_LONG).show();
        return tanSum;
    }
}
