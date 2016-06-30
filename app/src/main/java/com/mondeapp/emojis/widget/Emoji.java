package com.mondeapp.emojis.widget;

/**
 * Created by dani on 29/6/16.
 */
public class Emoji {

    public int id;
    public int resource;
    public String unicode;
    public int category;

    public Emoji(){

    }

    public Emoji(int id, int resource, String unicode, int category){
        this.id = id;
        this.resource = resource;
        this.unicode = unicode;
        this.category = category;
    }
}
