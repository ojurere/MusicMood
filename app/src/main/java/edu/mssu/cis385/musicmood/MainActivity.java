package edu.mssu.cis385.musicmood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity{

    private Button btnToggleDark;
    Button btNotification;
    public static final String EXTRA_MESSAGE = "edu.mssu.cis385.MESSAGE";
    private boolean mDarkTheme;
    private SharedPreferences mSharedPrefs;
    private final String CHANNEL_ID = "This app gives you a playlist that matches your energy!";
    private final int NOTIFICATION_ID = 0;




    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mSharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        mDarkTheme = mSharedPrefs.getBoolean(SettingsFragment.PREFERENCE_THEME, false);
        if (mDarkTheme) {
            setTheme(R.style.DarkTheme);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button happyButton = findViewById(R.id.answerButtonHappy);
        happyButton.setOnClickListener(mHappyButtonClickListener);

        Button hopefulButton = findViewById(R.id.answerButtonHopeful);
        hopefulButton.setOnClickListener(mHopefulButtonClickListener);

        Button madButton = findViewById(R.id.answerButtonMad);
        madButton.setOnClickListener(mMadButtonClickListener);

        Button sadButton = findViewById(R.id.answerButtonSad);
        sadButton.setOnClickListener(mSadButtonClickListener);

        createTimerNotificationChannel();

        btNotification = findViewById(R.id.bt_notification);

        btNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                createTimerNotification(CHANNEL_ID);
            }
        });
    }
    private void createTimerNotification(String text) {

        // Create notification with various properties
        Notification notification = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle(getString(R.string.app_name))
                .setContentText(text)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .build();

        // Get compatibility NotificationManager
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplicationContext());

        // Post notification using ID.  If same ID, this notification replaces previous one
        notificationManager.notify(NOTIFICATION_ID, notification);
    }


    private void createTimerNotificationChannel() {
        if (Build.VERSION.SDK_INT < 26) return;

        CharSequence name = getString(R.string.channel_name);
        String description = getString(R.string.channel_description);
        int importance = NotificationManager.IMPORTANCE_HIGH;
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
        channel.setDescription(description);

        // Register channel with system
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.subject_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.settings:
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    protected void onResume() {
        super.onResume();

        // If theme changed, recreate the activity so theme is applied
        boolean darkTheme = mSharedPrefs.getBoolean(SettingsFragment.PREFERENCE_THEME, false);
        if (darkTheme != mDarkTheme) {
            recreate();
        }
    }

    private final View.OnClickListener mHappyButtonClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            // Do something in response to button
            /** Called when the user taps the button */
            Intent intent = new Intent(MainActivity.this, PlaylistActivity.class);
            startActivity(intent);
        }
    };

    private final View.OnClickListener mHopefulButtonClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            // Do something in response to button
            /** Called when the user taps the button */
            Intent intent = new Intent(MainActivity.this, HopefulActivity.class);
            startActivity(intent);
        }
    };

    private final View.OnClickListener mMadButtonClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            // Do something in response to button
            /** Called when the user taps the button */
            Intent intent = new Intent(MainActivity.this, MadActivity.class);
            startActivity(intent);
        }
    };


    private final View.OnClickListener mSadButtonClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            // Do something in response to button
            /** Called when the user taps the button */
            Intent intent = new Intent(MainActivity.this, SadActivity.class);
            startActivity(intent);
        }
    };


    }

