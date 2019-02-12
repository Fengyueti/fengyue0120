package com.example.lenovo.fengyue0120.model;

import android.os.Handler;

import com.example.lenovo.fengyue0120.contract.Contract;
import com.example.lenovo.fengyue0120.net.OkhttpCallback;
import com.example.lenovo.fengyue0120.net.OkhttpUtils;
import com.example.lenovo.fengyue0120.net.RequestCallback;

import java.util.HashMap;

public class SModel implements Contract.CModel {
    Handler handler=new Handler();
    @Override
    public void show(String api, HashMap<String, String> params, final RequestCallback requestCallback) {
        OkhttpUtils.getmInstance().doPost(api, params, new OkhttpCallback() {
            @Override
            public void success(final String result) {
                if(requestCallback!=null){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            requestCallback.success(result);
                        }
                    });
                }
            }

            @Override
            public void failure(String msg) {
                if(requestCallback!=null){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            requestCallback.failure("网络不稳定");
                        }
                    });
                }
            }
        });
    }

  @Override
    public void showright(String api, HashMap<String, String> params, final RequestCallback requestCallback) {
        OkhttpUtils.getmInstance().doPost(api, params, new OkhttpCallback() {
            @Override
            public void success(final String result) {
                if(requestCallback!=null){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            requestCallback.success(result);
                        }
                    });
                }
            }

            @Override
            public void failure(String msg) {
                if(requestCallback!=null){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            requestCallback.failure("网络不稳定");
                        }
                    });
                }
            }
        });
    }
}
