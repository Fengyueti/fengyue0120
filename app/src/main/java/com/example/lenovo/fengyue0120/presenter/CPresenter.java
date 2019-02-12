package com.example.lenovo.fengyue0120.presenter;

import com.example.lenovo.fengyue0120.contract.Contract;
import com.example.lenovo.fengyue0120.model.SModel;
import com.example.lenovo.fengyue0120.net.RequestCallback;

import java.util.HashMap;

public class CPresenter extends Contract.CPresenter {
    private SModel sModel;
    private Contract.CView cView;

    public CPresenter(Contract.CView cView) {
        this.sModel = new SModel();
        this.cView = cView;
    }

    @Override
    public void show(String api, HashMap<String, String> params) {
        if(sModel!=null){
            sModel.show(api, params, new RequestCallback() {
                @Override
                public void success(String result) {
                    if(cView!=null){
                        cView.onsuccess(result);
                    }
                }

                @Override
                public void failure(String msg) {
                    if(cView!=null){
                        cView.onfailure(msg);
                    }
                }
            });
        }
    }

    @Override
    public void showright(String api, HashMap<String, String> params) {
        if(sModel!=null){
            sModel.showright(api, params, new RequestCallback() {
                @Override
                public void success(String result) {
                    if(cView!=null){
                        cView.onsuccessright(result);
                    }
                }

                @Override
                public void failure(String msg) {
                    if(cView!=null){
                        cView.onfailure(msg);
                    }
                }
            });
        }
    }

    public void destroy(){
        if(cView!=null){
            cView=null;
        }
    }
}
