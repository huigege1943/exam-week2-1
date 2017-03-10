package com.example.hui.js_with_native;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import java.util.List;

/**
 * Created by hui on 2017/3/10.
 */

public class Tools {

    public static boolean isBackstage(Context context) {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> list = am.getRunningAppProcesses();
        for (ActivityManager.RunningAppProcessInfo appProcesses : list) {
            if (appProcesses.processName.equals(context.getPackageName())) {
                if (appProcesses.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_BACKGROUND) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void showDialog(Context context ,final String str){
        AlertDialog.Builder builder= new AlertDialog.Builder(context);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage(str);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
