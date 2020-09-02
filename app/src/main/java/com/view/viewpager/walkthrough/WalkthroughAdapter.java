package com.view.viewpager.walkthrough;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import com.view.viewpager.R;
import com.view.viewpager.fragment.CodeFragment;
import com.view.viewpager.fragment.DemoFragment;
import com.view.viewpager.fragment.MobileFragment;
import com.view.viewpager.fragment.YoutubeFragment;
import com.view.viewpager.ui.MainActivity;

public class WalkthroughAdapter extends FragmentPagerAdapter {

    public WalkthroughAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

   switch (position)
   {
       case 0:
           return new MobileFragment();
       case 1:
           return new YoutubeFragment();
       case 2:
           return new CodeFragment();

       default:
           return null;
   }

    }

    @Override
    public int getCount() {
        return 3;
    }
}
