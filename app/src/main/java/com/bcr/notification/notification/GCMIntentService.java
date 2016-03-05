package com.bcr.notification.notification;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.bcr.notification.TwoActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import com.bcr.notification.R;

import org.json.JSONObject;

/**
 * Created by Win7 on 03/03/2016.
 */
public class GCMIntentService extends IntentService {

    public GCMIntentService() {
        super(GCMIntentService.class.getName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Bundle dataBundle = intent.getBundleExtra("data");
        try {
            JSONObject customJSON = new JSONObject(dataBundle.getString("custom"));
            if (customJSON.has("a")) {
                ModelNotif notif = new Gson().fromJson(customJSON.getString("a"), ModelNotif.class);
                Log.d("notif", customJSON.getString("a"));

                intent = new Intent(this, TwoActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

//                sendNotification(notif);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendNotification(ModelNotif notif) {
        NotificationManager mNotificationManager = (NotificationManager)
                this.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle(getResources().getString(R.string.app_name))
                        .setAutoCancel(true)
                        .setPriority(Notification.PRIORITY_MAX)
                        .setVibrate(new long[0])
                        .setStyle(new NotificationCompat.BigTextStyle()
                                .bigText(notif.idCustomer + ""))
                        .setContentText(notif.idOrder + "");
        PendingIntent contentIntent = null;
        Intent intent = new Intent(this, TwoActivity.class);
//        intent.putExtra("order_id", notif.idOrder);
//        intent.putExtra("customer_id", notif.idCustomer);
        contentIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(contentIntent);
        mNotificationManager.notify(0, mBuilder.build());
    }
}
