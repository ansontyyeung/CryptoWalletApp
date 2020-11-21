package com.example.a4017btcwallet;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a4017btcwallet.utils.Xutils;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@ContentView(R.layout.activity_trans)
public class transActivity extends Activity  {



    @ViewInject(R.id.jine)
    EditText jine;


    @ViewInject(R.id.shoukuan)
    EditText shoukuan;


    @ViewInject(R.id.name)
    TextView name;

    String namest;


    String url;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        x.view().inject(transActivity.this);
        super.onCreate(savedInstanceState);
        initData();

        namest=getIntent().getStringExtra("name");


        name.setText(namest);




    }

    protected void initData() {



        findViewById(R.id.commotbutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jieest=jine.getText()+"";
                String shoukuanst=shoukuan.getText()+"";

                url=namest+"/new_transaction?address="+shoukuanst+"&amount="+jieest;

                Xutils.get(url, null, new Xutils.GetDataCallback() {
                    @Override
                    public void success(String result) {
                        OkHttpClient client = new OkHttpClient();
                        Log.e("======", result);
                        Gson gson = new Gson();//创建Gson对象  
                        Toast.makeText(transActivity.this, "Transaction Succeed", Toast.LENGTH_SHORT).show();
                        client.setConnectTimeout(30, TimeUnit.MINUTES); // connect timeout
                        client.setReadTimeout(30, TimeUnit.MINUTES);    // socket timeout
                        Xutils.get(namest+"/mine", null, new Xutils.GetDataCallback() {
                            public void success(String result) {
                                finish();
                            }
                            public void failed(String... args) {
                            }
                        });

                    }
                    @Override
                    public void failed(String... args) {
                        Toast.makeText(transActivity.this, "Transaction Fail", Toast.LENGTH_SHORT).show();
                        // Log.e(args+);

                    }
                });
            }
        });
    }
}
