package com.example.luckychuan.logisticsquery.model;

/**
 * Created by Luckychuan on 2017/4/17.
 */
public interface QueryModel {

    /**
     *
     * @param type  快递公式名称
     * @param postId  快递单号
     * @param callback  查询结果的回调
     */
    void requestQuery(String type, String postId, QueryCallback callback);

    interface QueryCallback{
        void onSuccess(Logistics logistics);
        void onFail(String failMsg);
    }

}
