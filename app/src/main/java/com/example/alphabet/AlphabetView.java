package com.example.alphabet;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

public class AlphabetView extends LinearLayout {

    private Context ctx;
    private SayThread sayThread;

    private String[][] alphabet = {
            {"A", "B", "C", "D"},
            {"E", "F", "G", "H"},
            {"I", "J", "K", "L"},
            {"M", "N", "O", "P"},
            {"Q", "R", "S", "T"},
            {"U", "V", "W"},
            {"X", "Y", "Z"}
    };

    public AlphabetView(Context context, AttributeSet attrs) {
        super(context, attrs);
        ctx = context;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        LinearLayout ll;
        AlphabetLetterView tv;


        setOrientation(LinearLayout.VERTICAL);

        for (int i = 0; i < alphabet.length; i++) {
            ll = new LinearLayout(ctx);
            ll.setOrientation(LinearLayout.HORIZONTAL);
            ll.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, 0, 1));

            for (int j = 0; j < alphabet[i].length; j++) {
                sayThread = new SayThread(
                        ctx,
                        new TextToSpeech.OnInitListener() {
                            @Override
                            public void onInit(int status) {

                            }
                        },
                        alphabet[i][j]
                );
                tv = new AlphabetLetterView(ctx, sayThread);
                tv.setGravity(Gravity.CENTER);
                tv.setTextSize(50f);
                tv.setLayoutParams(new LayoutParams(0, LayoutParams.MATCH_PARENT, 1));
                tv.setText(alphabet[i][j]);

                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ((AlphabetLetterView) v).speak();
                    }
                });


                ll.addView(tv);
            }

            addView(ll);
        }

    }
}
