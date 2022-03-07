package com.example.romannumeralconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class ToArabicActivity extends AppCompatActivity {
    private Button btnConvertToArabic;
    private EditText etRomanNumeral;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_arabic);

        //GET COMPONENTS BY ID
        btnConvertToArabic = findViewById(R.id.btnConvertToArabic);
        etRomanNumeral = findViewById(R.id.etRomanNumeral);

        //ONCLICK LISTENERS
        btnConvertToArabic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //GET NUMBER TO CONVERT
                String romanNumeral = etRomanNumeral.getText().toString().toUpperCase();

                //INSTANCE OF UTIL CLASS
                RomanConverter rc = new RomanConverter();

                //CONVERT
                int arabicNumeral = rc.RomanToArabic(romanNumeral);

                //DEFINE RESULT AND ADD VARIABLES TO IT
                Intent resultIntent = new Intent();
                resultIntent.putExtra("childActivity", "ToArabicActivity");
                resultIntent.putExtra("input", romanNumeral);
                resultIntent.putExtra("result", arabicNumeral);
                setResult(ConverterContstants.FROM_ROMAN, resultIntent);
                finish();
            }
        });
    }
}