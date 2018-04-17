package com.example.jacobnewberry.ptcmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    //declare variables for the buttons on the screen
    Button customersButton;
    Button sessionsButton;
    Button logOffButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        //Place references in the variable
        customersButton = (Button) findViewById(R.id.customerButton);
        sessionsButton = (Button) findViewById(R.id.sessionsButton);
        logOffButton = (Button) findViewById(R.id.logOffButton);

        //create the onclick listener for customers button
        customersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //create intent to launch customersActivity
                Intent startIntent = new Intent(getApplicationContext(), customersActivity.class);
                startActivity(startIntent);
            }
        });


        //create the onclick listener for sessions button
        sessionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //create intent to launch sessionsActivity
                Intent startIntent = new Intent(getApplicationContext(), sessionsActivity.class);
                startActivity(startIntent);

            }
        });

        //create the onClick listener for logOff button
        logOffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //create intent to go back to login screen
                Intent startIntent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(startIntent);

                Toast.makeText(getApplicationContext(),R.string.logout, Toast.LENGTH_SHORT).show();
            }
        });


    }
}
