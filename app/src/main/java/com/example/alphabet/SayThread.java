package com.example.alphabet;

import android.content.Context;
import android.graphics.Color;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.widget.TextView;

import java.util.Locale;

public class SayThread extends TextToSpeech implements Runnable {
    private boolean isSpeaking = false;
    private Context ctx;
    private String letter;


    public SayThread(Context context, OnInitListener listener, String letter) {
        super(context, listener);
        this.ctx = context;
        this.letter = letter;
    }

    @Override
    public void run() {
        isSpeaking = true;
        while (isSpeaking) {
            setLanguage(Locale.UK);
            speak(letter.toLowerCase(), TextToSpeech.QUEUE_ADD, null);
            Log.d("DEBUGGING", letter);
            stopSpeaking();
        }
    }

    public void stopSpeaking() {
        isSpeaking = false;
    }

    @Override
    public boolean isSpeaking() {
        return isSpeaking;
    }
}
