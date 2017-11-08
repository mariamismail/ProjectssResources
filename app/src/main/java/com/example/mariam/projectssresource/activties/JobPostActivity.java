package com.example.mariam.projectssresource.activties;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.mariam.projectssresource.R;
import com.example.mariam.projectssresource.models.ProjectNeed;
import com.example.mariam.projectssresource.models.Resource;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by Mariam on 17/10/2017.
 */

public class JobPostActivity extends AppCompatActivity {
    private String job;
    private String qualification;
    private String country;
    private Button next;
    private Spinner qualificationSpinner;
    private Spinner jobsSpinner;
    private Spinner countriesSpinner;
    ListView listView ;
    ArrayList<String>values;
    Activity activity;
    ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_joppsot);
        Toolbar toolbar = (Toolbar) findViewById(R.id.mytoolbar);
        toolbar.setTitle("التوظيف");
        setSupportActionBar(toolbar);
        activity=this;
        listView = (ListView) findViewById(R.id.list);
       next=(Button) findViewById(R.id.button1);
         jobsSpinner = (Spinner) findViewById(R.id.jobsSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.job_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jobsSpinner.setAdapter(adapter);

         countriesSpinner = (Spinner) findViewById(R.id.countriesSpinner);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.countries_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countriesSpinner.setAdapter(adapter2);

        qualificationSpinner=(Spinner) findViewById(R.id.qualificationSpinner);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.qualification_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        qualificationSpinner.setAdapter(adapter3);
        values=new ArrayList<>();

        // listAdapter = new ArrayAdapter<String>(activity,
               // android.R.layout.simple_list_item_1, android.R.id.text1, values);

       next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listAdapter.clear();
                job=jobsSpinner.getSelectedItem().toString();
                country=countriesSpinner.getSelectedItem().toString();
                qualification=qualificationSpinner.getSelectedItem().toString();



//                //add new resource
//                final FirebaseDatabase database = FirebaseDatabase.getInstance();
//                DatabaseReference myRef = database.getReference("Resources").child("Engineers").child(filed).push();
//                String name= myRef.getKey();
//                Resource resource = new Resource();
//                resource.setCountry(country);
//                resource.setResourceID(name);
//                myRef.setValue(resource);
//
//
////
////                    //search for resource
//                DatabaseReference engineersRef = database.getReference("projectsNeeds").child("Engineers").child(filed);
//
//                engineersRef.orderByChild("country").equalTo(country).addChildEventListener(new ChildEventListener() {
//                    @Override
//                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                        String name= dataSnapshot.getValue().toString();
//                        values.add(name);
//
//                        // Assign adapter to ListView
//                        listView.setAdapter(listAdapter);
//                    }
//
//                    @Override
//                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//
//                    }
//
//                    @Override
//                    public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//                    }
//
//                    @Override
//                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError databaseError) {
//
//                    }
//                });

            }
        });
    }
}
