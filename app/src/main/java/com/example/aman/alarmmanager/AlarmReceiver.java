package com.example.aman.alarmmanager;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {
 static int i = 0;

    NotificationManager mNotification;
    static boolean flag = false;
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        // Toast.makeText(context,"Recieved",Toast.LENGTH_SHORT).show();
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context).setSmallIcon
                (android.R.drawable.ic_menu_report_image).setContentTitle("My notification").setAutoCancel(true)
                .setContentText("Alarm !!!" + i);

        Intent resultIntent = new Intent(context, MainActivity.class);
        flag = true;
        resultIntent.putExtra("id",flag);
       // resultIntent.putExtra("id",i);
        //Changing the pending intent id's
        PendingIntent resultPendingIntent = PendingIntent.getActivity(context, i++, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntent);
        mNotification = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotification.notify(0, mBuilder.build());


    }
}
