package com.example.cbluser35.toolbar.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cbluser35.toolbar.R;

/**
 * Created by cbluser3 on 31/1/17.
 */

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvSignin;EditText etFname,etLname,etEmailUp,etPassUp;
    Button btSignup;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        setToolbar();
        initView();

    }
    private void initView(){
        tvSignin=(TextView)findViewById(R.id.tvSignin);
        tvSignin.setOnClickListener(SignUpActivity.this);
        etFname=(EditText)findViewById(R.id.etFname);
        etLname=(EditText)findViewById(R.id.etLname);
        etEmailUp=(EditText)findViewById(R.id.etEmail);
        etPassUp=(EditText)findViewById(R.id.etSignPass);

        btSignup=(Button)findViewById(R.id.btLogin);
        btSignup.setOnClickListener(SignUpActivity.this);
    }

    private void setToolbar(){
        toolbar=(Toolbar)findViewById(R.id.tbTool);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
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

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.tvSignin) {
            Intent intent = new Intent(this, SignInActivity.class);
            startActivity(intent);
        }
        else{
            if(check(etFname) && check(etLname) && check(etEmailUp) && check(etPassUp)){
                Intent intent = new Intent(this, BrandListActivity.class);
                startActivity(intent);
            }


        }
    }

    private boolean check(EditText et)
    {
        if(et.getText().toString().isEmpty())
        {
            et.setError(et.getHint().toString()+getResources().getString(R.string.error));
            et.requestFocus();
            return false;
        }
        return true;
    }
}
