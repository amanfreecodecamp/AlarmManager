package com.example.aman.alarmmanager;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = getIntent();
       boolean id = i.getBooleanExtra("id",false);
       // Toast.makeText(this,"id is "+ id,Toast.LENGTH_SHORT).show();
        Toast.makeText(this, ""+AlarmReceiver.flag, Toast.LENGTH_SHORT).show();
        if(AlarmReceiver.flag) {
//
            NotificationManager notifManager= (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
            notifManager.cancelAll();
        }

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // setting up the Alarm.
                AlarmManager am = (AlarmManager) MainActivity.this.getSystemService(Context.ALARM_SERVICE);
                Intent i = new Intent(MainActivity.this, AlarmReceiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 1, i, 0);
               // PendingIntent pendingIntent2 = PendingIntent.getBroadcast(MainActivity.this, 1, i, 0);
                am.set(AlarmManager.RTC, System.currentTimeMillis() + 2000, pendingIntent);
                //am.set(AlarmManager.RTC, System.currentTimeMillis() + 2000, pendingIntent2);
            }
        });
    }

  /*  public static void cancelNotification(Context ctx, int notifyId) {
        String ns = Context.NOTIFICATION_SERVICE;
        NotificationManager nMgr = (NotificationManager) ctx.getSystemService(ns);
        nMgr.cancel(notifyId);
    }*/



}
