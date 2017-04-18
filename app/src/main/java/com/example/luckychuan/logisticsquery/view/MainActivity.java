package com.example.luckychuan.logisticsquery.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.luckychuan.logisticsquery.R;
import com.example.luckychuan.logisticsquery.model.Logistics;
import com.example.luckychuan.logisticsquery.model.QueryModel;
import com.example.luckychuan.logisticsquery.model.QueryModelImpl;

import java.util.Iterator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    private EditText mCompanyEdit;
    private EditText mIdEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        new QueryModelImpl().requestQuery("yuantong", "500379523313", new QueryModel.QueryCallback() {

            @Override
            public void onSuccess(Logistics logistics) {
                Log.d(TAG, "onSuccess: " + logistics.toString());
                for (Iterator<Logistics.Data> iterator = logistics.getDataList().iterator(); iterator.hasNext(); ) {
                    Logistics.Data data = iterator.next();
                    Log.d(TAG, "onSuccess: " + data.toString());
                }
            }

            @Override
            public void onFail(String failMsg) {
                Log.d(TAG, "onFail: " + failMsg);
            }
        });

    }

    private void initView() {
        ((Button) findViewById(R.id.query_btn)).setOnClickListener(this);
        mIdEdit = (EditText) findViewById(R.id.id_edit);
        mCompanyEdit = (EditText) findViewById(R.id.company_edit);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.query_btn:
                break;
        }
    }
}
