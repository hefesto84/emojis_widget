package com.mondeapp.emojis.widget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by dani on 29/6/16.
 */
public class EmojiHelper {

    public static final int RECENT = 0;
    public static final int FACES = 0;
    public static final int ANIMALS = 0;
    public static final int NATURE = 0;
    public static final int LOVE = 0;
    public static final int WEATHER = 0;
    public static final int FOOD = 0;

    private static EmojiHelper INSTANCE = null;
    private HashMap<Integer,List<Emoji>> emojis;

    private EmojiHelper(){
        emojis = new HashMap<>();
        emojis.put(RECENT,new ArrayList<Emoji>());
        emojis.put(FACES,new ArrayList<Emoji>());
        emojis.put(ANIMALS,new ArrayList<Emoji>());
        emojis.put(NATURE,new ArrayList<Emoji>());
        emojis.put(LOVE,new ArrayList<Emoji>());
        emojis.put(WEATHER,new ArrayList<Emoji>());
        emojis.put(FOOD,new ArrayList<Emoji>());
    }

    public static EmojiHelper getInstance(){
        if(INSTANCE == null){
            INSTANCE = new EmojiHelper();
        }
        return INSTANCE;
    }

    public List<Emoji> getEmojisByCategory(int category){
        return emojis.get(category);
    }
}
