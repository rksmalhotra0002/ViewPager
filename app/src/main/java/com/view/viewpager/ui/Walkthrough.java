package com.view.viewpager.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;
import com.view.viewpager.R;
import com.view.viewpager.animation.ZoomAnimation;
import com.view.viewpager.animation.ZoomAnimationtwo;
import com.view.viewpager.databinding.ActivityWalkthroughBinding;
import com.view.viewpager.fragment.ChatFragment;
import com.view.viewpager.model.Model;
import com.view.viewpager.walkthrough.RecyclerviewAdapter;
import com.view.viewpager.walkthrough.WalkthroughAdapter;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Walkthrough extends AppCompatActivity {

private ActivityWalkthroughBinding activityWalkthroughBinding;
private RecyclerviewAdapter recyclerviewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        activityWalkthroughBinding=ActivityWalkthroughBinding.inflate(getLayoutInflater());
        View view=activityWalkthroughBinding.getRoot();
        setContentView(view);

        getids();

    }

    private void  getids()
    {

        Timer timer=new Timer();
        timer.scheduleAtFixedRate(new Timertasks(),2000,4000);

        setAdapterforviewpager2();
    }

    public void btnNextClickd(View v)
    {
        int current=getitemd(1);

        if(current<recyclerviewAdapter.arrayList.size())
        {
            activityWalkthroughBinding.viewpager2.setCurrentItem(current);
        }

    else
            {
                ChatFragment chatFragment=new ChatFragment();
              getSupportFragmentManager().beginTransaction().replace(R.id.cons,chatFragment).addToBackStack(null).commit();
            }
    }

    private int getitemd(int i)
    {
        return activityWalkthroughBinding.viewpager2.getCurrentItem()+i;
    }

    public void btnpreviouss(View v)
    {
        int currents=getItemss(1);
        if(currents<recyclerviewAdapter.arrayList.size())
        {
            activityWalkthroughBinding.viewpager2.setCurrentItem(currents);
        }

    }
    private int getItemss(int i) {
        return activityWalkthroughBinding.viewpager2.getCurrentItem() - i;
    }

    private void setAdapterforviewpager2()
    {
        ArrayList<Model>a=new ArrayList<>();

        a.add(new Model("Mobile Development",R.drawable.ic_undraw_mobile_development));
        a.add(new Model("Youtube Tutorial",R.drawable.ic_undraw_youtube_tutorial));
        a.add(new Model("Code Snippets",R.drawable.ic_undraw_my_code_snippets));

        recyclerviewAdapter=new RecyclerviewAdapter(a,this);
        activityWalkthroughBinding.viewpager2.setAdapter(recyclerviewAdapter);

        activityWalkthroughBinding.viewpager2.setPageTransformer(new ZoomAnimationtwo());

        activityWalkthroughBinding.wormDotsViewpager2.setViewPager2(activityWalkthroughBinding.viewpager2);

        setlistenerforviewpager2();
    }

    private void setlistenerforviewpager2()
    {

        activityWalkthroughBinding.viewpager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                if (position==0) {

                    activityWalkthroughBinding.tvViewpagerNext.setText(R.string.next);
                    activityWalkthroughBinding.tvViewpagerNext.setEnabled(true);
                      activityWalkthroughBinding.tvViewpagerNext.setVisibility(View.VISIBLE);
                    activityWalkthroughBinding.tvViewpagerPrevious.setEnabled(false);
                    activityWalkthroughBinding.tvViewpagerPrevious.setVisibility(View.GONE);

                }
                else if(position==1)
                {
                      activityWalkthroughBinding.tvViewpagerNext.setText(R.string.next);
                      activityWalkthroughBinding.tvViewpagerNext.setEnabled(true);
                      activityWalkthroughBinding.tvViewpagerNext.setVisibility(View.VISIBLE);
                    activityWalkthroughBinding.tvViewpagerPrevious.setText(R.string.previous);
                    activityWalkthroughBinding.tvViewpagerPrevious.setEnabled(true);
                    activityWalkthroughBinding.tvViewpagerPrevious.setVisibility(View.VISIBLE);
                }
                else if(position==2)
                {
                      activityWalkthroughBinding.tvViewpagerNext.setText(R.string.conts);
                      activityWalkthroughBinding.tvViewpagerNext.setEnabled(true);
                      activityWalkthroughBinding.tvViewpagerNext.setVisibility(View.VISIBLE);
                    activityWalkthroughBinding.tvViewpagerPrevious.setText(R.string.previous);
                    activityWalkthroughBinding.tvViewpagerPrevious.setEnabled(true);
                    activityWalkthroughBinding.tvViewpagerPrevious.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    public class Timertasks extends TimerTask
    {
        @Override
        public void run() {
        Walkthrough.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {

                if(activityWalkthroughBinding.viewpager2.getCurrentItem()==0)
                {
                    activityWalkthroughBinding.viewpager2.setCurrentItem(1);
                }
                else if(activityWalkthroughBinding.viewpager2.getCurrentItem()==1)
                {
                    activityWalkthroughBinding.viewpager2.setCurrentItem(2);
                }
                else
                {
                    activityWalkthroughBinding.viewpager2.setCurrentItem(0);
                }
            }
        });
        }

    }
}
