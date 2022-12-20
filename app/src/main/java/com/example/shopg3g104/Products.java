package com.example.shopg3g104;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shopg3g104.Adapters.ProductAdapter;
import com.example.shopg3g104.DB.DBHelper;
import com.example.shopg3g104.Entities.Product;
import com.example.shopg3g104.Services.ProductService;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import com.example.shopg3g104.Adapters.ProductAdapter;
import com.example.shopg3g104.Entities.Product;

import java.util.ArrayList;

public class Products extends AppCompatActivity {
    private ListView listViewProduct;
    private ArrayList<Product> arrayProductos;
    private ProductAdapter productAdapter;

    /*private Button btnPro1;
    private TextView txtPro1, txtPriPro1;*/

    private DBHelper dbHelper;
    private ProductService productService;
    private ListView listViewProducts;
    private ArrayList<Product> arrayProducts;
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        arrayProducts = new ArrayList<>();

        try{
            dbHelper = new DBHelper(this);
            byte [] img = "".getBytes();
            /*dbHelper.insertData("Product1", "Description1", "100", img);
            dbHelper.insertData("Product2", "Description2", "200", img);
            dbHelper.insertData("Product3", "Description3", "300", img);
            dbHelper.insertData("Product4", "Description4", "400", img);
            dbHelper.insertData("Product5", "Description5", "500", img);*/
            productService = new ProductService();
            Cursor cursor = dbHelper.getData();
            arrayProducts = productService.cursorToArray(cursor);
            Toast.makeText(this, "Insert OK", Toast.LENGTH_SHORT).show();
        }catch(Exception e){
            Log.e("Database", e.toString());
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }


        /*Product product1 = new Product(R.drawable.product1, "AirPods Max", "Excellent", 500);
        Product product2 = new Product(R.drawable.product2, "Bose 700", "Great", 350);
        Product product3 = new Product(R.drawable.product3, "Soundcore Life Q35", "Good", 100);

        arrayProducts.add(product1);
        arrayProducts.add(product2);
        arrayProducts.add(product3);*/

        productAdapter = new ProductAdapter(this, arrayProducts);

        listViewProducts = (ListView) findViewById(R.id.listPro);
        listViewProducts.setAdapter(productAdapter);

        /*btnPro1 = (Button) findViewById(R.id.btnPro1);
        txtPro1 = (TextView) findViewById(R.id.txtPro1);
        txtPriPro1 = (TextView) findViewById(R.id.txtPriPro1);

        btnPro1.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), ProductDetails.class);
            intent.putExtra("name", txtPro1.getText().toString());
            intent.putExtra("price", txtPriPro1.getText().toString());
            intent.putExtra("description", "Excellent");
            intent.putExtra("imageCode", R.drawable.product1);
            intent.putExtra("imageCodeBlank", R.drawable.blank_image);
            startActivity(intent);
        });*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.actionFor:
                Intent intent = new Intent(getApplicationContext(), ProductForm.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}