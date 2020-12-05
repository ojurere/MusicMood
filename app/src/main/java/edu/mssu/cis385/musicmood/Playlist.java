package edu.mssu.cis385.musicmood;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Playlist {
    //should only contain data. add song, remove, and list of songs


    public static final String FILENAME = "songnamesfile.txt";

    private Context mContext;
    private List<String> mPlaylist;

    public Playlist(Context context) {
        mContext = context;
        mPlaylist = new ArrayList<>();
    }

    public void addItem(String item) throws IllegalArgumentException {
        mPlaylist.add(item);
    }

    public String[] getItems() {
        String[] items = new String[mPlaylist.size()];
        return mPlaylist.toArray(items);
    }

    public void clear() {
        mPlaylist.clear();
    }

    public void saveToFile() throws IOException {

        // Write list to file in internal storage
        FileOutputStream outputStream = mContext.openFileOutput(FILENAME, Context.MODE_PRIVATE);
        writeListToStream(outputStream);
    }

    public void readFromFile() throws IOException {

        BufferedReader reader = null;

        try {
            // Read in list from file in internal storage
            FileInputStream inputStream = mContext.openFileInput(FILENAME);
            reader = new BufferedReader(new InputStreamReader(inputStream));

            mPlaylist.clear();

            String line;
            while ((line = reader.readLine()) != null) {
                mPlaylist.add(line);
            }
        }
        catch (FileNotFoundException ex) {
            // Ignore
        }
        finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    private void writeListToStream(FileOutputStream outputStream) {
        PrintWriter writer = new PrintWriter(outputStream);
        for (String item : mPlaylist) {
            writer.println(item);
        }
        writer.close();
    }
}


