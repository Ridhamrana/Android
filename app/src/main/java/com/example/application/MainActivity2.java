package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private TextView t1,t2,t3,t4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t1=findViewById(R.id.name);
        t2=findViewById(R.id.contact);
        t3=findViewById(R.id.email);
        t4=findViewById(R.id.password);
        Intent i= getIntent();
        String name= i.getStringExtra("name");
        String contact=i.getStringExtra("contact");
        String email=i.getStringExtra("email");
        String password=i.getStringExtra("password");
        t1.setText(name);
        t2.setText(contact);
        t3.setText(email);
        t4.setText(password);
    }
}