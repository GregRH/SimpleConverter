package com.example.simpleconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class TriangleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle);
    }
    public void calcTriangle(View view){
        Triangle t ;
        EditText[] txtSide = {findViewById(R.id.txtSideA),findViewById(R.id.txtSideB),findViewById(R.id.txtSideC),findViewById(R.id.txtAngleA),findViewById(R.id.txtAngleB)};
        double[] sides = new double[5];
        for(int i = 0; i<5;i++){
            try{//this is really bad
                sides[i]=Double.parseDouble(txtSide[i].getText().toString());//TODO use the function to check input
            }catch(Exception e){
                Log.d("err message",e.getMessage());
                sides[i]=0;
            }
        }
        t = new Triangle(sides[0],sides[1],sides[2],sides[3],sides[4],90);
        if(utils.isRightTriangle(t)||true) {//this function isn't finished
            utils.calculateAngles(t);
            utils.calculateSides(t);
            fillTriangle(t);
        }
    }
    public void fillTriangle(Triangle a){
        EditText[] txtSide = {findViewById(R.id.txtSideA),findViewById(R.id.txtSideB),findViewById(R.id.txtSideC),findViewById(R.id.txtAngleA),findViewById(R.id.txtAngleB)};
        double[] sides ={a.getSide_a(),a.getSide_b(),a.getSide_c(),a.getAngleA(),a.getAngleB()};
        for(int i = 0;i<5;i++){//no Angle C
            txtSide[i].setText(utils.decToFrac(sides[i],16));
        }
    }

}