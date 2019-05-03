package com.millsoftspb.trampetsimulator_ver2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PlayActivity extends AppCompatActivity implements View.OnTouchListener {

    public TrumpetModel trumpet;
    private ImageView valve_1, valve_2, valve_3;
    private final int noteA=1,noteB=2,noteC=3,noteD=4,noteE=5,noteF=6,noteG=7;
    boolean isDownValve_1, isDownValve_2, isDownValve_3 = false;
    float volume;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        //init trumpet
        trumpet = new TrumpetModel(this);

        //init valve view
        valve_1 = findViewById(R.id.imageView1);
        valve_1.setOnTouchListener(this);
        valve_2 = findViewById(R.id.imageView2);
        valve_2.setOnTouchListener(this);
        valve_3 = findViewById(R.id.imageView3);
        valve_3.setOnTouchListener(this);


    }

    //touch processing
    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch (v.getId()) {
            //**************Valve_1*******************
            case (R.id.imageView1): {
                if (event.getAction() == MotionEvent.ACTION_DOWN||event.getAction() == MotionEvent.ACTION_MOVE) {
                    isDownValve_1 = true;
                    valve_1.setImageResource(R.drawable.valve_png_down);
                } else {
                    isDownValve_1 = false;
                    valve_1.setImageResource(R.drawable.valve_png_up);
                }
            }
            trumpetManager();
            break;
            //**************Valve_2*******************
            case (R.id.imageView2): {
                if (event.getAction() == MotionEvent.ACTION_DOWN||event.getAction() == MotionEvent.ACTION_MOVE) {
                    isDownValve_2 = true;
                    valve_2.setImageResource(R.drawable.valve_png_down);
                } else {
                    isDownValve_2 = false;
                    valve_2.setImageResource(R.drawable.valve_png_up);
                }
            }
            trumpetManager();
            break;
            //**************Valve_3*******************
            case (R.id.imageView3): {
                if (event.getAction() == MotionEvent.ACTION_DOWN||event.getAction() == MotionEvent.ACTION_MOVE) {
                    isDownValve_2 = true;
                    valve_3.setImageResource(R.drawable.valve_png_down);
                } else {
                    isDownValve_2 = false;
                    valve_3.setImageResource(R.drawable.valve_png_up);
                }
            }
            trumpetManager();
            break;
        }
        return true;
    }
    //****************calculate by touch valves***********************************
    private void trumpetManager() {
        //******D*******
        if (isDownValve_1&!isDownValve_2&isDownValve_3) trumpet.play(volume,noteD);//  >=тТт=-

        //******F*******
        if (isDownValve_1&!isDownValve_2&!isDownValve_3) trumpet.play(volume,noteF);//  >=тТТ=-

        //******B*******
        if (!isDownValve_1&isDownValve_2&!isDownValve_3) trumpet.play(volume,noteB);//  >=TтТ=-

        //******E*******
        if (isDownValve_1&isDownValve_2&!isDownValve_3&volume<0.5) trumpet.play(1,noteE);//-  >=ттТ=-

        //******A*******
        if (isDownValve_1&isDownValve_2&!isDownValve_3&volume>=0.5) trumpet.play(1,noteA);// + >=ттТ=-

        //******C*******
        if (!isDownValve_1&!isDownValve_2&!isDownValve_3&volume<0.5) trumpet.play(1,noteC);//-  >=ТТТ=-

        //******G*******
        if (!isDownValve_1&!isDownValve_2&!isDownValve_3&volume>=0.5) trumpet.play(1,noteG);//+  >=ТТТ=-

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (trumpet != null) trumpet.destroyTrumpet();
    }

}