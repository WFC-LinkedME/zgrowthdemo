package cc.lkme.linktrackdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

import cc.lkme.linktrack.LinkTrack;

public class MainActivity extends AppCompatActivity {

    private Button report, login,
            user_profile_set_immutable, user_profile_set,
            user_profile_remove, user_profile_delete,
            user_profile_install_channel, flush;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("主页Title");
        report = findViewById(R.id.report);
        flush = findViewById(R.id.flush);
        login = findViewById(R.id.login);
        user_profile_set_immutable = findViewById(R.id.user_profile_set_immutable);
        user_profile_set = findViewById(R.id.user_profile_set);
        user_profile_remove = findViewById(R.id.user_profile_remove);
        user_profile_delete = findViewById(R.id.user_profile_delete);
        user_profile_install_channel = findViewById(R.id.user_profile_install_channel);
        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.putOpt("demotestboolean", true);
                    jsonObject.putOpt("demoteststring", "testStr");
                    jsonObject.putOpt("demotestnumber", 1234.4);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    jsonObject.putOpt("demotestdatetime", simpleDateFormat.format(new Date()));
                    JSONArray jsonArray = new JSONArray();
                    jsonArray.put("itemOne");
                    jsonArray.put("itemTwo");
                    jsonArray.put("3");
                    jsonObject.putOpt("demotestlist", jsonArray);
                    LinkTrack.getInstance().track("report_test_data", jsonObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        flush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinkTrack.getInstance().eventFlush();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinkTrack.getInstance().login("15510680829");
            }
        });

        user_profile_set_immutable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.putOpt("$email", "lipeng@linkedme.cc");
                    LinkTrack.getInstance().userProfileSetImmutable(jsonObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        user_profile_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.putOpt("$age", "18");
                    jsonObject.putOpt("$name", "lipeng");
                    jsonObject.putOpt("$sex", "1");
                    LinkTrack.getInstance().userProfileSet(jsonObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        user_profile_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.putOpt("$age", "");
                    LinkTrack.getInstance().userProfileRemove(jsonObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        user_profile_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinkTrack.getInstance().userProfileDelete();
            }
        });
        user_profile_install_channel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinkTrack.getInstance().setInstallChannel("应用宝");
            }
        });


    }
}
