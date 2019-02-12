package com.example.lenovo.fengyue0120.app;

import android.app.Application;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

public class App extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        UMConfigure.init(this,"5c39cbd5b465f51241000d5d","umeng",UMConfigure.DEVICE_TYPE_PHONE,""); //5c39cbd5b465f51241000d5d
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
    }
}
