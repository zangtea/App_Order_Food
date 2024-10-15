package com.example.app_order_food.Activity;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_order_food.Adapter.CartAdapter;
import com.example.app_order_food.Helper.ChangeNumberItemsListener;
import com.example.app_order_food.Helper.ManagmentCart;
import com.example.app_order_food.R;
import com.example.app_order_food.databinding.ActivityCartBinding;
import com.example.app_order_food.databinding.ActivityDetailBinding;

import java.util.List;

public class CartActivity extends AppCompatActivity {
  private ActivityCartBinding binding; // Thay vì ActivityDetailBinding
    
    private RecyclerView.Adapter adapter;
    private ManagmentCart managmentCart;
    private double tax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());

        managmentCart = new ManagmentCart(this);

        setVariable();
        calculateCart();
        initList();

    }

    private void initList() {
        if (managmentCart.getListCart().isEmpty())
        {
            binding.emptyTxt.setVisibility(View.VISIBLE);
            binding.scrollviewCart.setVisibility(View.GONE);
        }else{
            binding.emptyTxt.setVisibility(View.GONE);
            binding.scrollviewCart.setVisibility(View.VISIBLE);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        binding.cartView.setVisibility(View.VISIBLE);
        adapter = new CartAdapter(managmentCart.getListCart(), this, () -> calculateCart());
        binding.cartView.setAdapter(adapter);


    }

    private void calculateCart() {
        double percentTax=0.02;
        double delivery=10;

        tax = Math.round(managmentCart.getTotalFee()*percentTax*100.0) / 100 ;
        double total = Math.round((managmentCart.getTotalFee() + tax + delivery ) * 100) / 100;
        double itemTotal = Math.round(managmentCart.getTotalFee() * 100 ) / 100;

        binding.totalFeeTxt.setText("$" + itemTotal);

        binding.taxTxt.setText("$" + tax);
        binding.deliveryTxt.setText("$"+ delivery);
        binding.totalTxt.setText("$" +total);


    }

    private void setVariable() {
        binding.backBtn.setOnClickListener(view -> finish()
        );
    }
}