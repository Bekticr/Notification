package com.bcr.notification;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.onesignal.OneSignal;

import org.json.JSONObject;

/**
 * Created by Win7 on 05/03/2016.
 */
public class App extends Application {

    private static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;

        OneSignal.startInit(this)
                .setNotificationOpenedHandler(new NotificationOpenedHandler())
                .setAutoPromptLocation(true)
                .init();
    }

    private class NotificationOpenedHandler implements OneSignal.NotificationOpenedHandler {

        @Override
        public void notificationOpened(String message, JSONObject additionalData, boolean isActive) {

            // TODO: Replace YourActivity with your Activity.
            Intent intent = new Intent(App.appContext, TwoActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

}