package com.example.hui.js_with_native;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class SettingActivity extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        webView = (WebView) findViewById(R.id.settingWebView);
        webView.setWebChromeClient(new WebChromeClient());
        final WebSettings settings = webView.getSettings();
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);

        webView.addJavascriptInterface(new JavascriptInterface(), "jsInterface3");
        try {
            webView.loadUrl("file:///android_asset/setting.html");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public class JavascriptInterface {

        @android.webkit.JavascriptInterface
        public void toMain() {

            finish();

        }

        @android.webkit.JavascriptInterface
        public void toLogin() {
            Intent intent = new Intent(SettingActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK  | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();

        }
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
