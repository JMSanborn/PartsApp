package com.partsapp.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.partsapp.Database.Repository;
import com.partsapp.Entity.Part;
import com.partsapp.Entity.Product;
import com.partsapp.R;

public class MainActivity extends AppCompatActivity {
    public static int numAlert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enterHere(View view) {
        Intent intent=new Intent(MainActivity.this, ProductList.class);
        startActivity(intent);
        Repository repo=new Repository(getApplication());
        Product product=new Product(2, "Bicycle", 10.0);
        repo.insert(product);
        Part part=new Part(2, "Brake", 10.0, 1);
        repo.insert(part);
    }
}