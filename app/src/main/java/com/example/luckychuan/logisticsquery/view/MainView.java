package com.example.luckychuan.logisticsquery.view;

import com.example.luckychuan.logisticsquery.model.Logistics;

import java.util.List;

/**
 * Created by Luckychuan on 2017/4/18.
 */
public interface MainView {

    void updateAdapter(List<Logistics.Data> dataList);
    void showErrorToast(String errorString);
    void showProgressDialog();
    void hideProgressDialog();
}
