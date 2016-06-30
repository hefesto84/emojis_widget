package com.mondeapp.emojis.widget;

import com.mondeapp.emojis.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by dani on 29/6/16.
 */
public class EmojiHelper {

    public static final int TEMPORAL        = 0;
    public static final int FACES           = 1;
    public static final int CELEBRITIES     = 2;
    public static final int ANIMALS         = 3;
    public static final int NATURE          = 4;
    public static final int FASHION         = 5;
    public static final int LOVE            = 6;
    public static final int WEATHER         = 7;
    public static final int FOOD            = 8;
    public static final int SPORTS          = 9;
    public static final int TRANSPORTS      = 10;
    public static final int OFFICE          = 11;
    public static final int TECHNOLOGY      = 12;
    public static final int NUMBERS         = 13;
    public static final int HANDS           = 14;
    public static final int FLAGS           = 15;
    public static final int BRANDS          = 16;

    private static EmojiHelper INSTANCE = null;
    private HashMap<Integer,List<Emoji>> emojis;

    private EmojiHelper(){

        emojis = new HashMap<>();
        emojis.put(TEMPORAL,new ArrayList<Emoji>());
        emojis.put(FACES,new ArrayList<Emoji>());
        emojis.put(CELEBRITIES,new ArrayList<Emoji>());
        emojis.put(ANIMALS,new ArrayList<Emoji>());
        emojis.put(NATURE,new ArrayList<Emoji>());
        emojis.put(FASHION,new ArrayList<Emoji>());
        emojis.put(LOVE,new ArrayList<Emoji>());
        emojis.put(WEATHER,new ArrayList<Emoji>());
        emojis.put(FOOD,new ArrayList<Emoji>());
        emojis.put(SPORTS,new ArrayList<Emoji>());
        emojis.put(TRANSPORTS,new ArrayList<Emoji>());
        emojis.put(OFFICE,new ArrayList<Emoji>());
        emojis.put(TECHNOLOGY,new ArrayList<Emoji>());
        emojis.put(NUMBERS,new ArrayList<Emoji>());
        emojis.put(HANDS,new ArrayList<Emoji>());
        emojis.put(FLAGS,new ArrayList<Emoji>());
        emojis.put(BRANDS,new ArrayList<Emoji>());

        emojis.get(FACES).add(new Emoji(0, R.drawable.aburrido,"aburrido",FACES));
        emojis.get(FACES).add(new Emoji(1, R.drawable.aplauso,"aplauso",FACES));
        emojis.get(FACES).add(new Emoji(2, R.drawable.bostezo,"aburrido",FACES));
        emojis.get(FACES).add(new Emoji(3, R.drawable.enamorado,"aplauso",FACES));
        emojis.get(FACES).add(new Emoji(4, R.drawable.enfadado,"aburrido",FACES));
        emojis.get(FACES).add(new Emoji(5, R.drawable.escucha,"aplauso",FACES));
        emojis.get(FACES).add(new Emoji(6, R.drawable.feliz,"aburrido",FACES));
        emojis.get(FACES).add(new Emoji(7, R.drawable.fiesta,"aplauso",FACES));
        emojis.get(FACES).add(new Emoji(8, R.drawable.hipster,"aburrido",FACES));
        emojis.get(FACES).add(new Emoji(9, R.drawable.llora_risa,"aplauso",FACES));
        emojis.get(FACES).add(new Emoji(10, R.drawable.llorando,"aburrido",FACES));
        emojis.get(FACES).add(new Emoji(11, R.drawable.mano_cara,"aplauso",FACES));
        emojis.get(FACES).add(new Emoji(12, R.drawable.movil,"aburrido",FACES));
        emojis.get(FACES).add(new Emoji(13, R.drawable.negar,"aplauso",FACES));
        emojis.get(FACES).add(new Emoji(14, R.drawable.sin_comentarios,"aburrido",FACES));
    }

    public static EmojiHelper getInstance(){
        if(INSTANCE == null){
            INSTANCE = new EmojiHelper();
        }
        return INSTANCE;
    }

    public List<Emoji> getEmojisByCategory(int category){
        List<Emoji> _emojis = emojis.get(category);
        return _emojis!=null ? _emojis : new ArrayList<Emoji>();
    }
}
