package com.example.simpleconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText frac = findViewById(R.id.numFrac);
        TextView txtResult = findViewById(R.id.txtResult);
        txtResult.setText("Enter a decimal");
        frac.setText(Integer.toString(16));
    }
    public void onBtnClick(View view) {
        TextView txtResult = findViewById(R.id.txtResult);
        EditText numInput = findViewById(R.id.numInput);
        EditText frac = findViewById(R.id.numFrac);
        int denom = 0;
        try {
            denom = Integer.parseInt(frac.getText().toString());
        } catch(Exception e){
            denom = 16;
            frac.setText(Integer.toString(denom));
        }
        if (denom <= 0) {
            denom = 16;
            frac.setText(Integer.toString(denom));
        }
        //IDK if i need error handling for this
        try {//I do
            txtResult.setText(utils.decToFrac(Double.parseDouble(numInput.getText().toString()), denom));
        }catch (Exception e){
            numInput.setText("Bad");
        }
    }
}