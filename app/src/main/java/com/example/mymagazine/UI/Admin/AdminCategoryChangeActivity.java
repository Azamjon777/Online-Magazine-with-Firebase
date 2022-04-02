package com.example.mymagazine.UI.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.mymagazine.R;

public class AdminCategoryChangeActivity extends AppCompatActivity {
    private ImageView car, moto, boat, service;
    private ImageView dress, shoes, clothes, hat;
    private ImageView phone, computer, photo, fridge;
    private ImageView sport, book, collection, music;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_category_change);

        init();
        car.setOnClickListener((v) ->{
            Intent intent = new Intent(AdminCategoryChangeActivity.this, AdminAddNewProductActivity.class);
            intent.putExtra("category", "car");
            startActivity(intent);
        });
        moto.setOnClickListener((v) ->{
            Intent intent = new Intent(AdminCategoryChangeActivity.this, AdminAddNewProductActivity.class);
            intent.putExtra("category", "moto");
            startActivity(intent);
        });
        boat.setOnClickListener((v) ->{
            Intent intent = new Intent(AdminCategoryChangeActivity.this, AdminAddNewProductActivity.class);
            intent.putExtra("category", "boat");
            startActivity(intent);
        });
        service.setOnClickListener((v) ->{
            Intent intent = new Intent(AdminCategoryChangeActivity.this, AdminAddNewProductActivity.class);
            intent.putExtra("category", "service");
            startActivity(intent);
        });
        dress.setOnClickListener((v) ->{
            Intent intent = new Intent(AdminCategoryChangeActivity.this, AdminAddNewProductActivity.class);
            intent.putExtra("category", "dress");
            startActivity(intent);
        });
        shoes.setOnClickListener((v) ->{
            Intent intent = new Intent(AdminCategoryChangeActivity.this, AdminAddNewProductActivity.class);
            intent.putExtra("category", "shoes");
            startActivity(intent);
        });
        clothes.setOnClickListener((v) ->{
            Intent intent = new Intent(AdminCategoryChangeActivity.this, AdminAddNewProductActivity.class);
            intent.putExtra("category", "clothes");
            startActivity(intent);
        });
        hat.setOnClickListener((v) ->{
            Intent intent = new Intent(AdminCategoryChangeActivity.this, AdminAddNewProductActivity.class);
            intent.putExtra("category", "hat");
            startActivity(intent);
        });
        phone.setOnClickListener((v) ->{
            Intent intent = new Intent(AdminCategoryChangeActivity.this, AdminAddNewProductActivity.class);
            intent.putExtra("category", "phone");
            startActivity(intent);
        });
        computer.setOnClickListener((v) ->{
            Intent intent = new Intent(AdminCategoryChangeActivity.this, AdminAddNewProductActivity.class);
            intent.putExtra("category", "computer");
            startActivity(intent);
        });
        photo.setOnClickListener((v) ->{
            Intent intent = new Intent(AdminCategoryChangeActivity.this, AdminAddNewProductActivity.class);
            intent.putExtra("category", "photo");
            startActivity(intent);
        });
        fridge.setOnClickListener((v) ->{
            Intent intent = new Intent(AdminCategoryChangeActivity.this, AdminAddNewProductActivity.class);
            intent.putExtra("category", "fridge");
            startActivity(intent);
        });
        sport.setOnClickListener((v) ->{
            Intent intent = new Intent(AdminCategoryChangeActivity.this, AdminAddNewProductActivity.class);
            intent.putExtra("category", "sport");
            startActivity(intent);
        });
        book.setOnClickListener((v) ->{
            Intent intent = new Intent(AdminCategoryChangeActivity.this, AdminAddNewProductActivity.class);
            intent.putExtra("category", "book");
            startActivity(intent);
        });
        collection.setOnClickListener((v) ->{
            Intent intent = new Intent(AdminCategoryChangeActivity.this, AdminAddNewProductActivity.class);
            intent.putExtra("category", "collection");
            startActivity(intent);
        });
        music.setOnClickListener((v) ->{
            Intent intent = new Intent(AdminCategoryChangeActivity.this, AdminAddNewProductActivity.class);
            intent.putExtra("category", "music");
            startActivity(intent);
        });

    }

    private void init(){
        car = findViewById(R.id.car);
        moto = findViewById(R.id.moto);
        boat = findViewById(R.id.boat);
        service = findViewById(R.id.service);

        dress = findViewById(R.id.dress);
        shoes = findViewById(R.id.shoes);
        clothes = findViewById(R.id.sweater);
        hat = findViewById(R.id.hats);

        phone = findViewById(R.id.phone);
        computer = findViewById(R.id.pc);
        photo = findViewById(R.id.photo);
        fridge = findViewById(R.id.fridge);

        sport = findViewById(R.id.bicycle);
        book = findViewById(R.id.books);
        collection = findViewById(R.id.collections);
        music = findViewById(R.id.guitar);
    }
}