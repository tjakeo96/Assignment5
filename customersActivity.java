package com.example.jacobnewberry.ptcmanagement;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class customersActivity extends ListActivity  implements android.view.View.OnClickListener{

    Button btnAdd,btnGetAll;
    TextView customer_Id;

    @Override
    public void onClick(View view) {
        if (view== findViewById(R.id.addCustomerButton)){

            Intent intent = new Intent(this,addCustomerActivity.class);
            intent.putExtra("customer_Id",0);
            startActivity(intent);

        }else {

            CustomerCrud crud = new CustomerCrud(this);

            ArrayList<HashMap<String, String>> customerList =  crud.getCustomerList();
            if(customerList.size()!=0) {
                ListView lv = getListView();
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                        customer_Id = (TextView) view.findViewById(R.id.customer_Id);
                        String customerId = customer_Id.getText().toString();
                        Intent objIndent = new Intent(getApplicationContext(),addCustomerActivity.class);
                        objIndent.putExtra("customer_Id", Integer.parseInt(customerId));
                        startActivity(objIndent);
                    }
                });
                ListAdapter adapter = new SimpleAdapter( customersActivity.this,customerList, R.layout.customer_entry, new String[] { "id","name"}, new int[] {R.id.customer_Id, R.id.customer_name});
                setListAdapter(adapter);
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customers);

        btnAdd = (Button) findViewById(R.id.addCustomerButton);
        btnAdd.setOnClickListener(this);

        btnGetAll = (Button) findViewById(R.id.updateButton);
        btnGetAll.setOnClickListener(this);

    }


}
