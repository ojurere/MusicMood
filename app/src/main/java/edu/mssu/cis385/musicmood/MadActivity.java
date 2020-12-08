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
public class MadActivity extends AppCompatActivity {

    TextView userPlaylist;
    private TextView mItemListTextView;
    private Playlist mSongList;
    static final int READ_BLOCK_SIZE = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mad);

        mItemListTextView = findViewById(R.id.madItemList);

        mSongList = new Playlist(this);

        userPlaylist=(TextView)findViewById(R.id.madItemList);

        displayList();


    }

    public void WriteBtn(View v) {
        // add-write text into file
        try {
            FileOutputStream fileout=openFileOutput("madMoodFile.txt", MODE_PRIVATE);
            OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
            outputWriter.write(getString(R.string.twenty_one)+ "\n" +
                                getString(R.string.twenty_two)+ "\n" +
                                getString(R.string.twenty_three)+ "\n" +
                                getString(R.string.twenty_four)+ "\n" +
                                getString(R.string.twenty_five)+ "\n" +
                                getString(R.string.twenty_six)+ "\n" +
                                getString(R.string.twenty_seven)+ "\n" +
                                getString(R.string.twenty_eight)+ "\n" +
                                getString(R.string.twenty_nine)+ "\n" +
                                getString(R.string.thirty)+ "\n" );
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
            FileInputStream fileIn=openFileInput("madMoodFile.txt");
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