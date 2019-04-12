package com.example.bodymassindexproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private TextView weighttxt, heighttxt, resulttxt;
private Button calcbttn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initiate();
        setbutton();
    }
    private void initiate(){
weighttxt =findViewById(R.id.weighttxt);
heighttxt =findViewById(R.id.heighttxt);
resulttxt = findViewById(R.id.resulttxt);
calcbttn = findViewById(R.id.calcbtn);


    }
    private void setbutton(){
        calcbttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalculateBMI();
            }
        });
    }

    private void CalculateBMI(){
    float weight=Float.parseFloat(weighttxt.getText().toString());
    float height=Float.parseFloat(heighttxt.getText().toString())/100;
    WeightModel wm=new WeightModel(weight,height);
    float result=wm.getWeight()/(wm.getHeight()*wm.getHeight());
    resulttxt.setText(""+result);
        if (result<18.5){
            Toast.makeText(MainActivity.this,"Underweight",Toast.LENGTH_LONG).show();
        }
        else if (result>=18.5 && result<=24.9){
            Toast.makeText(MainActivity.this,"Normal Weight",Toast.LENGTH_LONG).show();
        }
        else if (result>=25 && result<=29.9){
            Toast.makeText(MainActivity.this,"Overweight",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(MainActivity.this,"Obesity",Toast.LENGTH_LONG).show();
        }


    }
}
