package com.view.viewpager.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.view.viewpager.R;
import com.view.viewpager.databinding.FragmentYoutubeBinding;

public class YoutubeFragment extends Fragment {

    private ViewPager viewPager;
    private FragmentYoutubeBinding fragmentYoutubeBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentYoutubeBinding=FragmentYoutubeBinding.inflate(inflater,container,false);

        View view=fragmentYoutubeBinding.getRoot();

        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewPager=getActivity().findViewById(R.id.viewpager);

        fragmentYoutubeBinding.tvNextTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewPager.setCurrentItem(2);
            }
        });
        fragmentYoutubeBinding.tvPreviousTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentYoutubeBinding=null;
    }
}
