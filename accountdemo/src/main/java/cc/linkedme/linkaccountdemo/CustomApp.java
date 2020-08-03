package cc.linkedme.linkaccountdemo;

import android.app.Application;

import cc.lkme.common.LinkGrowth;


public class CustomApp extends Application {

    // 替换成正式Key
    private String appKey = "7e289a2484f4368dbafbd1e5c7d06903";

    @Override
    public void onCreate() {
        super.onCreate();
        LinkGrowth.getInstance(getApplicationContext(), appKey);
        if (BuildConfig.DEBUG) {
            LinkGrowth.getInstance().setDebug();
        }
        // 设置用户协议授权状态，如果不设置，默认true，如果设置为false，则在用户同意后设置为true，否则不发送任何请求
        // demo此处设置为true
        LinkGrowth.getInstance().setPrivacyStatus(true);
    }
}
