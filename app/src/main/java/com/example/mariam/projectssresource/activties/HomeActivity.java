package com.example.mariam.projectssresource.activties;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mariam.projectssresource.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Mariam on 01/11/2017.
 */

public class HomeActivity extends AppCompatActivity {
    Activity activity;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        if(mAuth.getCurrentUser() == null) {

            // Start sign in/sign up activity
            //startActivityForResult(intent,code)
            setContentView(R.layout.activity_home);
            Toolbar toolbar = (Toolbar) findViewById(R.id.mytoolbar);
            toolbar.setTitle("شبكه مشروعات البناء");
            setSupportActionBar(toolbar);


            activity=this;
            Button reg= (Button) findViewById(R.id.register);
            reg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(activity,AddUserActivity.class);
                    startActivity(intent);

                }
            });

        } else {
            // User is already signed in. Therefore, display
            // a welcome Toast
            FirebaseUser user1 = mAuth.getCurrentUser();
            String name=mAuth
                    .getCurrentUser()
                    .getDisplayName();
            if (user1 != null & name!=null) {

                Toast.makeText(this,
                        "Welcome " + name,
                        Toast.LENGTH_LONG)
                        .show();
            }


    }

}}
