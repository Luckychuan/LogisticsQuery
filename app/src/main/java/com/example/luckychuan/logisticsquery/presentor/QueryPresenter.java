package com.example.luckychuan.logisticsquery.presentor;

import com.example.luckychuan.logisticsquery.model.Logistics;
import com.example.luckychuan.logisticsquery.model.QueryModel;
import com.example.luckychuan.logisticsquery.model.QueryModelImpl;
import com.example.luckychuan.logisticsquery.view.MainView;

/**
 * Created by Luckychuan on 2017/4/18.
 */
public class QueryPresenter  extends BasePresenter<MainView> {

    private QueryModel mQueryModel;
    private MainView mMainView;

    public QueryPresenter(MainView view){
        mMainView = view;
        mQueryModel = new QueryModelImpl();
    }

    public void requestData(String type,String postId){
        mMainView.showProgressDialog();
        mQueryModel.requestQuery(type, postId, new QueryModel.QueryCallback() {

            @Override
            public void onSuccess(Logistics logistics) {
                mMainView.hideProgressDialog();
                if (logistics.getStatus().equals("200")) {
                    mMainView.updateAdapter(logistics.getDataList());
                } else {
                    mMainView.showErrorToast("快递公司参数异常：单号不存在或者已经过期");
                }
            }

            @Override
            public void onFail(String failMsg) {
                mMainView.hideProgressDialog();
                if (failMsg.equals("Unable to resolve host \"www.kuaidi100.com\": No address associated with hostname")) {
                    mMainView.showErrorToast( "网络异常");
                }
            }
        });
    }


}
