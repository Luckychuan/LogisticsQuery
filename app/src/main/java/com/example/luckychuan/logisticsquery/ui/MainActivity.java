package com.example.luckychuan.logisticsquery.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.luckychuan.logisticsquery.R;
import com.example.luckychuan.logisticsquery.model.Logistics;
import com.example.luckychuan.logisticsquery.presentor.QueryPresenter;
import com.example.luckychuan.logisticsquery.view.MainView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MainView {

    private static final String TAG = "MainActivity";
    private ProgressDialog mProgressDialog;
    private EditText mCompanyEdit;
    private EditText mIdEdit;
    private LogisticsRecyclerAdapter mAdapter;
    private List<Logistics.Data> mDataList;
    private QueryPresenter mQueryPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("查询中...");

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

        mQueryPresenter = new QueryPresenter(this);
        mQueryPresenter.attach(this);

    }

    public void updateAdapter(List<Logistics.Data> dataList) {
        mDataList.clear();
        mDataList.addAll(dataList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorToast(String errorString) {
        Toast.makeText(MainActivity.this, errorString, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressDialog() {
        mProgressDialog.show();
    }

    @Override
    public void hideProgressDialog() {
        if (mProgressDialog.isShowing()) {
            mProgressDialog.hide();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.query_btn:
                mQueryPresenter.requestData(mCompanyEdit.getText().toString(),mIdEdit.getText().toString());
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mQueryPresenter.detach();
    }
}
