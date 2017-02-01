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

import com.example.cbluser35.toolbar.common.EmailValidator;
import com.example.cbluser35.toolbar.R;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener{
    EmailValidator validator=new EmailValidator();
    EditText etUser,etPass;
    Button btLogin;
    TextView tvNotLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getToolbar();
        initViews();

    }


    private void getToolbar(){
        Toolbar toolbar=(Toolbar)findViewById(R.id.tbTool);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
    }


    private void initViews(){
        tvNotLogin=(TextView)findViewById(R.id.tvSignUp);
        btLogin=(Button)findViewById(R.id.btLogin);
        btLogin.setOnClickListener(SignInActivity.this);
        tvNotLogin.setOnClickListener(SignInActivity.this);
        etUser=(EditText)findViewById(R.id.etUserLogin);
        etPass=(EditText)findViewById(R.id.etPassLogin);
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

        if(v.getId()==R.id.btLogin ){
            if(check(etUser) && check(etPass) && validator.validate(etUser.getText().toString())){

                Intent intent=new Intent(SignInActivity.this,BrandListActivity.class);
                startActivity(intent);
            }
        }

        else{
            Intent intent=new Intent(SignInActivity.this,SignUpActivity.class);
            startActivity(intent);
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
