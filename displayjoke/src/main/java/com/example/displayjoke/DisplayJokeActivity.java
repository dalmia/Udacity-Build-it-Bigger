package com.example.displayjoke;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


/**
 * Custom Activity to receive the joke from the intent and display it
 */

public class DisplayJokeActivity extends AppCompatActivity {

    public static final String JOKE_INTENT_KEY = "joke";
    TextView joke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);
        joke = (TextView)findViewById(R.id.joke);

        // Receiving the joke and setting it as the text for our textView
        joke.setText(getIntent().getStringExtra(JOKE_INTENT_KEY));
    }
}
