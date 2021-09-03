package com.example.simpleconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.EditText;
public class ConverterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);
        TextView instructions = findViewById(R.id.InstructionsTxt);
        TextView result = findViewById(R.id.resultTxt);
        result.setText("Results are shown here");
        //todo change reduce text
        instructions.setText("Converts between decimals and mixed numbers.\nYou can set the accuracy by changing denominator but mixed numbers are reduced.\nEnter a number as a decimal or mixed number. \nex\n10.5\n10 1/2");
    }
    public void calcButton(View view){
        EditText input = findViewById(R.id.NumInTxt);
        EditText frac = findViewById(R.id.DenomTxt);
        TextView result = findViewById(R.id.resultTxt);
        Switch reduceSwitch = findViewById(R.id.ReduceSwitch);
        int denom=16;
        if(isNum(frac.getText().toString())){
            try {
                denom=Integer.parseInt(frac.getText().toString());
                Log.d("Converter","Denominator"+denom);
            }catch(Exception e){
                denom=16;
                frac.setText(denom+"");
                Log.d("Converter","Invalid Denominator");
            }
        }
        try{
            if(utils.checkValidinput(input.getText().toString())){
                //convert
                if(utils.isFrac(input.getText().toString()))
                    //convert to decimal
                    result.setText(Double.toString(utils.fracToDouble(input.getText().toString())));
                else
                    //convert to fraction
                result.setText(utils.decToFrac(Double.parseDouble(input.getText().toString()), denom,reduceSwitch.isChecked()));

            }
            else
                result.setText("Please enter a valid number");
        }catch(Exception e){
            result.setText("Please enter a valid number");
            Log.d("Converter", "Failed to convert");
        }
    }
    private boolean isNum(String string){
        if(string == "")
            return false;
        for(int i =0;i<string.length();i++){
            if((string.toCharArray()[i]-'0')>9||(string.toCharArray()[i]-'0')<0)
                return false;
        }
        return true;
    }

}