package edu.mssu.cis385.musicmood;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Song {
    public static final String FILENAME = "songnamesfile.txt";
    private final static String TAG = "Song";



    private String mSongName;
    private String mSongArtist;
    private String mSongGenre;

    /*public static void main(String[] args) {
        ArrayList<String> songName = new ArrayList<String>();
        songName.add("Dynamite");
        songName.add("Good Thing");
        songName.add("Into the Sun");
        songName.add("Little Bitty Pretty One");
        songName.add("Lovely Day");
        songName.add("Rhythm of Love");
        songName.add("Staring at the Sun");
        songName.add("LOVE");
        songName.add("Jerusalema");
        songName.add("Drip Like ME");
        System.out.println(songName);

        ArrayList<String> songArtist = new ArrayList<String>();
        songArtist.add("BTS");
        songArtist.add("Zedd & Kehlani");
        songArtist.add("Johnny 2 Phones");
        songArtist.add("Thurston Harris");
        songArtist.add("Bill Withers");
        songArtist.add("Plain White T\'s");
        songArtist.add("Post Malone ft. SZA");
        songArtist.add("Jhene Aiko");
        songArtist.add("Master KG ft. Burna Boy & Nomcebo Zikode");
        songArtist.add("Kenndog");
        System.out.println(songName);
    }*/

    private void writeToInternalFile(Context ctx) throws IOException {
        FileOutputStream outputStream = ctx.openFileOutput("songnamesfile", Context.MODE_PRIVATE);
        PrintWriter writer = new PrintWriter(outputStream);
        writer.println("Dynamite");
        writer.println("Good Thing");
        writer.println("Into the Sun");
        writer.close();

    }

    private String readFromInternalFile(Context ctx) throws IOException {
        FileInputStream inputStream = ctx.openFileInput("songnamesfile");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        try {
            String line;
            StringBuilder stringBuilder = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append('\n');
            }

            return stringBuilder.toString();
        }
        finally {
            reader.close();
        }

    }

}
