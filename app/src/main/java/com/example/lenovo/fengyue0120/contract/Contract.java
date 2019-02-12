package com.example.lenovo.fengyue0120.contract;

import com.example.lenovo.fengyue0120.net.RequestCallback;

import java.util.HashMap;

public interface Contract {
    public abstract class CPresenter{
        public abstract void show(String api, HashMap<String,String> params);
        public abstract void showright(String api, HashMap<String,String> params);

    }
    interface CModel{
        void show(String api, HashMap<String,String> params, RequestCallback requestCallback);
        void showright(String api, HashMap<String,String> params, RequestCallback requestCallback);
    }
    interface CView{
        void onsuccess(String result);
        void onsuccessright(String result);
        void onfailure(String msg);
    }
}
