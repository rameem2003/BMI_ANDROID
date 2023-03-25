package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class home extends AppCompatActivity {
    private TextView about;
    private CardView btn, reset;
    private EditText age, weight, ft, in;
    private TextView result, des;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        about = findViewById(R.id.about);

        btn = findViewById(R.id.btn);
        reset = findViewById(R.id.reset);


        age = findViewById(R.id.age);
        weight = findViewById(R.id.weight);
        ft = findViewById(R.id.ft);
        in = findViewById(R.id.in);

        result = findViewById(R.id.result);
        des = findViewById(R.id.des);

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home.this, about.class);
                startActivity(intent);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getKg = weight.getText().toString();
                String getFt = ft.getText().toString();
                String getIn = in.getText().toString();

                if(getKg.isEmpty() == false && getFt.isEmpty() == false && getIn.isEmpty() == false){
                    float weightValue = Float.parseFloat(getKg);
                    float fitValue = Float.parseFloat(getFt);
                    float inchValue = Float.parseFloat(getIn);

                    float height = (float) (fitValue * 0.3048 + inchValue * 0.0254);

                    float bmi = weightValue / (height * height);

                    result.setText("BMI : " + String.format("%.2f", bmi) + " Kg/Sqr M");

                    if(bmi < 16){
                        des.setText("Severe Thinness");
                    } else if (bmi >= 16 && bmi <= 17) {
                        des.setText("Moderate Thinness");
                    } else if (bmi >= 17 && bmi <= 18.5) {
                        des.setText("Mild Thinness");
                    } else if (bmi >= 18.5 && bmi <= 25) {
                        des.setText("Normal");
                    } else if (bmi >= 25 && bmi <= 30) {
                        des.setText("Overweight");
                    } else if (bmi >= 30 && bmi <= 35) {
                        des.setText("Obese Class 1");
                    } else if (bmi >= 35 && bmi <= 40) {
                        des.setText("Obese Class 2");
                    } else if (bmi > 40) {
                        des.setText("Obese Class 3");
                    }
                }else {
                    Toast.makeText(home.this, "Please enter a value", Toast.LENGTH_LONG).show();
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                age.setText("");
                weight.setText("");
                ft.setText("");
                in.setText("");
                result.setText("BMI Result");
                des.setText("Comment");

                Toast.makeText(home.this, "All fields are cleared", Toast.LENGTH_LONG).show();
            }
        });
    }
}