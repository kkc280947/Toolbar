package com.example.cbluser35.toolbar.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.cbluser35.toolbar.adapter.RecyclerAdapter;
import com.example.cbluser35.toolbar.model.BrandModel;
import com.example.cbluser35.toolbar.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cbluser3 on 31/1/17.
 */

public class BrandListActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<BrandModel> blist=new ArrayList<>();
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand_list);
        setToolbar();
        initView();
        addData();

    }
    /*RecyclerView */
    private void initView(){
        recyclerView=(RecyclerView)findViewById(R.id.rvList);
    }
    /*Toolbar*/
    private void setToolbar(){
        toolbar=(Toolbar)findViewById(R.id.tbToolHome);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
    }

    /* Adding Elements in activity_brand_list*/
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

        RecyclerAdapter recyclerAdapter=new RecyclerAdapter(this,blist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(recyclerAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){

            case android.R.id.home:{
                onBackPressed();
            }

         /*   case R.id.toolMenu:{
                onBackPressed();
                break;
            } */
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.clear();
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onPrepareOptionsMenu(menu);
    }

}