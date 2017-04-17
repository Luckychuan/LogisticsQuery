package com.example.luckychuan.logisticsquery.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.luckychuan.logisticsquery.R;
import com.example.luckychuan.logisticsquery.model.Logistics;
import com.example.luckychuan.logisticsquery.model.QueryModel;
import com.example.luckychuan.logisticsquery.model.QueryModelImpl;

import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new QueryModelImpl().requestQuery("yuantong", "500379523313", new QueryModel.QueryCallback() {
            
            @Override
            public void onSuccess(Logistics logistics) {
                Log.d(TAG, "onSuccess: " + logistics.toString());
                for (Iterator<Logistics.Data> iterator = logistics.getDataList().iterator(); iterator.hasNext(); ) {
                    Logistics.Data data =  iterator.next();
                    Log.d(TAG, "onSuccess: "+data.toString());
                }
            }

            @Override
            public void onFail(String failMsg) {
                Log.d(TAG, "onFail: "+failMsg);
            }
        });

    }
}
