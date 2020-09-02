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
import com.view.viewpager.databinding.FragmentMobileBinding;

public class MobileFragment extends Fragment {

private ViewPager viewPager;
private TextView tv_next;
private FragmentMobileBinding fragmentMobileBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentMobileBinding=FragmentMobileBinding.inflate(inflater,container,false);
        View view=fragmentMobileBinding.getRoot();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        viewPager=getActivity().findViewById(R.id.viewpager);

        fragmentMobileBinding.tvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewPager.setCurrentItem(1);

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        fragmentMobileBinding=null;
    }
}