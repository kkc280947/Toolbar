package com.example.cbluser35.toolbar.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.cbluser35.toolbar.R;
import com.example.cbluser35.toolbar.adapter.RecycleAdapterCard;
import com.example.cbluser35.toolbar.model.BrandModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cbluser3 on 31/1/17.
 */

public class CardViewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<BrandModel> blist=new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_card);
        init();
        addData();

    }

    private void init(){
        recyclerView=(RecyclerView)findViewById(R.id.rvList);
    }
    private void addData(){

        blist.add(new BrandModel("Albertsons",R.drawable.logo_albertsons));
        blist.add(new BrandModel("Adidas",R.drawable.logo_adidas));
        blist.add(new BrandModel("Aerie",R.drawable.logo_aerie));
        blist.add(new BrandModel("Aeropostle",R.drawable.logo_aeropostale));
        blist.add(new BrandModel("Almo Drafthouse ",R.drawable.logo_alamo));
        blist.add(new BrandModel("Adidas",R.drawable.logo_adidas));
        blist.add(new BrandModel("Adidas",R.drawable.logo_adidas));
        blist.add(new BrandModel("Adidas",R.drawable.logo_adidas));
        blist.add(new BrandModel("Adidas",R.drawable.logo_adidas));

        RecycleAdapterCard recycleAdapter=new RecycleAdapterCard(this,blist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(recycleAdapter);
    }
}
