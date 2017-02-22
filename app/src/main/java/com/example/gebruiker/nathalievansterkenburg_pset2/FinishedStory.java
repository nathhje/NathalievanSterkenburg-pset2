package com.example.gebruiker.nathalievansterkenburg_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class FinishedStory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finished_story);
        GotTheWord();
    }

    public void GotTheWord(){
        Intent intent = getIntent();
        String theend = intent.getStringExtra("theend");

        TextView response = (TextView) findViewById(R.id.response);
        response.setText(theend);
    }

    // starts MainActivity when retry button is clicked
    public void again(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
