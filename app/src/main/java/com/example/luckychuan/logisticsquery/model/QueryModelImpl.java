package com.example.luckychuan.logisticsquery.model;

import com.example.luckychuan.logisticsquery.retrofit.ApiService;
import com.example.luckychuan.logisticsquery.retrofit.RetrofitUtil;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Luckychuan on 2017/4/17.
 */
public class QueryModelImpl implements QueryModel {

    @Override
    public void requestQuery(String type, String postId, final QueryCallback callback) {
        RetrofitUtil.getInstance()
                .getRetrofit()
                .create(ApiService.class)
                .getData(type,postId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Logistics>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(e.getMessage());
                    }

                    @Override
                    public void onNext(Logistics logistics) {
                        callback.onSuccess(logistics);
                    }
                });
    }
}
