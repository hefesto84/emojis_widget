package com.mondeapp.emojis.widget;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.mondeapp.emojis.R;

import java.util.List;

/**
 * Created by dani on 29/6/16.
 */
public class EmojiGridView {

    public View rootView;
    private TextView txtPageNumber;
    private int pageNumber;
    private List<Emoji> emojis;

    public EmojiGridView(Context context, int pageNumber, List<Emoji> emojis){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        rootView = inflater.inflate(R.layout.emoji_widget_gridview, null);

        this.pageNumber = pageNumber;

        load();
    }

    private void load(){
        //txtPageNumber.setText(String.valueOf(pageNumber));
    }
}
