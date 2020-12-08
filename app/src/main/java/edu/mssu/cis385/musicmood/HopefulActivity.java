package edu.mssu.cis385.musicmood;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


//does everything else. when playlist opens, it displays the songs
public class HopefulActivity extends AppCompatActivity {

    TextView userPlaylist;
    private TextView mItemListTextView;
    private Playlist mSongList;
    static final int READ_BLOCK_SIZE = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hopeful);

        mItemListTextView = findViewById(R.id.hopefulItemList);

        mSongList = new Playlist(this);

        userPlaylist=(TextView)findViewById(R.id.hopefulItemList);

        displayList();


    }

    public void WriteBtn(View v) {
        // add-write text into file
        try {
            FileOutputStream fileout=openFileOutput("hopefulMoodFile.txt", MODE_PRIVATE);
            OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
            outputWriter.write(getString(R.string.eleven)+ "\n" +
                                getString(R.string.twelve)+ "\n" +
                                getString(R.string.thirteen)+ "\n" +
                                getString(R.string.fourteen)+ "\n" +
                                getString(R.string.fifteen)+ "\n" +
                                getString(R.string.sixteen)+ "\n" +
                                getString(R.string.seventeen)+ "\n" +
                                getString(R.string.eighteen)+ "\n" +
                                getString(R.string.nineteen)+ "\n" +
                                getString(R.string.twenty)+ "\n" );
            outputWriter.close();

            //display file saved message
            Toast.makeText(getBaseContext(), "Playlist created successfully!",
                    Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Read text from file
    public void ReadBtn(View v) {
        //reading text from file
        try {
            FileInputStream fileIn=openFileInput("hopefulMoodFile.txt");
            InputStreamReader InputRead= new InputStreamReader(fileIn);

            char[] inputBuffer= new char[READ_BLOCK_SIZE];
            String s="";
            int charRead;

            while ((charRead=InputRead.read(inputBuffer))>0) {
                // char to string conversion
                String readstring=String.copyValueOf(inputBuffer,0,charRead);
                s +=readstring;
            }
            InputRead.close();
            userPlaylist.setText(s);
            userPlaylist.findViewById(R.id.itemList);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void displayList() {
        // Display a numbered list of items
        StringBuffer itemText = new StringBuffer();
        String[] items = mSongList.getItems();
        for (int i = 0; i < items.length; i++) {
            itemText.append((i + 1) + ". " + items[i] + "\n");
        }

        mItemListTextView.setText(itemText);

    }



}