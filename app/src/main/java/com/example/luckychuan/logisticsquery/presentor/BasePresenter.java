package com.example.luckychuan.logisticsquery.presentor;

/**
 * Created by Luckychuan on 2017/4/18.
 */
public abstract  class BasePresenter<T> {

    public T mView;

    public void attach(T view){
        mView = view;
    }

    public void detach(){
        mView = null;
    }

}
