package com.example.app_order_food.Activity;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.app_order_food.Domain.Foods;
import com.example.app_order_food.Helper.ManagmentCart;
import com.example.app_order_food.R;
import com.example.app_order_food.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {
ActivityDetailBinding binding;
private Foods object;
private int num = 1;
private ManagmentCart managmentCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getIntentExtra();
        setVariable();


    }

    private void setVariable() {
        managmentCart = new ManagmentCart(this);
        binding.backBtn.setOnClickListener(view -> finish());

        Glide.with(DetailActivity.this)
                .load(object.getImagePath())
                .into(binding.pic);


        binding.priceTxt.setText("$" + object.getPrice());
        binding.titleTxt.setText(object.getTitle());
        binding.descriptionTxt.setText(object.getDescription());
        binding.rateTxt.setText(object.getStar() + "Rating");
        binding.ratingBar.setRating((float) object.getStar());
        binding.totalTxt.setText((num * object.getPrice() + "$"));

        binding.plusBtn.setOnClickListener(view -> {
            num = num +1;
            binding.numTxt.setText(num + " ");
            binding.totalTxt.setText((" $"+num*object.getPrice()));

        });
        binding.minusBtn.setOnClickListener(view -> {
            if (num > 1){
                num = num -1;
                binding.numTxt.setText(num + "");
                binding.totalTxt.setText((" $"+num*object.getPrice()));
            }
        });
        binding.addBtn.setOnClickListener(view -> object.setNumberInCart(num));

    }

    private void getIntentExtra() {
        object = (Foods) getIntent().getSerializableExtra("object");
        managmentCart.insertFood(object);


    }
}