package com.example.luckychuan.logisticsquery.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.luckychuan.logisticsquery.R;
import com.example.luckychuan.logisticsquery.model.Logistics;
import com.example.luckychuan.logisticsquery.model.QueryModel;
import com.example.luckychuan.logisticsquery.model.QueryModelImpl;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    private EditText mCompanyEdit;
    private EditText mIdEdit;
    private LogisticsRecyclerAdapter mAdapter;
    private List<Logistics.Data> mDataList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {
        ((Button) findViewById(R.id.query_btn)).setOnClickListener(this);
        mIdEdit = (EditText) findViewById(R.id.id_edit);
        mIdEdit.setText("500379523313");
        mCompanyEdit = (EditText) findViewById(R.id.company_edit);
        mCompanyEdit.setText("yuantong");
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        mDataList = new ArrayList<>();
        mAdapter = new LogisticsRecyclerAdapter(mDataList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter);
    }

    public void updateAdapter(List<Logistics.Data> dataList){
        mDataList.clear();
        mDataList.addAll(dataList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.query_btn:
                new QueryModelImpl().requestQuery(mCompanyEdit.getText().toString(), mIdEdit.getText().toString(), new QueryModel.QueryCallback() {

                    @Override
                    public void onSuccess(Logistics logistics) {
                        Log.d(TAG, "onSuccess: " + logistics.toString());
                        if(logistics.getStatus().equals("200")){
                            updateAdapter(logistics.getDataList());
                        }else{
                            Toast.makeText(MainActivity.this, "快递公司参数异常：单号不存在或者已经过期", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFail(String failMsg) {
                        Log.d(TAG, "onFail: " + failMsg);
                    }
                });
                break;
        }
    }
}
