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
            txtResult.setText(decToFrac(Double.parseDouble(numInput.getText().toString()), denom));
        }catch (Exception e){
            numInput.setText("Bad");
        }
    }
    private String decToFrac(double x, int d){
        //pass it a number in decimal and it will convert it to the nearest fraction with d as the denominator
        //d > 0
        String r =Integer.toString((int)x)+"";
        double err = 1/(d*2.0); //err is halfway between units
        x=x-(int)x;
        int i=0;
        while(x>err&&x>0){
            i++;
            x=x-(1.0/d);
        }
        r=r+" "+Integer.toString(i)+"/"+Integer.toString(d);
        return r;
    }
}