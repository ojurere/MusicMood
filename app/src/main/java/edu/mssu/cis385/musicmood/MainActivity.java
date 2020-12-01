package edu.mssu.cis385.musicmood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "edu.mssu.cis385.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getMood(View view) {
        // Do something in response to button
        /** Called when the user taps the GO button */
            Intent intent = new Intent(this, PlaylistActivity.class);
            startActivity(intent);
        }
    }
