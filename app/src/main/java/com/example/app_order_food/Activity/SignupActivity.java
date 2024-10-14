package com.example.app_order_food.Activity;

import static android.widget.Toast.LENGTH_SHORT;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.app_order_food.databinding.ActivitySignupBinding;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public class SignupActivity extends BaseActivity {
ActivitySignupBinding binding;
    private String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setVariable();

    }

    private void setVariable() {
        binding.signupBtn.setOnClickListener(this::onClick);
    }

    private void onClick(View view) {
        String email = binding.userEdt.getText().toString();
        String password = binding.passEdt.getText().toString();

        if (password.length() < 6) {
            Toast.makeText(SignupActivity.this, "your password must be 6 character", LENGTH_SHORT).show();
            return;
        }
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.i(TAG, "onComplete: ");
                    startActivity(new Intent(SignupActivity.this, MainActivity.class));
                } else {
                    Log.i(TAG, "failure");
                    Toast.makeText(SignupActivity.this, "Authentication", LENGTH_SHORT).show();

                }
            }
        });

    }
}