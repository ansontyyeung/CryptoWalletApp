package com.example.a4017btcwallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a4017btcwallet.bean.userwallet;
import com.example.a4017btcwallet.utils.Xutils;
import com.google.gson.Gson;

public class UserActivity extends AppCompatActivity {


    TextView  userwallet,usernametv,userkey;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        userwallet=findViewById(R.id.userwallet);
        usernametv=findViewById(R.id.usernametv);
        userkey=findViewById(R.id.userkey);


        findViewById(R.id.tuichu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        String name = getIntent().getStringExtra("name");

        usernametv.setText(name);


        Xutils.get(name+"/get_info", null, new Xutils.GetDataCallback() {
            @Override
            public void success(String result) {

                Log.e("======", result);
                Gson gson = new Gson();//创建Gson对象  
                userwallet q=gson.fromJson(result,userwallet.class);

                if(q!=null)
                {
                    userwallet.setText(q.getBalance()+"");
                    userkey.setText("My key: " + q.getPublic_key()+"");
                }

            }
            @Override
            public void failed(String... args) {
                Toast.makeText(UserActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                // Log.e(args+);

            }
        });
    }
}
