package com.millsoftspb.trampetsimulator_ver2;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.SoundPool;

public class TrumpetModel {

    private SoundPool soundPool;
    private int soundA,soundB,soundC,soundD,soundE,soundF,soundG;
    private final int sA=1,sB=2,sC=3,sD=4,sE=5,sF=6,sG=7, stop=10;
    private Context context;

    public TrumpetModel(Context context) {
        this.context = context;
        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();
        soundPool = new SoundPool.Builder()
                .setMaxStreams(7)
                .setAudioAttributes(audioAttributes)
                .build();
        soundA = soundPool.load(context,R.raw.a4,1);
        soundB = soundPool.load(context,R.raw.b4,1);
        soundC = soundPool.load(context,R.raw.c4,1);
        soundD = soundPool.load(context,R.raw.d4,1);
        soundE = soundPool.load(context,R.raw.e4,1);
        soundF = soundPool.load(context,R.raw.f4,1);
        soundG = soundPool.load(context,R.raw.g4,1);
    }
 public void playSound(int sound) {
        switch (sound) {
            case sA:
                soundPool.play(soundA,1,1,0,0,1);
                break;
            case sB:
                soundPool.play(soundB,1,1,0,0,1);
                break;
            case sC:
                soundPool.play(soundC,1,1,0,0,1);
                break;
            case sD:
                soundPool.play(soundD,1,1,0,0,1);
                break;
            case sE:
                soundPool.play(soundE,1,1,0,0,1);
                break;
            case sF:
                soundPool.play(soundF,1,1,0,0,1);
                break;
            case sG:
                soundPool.play(soundG,1,1,0,0,1);
            break;
        }
 }
public void destroyTrumpet (){
soundPool.release();
soundPool = null;
    }
}
