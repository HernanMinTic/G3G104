package com.example.shopg3g104;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProductDetails extends AppCompatActivity {

    private Button btnDetPro;
    private TextView txtProName, txtDetPro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        btnDetPro = (Button) findViewById(R.id.btnDetPro);
        txtProName = (TextView) findViewById(R.id.txtProName);
        txtDetPro = (TextView) findViewById(R.id.btnDetPro);

        Intent intendIn = getIntent();
        txtProName.setText(intendIn.getStringExtra("name"));

        btnDetPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Products.class);
                startActivity(intent);
            }
        });
    }
}