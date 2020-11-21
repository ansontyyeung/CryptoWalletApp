/**
 * Created on Tue Nov 3 2020
 *
 * @author: tungyanyeung
 */
package com.example.a4017btcwallet;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a4017btcwallet.bean.transhist;
import com.example.a4017btcwallet.bean.userwallet;
import com.example.a4017btcwallet.utils.Xutils;
import com.google.gson.Gson;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_main)

public class MainActivity extends AppCompatActivity {

    String pubkey;

    @ViewInject(R.id.listvew)
    ListView listvew;

    @ViewInject(R.id.zhuan)
    TextView zhuan;

    @ViewInject(R.id.geren)
    ImageView geren;
    String name;

    List<transhist.ChainBean.TransactionsBean> list=new ArrayList<>();
    transhist  transhist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        x.view().inject(MainActivity.this);
        super.onCreate(savedInstanceState);
        name=getIntent().getStringExtra("name");

        zhuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, transActivity.class);
                intent.putExtra("name", name);
                startActivity(intent);

            }
        });
        geren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, UserActivity.class);
                intent.putExtra("name", name);
                startActivity(intent);

            }
        });

    }


    @Override
    protected void onResume() {
        super.onResume();
        infohttp(name);
        loginhttp( name );

        //datebend( name );

    }

    public void datebend(final String username )
    {


        String result="{\"chain\": [{\"index\": 0, \"transactions\": [{\"sender\": \"Block_Reward\", \"recipient\": \"30819f300d06092a864886f70d010101050003818d0030818902818100ac388dd12b77d9cfc4cf08127c194bc6b0a8113dfe8b17ff19ddf3543faa2b076a120cfd604ce2c71588fa76d5ef0b729c36cf7389c0fbe3af7cb28b0ff92dd8abcb5e1cb74c669fb05997aef4792666449aab4647b8385fa3819c75c4a45637a9a89198ec9d58c1d1cb44f2262c83837e19b41f1d0489699d4d0b3dc6a30bff0203010001\", \"value\": \"5.0\"}], \"timestamp\": \"11/06/2020, 20:15:00\", \"previous_hash\": \"0\", \"hash\": \"3a788cb5d28e3e1447eca1789d597c622ac5c056ddd27acb80f4dae1c0665c62\", \"nonce\": 0}, {\"index\": 1, \"transactions\": [{\"sender\": \"Block_Reward\", \"recipient\": \"30819f300d06092a864886f70d010101050003818d0030818902818100af4bd084d5d74412af39c8667ad6cc13e7e2c8b34f2bb894674f4e92ec3d70a24e3c3ac5b50aff6629e3829211649aa9abbef68f4eb168dc109520ed2de2d2071e611b2f8efbf176d45955208345772ade3861f6101e0a89044277e6b4eeeb77501175f1a75b0cc4d0b790b1b7351ac8187af09cebcf008aecd9db596c286b6f0203010001\", \"value\": \"5.0\"}, {\"sender\": \"30819f300d06092a864886f70d010101050003818d0030818902818100d2db4ecac72e6f0dcdd291a3782c48f15a80029106b643153ac47bdff2a7ddb35aeb6888127f51b6a411a4c5934f3b407d89ada1060c97694048e7440c54c42b09d9067fad2a6288ee365558773c3f90b569d0299eecffe50ff2137572632a5395dba77b81b95ea8e09323ca1b1cf9e7aa134c39b872cc723805d6c2769e3a4f0203010001\", \"recipient\": \"30819f300d06092a864886f70d010101050003818d0030818902818100ac388dd12b77d9cfc4cf08127c194bc6b0a8113dfe8b17ff19ddf3543faa2b076a120cfd604ce2c71588fa76d5ef0b729c36cf7389c0fbe3af7cb28b0ff92dd8abcb5e1cb74c669fb05997aef4792666449aab4647b8385fa3819c75c4a45637a9a89198ec9d58c1d1cb44f2262c83837e19b41f1d0489699d4d0b3dc6a30bff0203010001\", \"value\": \"5\", \"signature\": \"36e8a676f77155c587654f198cdcc057822da4ee7c69112f7d02e7db148e7d56b4473f14ad9ef2ff7e7d1e40478a0ddd022025b3a878bd12990995e570ae12cd60f8646808cd146cd5fba8c2572cc7543074896231a6c527b8e94a402cbd1ea4d270ae308f40fe78d60fc8864dc163cdcc5c695774198c74b43cb49bdfb4cb7d\"}], \"timestamp\": \"11/06/2020, 20:17:21\", \"previous_hash\": \"3a788cb5d28e3e1447eca1789d597c622ac5c056ddd27acb80f4dae1c0665c62\", \"hash\": \"003827b13d59b0a0c5b23eaf78dbd63d5defa95b2dbdb5751d5dd81d22f46da8\", \"nonce\": 214}], \"length\": 2}";
        Gson gson = new Gson();//创建Gson对象  

        transhist=gson.fromJson(result,transhist.class);

        list.clear();

        if(transhist!=null)
        {
            for (int i=0;i<transhist.getChain().size();i++)
            {
                list.addAll(transhist.getChain().get(i).getTransactions());
            }

            listvew.setAdapter(new transAdapter());
        }
    }

    public void infohttp(final String username)
    {
        Xutils.get(username+"/get_info", null, new Xutils.GetDataCallback() {
            @Override
            public void success(String result) {
                Log.e("======", result);
                Gson gson = new Gson();
                userwallet q=gson.fromJson(result,userwallet.class);

                if(q!=null)
                {
                    pubkey = q.getPublic_key();
                }
            }

            @Override
            public void failed(String... args) {
                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                // Log.e(args+);

            }
        });
    }


    public void loginhttp(final String username )
    {
        Xutils.get(username+"/fullchainforapp", null, new Xutils.GetDataCallback() {
            @Override
            public void success(String result) {

                Log.e("======", result);
                Gson gson = new Gson();
                list.clear();

                transhist=gson.fromJson(result,transhist.class);
                if(transhist!=null)
                {
                    for (int i=0;i<transhist.getChain().size();i++)
                    {


                        for (int j=0;j<transhist.getChain().get(i).getTransactions().size();j++)
                        {
                            if(transhist.getChain().get(i).getTransactions().get(j).getSender().equals(pubkey) ||
                                    transhist.getChain().get(i).getTransactions().get(j).getRecipient().equals(pubkey)) {
                                list.add(transhist.getChain().get(i).getTransactions().get(j));
                            }
                        }
                    }
                    listvew.setAdapter(new transAdapter());
                }

            }

            @Override
            public void failed(String... args) {
                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                // Log.e(args+);


            }
        });
    }


    class transAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return list.size();
        }

        @SuppressLint("ResourceAsColor")
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.trans_item,null);
            TextView name = view.findViewById(R.id.name);
            name.setMovementMethod(new ScrollingMovementMethod());
            TextView data = view.findViewById(R.id.data);
            TextView sender = view.findViewById(R.id.sender);
            sender.setMovementMethod(new ScrollingMovementMethod());
            TextView type = view.findViewById(R.id.type);
            TextView fee = view.findViewById(R.id.fee);
            sender.setText("Sender:" + list.get(position).getSender());
            name.setText("Recipient:" + list.get(position).getRecipient());
            data.setText("Amount：" + list.get(position).getValue());

            if(list.get(position).getSender().equals(pubkey)) {
                sender.setText("Sender: Me");
                type.setText("Sent");
                fee.setText("Fee: " + list.get(position).getFee());
            }

            if(list.get(position).getRecipient().equals(pubkey)) {
                name.setText("Recipient：Me");
                type.setText("Received");
            }

            return view;
        }




    }
}

