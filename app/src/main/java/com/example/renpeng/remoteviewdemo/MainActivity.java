package com.example.renpeng.remoteviewdemo;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.text);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
//                Notification.Builder builder = new Notification.Builder(MainActivity.this);
//                Intent intent = new Intent(MainActivity.this,MainActivity.class);
//                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
//                builder.setContentIntent(pendingIntent);
//                builder.setSmallIcon(R.mipmap.ic_launcher);
//                builder.setWhen(System.currentTimeMillis());
//                builder.setContentText("内容");
//                builder.setContentTitle("标题");
//                builder.setTicker("状态栏");
//                builder.setOngoing(false);
//                builder.setSound(Uri.withAppendedPath(MediaStore.Audio.Media.INTERNAL_CONTENT_URI,"1"));
//                builder.setVibrate(new long[]{2000,1000,4000});
//                Notification notification = builder.build();
//                NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//                manager.notify(1,notification);

                Notification.Builder builder = new Notification.Builder(MainActivity.this);
                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setWhen(System.currentTimeMillis());
                builder.setContentText("内容");
                builder.setContentTitle("标题");
                builder.setTicker("状态栏");
                RemoteViews remoteViews = new RemoteViews(getPackageName(),R.layout.remote);
                remoteViews.setTextViewText(R.id.text1,"11111");
                remoteViews.setImageViewResource(R.id.icon,R.drawable.iii);
                remoteViews.setOnClickPendingIntent(R.id.text1,pendingIntent);
                builder.setContent(remoteViews);
                Notification notification = builder.build();
                NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                manager.notify(1,notification);


            }
        });
    }
}
