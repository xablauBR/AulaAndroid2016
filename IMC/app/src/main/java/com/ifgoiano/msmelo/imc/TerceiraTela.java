package com.ifgoiano.msmelo.imc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TerceiraTela extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terceira_tela);

        Intent it = getIntent();
        if(it != null){
            Bundle param = it.getExtras();
            if(param != null){
                Double imc = param.getDouble("imc");
                TextView tvIMC = (TextView) findViewById(R.id.viewIMC);
                TextView tvFrase = (TextView) findViewById(R.id.viewFrase);

                tvIMC.setText(""+imc);
                tvFrase.setText("Seu gordo!!!");
            }
        }
    }
}
