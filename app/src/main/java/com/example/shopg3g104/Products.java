package com.example.shopg3g104;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Products extends AppCompatActivity {

    private Button btnDetPro;
    private TextView txtProName, txtPriPro, txtDesPro;
    private ImageView imgDetPro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        btnDetPro = (Button) findViewById(R.id.btnDetPro);

        txtProName = (TextView) findViewById(R.id.txtProName);
        txtPriPro = (TextView) findViewById(R.id.txtPriPro);
        txtDesPro = (TextView) findViewById(R.id.txtDesPro);

        imgDetPro = (ImageView) findViewById(R.id.imgDetPro);

        Intent intentIn = getIntent();
        txtProName.setText(intentIn.getStringExtra("name"));
        txtDesPro.setText(intentIn.getStringExtra("description"));
        txtPriPro.setText(intentIn.getStringExtra("price"));
        //int codeImage = intentIn.getIntExtra("image", 0);
        //imgDetPro.setImageResource(codeImage);

        btnDetPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ProductDetails.class);
                startActivity(intent);
            }
        });
    }
}

        /*btnPro1.setOnClickListener(view -> {
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
        });*/

