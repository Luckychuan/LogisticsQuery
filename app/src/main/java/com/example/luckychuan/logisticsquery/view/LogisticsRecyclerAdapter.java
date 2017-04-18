package com.example.luckychuan.logisticsquery.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.luckychuan.logisticsquery.R;
import com.example.luckychuan.logisticsquery.model.Logistics;

import java.util.List;

/**
 * Created by Luckychuan on 2017/4/18.
 */
public class LogisticsRecyclerAdapter extends RecyclerView.Adapter<LogisticsRecyclerAdapter.ViewHolder> {

    private List<Logistics.Data> mDataList;


    public LogisticsRecyclerAdapter( List<Logistics.Data> dataList){
        mDataList = dataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Logistics.Data data = mDataList.get(position);
        holder.infoText.setText(data.getContext());
        holder.timeText.setText(data.getTime());
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView infoText;
        public TextView timeText;

        public ViewHolder(View itemView) {
            super(itemView);

            infoText = (TextView) itemView.findViewById(R.id.info_item);
            timeText = (TextView) itemView.findViewById(R.id.time_item);

        }
    }


}
