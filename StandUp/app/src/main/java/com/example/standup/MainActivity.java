package com.example.standup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendNotification(View view)
    {
        /*NotificationManager is responsible for issuing the notifications via
        * Notification Service -  It will also be capable of Cancelling the
        * notifications*/
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        /*Create a NotificationChannel*/
        /*Step-1 - create a channel id*/
        String Channel_id = "pavan_channel";
        /*Step-2 - Know the version of the system*/
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel nc =
                    new NotificationChannel(Channel_id,"PAVAN CHANNEL",
                            NotificationManager.IMPORTANCE_HIGH);
            nc.enableLights(true);
            nc.enableVibration(true);
            nc.setDescription("Sample Channel");
            notificationManager.createNotificationChannel(nc);
        }
        /*Step-3 - Building the notification*/
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this,Channel_id);
        builder.setSmallIcon(R.drawable.stand);
        builder.setContentTitle("STAND UP!");
        builder.setContentText("Walking is healthy. Its been an hour since you walked");
        builder.setPriority(NotificationCompat.PRIORITY_MAX);
        Intent i = new Intent(this,MainActivity.class);
        PendingIntent pi
                = PendingIntent.getActivity(this,23,i,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pi);
        builder.setAutoCancel(true);
        builder.addAction(R.drawable.stand,"SAMPLE",pi);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.a);
        builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap));
        /*Step-4 - Send the notification*/
        notificationManager.notify(121,builder.build());
    }
}
