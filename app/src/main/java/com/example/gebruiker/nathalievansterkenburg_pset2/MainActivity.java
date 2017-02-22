package com.example.gebruiker.nathalievansterkenburg_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    // starts Words activity when start button is clicked
    public void next(View view) {

        Intent intent = new Intent(this, Words.class);
        startActivity(intent);
    }

}
