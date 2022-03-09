package com.partsapp.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.partsapp.Database.Repository;
import com.partsapp.Entity.Product;
import com.partsapp.R;

public class PartList extends AppCompatActivity {
    EditText editName;
    EditText editPrice;
    String name;
    Double price;
    int productID;
    Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_list);
        editName=findViewById(R.id.editProductName);
        editPrice=findViewById(R.id.editProductPrice);
        productID=getIntent().getIntExtra("id", -1);
        name=getIntent().getStringExtra("name");
        price=getIntent().getDoubleExtra("price", -1.0);
        editName.setText(name);
        editPrice.setText(Double.toString(price));
        repository=new Repository(getApplication());


    }
    public void saveButton(View view){
        Product product;
        if (productID == -1){
            int newID = repository.getAllProducts().get(repository.getAllProducts().size() - 1).getProductID() +1;
            product = new Product(newID, editName.getText().toString(), Double.parseDouble(editPrice.getText().toString()));
            repository.insert(product);
        } else{
            product = new Product(productID, editName.getText().toString(), Double.parseDouble(editPrice.getText().toString()));
            repository.update(product);
        }

    }
    public void detailScreen(View view) {
        Intent intent = new Intent(PartList.this, PartDetail.class);
        startActivity(intent);
    }
}