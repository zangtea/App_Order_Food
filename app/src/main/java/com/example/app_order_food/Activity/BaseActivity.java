package com.example.app_order_food.Activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.app_order_food.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class BaseActivity extends AppCompatActivity {
FirebaseAuth mAuth;
FirebaseDatabase database;
    public String TAG = "uilover";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        database = FirebaseDatabase.getInstance();
        mAuth = FirebaseAuth.getInstance();
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.white));

    }
}