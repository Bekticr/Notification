package com.bcr.notification.notification;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.dot.rajapindah.App;
import com.dot.rajapindah.R;
import com.dot.rajapindah.model.main_page.ModelNotif;
import com.dot.rajapindah.views.BaseActivity;
import com.dot.rajapindah.views.HomeActivity;
import com.dot.rajapindah.views.main_page.activity.User_Activity;
import com.dot.rajapindah.views.raja_pindah.activity.Add_your_location_Activity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

/**
 * Created by Win7 on 03/03/2016.
 */
public class BackgroundDataReceiver extends WakefulBroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        intent.getBundleExtra("data");

        ComponentName comp = new ComponentName(context.getPackageName(),
                GCMIntentService.class.getName());
        startWakefulService(context, (intent.setComponent(comp)));
        setResultCode(Activity.RESULT_OK);

    }

}