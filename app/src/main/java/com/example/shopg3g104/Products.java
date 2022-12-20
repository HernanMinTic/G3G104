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
import com.example.shopg3g104.DB.DBFirebase;
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

    private DBHelper dbHelper;
    private DBFirebase dbFirebase;
    private ProductService productService;
    private ListView listViewProducts;
    private ArrayList<Product> arrayProducts;
    private ProductAdapter ProductAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        arrayProducts = new ArrayList<>();

        try{
            //dbHelper = new DBHelper(this);
            dbFirebase = new DBFirebase();

            //byte [] img = "".getBytes();

            productService = new ProductService();
            //Cursor cursor = dbHelper.getData();
            //arrayProducts = productService.cursorToArray(cursor);
            Toast.makeText(this, "Insert OK", Toast.LENGTH_SHORT).show();
        }catch(Exception e){
            Log.e("Database", e.toString());
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }
        productAdapter = new ProductAdapter(this, arrayProducts);

        listViewProducts = (ListView) findViewById(R.id.listPro);
        listViewProducts.setAdapter(productAdapter);

        dbFirebase.getData(productAdapter, arrayProducts);
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