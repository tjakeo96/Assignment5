package com.example.jacobnewberry.ptcmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    //declare variables of the xml objects
    EditText username;
    EditText password;
    Button login;

    String correctUsername = "jdoe";
    String correctPassword = "welcome1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //place references in the variable
        username = (EditText) findViewById(R.id.usernameEditText);
        password = (EditText) findViewById(R.id.passwordEditText);
        login = (Button) findViewById(R.id.loginButton);

        //create the onclick listener
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //action to take when button is called
                verify(username.getText().toString(), password.getText().toString());
            }
        });
    }

    //create method to verify login
    public void verify(String username, String password){
        //if statement to compare user input to correct login credentials
        if((username.equals(correctUsername)) && (password.equals(correctPassword))){
            Toast.makeText(getApplicationContext(),R.string.successful_login, Toast.LENGTH_SHORT).show();
            //get permissions



            //create intent to launch second activity
            Intent startIntent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(startIntent);

        }
        else{
            Toast.makeText(getApplicationContext(),R.string.unsuccessful_login, Toast.LENGTH_SHORT).show();
        }






    }
}
