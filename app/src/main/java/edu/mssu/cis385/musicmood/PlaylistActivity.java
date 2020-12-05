package edu.mssu.cis385.musicmood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;



//does everything else. when playlist opens, it displays the songs
public class PlaylistActivity extends AppCompatActivity {

    private TextView mItemListTextView;
    private Playlist mSongList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        mItemListTextView = findViewById(R.id.itemList);

        mSongList = new Playlist(this);

        displayList();

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