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
