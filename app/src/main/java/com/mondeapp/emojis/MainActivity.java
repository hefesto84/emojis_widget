package com.mondeapp.emojis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.mondeapp.emojis.widget.EmojiWidget;

public class MainActivity extends AppCompatActivity {

    EmojiWidget widget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        widget = (EmojiWidget)findViewById(R.id.emoji_widget);
        widget.init(true);
    }
}
