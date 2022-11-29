package com.example.shopg3g104;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Products extends AppCompatActivity {

    private Button btnPro1, btnPro2, btnPro3;
    private TextView txtPro1, txtPro2, txtPro3, txtPriPro1, txtPriPro2, txtPriPro3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        btnPro1 = (Button) findViewById(R.id.btnPro1);
        btnPro2 = (Button) findViewById(R.id.btnPro2);
        btnPro3 = (Button) findViewById(R.id.btnPro3);

        txtPro1 = (TextView) findViewById(R.id.txtPro1);
        txtPro2 = (TextView) findViewById(R.id.txtPro2);
        txtPro3 = (TextView) findViewById(R.id.txtPro3);
        txtPriPro1 = (TextView) findViewById(R.id.txtPriPro1);
        txtPriPro2 = (TextView) findViewById(R.id.txtPriPro2);
        txtPriPro3 = (TextView) findViewById(R.id.txtPriPro3);

        btnPro1.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), ProductDetails.class);
            intent.putExtra("name", txtPro1.getText().toString());
            intent.putExtra("price", txtPriPro1.getText().toString());
            intent.putExtra("description", "Excellent");
            intent.putExtra("imageCode", R.drawable.product1);
            intent.putExtra("imageCodeBlank", R.drawable.blank_image);
            startActivity(intent);
        });

        btnPro2.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), ProductDetails.class);
            intent.putExtra("name", txtPro2.getText().toString());
            intent.putExtra("price", txtPriPro2.getText().toString());
            intent.putExtra("description", "Great");
            intent.putExtra("imageCode", R.drawable.product2);
            intent.putExtra("imageCodeBlank", R.drawable.blank_image);
            startActivity(intent);
        });

        btnPro3.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), ProductDetails.class);
            intent.putExtra("name", txtPro3.getText().toString());
            intent.putExtra("price", txtPriPro3.getText().toString());
            intent.putExtra("description", "Good");
            intent.putExtra("imageCode", R.drawable.product3);
            intent.putExtra("imageCodeBlank", R.drawable.blank_image);
            startActivity(intent);
        });
    }
}