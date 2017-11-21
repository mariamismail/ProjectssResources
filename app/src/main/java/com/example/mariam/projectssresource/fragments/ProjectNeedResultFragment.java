package com.example.mariam.projectssresource.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.mariam.projectssresource.R;

import java.util.ArrayList;

/**
 * Created by Mariam on 15/11/2017.
 */

public class ProjectNeedResultFragment extends Fragment {

    ListView listView ;
    ArrayList<String> values;
    Activity activity;
    ArrayAdapter<String> listAdapter;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  rootView= inflater.inflate(R.layout.fragment_projectneed_result, container, false);
        activity=getActivity();
        listView = (ListView) rootView.findViewById(R.id.list);
        values= new ArrayList<>();
        values= getActivity().getIntent().getStringArrayListExtra("list");
        //TODO save the values array to shared prefrence or internal database and get it again if not found in the intent

         listAdapter = new ArrayAdapter<String>(activity,
         android.R.layout.simple_list_item_1, android.R.id.text1, values);
        // Assign adapter to ListView
        //  listAdapter.clear();
         listView.setAdapter(listAdapter);


        return rootView;
    }
}
