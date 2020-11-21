package com.example.a4017btcwallet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a4017btcwallet.utils.Xutils;
import com.google.gson.Gson;

import org.xutils.ex.DbException;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ContentView(R.layout.activity_login)
public class LoginActivity extends Activity {

    @ViewInject(R.id.tv_regi)
    TextView tv_regi;
    @ViewInject(R.id.tv_login)
    TextView tv_login;
    @ViewInject(R.id.et_phone)
    EditText et_phone;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        x.view().inject(LoginActivity.this);
        super.onCreate(savedInstanceState);
        initListener();
    }



    protected void initListener() {



        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempPhone = et_phone.getText().toString()+"";

                // loginhttp( tempPhone );

                loginbendi( tempPhone );
            }
        });
    }

    public void loginbendi(final String username )
    {


        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.putExtra("name", username);
        startActivity(intent);
        finish();
    }

    public void loginhttp( String username )
    {

        if(username.equals(""))
        {
            username="0";
        }


        final int lastuser=Integer.parseInt(username);

        Xutils.get(lastuser+"/register_node?node="+(lastuser-1)+"&com_port="+lastuser, null, new Xutils.GetDataCallback() {
            @Override
            public void success(String result) {

                Log.e("======", result);
                Gson gson = new Gson();//创建Gson对象  

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("name", lastuser+"");
                startActivity(intent);
                finish();

            }

            @Override
            public void failed(String... args) {
                Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                // Log.e(args+);


            }
        });
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

}

