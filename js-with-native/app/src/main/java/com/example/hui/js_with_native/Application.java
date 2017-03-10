package com.example.hui.js_with_native;

import android.content.Context;
import android.util.Log;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by hui on 2017/3/10.
 */

public class Application extends android.app.Application {
    Context context;
    public static Boolean screenState = true;
    public static int count = 0;
    public static Boolean activityState= true;
    public static Boolean state = true;

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
        context = this;
        ScreenListener l = new ScreenListener(this);
        l.begin(new ScreenListener.ScreenStateListener() {

            @Override
            public void onUserPresent() {

                screenState = true;
                count = count + 1;
                if(activityState==false){
                    Log.e("State","我知道但不吭声");
                }
            }

            @Override
            public void onScreenOn() {
            }

            @Override
            public void onScreenOff() {
                screenState=false;
            }
        });
    }
}
