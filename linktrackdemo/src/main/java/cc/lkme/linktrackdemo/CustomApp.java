package cc.lkme.linktrackdemo;

import android.app.Application;

import org.json.JSONException;
import org.json.JSONObject;

import cc.lkme.common.LinkGrowth;
import cc.lkme.linktrack.LinkTrack;

public class CustomApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LinkGrowth.getInstance(this, "7e289a2484f4368dbafbd1e5c7d06903");
        if (BuildConfig.DEBUG) {
            //设置debug模式下打印LinkedME日志
            LinkGrowth.getInstance().setDebug();
        }
        // 设置用户协议授权状态，如果不设置，默认true，如果设置为false，则在用户同意后设置为true，否则不发送任何请求
        // demo此处设置为true
        LinkGrowth.getInstance().setPrivacyStatus(true);
        JSONObject commonProperties = new JSONObject();
        try {
            commonProperties.put("demoappversion", "1.0.1");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        LinkTrack.getInstance().setCommonProperties(commonProperties);
    }
}
