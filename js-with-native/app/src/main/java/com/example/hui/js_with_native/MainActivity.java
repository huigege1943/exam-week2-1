package com.example.hui.js_with_native;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private OkHttpClient client;
    private String str="";
    private String link = "http://www.weather.com.cn/data/cityinfo/101010100.html";
    private Call call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView) findViewById(R.id.mainWebView);
        webView.setWebChromeClient(new WebChromeClient());
        final WebSettings settings = webView.getSettings();
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);

        webView.addJavascriptInterface(new JavascriptInterface(), "jsInterface2");
        try {
            webView.loadUrl("file:///android_asset/main.html");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public class JavascriptInterface {

        @android.webkit.JavascriptInterface
        public void toSetting() {
            Intent intent = new Intent(MainActivity.this,SettingActivity.class);
            startActivity(intent);
        }

        @android.webkit.JavascriptInterface
        public void api() throws IOException {
            getAPI();
        }
    }

    public void getAPI() throws IOException{
        client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(link)
                .addHeader("Accept", "application/json; q=0.5")
                .build();
        call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                str = response.body().string();
                System.out.println(str);

                sendPost();
            }
        });
    }

    public void sendPost(){
        webView.post(new Runnable() {
            @Override
            public void run() {
                if(str.equals("")){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else if (!str.equals("")) {
                    webView.loadUrl("javascript:getLink(\'" + link + "\')");
                    webView.loadUrl("javascript:getContent(\'" + str + "\')");
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Application.activityState = true;
        if(!Tools.isBackstage(this)){
            if(!Application.state) {
                Tools.showDialog(this, "开始工作");
                Application.state = true;
            }else if(Application.screenState==false && Application.count>=0){
                Tools.showDialog(this,"欢迎归来");
            }


        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Application.activityState = false;
        if(Tools.isBackstage(this)) {
            Log.i("State", "我休息一下");
            Application.state = false;
        }
    }
}
