package com.example.mariam.projectssresource.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mariam.projectssresource.R;
import com.example.mariam.projectssresource.activties.MainActivity;
import com.example.mariam.projectssresource.models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.FirebaseDatabase;

import static android.app.Activity.RESULT_OK;
import static com.example.mariam.projectssresource.utils.Utils.checkFieldsRequired;

/**
 * Created by Mariam on 07/11/2017.
 */

public class AddUserFragment extends Fragment {
    LinearLayout linearLayout;
     FirebaseAuth mAuth;
    Activity activity;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }




        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            final View  rootView= inflater.inflate(R.layout.fragment_edit, container, false);
            activity=getActivity();
            mAuth = FirebaseAuth.getInstance();
            Button reg=(Button) rootView.findViewById(R.id.regNow);

            linearLayout= (LinearLayout) rootView. findViewById(R.id.linear);
            final Spinner countriesSpinner = (Spinner)rootView. findViewById(R.id.countriesSpinner);
            ArrayAdapter<CharSequence> adapter0 = ArrayAdapter.createFromResource(getActivity(),
                    R.array.countries_array, android.R.layout.simple_spinner_item);
            adapter0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            countriesSpinner.setAdapter(adapter0);



            final Spinner jobsSpinner = (Spinner)rootView. findViewById(R.id.jopsSpinner

            );
            ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(),
                    R.array.gender_array, android.R.layout.simple_spinner_item);
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            jobsSpinner.setAdapter(adapter2);

            reg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                if(checkFieldsRequired(linearLayout)){
                    String name= ((EditText)rootView.findViewById((R.id.personName))).getText().toString();
                    String  phone=((EditText)rootView.findViewById((R.id.phone))).getText().toString();
                    String  mail= ((EditText)rootView.findViewById((R.id.email))).getText().toString();

                    String country=countriesSpinner.getSelectedItem().toString();
                    String city=((EditText)rootView.findViewById((R.id.citySpinner))).getText().toString();
                    String gender=jobsSpinner.getSelectedItem().toString();
                    User user=new User(name,phone,country,city,gender,mail);


                    Intent intent = new Intent();
                    intent.putExtra("user",user);

                 onActivityResult(111,122,intent);}

                    else {
                    Toast.makeText(activity , "اكمل البيانات",
                            Toast.LENGTH_SHORT).show();
                }





                }
            });




            return rootView;
        }

    public  void addNewUser(final User user, String password){

        mAuth.createUserWithEmailAndPassword(user.getMail(), password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            FirebaseUser firebaseUser = mAuth.getCurrentUser();

                            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                    .setDisplayName(user.getName())
                                    .build();

                            firebaseUser.updateProfile(profileUpdates)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                Toast.makeText(activity , "تم التسجيل بنجاح",
                                                        Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                            FirebaseDatabase database=   FirebaseDatabase.getInstance();
                            String id=  firebaseUser.getUid();
                            database.getReference("users").child(id).setValue(user);

                            Intent intent=new Intent(getActivity(),MainActivity.class);
                            startActivity(intent);

                        } else {
                            // If sign in fails, display a message to the user.
                            //Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(activity , "تعذر التسجيل حاول لاحقا",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // ...
                    }
                });




    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==122){

          User  user=  (User) data.getSerializableExtra("user");


           addNewUser(user,"123456789");

        }
    }
}

