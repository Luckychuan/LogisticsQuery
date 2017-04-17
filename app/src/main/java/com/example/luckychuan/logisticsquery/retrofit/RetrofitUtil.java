package com.example.luckychuan.logisticsquery.retrofit;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Luckychuan on 2017/4/17.
 */
public class RetrofitUtil {

    private static RetrofitUtil mRetrofitUtil;
    private Retrofit mRetrofit;
    private static final String mBaseUrl = "http://www.kuaidi100.com/";

    private RetrofitUtil(){}

    public static RetrofitUtil getInstance(){
        if(mRetrofitUtil != null){
            return mRetrofitUtil;
        }
        mRetrofitUtil = new RetrofitUtil();
        return mRetrofitUtil;
    }

    /**
     * 初始化okhttp和retrofit
     */
    public void init(Context context){
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .writeTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                .cache(new Cache(context.getCacheDir(),10*1024*1024))
                .build();

        mRetrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

    }

    public Retrofit getRetrofit(){
        return  mRetrofit;
    }




}
