package com.example.app_order_food.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.core.content.ContextCompat;

import com.example.app_order_food.R;
import com.example.app_order_food.databinding.ActivityIntroBinding;

public class IntroActivity extends BaseActivity {

    ActivityIntroBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityIntroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setVariable();
        getWindow().setStatusBarColor(Color.parseColor("#FFE4B5"));


    }

    private void setVariable() {
        binding.loginBtn.setOnClickListener(view -> {
            if(mAuth.getCurrentUser() !=null){
              startActivity(new Intent(IntroActivity.this,MainActivity.class));
            }else{
                startActivity(new Intent(IntroActivity.this,LoginActivity.class));
            }

        });
        binding.signBtn.setOnClickListener(view -> startActivity(new Intent(IntroActivity.this, SignupActivity.class)));
    }
    }
