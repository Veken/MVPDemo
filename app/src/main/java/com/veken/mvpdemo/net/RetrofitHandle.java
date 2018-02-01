package com.veken.mvpdemo.net;


import com.veken.mvpdemo.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;


/**
 * Retrofit 初始化
 * Created Veken
 */
public class RetrofitHandle {

    private static final int DEFAULT_TIMEOUT = 10;

    public static String BASE_URL = "https://api.douban.com/"; //测试

    public Retrofit retrofit;

    //构造方法私有
    private RetrofitHandle() {
        initRetrofit();
    }

    //获取单例
    public static RetrofitHandle getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private void initRetrofit() {
        //添加统一的log管理，打release包的时候记得将Level设置成Level.NONE
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();

        if (BuildConfig.DEBUG) {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }

        OkHttpClient.Builder builder = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);

        //手动创建一个OkHttpClient并设置超时时间
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())   //添加Gson解析
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())  //支持RxJava回调
                .baseUrl(BASE_URL)
                .build();
    }

    //在访问HttpMethods时创建单例
    private static class SingletonHolder {
        private static final RetrofitHandle INSTANCE = new RetrofitHandle();
    }
}
