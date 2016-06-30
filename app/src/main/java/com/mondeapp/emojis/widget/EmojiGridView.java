package com.mondeapp.emojis.widget;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import com.mondeapp.emojis.R;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by dani on 29/6/16.
 */
public class EmojiGridView {

    public View rootView;
    private List<Emoji> emojis;
    private GridView mGridView;
    private Context context;

    public EmojiGridView(Context context, int pageNumber, List<Emoji> emojis){
        this.context = context;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        rootView = inflater.inflate(R.layout.emoji_widget_gridview, null);
        mGridView = (GridView)rootView.findViewById(R.id.emojisGrid);

        load(pageNumber);
    }

    private void load(int pageNumber){
        EmojiAdapter adapter = new EmojiAdapter(context,EmojiHelper.getInstance().getEmojisByCategory(pageNumber),R.layout.emoji_widget_item);
        mGridView.setAdapter(adapter);
    }
}
