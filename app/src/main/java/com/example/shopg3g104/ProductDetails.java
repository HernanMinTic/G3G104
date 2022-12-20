package com.example.shopg3g104;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shopg3g104.DB.DBHelper;
import com.example.shopg3g104.Entities.Product;
import com.example.shopg3g104.Services.ProductService;

import java.util.ArrayList;

public class ProductDetails extends AppCompatActivity {

    private DBHelper dbHelper;
    private ProductService productService;
    private Button btnDetPro;
    private TextView txtNamPro, txtDesPro, txtPriPro;
    private ImageView imgDetPro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        btnDetPro = (Button) findViewById(R.id.btnDetPro);
        txtNamPro = (TextView) findViewById(R.id.txtNamPro);
        txtDesPro = (TextView) findViewById(R.id.txtDesPro);
        txtPriPro = (TextView) findViewById(R.id.txtPriPro);
        imgDetPro = (ImageView) findViewById(R.id.imgDetPro);
        //dbHelper = new DBHelper(this);
        productService = new ProductService();

        Intent intentIn = getIntent();
        String id = intentIn.getStringExtra("id");

        txtNamPro.setText(intentIn.getStringExtra("name"));
        txtDesPro.setText(intentIn.getStringExtra("description"));
        txtPriPro.setText(String.valueOf(intentIn.getStringExtra("price")));
        //imgDetPro.setImageBitmap(productService.byteToBitmap(product.getImage()));

        btnDetPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Products.class);
                startActivity(intent);
            }
        });
    }
}