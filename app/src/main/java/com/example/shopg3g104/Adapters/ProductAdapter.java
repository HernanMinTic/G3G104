package com.example.shopg3g104.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shopg3g104.Entities.Product;
import com.example.shopg3g104.R;

import java.util.ArrayList;

public class ProductAdapter  extends BaseAdapter {
    private Context context;
    private ArrayList<Product> arrayProducts;

    public ProductAdapter(Context context, ArrayList<Product> arrayProducts) {
        this.context = context;
        this.arrayProducts = arrayProducts;
    }

    @Override
    public int getCount() {
        return this.arrayProducts.size();
    }

    @Override
    public Object getItem(int i) {
        return this.arrayProducts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, 
                        ViewGroup viewGroup) {
        View view = convertView;
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        view = LayoutInflater.inflate(R.layout.product_template, root: null);

        Product product = arrayProducts.get(position);

        ImageView imageProduct1 = (ImageView) view.findViewById(R.id.imageProduct1);
        TextView textNameProduct1 = (TextView) view.findViewById(R.id.textNameProduct1);
        TextView textDescriptionProduct1 = (TextView) view.findViewById(R.id.textDescriptionProduct1);
        TextView textPrinceProduct1 = (TextView) view.findViewById(R.id.textPrinceProduct1);

        imageProduct1.setImageResource(product.getImage());
        textNameProduct1.setText(product.getName());
        textDescriptionProduct1.setText(product.getDescription());
        textPrinceProduct1.setText(String.valueOf(product.getPrice()));

        return view;
    }
}
