package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText name,con,email,password;
    private Button sumbit;
    private CheckBox check;
    boolean error=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name_id);
        con=findViewById(R.id.contact_id);
        email=findViewById(R.id.email_id);
        password=findViewById(R.id.password_id);
        check=findViewById(R.id.check_id);
        sumbit=findViewById(R.id.btnclick);
        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    Toast.makeText(MainActivity.this,"check",Toast.LENGTH_SHORT).show();
                }
            }
        });
        sumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                error= CheckAllFields();
                if(error) {
                    String Name = name.getText().toString();
                    String Contact = con.getText().toString();
                    String Email = email.getText().toString();
                    String Password = password.getText().toString();
                    Intent i = new Intent(MainActivity.this, MainActivity2.class);
                    i.putExtra("name", Name);
                    i.putExtra("contact", Contact);
                    i.putExtra("email", Email);
                    i.putExtra("password", Password);

                    startActivity(i);
                }
            }
        });
    }
    private boolean CheckAllFields() {
        if (name.length()==0) {
            name.setError("Please fill up");
            return false;
        }
        if(con.length()==0){
            con.setError("Please fill up");
            return false;
        }
        if(email.length()==0){
            email.setError("Please fill up");
            return false;
        }
        if (password.length() == 0) {
            password.setError("Password is required");
            return false;
        }
        return true;
    }
}