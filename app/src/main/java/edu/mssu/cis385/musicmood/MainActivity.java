package edu.mssu.cis385.musicmood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.NotificationCompat;

import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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

        btNotification = findViewById(R.id.bt_notification);

        btNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String message = "MusicMood is designed to match your energy, providing the vibes and playlists that you need!";
                NotificationCompat.Builder builder = new NotificationCompat.Builder(
                        MainActivity.this
                )
                        .setSmallIcon(R.drawable.ic_message)
                        .setContentTitle("New Notification")
                        .setContentText(message)
                        .setAutoCancel(true);

                Intent intent = new Intent(MainActivity.this,
                        NotificationActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("message",message);

                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,
                        0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);

                NotificationManager notificationManager = (NotificationManager)getSystemService(
                        Context.NOTIFICATION_SERVICE
                );
                notificationManager.notify(0,builder.build());
            }
        });


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

