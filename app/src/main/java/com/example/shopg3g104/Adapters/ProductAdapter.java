package com.example.shopg3g104.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shopg3g104.Entities.Product;
import com.example.shopg3g104.ProductDetails;
import com.example.shopg3g104.Products;
import com.example.shopg3g104.R;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Product> arrayProducts;

    public ProductAdapter(Context context, ArrayList<Product> arrayProducts) {
        this.context = context;
        this.arrayProducts = arrayProducts;
    }

    @Override
    public int getCount() {
        return arrayProducts.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayProducts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        view = layoutInflater.inflate(R.layout.product_template, null);

        Button btnProTem = (Button) view.findViewById(R.id.btnProTem);
        TextView txtNamProTem = (TextView) view.findViewById(R.id.txtNamProTem);
        TextView txtDesProTem = (TextView) view.findViewById(R.id.txtDesProTem);
        TextView txtPriProTem = (TextView) view.findViewById(R.id.txtPriProTem);
        ImageView imgProTem = (ImageView) view.findViewById(R.id.imgProTem);

        Product product = arrayProducts.get(i);

        txtNamProTem.setText(product.getName());
        txtDesProTem.setText(product.getDescription());
        txtPriProTem.setText(String.valueOf(product.getPrice()));

        byte[] image = product.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
        imgProTem.setImageBitmap(bitmap);

        imgProTem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context.getApplicationContext(), ProductDetails.class);
                intent.putExtra("id", String.valueOf(product.getId()));
                context.startActivity(intent);
            }
        });

        btnProTem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context.getApplicationContext(), ProductDetails.class);
                intent.putExtra("id", String.valueOf(product.getId()));
                context.startActivity(intent);
            }
        });

    /*setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ProductDetails.class);
                Toast.makeText(context.getApplicationContext(), "Presionado: "+ product.getName(), Toast.LENGTH_SHORT).show();
                intent.putExtra("name", product.getName());
                intent.putExtra("description", product.getDescription());
                intent.putExtra("price", String.valueOf(product.getPrice()));
                intent.putExtra("image", product.getImage());
                context.startActivity(intent);
            }
        });*/

        return view;
    }
}
