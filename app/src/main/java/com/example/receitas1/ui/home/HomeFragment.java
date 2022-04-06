package com.example.receitas1.ui.home;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.receitas1.R;
import com.example.receitas1.databinding.FragmentHomeBinding;

import java.io.ByteArrayOutputStream;

public class HomeFragment extends Fragment implements View.OnClickListener{
    Intent i;
    private FragmentHomeBinding binding;
    private ImageView bt1;
   //private ImageView bytes;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        bt1 = rootView.findViewById(R.id.imgBolo);
        bt1.setOnClickListener(this);

        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView;

        return root;

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.imgBolo){
            Drawable drawable = bt1.getDrawable();
            Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            byte[] imageInByte = stream.toByteArray();

             i = new Intent(getActivity(), boloc.class);


            i.putExtra("imagem", imageInByte);
            startActivity(i);
        }
    }
}