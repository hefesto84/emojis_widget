package com.mondeapp.emojis.widget;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by dani on 29/6/16.
 */
public class EmojiPageAdapter extends PagerAdapter {

    private List<EmojiGridView> views;

    public EmojiPageAdapter(List<EmojiGridView> views){
        this.views = views;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View v = views.get(position).rootView;
        ((ViewPager)container).addView(v, 0);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object view) {
        ((ViewPager)container).removeView((View)view);
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object key) {
        return key == view;
    }

}
