package com.example.welcome;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by user on 4/17/2018.
 */

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater myLayoutinflator;

    public SliderAdapter(Context context) {
        this.context = context;

    }

    public int[] slide_images = {
            R.drawable.eat_icon,
            R.drawable.sleep_icon,
            R.drawable.learn_icon
    };




    public String[] slide_headings = {
            "EAT",
            "SLEEP",
            "Learn"
    };

    public String[]  slide_desc ={
            "If you don't cut the cake in pieces and just eat the whole cake, then you only had one piece.",
            "Don't give up on your dreams so soon,...sleep longer.",
            "Sometimes you succeed.... and other times you learn."
    };









    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == (RelativeLayout) o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        //return super.instantiateItem(container, position);

        myLayoutinflator = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = myLayoutinflator.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescription = (TextView) view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_desc[position]);


        container.addView(view);


        return view;




    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object){
      container.removeView((RelativeLayout) object);
    }





}
