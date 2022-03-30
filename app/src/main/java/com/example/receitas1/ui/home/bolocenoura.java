package com.example.receitas1.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.receitas1.R;

public class bolocenoura extends AppCompatActivity {
    private ImageView bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bolocenoura);
        bt1 = findViewById(R.id.bt1);


        Intent intent = getIntent();

        Bundle param = intent.getExtras();
        byte[] bytes = param.getByteArray("bitmapbytes");
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);

        bt1.setImageBitmap(drawable);
    }
}