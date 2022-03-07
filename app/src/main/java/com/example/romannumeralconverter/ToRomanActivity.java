package com.example.romannumeralconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ToRomanActivity extends AppCompatActivity {
    private Button btnConvertToRoman;
    private EditText etArabicNumeral;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_roman);

        //GET COMPONENTS BY ID
        btnConvertToRoman = findViewById(R.id.btnConvertToRoman);
        etArabicNumeral = findViewById(R.id.etArabicNumeral);

        //ONCLICK LISTENERS
        btnConvertToRoman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //GET NUMBER TO CONVERT
                int arabicNumeral = Integer.parseInt(etArabicNumeral.getText().toString());
                //INSTANCE OF UTIL CLASS
                RomanConverter rc = new RomanConverter();

                //CONVERT
                String romanNumeral = rc.ArabicToRoman(arabicNumeral);

                //DEFINE RESULT AND ADD VALUES TO IT
                Intent resultIntent = new Intent();
                resultIntent.putExtra("childActivity", "ToRomanActivity");
                resultIntent.putExtra("input", arabicNumeral);
                resultIntent.putExtra("result", romanNumeral);
                setResult(ConverterContstants.FROM_ARABIC, resultIntent);
                finish();
            }
        });

    }
}