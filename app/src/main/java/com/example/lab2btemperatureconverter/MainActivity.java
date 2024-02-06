package com.example.lab2btemperatureconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.example.lab2btemperatureconverter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    double f_temp, c_temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isvalidConversion()){
                    convert();
                }
            }
        });
    }

    protected boolean isvalidConversion(){
        if(binding.fInput.getText().toString().equals(".") || binding.cInput.getText().toString().equals(".")){
            return false;
        }
        else if (binding.fInput.getText().toString().isEmpty() && binding.cInput.getText().toString().isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }
    protected void convert(){

        if (TextUtils.isEmpty(binding.fInput.getText())){
            c_temp = Double.parseDouble(binding.cInput.getText().toString());
            f_temp = (c_temp * 9/5) + 32;
            binding.fInput.setText(String.valueOf(f_temp));
        }
        else {
            f_temp = Double.parseDouble(binding.fInput.getText().toString());
            c_temp = (f_temp - 32) * 5/9;
            binding.cInput.setText(String.valueOf(c_temp));
        }


    }
}