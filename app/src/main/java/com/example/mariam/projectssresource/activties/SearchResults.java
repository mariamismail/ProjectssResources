package com.example.mariam.projectssresource.activties;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.mariam.projectssresource.R;
import com.example.mariam.projectssresource.fragments.ProjectNeedResultFragment;

/**
 * Created by Mariam on 15/11/2017.
 */

public class SearchResults extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serch_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.mytoolbar);
        toolbar.setTitle("نتائج البحث");
        setSupportActionBar(toolbar);


        ProjectNeedResultFragment fragment = new ProjectNeedResultFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.projectNeedResult, fragment).commit();
    }
}
