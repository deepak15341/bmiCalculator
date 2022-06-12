package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtwt,edthtft,edthtin;
        Button btn;
        TextView txt,txt2;
        LinearLayout llmain;

        edtwt=findViewById(R.id.edtwt);
        edthtft=findViewById(R.id.edthtft);
        edthtin=findViewById(R.id.edthtin);
        btn=findViewById(R.id.btn);
        txt=findViewById(R.id.txt);
        llmain=findViewById(R.id.llMain);
        txt2=findViewById(R.id.txt2);

        btn.setOnClickListener(view -> {
            int wt=Integer.parseInt(edtwt.getText().toString());
            int ft=Integer.parseInt(edthtft.getText().toString());
            int in=Integer.parseInt(edthtin.getText().toString());
            double ht=(ft*12)+in;
            double htc=ht*2.54;
            double htm=htc/100;
            float bmi= (float) (wt/(htm*htm));
            if (bmi<18){
                txt.setText("Your Bmi is : "+bmi );
                txt2.setText(R.string.owt);
                llmain.setBackgroundColor(getResources().getColor(R.color.yellow));
            }
            else if (bmi>25){
                txt.setText("Your Bmi is : "+bmi );
                txt2.setText(R.string.unw);
                llmain.setBackgroundColor(getResources().getColor(R.color.red));
            }

            else {
                txt.setText("Your Bmi is : "+bmi);
                txt2.setText(R.string.ht);
                llmain.setBackgroundColor(getResources().getColor(R.color.green));
            }
        });
    }
}