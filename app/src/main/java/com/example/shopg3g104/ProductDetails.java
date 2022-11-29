package com.example.shopg3g104;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetails extends AppCompatActivity {

    private Button btnDetPro;
    private TextView txtProName, txtDetPro, txtDesPro, txtPriPro;
    private ImageView imgDetPro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        btnDetPro = (Button) findViewById(R.id.btnDetPro);
        txtProName = (TextView) findViewById(R.id.txtProName);
        txtDetPro = (TextView) findViewById(R.id.txtDetPro);
        txtDesPro = (TextView) findViewById(R.id.txtDesPro);
        txtPriPro = (TextView) findViewById(R.id.txtPriPro);
        imgDetPro = (ImageView) findViewById(R.id.imgDetPro);

        Intent intendIn = getIntent();
        txtProName.setText(intendIn.getStringExtra("name"));
        txtPriPro.setText(intendIn.getStringExtra("price"));
        txtDesPro.setText(intendIn.getStringExtra("description"));

        int imageCodeBlank = intendIn.getIntExtra("imageCodeBlank", 0);
        int codeImage = intendIn.getIntExtra("imageCode", imageCodeBlank);
        imgDetPro.setImageResource(codeImage);

        btnDetPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Products.class);
                startActivity(intent);
            }
        });
    }
}