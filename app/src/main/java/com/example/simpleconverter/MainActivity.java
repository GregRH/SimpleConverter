package com.example.simpleconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    public void toTriangle(View view){
        startActivity(new Intent(MainActivity.this, TriangleActivity.class));
    }
    public void onBtnClick(View view) {
        TextView txtResult = findViewById(R.id.txtResult);
        EditText numInput = findViewById(R.id.numInput);
        EditText frac = findViewById(R.id.numFrac);
        Button b = findViewById(R.id.button);
        int denom;
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
            if(utils.checkValidinput(numInput.getText().toString())) {
                String s = utils.decToFrac(Double.parseDouble(numInput.getText().toString()), denom);
                txtResult.setText(utils.decToFrac(Double.parseDouble(numInput.getText().toString()), denom));
                if (utils.checkValidinput(s)) {
                    b.setText(Double.toString(utils.fracToDouble(s)));
                }
            }
        }catch (Exception e){
            numInput.setText("Bad");
        }
    }
}