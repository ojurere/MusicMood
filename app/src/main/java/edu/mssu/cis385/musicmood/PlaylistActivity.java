package edu.mssu.cis385.musicmood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


//does everything else. when playlist opens, it displays the songs
public class PlaylistActivity extends AppCompatActivity {

    TextView userPlaylist;
    private TextView mItemListTextView;
    private Playlist mSongList;
    static final int READ_BLOCK_SIZE = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        mItemListTextView = findViewById(R.id.itemList);

        mSongList = new Playlist(this);

        userPlaylist=(TextView)findViewById(R.id.itemList);

        displayList();


    }

    public void WriteBtn(View v) {
        // add-write text into file
        try {
            FileOutputStream fileout=openFileOutput("happyMoodFile.txt", MODE_PRIVATE);
            OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
            outputWriter.write(getString(R.string.one)+ "\n" +
                                getString(R.string.two)+ "\n" +
                                getString(R.string.three)+ "\n" +
                                getString(R.string.four)+ "\n" +
                                getString(R.string.five)+ "\n" +
                                getString(R.string.six)+ "\n" +
                                getString(R.string.seven)+ "\n" +
                                getString(R.string.eight)+ "\n" +
                                getString(R.string.nine)+ "\n" +
                                getString(R.string.ten)+ "\n" );
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
            FileInputStream fileIn=openFileInput("happyMoodFile.txt");
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


//    private void writeToInternalFile(Context ctx) throws IOException {
//        FileOutputStream outputStream = ctx.openFileOutput("songnamesfile", Context.MODE_PRIVATE);
//        PrintWriter writer = new PrintWriter(outputStream);
//        writer.println("Dynamite");
//        writer.println("Good Thing");
//        writer.println("Into the Sun");
//        writer.close();
//
//    }
//
//    private String readFromInternalFile() throws IOException {
//        FileInputStream inputStream = openFileInput("songnamesfile");
//        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//
//        try {
//            String line;
//            StringBuilder stringBuilder = new StringBuilder();
//
//            while ((line = reader.readLine()) != null) {
//                stringBuilder.append(line);
//                stringBuilder.append('\n');
//            }
//
//            return stringBuilder.toString();
//        }
//        finally {
//            reader.close();
//        }
//
//    }
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