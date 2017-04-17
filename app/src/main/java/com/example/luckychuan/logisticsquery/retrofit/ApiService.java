package com.example.luckychuan.logisticsquery.retrofit;

import com.example.luckychuan.logisticsquery.model.Logistics;

import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Luckychuan on 2017/4/17.
 */
public interface ApiService {

    @POST("query")
    Observable<Logistics> getData(@Query("type") String type, @Query("postid") String id);

}
