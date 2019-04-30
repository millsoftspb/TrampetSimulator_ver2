package com.millsoftspb.trampetsimulator_ver2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PlayActivity extends AppCompatActivity implements View.OnTouchListener {

    public TrumpetModel trumpet;
    private final int sA=1,sB=2,sC=3,sD=4,sE=5,sF=6,sG=7, stop = 10;
    private Button buttonA,buttonB,buttonC,buttonD,buttonE,buttonF,buttonG;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

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
        Toast.makeText(getApplicationContext(),"onTouch",Toast.LENGTH_SHORT).show();
        switch (v.getId()) {

            case (R.id.buttonA):
                if (event.getAction()==MotionEvent.ACTION_DOWN) trumpet.playSound(sA);
                if (event.getAction()==MotionEvent.ACTION_UP) trumpet.playSound(stop);
                break;
            case (R.id.buttonB):
                trumpet.playSound(sB);
                break;
            case (R.id.buttonC):
                trumpet.playSound(sC);
                break;
            case (R.id.buttonD):
                trumpet.playSound(sD);
                break;
            case (R.id.buttonE):
                trumpet.playSound(sE);
                break;
            case (R.id.buttonF):
                trumpet.playSound(sF);
                break;
            case (R.id.buttonG):
                trumpet.playSound(sG);
                break;
        }
        return false;
    }
}
