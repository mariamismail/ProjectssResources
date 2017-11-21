package com.example.mariam.projectssresource.activties;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.mariam.projectssresource.R;
import com.example.mariam.projectssresource.models.Resource;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import static com.example.mariam.projectssresource.utils.Utils.checkFieldsRequired;

/**
 * Created by Mariam on 08/11/2017.
 */

public class AddDataActivity extends AppCompatActivity {
    String type;
    String expierenceYears;
    String expiernceConclusion;
    String targetTitle;
    String dateOfBeganing;
    String linkOfCV;
    String job;
    String country;
    String lastDgree;
    String nodeName;
    ArrayList<String>values;
    LinearLayout linearLayout;
    Spinner levelSpinner;
    Spinner typeSpinner;
    EditText experienceYera;
    EditText econclusion;
    EditText linkCV;
    EditText begningdate;
    Activity activity;
    String UId;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        Toolbar toolbar = (Toolbar) findViewById(R.id.mytoolbar);
        toolbar.setTitle("تسجيل البيانات");
        setSupportActionBar(toolbar);
        activity=this;
        UId= FirebaseAuth.getInstance().getCurrentUser().getUid();
        Button go= (Button)findViewById(R.id.button1);
        experienceYera=(EditText) findViewById(R.id.expierenceYears);
        econclusion=(EditText) findViewById(R.id.expierenceConclusion);
        begningdate=(EditText) findViewById(R.id.dataOfBeganing);
        linkCV=(EditText) findViewById(R.id.linkToCv);

        linearLayout=(LinearLayout) findViewById(R.id.linear);
        typeSpinner = (Spinner) findViewById(R.id.typeSpinner);
        levelSpinner = (Spinner) findViewById(R.id.levelSpinner);
        job= getIntent().getStringExtra("job");
        country= getIntent().getStringExtra("country");
        lastDgree= getIntent().getStringExtra("quali");
        values=new ArrayList<>();

        if (job.equals("مهندس")){
            ArrayAdapter<CharSequence> adapter0 = ArrayAdapter.createFromResource(activity,
                    R.array.engType_array, android.R.layout.simple_spinner_item);
            adapter0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            typeSpinner.setAdapter(adapter0);
            nodeName="مهندسين";

        }
        else if(job.equals("مهني")){
            ArrayAdapter<CharSequence> adapter0 = ArrayAdapter.createFromResource(activity,
                    R.array.otherType_array, android.R.layout.simple_spinner_item);
            adapter0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            typeSpinner.setAdapter(adapter0);
            nodeName="مهنين";
        }
        //else {} if we will add حرفي و مهني
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(activity,
                R.array.job_title, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        levelSpinner.setAdapter(adapter1);



        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TOdO prevent the same id from post twice in the same job by making sure that it's not alrady found by id
                if(checkFieldsRequired(linearLayout)){
                    type=typeSpinner.getSelectedItem().toString();
                    expierenceYears= experienceYera.getText().toString();
                    expiernceConclusion=econclusion.getText().toString();
                    targetTitle= levelSpinner.getSelectedItem().toString();


                    dateOfBeganing=begningdate.getText().toString();
                    linkOfCV=linkCV.getText().toString();

                    //                //add new resource
                final FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Resources").child(nodeName).child(type
                ).child(UId);

               //add new resource
                Resource resource = new Resource();
                    resource.setCountry(country);
                    resource.setResourceID(UId);
                    resource.setBeginningData(dateOfBeganing);
                    resource.setExpierenceYears(expierenceYears);
                    resource.setExpierenceConclusion(expiernceConclusion);
                    resource.setJobTitle(targetTitle);
                    resource.setLastDgree(lastDgree);
                    resource.setcVLink(linkOfCV);

                myRef.setValue(resource);

                    //search for projects needs
                DatabaseReference engineersRef = database.getReference("projectsNeeds").child(nodeName).child(type);

                engineersRef.orderByChild("country").equalTo(country).addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        String name= dataSnapshot.getValue().toString();
                        values.add(name);
                        Intent intent= new Intent(activity,SearchResults.class);
                        intent.putStringArrayListExtra("list",values);
                        startActivity(intent);

                    }

                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onChildRemoved(DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });




                }

            }
        });


    }
}
