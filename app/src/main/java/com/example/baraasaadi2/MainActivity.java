package com.example.baraasaadi2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnLogIn, btnSignUp;

    private final String valid_mail = "admin";
    private final String valid_password = "1";
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogIn = findViewById(R.id.buttonGoToLogIn);
        btnSignUp = findViewById(R.id.buttonGoToSignUp);

    }


    // this method loads menu design into this activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // in case user chose about menu
       switch (item.getItemId()){

            //open the about activity when the about menu item selected
           case R.id.about_menu:
            Intent i = new Intent(this,aboutActivity.class);
            startActivity(i);
            break;

           case R.id.listView:
               Intent a = new Intent(this,listActivity.class);
               startActivity(a);
            break;

        }
        return true;
    }

     // is called when the user clicked the back button
    @Override
    public void onBackPressed() {
        AlertDialog.Builder  dialog = new AlertDialog.Builder(this);
        dialog.setTitle(" Back Button was pressed!");
        dialog.setMessage("Are you sure you want to Exit");
        // in case the user choose no , nothing Happens dialog closes
        dialog.setNegativeButton( "No" , null);
        // when the user clicks on the ues button  the application closes
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.finish();
            }
        });
        dialog.setIcon(R.drawable.ic_baseline_insert_emoticon_24);
        AlertDialog alertDialog = dialog.create();
        alertDialog.show();
    }


    public void goToLogInPage(View view) {
        Intent i = new Intent(this, LogInActivity.class);
        startActivity(i);
    }

    public void goToSignUpPage(View view) {
        Intent i = new Intent(this, SignUpActivity.class);
        startActivity(i);
    }
}