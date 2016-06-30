package com.mondeapp.emojis.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.mondeapp.emojis.R;

import java.util.List;

/**
 * Created by dani on 26/5/16.
 */
public class EmojiAdapter extends BaseAdapter {
    private Context context;
    private List<Emoji> picturesList;
    private int layout;
    private LayoutInflater inflater;

    public EmojiAdapter(Context context, List<Emoji> picturesList, int layout) {
        this.context = context;
        this.picturesList = picturesList;
        /*
        for(Emoji emoji : picturesList){
            pi
        }
        for(int i = picturesList.size(); i<48; i++){
            picturesList.add(new Emoji(R.drawable.ic_faces_selected,R.drawable.ic_faces_selected,":soon:",EmojiHelper.FACES));
        }
        */
        this.picturesList = picturesList;
        this.layout = layout;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return this.picturesList.size();
    }

    public Object getItem(int position) {
        return picturesList.get(position);
    }

    public long getItemId(int position) {
        return picturesList.get(position).id;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        GridViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(layout, parent, false);
            holder = new GridViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (GridViewHolder) convertView.getTag();
        }

        holder.emoji.setImageResource(picturesList.get(position).resource);

        return convertView;
    }

    class GridViewHolder{

        ImageView emoji;

        public GridViewHolder(View view){
            emoji = (ImageView)view.findViewById(R.id.emoji);
        }
    }

}