package com.example.shopg3g104;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.shopg3g104.Adapters.ProductAdapter;
import com.example.shopg3g104.Entities.Product;

import java.util.ArrayList;

public class Products extends AppCompatActivity {
    private ListView listViewProduct;
    private ArrayList<Product> arrayProductos;
    private ProductAdapter productAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        arrayProductos = new ArrayList<>();
        Product producto1 = new Product(R.drawable.product1,"Apple AirPods Max", "Excellent", 500);
        Product producto2 = new Product(R.drawable.product2,"Bose Noise Cancelling", "Great", 350);
        Product producto3 = new Product(R.drawable.product3,"Soundcore Life Q30", "Good", 100);

        arrayProductos.add(producto1);
        arrayProductos.add(producto2);
        arrayProductos.add(producto3);


        productAdapter = new ProductAdapter(this, arrayProductos);
        listViewProduct = (ListView) findViewById(R.id.listViewProducts);
        listViewProduct.setAdapter(productAdapter);


        /*btnPro1.setOnClickListener(view -> {

        });*/


    }
}