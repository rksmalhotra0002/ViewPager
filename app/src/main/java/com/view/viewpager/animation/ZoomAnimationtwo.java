package com.view.viewpager.animation;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

public class ZoomAnimationtwo implements ViewPager2.PageTransformer {

    private final float MIN_SCALE=0.70f;
    private final float MIN_ALPHA=0.5f;

    @Override
    public void transformPage(@NonNull View page, float position) {

        int pageWidth=page.getWidth();
        int pageheight=page.getHeight();

        if(position<-1)
        {
            page.setAlpha(0f);

        }
        else if (position<=1)
        {
            float scalefactor=Math.max(MIN_SCALE,1-Math.abs(position));
            float vertMargin=pageheight*(1-scalefactor)/2;
            float horMargin=pageWidth*(1-scalefactor)/2;


            if(position<0)
            {
                page.setTranslationX(horMargin-vertMargin/2);
            }

            else {
                page.setTranslationX(-horMargin+vertMargin/2);
            }


            page.setScaleX(scalefactor);
            page.setScaleY(scalefactor);

            page.setAlpha(MIN_ALPHA+
                    (scalefactor-MIN_SCALE)/
                            (1-MIN_SCALE)*
                            (1-MIN_ALPHA));
        }
        else {
            page.setAlpha(0f);
        }
    }
}
