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
    }
    public void toTriangle(View view){
        startActivity(new Intent(MainActivity.this, TriangleActivity.class));
    }
    public void onBtnClick(View view) {
        startActivity(new Intent(MainActivity.this,ConverterActivity.class));

    }
}