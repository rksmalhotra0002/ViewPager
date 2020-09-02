package com.view.viewpager.walkthrough;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.view.viewpager.R;
import com.view.viewpager.databinding.WalkthroughLayoutBinding;
import com.view.viewpager.model.Model;

import java.util.ArrayList;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder> {

public ArrayList<Model> arrayList;
private Context context;

public RecyclerviewAdapter(ArrayList<Model>arrayList,Context context)
{
    this.arrayList=arrayList;
    this.context=context;
}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
       WalkthroughLayoutBinding walkthroughLayoutBinding=WalkthroughLayoutBinding.inflate(layoutInflater,parent,false);
        return new ViewHolder(walkthroughLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Model model=arrayList.get(position);
        holder.walkthroughLayoutBinding.tvText.setText(model.getName());
        holder.walkthroughLayoutBinding.ivImage.setImageResource(model.getImage());
    }

    @Override
    public int getItemCount() {

        return arrayList.size();

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

     WalkthroughLayoutBinding walkthroughLayoutBinding;

        public ViewHolder(WalkthroughLayoutBinding walkthroughLayoutBinding) {
            super(walkthroughLayoutBinding.getRoot());

            this.walkthroughLayoutBinding=walkthroughLayoutBinding;

        }
    }
}
