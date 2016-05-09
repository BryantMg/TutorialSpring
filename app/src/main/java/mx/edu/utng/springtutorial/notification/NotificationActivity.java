package mx.edu.utng.springtutorial.notification;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.widget.RemoteViews;
import android.widget.Button;
import android.view.View;
import java.util.Timer;
import java.util.TimerTask;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;

import mx.edu.utng.springtutorial.MenuActivity;
import mx.edu.utng.springtutorial.R;

/**
 * Created by Bryant Moreno on 06/05/2016.
 */
public class NotificationActivity extends Activity{

    private Button btnNotificacion;

    private static final int NOTIF_ALERTA_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_layout);

        btnNotificacion = (Button)findViewById(R.id.Btn_Notif);

        btnNotificacion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                NotificationCompat.Builder mBuilder =
                        new NotificationCompat.Builder(NotificationActivity.this)
                                .setSmallIcon(R.drawable.springlogo)
                                .setLargeIcon((((BitmapDrawable)getResources()
                                        .getDrawable(R.drawable.springlogo)).getBitmap()))
                                .setContentTitle("Spring Tutorial")
                                .setContentText("¡Es hora de practicar!")
                                .setContentInfo("4")
                                .setTicker("Notificaiones activas");

                Intent notIntent =
                        new Intent(NotificationActivity.this, MenuActivity.class);

                PendingIntent contIntent = PendingIntent.getActivity(
                        NotificationActivity.this, 0, notIntent, 0);

                mBuilder.setContentIntent(contIntent);

                NotificationManager mNotificationManager =
                        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                mNotificationManager.notify(NOTIF_ALERTA_ID, mBuilder.build());
            }
        });
    }



}
