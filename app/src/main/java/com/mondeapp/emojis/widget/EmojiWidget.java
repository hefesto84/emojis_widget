package com.mondeapp.emojis.widget;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mondeapp.emojis.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dani on 29/6/16.
 */
public class EmojiWidget extends LinearLayout implements ViewPager.OnPageChangeListener, View.OnClickListener{

    private EmojiPageAdapter mPagerAdapter;
    private LinearLayout mContainer;
    private HashMap<Integer,ImageView> mButtons;
    private HashMap<Integer,Integer> mButtonsIds;
    private int lastItemSelected = 0;
    private HorizontalScrollView mScroll;

    ViewPager mPager;

    private boolean debug;

    public EmojiWidget(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void init(boolean debug){
        this.debug = debug;
        mPager = (ViewPager)findViewById(R.id.emoji_widget_pager);
        mScroll = (HorizontalScrollView)findViewById(R.id.emoji_widget_topbar_scroll);
        mContainer = (LinearLayout)findViewById(R.id.emoji_widget_topbar_container);

        log("mPager initialized");
        if(mPager!=null){
            mPager.addOnPageChangeListener(this);
            log("mPager now has onpagelistener attached");
            initButtons();
            initPageAdapter();
            mPager.setCurrentItem(0);
            lastItemSelected = R.id.emoji_widget_page_temporal;
        }
    }

    private void initPageAdapter(){
        List<EmojiGridView> list = new ArrayList<>();
        for(int i = 0; i<mButtons.size(); i++){
            list.add(new EmojiGridView(getContext(),i,EmojiHelper.getInstance().getEmojisByCategory(i)));
        }
        mPagerAdapter = new EmojiPageAdapter(list);
        mPager.setAdapter(mPagerAdapter);
    }

    private void initButtons(){
        mButtons = new HashMap<>();
        mButtonsIds = new HashMap<>();

        mButtons.put(R.id.emoji_widget_page_temporal,((ImageView)findViewById(R.id.emoji_widget_page_temporal)));
        mButtons.put(R.id.emoji_widget_page_faces,((ImageView)findViewById(R.id.emoji_widget_page_faces)));
        mButtons.put(R.id.emoji_widget_page_celebrities,((ImageView)findViewById(R.id.emoji_widget_page_celebrities)));
        mButtons.put(R.id.emoji_widget_page_animals,((ImageView)findViewById(R.id.emoji_widget_page_animals)));
        mButtons.put(R.id.emoji_widget_page_nature,((ImageView)findViewById(R.id.emoji_widget_page_nature)));
        mButtons.put(R.id.emoji_widget_page_fashion,((ImageView)findViewById(R.id.emoji_widget_page_fashion)));
        mButtons.put(R.id.emoji_widget_page_love,((ImageView)findViewById(R.id.emoji_widget_page_love)));
        mButtons.put(R.id.emoji_widget_page_weather,((ImageView)findViewById(R.id.emoji_widget_page_weather)));
        mButtons.put(R.id.emoji_widget_page_food,((ImageView)findViewById(R.id.emoji_widget_page_food)));
        mButtons.put(R.id.emoji_widget_page_sports,((ImageView)findViewById(R.id.emoji_widget_page_sports)));
        mButtons.put(R.id.emoji_widget_page_transports,((ImageView)findViewById(R.id.emoji_widget_page_transports)));
        mButtons.put(R.id.emoji_widget_page_office,((ImageView)findViewById(R.id.emoji_widget_page_office)));
        mButtons.put(R.id.emoji_widget_page_technology,((ImageView)findViewById(R.id.emoji_widget_page_technology)));
        mButtons.put(R.id.emoji_widget_page_numbers,((ImageView)findViewById(R.id.emoji_widget_page_numbers)));
        mButtons.put(R.id.emoji_widget_page_hands,((ImageView)findViewById(R.id.emoji_widget_page_hands)));
        mButtons.put(R.id.emoji_widget_page_flags,((ImageView)findViewById(R.id.emoji_widget_page_flags)));
        mButtons.put(R.id.emoji_widget_page_brands,((ImageView)findViewById(R.id.emoji_widget_page_brands)));

        mButtons.get(R.id.emoji_widget_page_temporal).setOnClickListener(this);
        mButtons.get(R.id.emoji_widget_page_faces).setOnClickListener(this);
        mButtons.get(R.id.emoji_widget_page_celebrities).setOnClickListener(this);
        mButtons.get(R.id.emoji_widget_page_animals).setOnClickListener(this);
        mButtons.get(R.id.emoji_widget_page_nature).setOnClickListener(this);
        mButtons.get(R.id.emoji_widget_page_fashion).setOnClickListener(this);
        mButtons.get(R.id.emoji_widget_page_love).setOnClickListener(this);
        mButtons.get(R.id.emoji_widget_page_weather).setOnClickListener(this);
        mButtons.get(R.id.emoji_widget_page_food).setOnClickListener(this);
        mButtons.get(R.id.emoji_widget_page_sports).setOnClickListener(this);
        mButtons.get(R.id.emoji_widget_page_transports).setOnClickListener(this);
        mButtons.get(R.id.emoji_widget_page_office).setOnClickListener(this);
        mButtons.get(R.id.emoji_widget_page_technology).setOnClickListener(this);
        mButtons.get(R.id.emoji_widget_page_numbers).setOnClickListener(this);
        mButtons.get(R.id.emoji_widget_page_hands).setOnClickListener(this);
        mButtons.get(R.id.emoji_widget_page_flags).setOnClickListener(this);
        mButtons.get(R.id.emoji_widget_page_brands).setOnClickListener(this);

        mButtonsIds.put(0,R.id.emoji_widget_page_temporal);
        mButtonsIds.put(1,R.id.emoji_widget_page_faces);
        mButtonsIds.put(2,R.id.emoji_widget_page_celebrities);
        mButtonsIds.put(3,R.id.emoji_widget_page_animals);
        mButtonsIds.put(4,R.id.emoji_widget_page_nature);
        mButtonsIds.put(5,R.id.emoji_widget_page_fashion);
        mButtonsIds.put(6,R.id.emoji_widget_page_love);
        mButtonsIds.put(7,R.id.emoji_widget_page_weather);
        mButtonsIds.put(8,R.id.emoji_widget_page_food);
        mButtonsIds.put(9,R.id.emoji_widget_page_sports);
        mButtonsIds.put(10,R.id.emoji_widget_page_transports);
        mButtonsIds.put(11,R.id.emoji_widget_page_office);
        mButtonsIds.put(12,R.id.emoji_widget_page_technology);
        mButtonsIds.put(13,R.id.emoji_widget_page_numbers);
        mButtonsIds.put(14,R.id.emoji_widget_page_hands);
        mButtonsIds.put(15,R.id.emoji_widget_page_flags);
        mButtonsIds.put(16,R.id.emoji_widget_page_brands);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mButtons.get(lastItemSelected).setSelected(false);
        this.lastItemSelected = mButtonsIds.get(position);
        mButtons.get(lastItemSelected).setSelected(true);

        int w = mContainer.getWidth() / mButtons.size();

        mScroll.smoothScrollTo(w*position,0);


        //Log.d("EmojiWidget","L: "+mContainer.getWidth() + "|" + w);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void log(String str){
        if(debug){  Log.d("EmojiWidget",str);  }
    }

    public void onClick(View view) {
        mButtons.get(lastItemSelected).setSelected(false);
        mButtons.get(view.getId()).setSelected(true);
        switch (view.getId()){
            case R.id.emoji_widget_page_temporal:
                mPager.setCurrentItem(0);
                break;
            case R.id.emoji_widget_page_faces:
                mPager.setCurrentItem(1);
                break;
            case R.id.emoji_widget_page_celebrities:
                mPager.setCurrentItem(2);
                break;
            case R.id.emoji_widget_page_animals:
                mPager.setCurrentItem(3);
                break;
            case R.id.emoji_widget_page_nature:
                mPager.setCurrentItem(4);
                break;
            case R.id.emoji_widget_page_fashion:
                mPager.setCurrentItem(5);
                break;
            case R.id.emoji_widget_page_love:
                mPager.setCurrentItem(6);
                break;
            case R.id.emoji_widget_page_weather:
                mPager.setCurrentItem(7);
                break;
            case R.id.emoji_widget_page_food:
                mPager.setCurrentItem(8);
                break;
            case R.id.emoji_widget_page_sports:
                mPager.setCurrentItem(9);
                break;
            case R.id.emoji_widget_page_transports:
                mPager.setCurrentItem(10);
                break;
            case R.id.emoji_widget_page_office:
                mPager.setCurrentItem(11);
                break;
            case R.id.emoji_widget_page_technology:
                mPager.setCurrentItem(12);
                break;
            case R.id.emoji_widget_page_numbers:
                mPager.setCurrentItem(13);
                break;
            case R.id.emoji_widget_page_hands:
                mPager.setCurrentItem(14);
                break;
            case R.id.emoji_widget_page_flags:
                mPager.setCurrentItem(15);
                break;
            case R.id.emoji_widget_page_brands:
                mPager.setCurrentItem(16);
                break;
        }
    }
}
