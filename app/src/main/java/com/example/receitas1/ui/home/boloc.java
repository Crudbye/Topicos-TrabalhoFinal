package com.example.receitas1.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.receitas1.R;

public class boloc extends AppCompatActivity {
    private ImageView bt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bolocenoura);
        try {
            Bundle bundle = getIntent().getExtras();
            if (bundle != null){
                try {
                    byte[] imageInByte = bundle.getByteArray("imagem");
                    Bitmap bmp = BitmapFactory.decodeByteArray(imageInByte,0,imageInByte.length);
                    bt2 = findViewById(R.id.bt2);
                    bt2.setImageBitmap(bmp);
                }catch (Exception e){}
            }
        }catch (Exception e){
            Toast.makeText(this,""+e,Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}