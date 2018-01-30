package com.techespo.techespolistviewsampleapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Espo on 1/31/2018.
 */

public class ListViewAdapter extends BaseAdapter {
    private ArrayList<UserDao> itemList;
    private Context context;

    //Constructor
    ListViewAdapter(Context context, ArrayList<UserDao> itemList){
        this.context = context;
        this.itemList = itemList;
    }
    //get count method return the no of item will display
    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return itemList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertedView, ViewGroup viewGroup) {
        //assigning item position data in dao object
        UserDao dao =  itemList.get(position);

        View view  = convertedView;
        //check if converted view is null
        if(view == null){
            //creating inflater object
            LayoutInflater inflater =  (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //inflate row layout using inflater object
            view = inflater.inflate(R.layout.list_row_layout,null);
        }

        // setting data
        TextView txtID = (TextView) view.findViewById(R.id.txt_id);
        txtID.setText("id: "+dao.getId());
        TextView txtName = (TextView) view.findViewById(R.id.txt_name);
        txtName.setText(dao.getName());
        TextView txtPassword = (TextView) view.findViewById(R.id.txt_password);
        txtPassword.setText(dao.getPassword());
        TextView txtAddress = (TextView) view.findViewById(R.id.txt_address);
        txtAddress.setText(dao.getAddress());

        //return item view
        return view;
    }
}
