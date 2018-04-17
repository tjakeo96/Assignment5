package com.example.jacobnewberry.ptcmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

public class sessionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sessions);

        //create onclick and intent to start new session activity for new session button
        Button addSessionButton = (Button)findViewById(R.id.addSessionsButton);
        addSessionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), addSessionsActivity.class);
                startActivity(startIntent);
            }
        });


        //create a temporary array place holder
        String[] sessions = {"Paul, May 4, 2018", "Steven, May 14, 2018"};

        //create a list adapter
        ListAdapter sessionsListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sessions);

        //create a reference to the list view
        ListView sessionsListView = (ListView)findViewById(R.id.sessionsListView);

        //link adapter and list view
        sessionsListView.setAdapter(sessionsListAdapter);

    }
}
