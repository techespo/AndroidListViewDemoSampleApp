package com.techespo.techespolistviewsampleapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<UserDao> itemList;
    private ListView listView;
    private Context  context;
    private ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //declare activity context reference
        context =  this;
        //Calling ui method
        setUI();
    }
    //common set UI
    private void setUI(){
        //initialize array list
        itemList =  new ArrayList<UserDao>();
        //iterating loop for 10 time to set dummy data
        for(int i= 0; i<10;i++){
            //Creating user dao object and adding dummy data
            UserDao userObj = new UserDao();
            userObj.setAddress("Address "+i);
            userObj.setId(i);
            userObj.setName("Demo "+i);
            userObj.setMobile("111-111-10"+i);
            userObj.setPassword("110"+i);
            //add dummy object in list
            itemList.add(userObj);
        }

        listView = (ListView) findViewById(R.id.listview);
        //List adapter class object
        adapter =  new ListViewAdapter(context,itemList);
        //set adapter in list view
        listView.setAdapter(adapter);
        //set listview on item click listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //display toast with data
                Toast.makeText(context,"id:"+ itemList.get(position).getId()+" name:"+itemList.get(position).getName(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
