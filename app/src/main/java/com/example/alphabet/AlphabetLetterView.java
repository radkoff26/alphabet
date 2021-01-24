package com.example.alphabet;

import android.content.Context;

import androidx.annotation.NonNull;

public class AlphabetLetterView extends androidx.appcompat.widget.AppCompatTextView {

    private SayThread sayThread;

    public AlphabetLetterView(@NonNull Context context, SayThread sayThread) {
        super(context);
        this.sayThread = sayThread;
    }

    public void speak() {
        sayThread.run();
    }
}
