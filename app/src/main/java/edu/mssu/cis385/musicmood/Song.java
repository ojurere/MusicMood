package edu.mssu.cis385.musicmood;

import java.util.ArrayList;

public class Song {

    private String mSongName;
    private String mSongArtist;
    private String mSongGenre;

    public static void main(String[] args) {
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
    }

}
