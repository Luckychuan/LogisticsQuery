package com.example.luckychuan.logisticsquery.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Luckychuan on 2017/4/17.
 */
public class Logistics {

    private String message;
    private String nu;
    private boolean isCheck;
    private String condition;
    @SerializedName("com")
    private String company;

    public Logistics(String message, String nu, boolean isCheck, String condition, String company, String status, String state, List<Data> dataList) {
        this.message = message;
        this.nu = nu;
        this.isCheck = isCheck;
        this.condition = condition;
        this.company = company;
        this.status = status;
        this.state = state;
        this.dataList = dataList;
    }

    private String status;
    private String state;
    @SerializedName("data")
    private List<Data> dataList;

    public class Data{
        private String time;
        private String context;

        public Data(String time, String context) {
            this.time = time;
            this.context = context;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "time='" + time + '\'' +
                    ", context='" + context + '\'' +
                    '}';
        }

        public String getTime() {

            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getContext() {
            return context;
        }

        public void setContext(String context) {
            this.context = context;
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNu() {
        return nu;
    }

    public void setNu(String nu) {
        this.nu = nu;
    }

    public boolean ischeck() {
        return isCheck;
    }

    public void setIscheck(boolean isCheck) {
        this.isCheck = isCheck;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Data> getDataList() {
        return dataList;
    }

    public void setDataList(List<Data> dataList) {
        this.dataList = dataList;
    }

    @Override
    public String toString() {
        return "Logistics{" +
                "message='" + message + '\'' +
                ", nu='" + nu + '\'' +
                ", isCheck=" + isCheck +
                ", condition='" + condition + '\'' +
                ", company='" + company + '\'' +
                ", status='" + status + '\'' +
                ", state='" + state + '\'' +
                ", dataList=" + dataList +
                '}';
    }
}
