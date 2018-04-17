package com.example.jacobnewberry.ptcmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class addCustomerActivity extends AppCompatActivity {

    //declare variables for the xml items
    EditText newName;
    EditText newPhoneNumber;
    Button submitNewCustomer;
    int _Customer_Id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);

        newName = (EditText) findViewById(R.id.newNameEditText);
        newPhoneNumber = (EditText) findViewById(R.id.newNumberEditText);
        submitNewCustomer = (Button) findViewById(R.id.submitNewCustomerButton);

        submitNewCustomer.setOnClickListener((View.OnClickListener) this);

        Intent intent = getIntent();
        _Customer_Id = intent.getIntExtra("customer_Id", 0);
        CustomerCrud crud = new CustomerCrud(this);
        customersTable customer = new customersTable();
        customer = crud.getCustomerById(_Customer_Id);

        newName.setText(String.valueOf(customer.name));
        newPhoneNumber.setText(String.valueOf(customer.phone));
    }

    public void onClick(View view){
        if(view == findViewById(R.id.submitNewCustomerButton)){
            CustomerCrud crud = new CustomerCrud(this);
            customersTable customer = new customersTable();
            customer.name = newName.getText().toString();
            customer.phone = newPhoneNumber.getText().toString();
            customer.customer_ID = _Customer_Id;

            if(_Customer_Id == 0)
                _Customer_Id = crud.insert(customer);
            else
                crud.update(customer);

        }
    }
}
