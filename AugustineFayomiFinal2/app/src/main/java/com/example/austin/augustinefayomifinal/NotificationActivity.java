package com.example.austin.augustinefayomifinal;

import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class NotificationActivity extends AppCompatActivity {
    public static final int NOTIFICATION_ID = 1;
    String location ="Toronto";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        Intent intent = getIntent();
        location = intent.getStringExtra("message");

    }

    // Notification leading to a phone call
    public void sendPhoneNotification(View view) {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        builder.setSmallIcon(R.drawable.graduation);

        builder.setContentTitle("You have graduated")
                .setContentText("Your time at Fanshawe College is over Time to go to !"+ location);

        builder.setAutoCancel(true);


        NotificationManager notificationManager = (NotificationManager) getSystemService(
                NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }
}
