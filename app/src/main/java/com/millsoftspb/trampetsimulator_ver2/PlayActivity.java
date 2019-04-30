package com.millsoftspb.trampetsimulator_ver2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PlayActivity extends AppCompatActivity implements View.OnTouchListener {

    public TrumpetModel trumpet;
    int stop = -10;
    private Button buttonA,buttonB,buttonC,buttonD,buttonE,buttonF,buttonG;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        trumpet = new TrumpetModel(this);
        trumpet.soundPool.autoPause();

        textView = findViewById(R.id.textView);

        buttonA = findViewById(R.id.buttonA);
        buttonA.setOnTouchListener(this);
        buttonB = findViewById(R.id.buttonB);
        buttonB.setOnTouchListener(this);
        buttonC = findViewById(R.id.buttonC);
        buttonC.setOnTouchListener(this);
        buttonD = findViewById(R.id.buttonD);
        buttonD.setOnTouchListener(this);
        buttonE = findViewById(R.id.buttonE);
        buttonE.setOnTouchListener(this);
        buttonF = findViewById(R.id.buttonF);
        buttonF.setOnTouchListener(this);
        buttonG = findViewById(R.id.buttonG);
        buttonG.setOnTouchListener(this);
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (trumpet!=null) trumpet.destroyTrumpet();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch (v.getId()) {

            case (R.id.buttonA):{
                textView.setText(event.toString());
                if (event.getAction()==MotionEvent.ACTION_DOWN) trumpet.soundPool.play(trumpet.soundA,1,1,0,1,1);
                if (event.getAction()==MotionEvent.ACTION_UP) trumpet.soundPool.stop(trumpet.soundA);}
                break;
            case (R.id.buttonB):{
                if (event.getAction()==MotionEvent.ACTION_DOWN) trumpet.soundPool.play(trumpet.soundB,1,1,0,0,1);
                if (event.getAction()==MotionEvent.ACTION_UP) trumpet.soundPool.stop(trumpet.soundB);}
                break;
            case (R.id.buttonC):{
                if (event.getAction()==MotionEvent.ACTION_DOWN) trumpet.soundPool.play(trumpet.soundC,1,1,0,0,1);
                if (event.getAction()==MotionEvent.ACTION_UP) trumpet.soundPool.stop(trumpet.soundC);}
                break;
            case (R.id.buttonD):{
                if (event.getAction()==MotionEvent.ACTION_DOWN) trumpet.soundPool.play(trumpet.soundD,1,1,0,0,1);
                if (event.getAction()==MotionEvent.ACTION_UP) trumpet.soundPool.stop(trumpet.soundD);}
                break;
            case (R.id.buttonE):{
                if (event.getAction()==MotionEvent.ACTION_DOWN) trumpet.soundPool.play(trumpet.soundE,1,1,0,0,1);
                if (event.getAction()==MotionEvent.ACTION_UP) trumpet.soundPool.stop(trumpet.soundE);}
                break;
            case (R.id.buttonF):{
                if (event.getAction()==MotionEvent.ACTION_DOWN) trumpet.soundPool.play(trumpet.soundF,1,1,0,0,1);
                if (event.getAction()==MotionEvent.ACTION_UP) trumpet.soundPool.stop(trumpet.soundF);}
                break;
            case (R.id.buttonG):{
                if (event.getAction()==MotionEvent.ACTION_DOWN) trumpet.soundPool.play(trumpet.soundG,1,1,0,0,1);
                if (event.getAction()==MotionEvent.ACTION_UP) trumpet.soundPool.stop(trumpet.soundG);}
                break;
        }
        return false;
    }
}
