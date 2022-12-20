package com.example.shopg3g104.Services;

import android.database.Cursor;

import com.example.shopg3g104.Entities.Product;
import com.example.shopg3g104.R;

import java.util.ArrayList;

public class ProductService {
    public ArrayList<Product> cursorToArray(Cursor cursor){
        ArrayList<Product> list = new ArrayList<>();
        if(cursor.getCount() == 0){
            return list;
        }else{
            while (cursor.moveToNext()){
                Product product = new Product(
                        R.drawable.product1,
                        cursor.getString(1),
                        cursor.getString(2),
                        Integer.parseInt(cursor.getString(3))
                );
                list.add(product);
            }
        }
        return list;
    }
}
