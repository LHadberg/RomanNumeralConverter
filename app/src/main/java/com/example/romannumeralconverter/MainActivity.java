package com.example.romannumeralconverter;

import static java.lang.Integer.parseInt;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnToRoman, btnFromRoman;
    private TextView txtToValue, txtFromValue;
    private ActivityResultLauncher launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //GET COMPONENTS BY ID
        btnToRoman = findViewById(R.id.btnToRoman);
        btnFromRoman = findViewById(R.id.btnFromRoman);
        txtToValue = findViewById(R.id.txtToValue);
        txtFromValue = findViewById(R.id.txtFromValue);

        //LAUNCHER FOR NAVIGATION
        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                Intent res = result.getData();
                String childActivity = res.getStringExtra("childActivity");

                if(result.getResultCode() == ConverterContstants.FROM_ARABIC){
                    //FROM ARABIC
                    int arabicNumeral = res.getIntExtra("input", 0);
                    //TO ROMAN
                    String romanNumeral = res.getStringExtra("result");

                    //HANDLE RESULT
                    txtFromValue.setText("" + arabicNumeral);
                    txtToValue.setText(romanNumeral);
                    Toast.makeText(MainActivity.this, arabicNumeral + " = " + romanNumeral, Toast.LENGTH_SHORT).show();
                }

                //CONVERT FROM ROMAN TO ARABIC
                if(result.getResultCode() == ConverterContstants.FROM_ROMAN){
                    //FROM ROMAN
                    String romanNumeral = res.getStringExtra("input");
                    //TO ARABIC
                    int arabicNumeral = res.getIntExtra("result", 0);

                    //HANDLE RESULT
                    txtFromValue.setText(romanNumeral);
                    txtToValue.setText("" + arabicNumeral);
                    Toast.makeText(MainActivity.this, romanNumeral + " = " + arabicNumeral, Toast.LENGTH_SHORT).show();
                }
            }
        });

        //ONCLICK HANDLERS
        btnToRoman.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ToRomanActivity.class);
            launcher.launch(intent);
        });
        btnFromRoman.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ToArabicActivity.class);
            launcher.launch(intent);
        });
    }
}