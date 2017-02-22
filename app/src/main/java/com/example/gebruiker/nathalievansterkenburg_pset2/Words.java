package com.example.gebruiker.nathalievansterkenburg_pset2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;
import java.io.InputStream;

public class Words extends AppCompatActivity {

    Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);

        // calls function to initiate story
        try {
            makethestory();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // to compare number of blanks with filled in blanks
    int wordnumber;
    int pointer = 0;

    // initiate story
    public void makethestory() throws IOException {

        // list of possible stories
        String[] thechoices = {"madlib0_simple.txt", "madlib1_tarzan.txt", "madlib2_university.txt",
                "madlib3_clothes.txt", "madlib4_dance.txt"};

        // random number to choose random story
        int whatstory = (int) (Math.random() * 5);

        // ensures number isn't too high
        if (whatstory == 5){
            whatstory--;
        }

        // story is read from file
        InputStream thestory = getResources().getAssets().open(thechoices[whatstory]);

        // Story object is created
        story = new Story(thestory);

        // number of blanks is determined
        wordnumber = story.getPlaceholderCount();

        // type of word is determined for first blank
        EditText thewordET = (EditText) findViewById(R.id.word);
        String typeofword = story.getNextPlaceholder();
        thewordET.setText(typeofword);
    }

    // saves user input and starts FinishedStory activity
    public void finished(View view){

        // reads user input
        EditText thewordET = (EditText) findViewById(R.id.word);
        String theword = String.valueOf(thewordET.getText());

        // user input is placed in story
        story.fillInPlaceholder(theword);

        // number of filled in blanks is updated
        pointer++;

        // once all blanks have been filled FinishedStory activity is started
        if (pointer == wordnumber) {

            // full story is retrieved from story object
            String theend = story.toString();

            // intent is created and full story is added
            Intent intent = new Intent(this, FinishedStory.class);
            intent.putExtra("theend", theend);

            // story is reset
            story.clear();

            // FinishedStory activity is started
            startActivity(intent);
        }

        // type of word for next blank is determined
        String typeofword = story.getNextPlaceholder();
        thewordET.setText(typeofword);

    }
}
