package com.example.hui.js_with_native;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by hui on 2017/3/10.
 */

public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }
}
