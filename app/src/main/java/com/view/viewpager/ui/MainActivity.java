package com.view.viewpager.ui;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.view.viewpager.R;
import com.view.viewpager.animation.ZoomAnimation;
import com.view.viewpager.databinding.ActivityMainBinding;
import com.view.viewpager.fragment.DemoFragment;
import com.view.viewpager.walkthrough.WalkthroughAdapter;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

private ActivityMainBinding activityMainBinding;

private WalkthroughAdapter walkthroughAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding=ActivityMainBinding.inflate(getLayoutInflater());
        View view=activityMainBinding.getRoot();
        setContentView(view);

      //  checkFirstOpen();

        getids();
    }

    private void getids() {

    //   Timer timer=new Timer();
      // timer.scheduleAtFixedRate(new Timertasks(),1000,2000);

         setadapterforviewpager();
    }

    private void setadapterforviewpager()
    {

         walkthroughAdapter = new WalkthroughAdapter(getSupportFragmentManager());
       activityMainBinding.viewpager.setAdapter(walkthroughAdapter);
     //  activityMainBinding.viewpager.setPageTransformer(true,new ZoomAnimation());

        activityMainBinding.dotsIndicator.setViewPager(activityMainBinding.viewpager);

    }

    private void checkFirstOpen(){

        boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);

        if (!isFirstRun) {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            startActivity(intent);
            finish();

        }

        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("isFirstRun",
                false).apply();
    }



    public class Timertasks extends TimerTask
    {
        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if(activityMainBinding.viewpager.getCurrentItem()==0)
                    {
                        activityMainBinding.viewpager.setCurrentItem(1);
                    }
                    else if(activityMainBinding.viewpager.getCurrentItem()==1)
                    {
                        activityMainBinding.viewpager.setCurrentItem(2);
                    }
                    else
                    {
                        activityMainBinding.viewpager.setCurrentItem(0);
                    }
                }
            });
        }
    }
}
