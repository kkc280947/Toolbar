package com.example.cbluser35.toolbar.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cbluser35.toolbar.model.BrandModel;
import com.example.cbluser35.toolbar.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cbluser35 on 30/1/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    Activity activity;
    List<BrandModel> blist=new ArrayList<>();


    public RecyclerAdapter(Activity activity, List<BrandModel> blist) {
        this.activity=activity;
        this.blist=blist;
    }

    @Override
    public RecyclerAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(activity).inflate(R.layout.item_card,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.RecyclerViewHolder holder, int position) {
        holder.tvBrandName.setText(blist.get(position).brand);
        holder.ivBimage.setImageResource(blist.get(position).image);
    }

    @Override
    public int getItemCount() {
        return blist.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivBimage;
        private TextView tvBrandName;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            ivBimage=(ImageView)itemView.findViewById(R.id.ivBimage);
            tvBrandName=(TextView)itemView.findViewById(R.id.tvBrand);

        }
    }
}
