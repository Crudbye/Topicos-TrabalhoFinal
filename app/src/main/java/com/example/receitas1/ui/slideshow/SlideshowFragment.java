package com.example.receitas1.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.example.receitas1.R;
import com.example.receitas1.databinding.FragmentSlideshowBinding;

public class SlideshowFragment extends Fragment implements View.OnClickListener{
    private FragmentSlideshowBinding binding;
    private EditText et1;
    private TextView tv;
    private TextView tv2;
    private float resultReal;
    private float resultDolar;
    private double valorPeso;
    private float dolarD;
    private float realD;

    private Button bt1;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_slideshow, container, false);

        bt1 =  rootView.findViewById(R.id.botao);

        et1 =  (EditText) rootView.findViewById(R.id.et1);
        tv =  (TextView) rootView.findViewById(R.id.tv1);
        tv2 = (TextView) rootView.findViewById(R.id.tv2);

        if(savedInstanceState!=null){
            dolarD = savedInstanceState.getFloat("us");
            realD = savedInstanceState.getFloat("pss");
            tv.setText("Em Dolar: R$ "+dolarD);
            tv2.setText("Em Real: $ "+realD);
        }
        bt1.setOnClickListener(this);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

       // final TextView textView = binding.textSlideshow;
      //  slideshowViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.botao){

            valorPeso = Double.parseDouble(et1.getText().toString());
            dolarD = (float) (valorPeso*0.024);
            realD = (float) (valorPeso*0.12);
            tv.setText("Em Dolar: $ "+dolarD);
            tv2.setText("Em Real: R$ "+realD);
        }
    }
}