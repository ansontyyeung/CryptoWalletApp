/**
 * Created on Tue Nov 3 2020
 *
 * @author: tungyanyeung
 */
package com.example.a4017btcwallet.utils;

import org.xutils.common.Callback;
import org.xutils.common.util.DensityUtil;
import org.xutils.common.util.KeyValue;
import org.xutils.http.RequestParams;
import org.xutils.http.body.MultipartBody;
import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.List;
import java.util.Map;

public class Xutils {

    public static  final String BASE_URL = "http://10.0.2.2:";
    //  public static  final String BASE_URL = "http://192.168.3.7:8080";


    public static void get(String url, Map<String, Object> parms, final GetDataCallback callback) {
        RequestParams params = new RequestParams(BASE_URL + url);
        if(parms!=null){
            for (String key : parms.keySet()) {
                params.addParameter(key, parms.get(key));
            }
        }
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                callback.success(result);
            }
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                callback.failed();
            }
            @Override
            public void onCancelled(CancelledException cex) {}
            @Override
            public void onFinished() {}
        });
    }


    /**Callback interface*/
    public interface GetDataCallback {
        void success(String result);
        void failed(String... args);
    }





}
