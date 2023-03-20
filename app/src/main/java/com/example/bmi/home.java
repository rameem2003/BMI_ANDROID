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
    private CardView btn;
    private EditText age, weight, ft, in;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        about = findViewById(R.id.about);

        btn = findViewById(R.id.btn);
        age = findViewById(R.id.age);
        weight = findViewById(R.id.weight);
        ft = findViewById(R.id.ft);
        in = findViewById(R.id.in);

        result = findViewById(R.id.result);

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
//                Toast.makeText(home.this, "Button Is working", Toast.LENGTH_LONG).show();

                String getKg = weight.getText().toString();
                String getFt = ft.getText().toString();
                String getIn = in.getText().toString();


                float weightValue = Float.parseFloat(getKg);
                float fitValue = Float.parseFloat(getFt);
                float inchValue = Float.parseFloat(getIn);

                float height = (float) (fitValue * 0.3048 + inchValue * 0.0254);

                float bmi = weightValue / (height * height);

                result.setText("BMI : " + bmi);


            }
        });
    }
}