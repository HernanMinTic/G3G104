package com.example.shopg3g104;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Products extends AppCompatActivity {

    private Button btnPro1;
    private Button btnPro2;
    private Button btnPro3;

    private TextView txtPro1, txtPro2, txtPro3;

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

        btnPro1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ProductDetails.class);
                intent.putExtra("name", txtPro1.getText().toString());
                startActivity(intent);
            }
        });

        btnPro2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ProductDetails.class);
                intent.putExtra("name", txtPro2.getText().toString());
                startActivity(intent);
            }
        });

        btnPro3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ProductDetails.class);
                intent.putExtra("name", txtPro3.getText().toString());
                startActivity(intent);
            }
        });
    }
}