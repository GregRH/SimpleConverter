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
        if(true) {//this function isn't finished
            utils.calculateAnglesR(t);
            utils.calculateSidesR(t);
            fillTriangle(t);
        }
        Triangle hidden = new Triangle(3,4,5,0,0,0);
        Triangle hidden1 = new Triangle(3,4,0,0,0,90);//aCb
        Triangle hidden2 = new Triangle(0,4,5,36.8698,0,0);//cAb
        Triangle hidden3 = new Triangle(3,0,5,0,53.1301,0);//aBc
       // Triangle hidden4 = new Triangle(3,4,5,0,0,0);
        utils.calculateTriangle(hidden);
        utils.calculateTriangle(hidden1);
        utils.calculateTriangle(hidden2);
        utils.calculateTriangle(hidden3);
        Log.d("Hidden",hidden.toString());
        Log.d("Hidden1",hidden1.toString());
        Log.d("Hidden2",hidden2.toString());
        Log.d("Hidden3",hidden3.toString());
    }
    public void fillTriangle(Triangle a){
        EditText[] txtSide = {findViewById(R.id.txtSideA),findViewById(R.id.txtSideB),findViewById(R.id.txtSideC),findViewById(R.id.txtAngleA),findViewById(R.id.txtAngleB)};
        double[] sides =a.getSide();
        double[] angles= a.getAngle();
        Log.d("fill","");
        for(int i = 0;i<sides.length;i++){
            Log.d("fill","S"+i);
            txtSide[i].setText(utils.decToFrac(sides[i],16));
        }
        for(int i = 0;i<angles.length-1;i++) {
            Log.d("fill", "a" + i);
            txtSide[i+sides.length].setText(utils.decToFrac(angles[i], 16));
        }
    }

}