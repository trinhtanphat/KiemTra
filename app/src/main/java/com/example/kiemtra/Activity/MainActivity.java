package com.example.kiemtra.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.kiemtra.Adapter.ProductAdapter;
import com.example.kiemtra.DAO.ProductDAO;
import com.example.kiemtra.Model.Product;
import com.example.kiemtra.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductAdapter ProductAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ProductDAO ProductDAO = new ProductDAO(this);
        ArrayList<Product> listProduct = ProductDAO.getListProduct();
        ProductAdapter = new ProductAdapter(this, listProduct);
        recyclerView.setAdapter(ProductAdapter);
    }

    public void refreshRecyclerView() {
        ProductDAO ProductDAO = new ProductDAO(MainActivity.this);
        ArrayList<Product> list = ProductDAO.getListProduct();
        ProductAdapter ProductAdapter = new ProductAdapter(MainActivity.this, list);
        recyclerView.setAdapter(ProductAdapter);
    }
}