package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void convertCurrency(View view) {
        EditText editText = (EditText) findViewById(R.id.amountEditText);
        Log.i("edit text info", "Edit text works");
        String amountInPounds = editText.getText().toString();
        double amountInPoundsDouble = Double.parseDouble(amountInPounds);
        double amountInDollars = amountInPoundsDouble * 1.3;
        @SuppressLint("DefaultLocale") String amountInDollarsString = String.format("%.2f", amountInDollars);
        Toast.makeText(this, "$" + amountInPounds + " is" + amountInDollarsString + " pounds", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}