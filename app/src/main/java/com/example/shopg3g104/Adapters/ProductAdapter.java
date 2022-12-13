package com.example.shopg3g104.Adapters;

import android.content.Context;
import android.content.Intent;
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
import com.example.shopg3g104.R;

import java.util.ArrayList;

public class ProductAdapter  extends BaseAdapter {
    private Context context;
    private ArrayList<Product> arrayProductos;

    public ProductAdapter(Context context, ArrayList<Product> arrayProductos) {
        this.context = context;
        this.arrayProductos = arrayProductos;
    }

    @Override
    public int getCount() {return this.arrayProductos.size();}

    @Override
    public Object getItem(int i) {
        return this.arrayProductos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        view = layoutInflater.inflate(R.layout.product_template, null);



        ImageView imageProduct1 = (ImageView) view.findViewById(R.id.imageProducto);
        TextView textNameProduct1 = (TextView) view.findViewById(R.id.textNameProducto);
        TextView textDescriptionProduct1 = (TextView) view.findViewById(R.id.textDescriptionProducto);
        TextView textPrinceProduct1 = (TextView) view.findViewById(R.id.textPrinceProducto);

        Product product = arrayProductos.get(i);

        imageProduct1.setImageResource(product.getImage());
        textNameProduct1.setText(product.getName());
        textDescriptionProduct1.setText(product.getDescription());
        int Col = product.getPrice() *5000;
        int Usd = product.getPrice();
        String prices = "Pesos: "+Col+" - "+ "USD: "+Usd;
        textPrinceProduct1.setText(prices);
        imageProduct1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context.getApplicationContext(), ProductDetails.class);
                intent.putExtra("name", product.getName());
                intent.putExtra("description", product.getDescription());
                intent.putExtra("price", prices);
                intent.putExtra("imageCode", product.getImage());
                context.startActivity(intent);

            }
        });


        return view;

    }
}
