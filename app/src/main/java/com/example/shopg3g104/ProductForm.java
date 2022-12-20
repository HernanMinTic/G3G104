package com.example.shopg3g104;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.shopg3g104.DB.DBFirebase;
import com.example.shopg3g104.DB.DBHelper;
import com.example.shopg3g104.Entities.Product;
import com.example.shopg3g104.Services.ProductService;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ProductForm extends AppCompatActivity {

    private ProductService productService;
    //private DBHelper dbHelper;
    private DBFirebase dbFirebase;
    private Button btnAdd, btnGet, btnUpd, btnDel;
    private EditText editTxtNamFor, editTxtDesFor, editTxtPriFor, editTxtId;
    private ImageView imgToAdd;
    ActivityResultLauncher<String> content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_form);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnGet = (Button) findViewById(R.id.btnGet);
        btnUpd = (Button) findViewById(R.id.btnUpd);
        btnDel = (Button) findViewById(R.id.bntDel);
        editTxtId = (EditText) findViewById(R.id.editTxtId);
        editTxtNamFor = (EditText) findViewById(R.id.editTxtNamFor);
        editTxtDesFor = (EditText) findViewById(R.id.editTxtDesFor);
        editTxtPriFor = (EditText) findViewById(R.id.editTxtPriFor);
        imgToAdd = (ImageView) findViewById(R.id.imgAddFor);

        //byte[] img = "".getBytes(StandardCharsets.UTF_8);

        try {
            productService = new ProductService();
            //dbHelper = new DBHelper(this);
            dbFirebase = new DBFirebase();
        }catch (Exception e){
            Log.e("DB",e.toString());
        }

        /*content = registerForActivityResult(
                new ActivityResultContracts.GetContent(),
                new ActivityResultCallback<Uri>() {
                    @Override
                    public void onActivityResult(Uri result) {
                        try {
                            InputStream inputStream = getContentResolver().openInputStream(result);
                            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                            imgToAdd.setImageBitmap(bitmap);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );*/

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Product product = new Product(
                            editTxtNamFor.getText().toString(),
                            editTxtDesFor.getText().toString(),
                            Integer.parseInt(editTxtPriFor.getText().toString().trim()),
                            ""
                            //productService.imageViewToByte(imgToAdd)
                    );
                    //dbHelper.insertData(product);
                    dbFirebase.insertData(product);

                    Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_LONG).show();

                }catch (Exception e){
                    Log.e("DB Insert",e.toString());
                }

                Intent intent = new Intent(getApplicationContext(), Products.class);
                startActivity(intent);
            }
        });

        imgToAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                content.launch("image/*");
            }
        });

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = editTxtId.getText().toString().trim();
                if(id.compareTo("") != 0){
                    ArrayList<Product> list = new ArrayList<>();
                    list.add(dbFirebase.getDataById(id));

                    if(list.size() != 0){
                        Product product = list.get(0);
                        //imgToAdd.setImageBitmap(productService.byteToBitmap(product.getImage()));
                        editTxtNamFor.setText(product.getName());
                        editTxtDesFor.setText(product.getDescription());
                        editTxtPriFor.setText(String.valueOf(product.getPrice()));
                    }else{
                        Toast.makeText(getApplicationContext(),"Do not exist",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"Insert ID",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = editTxtId.getText().toString().trim();
                if(id.compareTo("") != 0){
                    Log.d("DB",id);
                    dbFirebase.deleteDataById(id);
                    clean();

                }else{
                    Toast.makeText(getApplicationContext(),"Insert ID to delete",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnUpd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = editTxtId.getText().toString().trim();
                if(id.compareTo("") != 0){
                    dbFirebase.updateDataById(
                            id,
                            editTxtNamFor.getText().toString(),
                            editTxtDesFor.getText().toString(),
                            editTxtPriFor.getText().toString(),
                            ""
                            //productService.imageViewToByte(imgToAdd)
                    );
                    clean();
                }

            }
        });
    }

    public void clean(){
        editTxtNamFor.setText("");
        editTxtDesFor.setText("");
        editTxtPriFor.setText("");
        imgToAdd.setImageResource(R.drawable.add_photo);
    }
}