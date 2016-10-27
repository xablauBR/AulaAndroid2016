package com.ifgoiano.msmelo.imc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SegundaTela extends AppCompatActivity {

    private TextView tvNome, tvPeso, tvAltura;
    private String nome, peso, altura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);

        Intent it = getIntent();
        if(it != null){
            Bundle params = it.getExtras();
            if(params != null){

                this.nome = params.getString("nome");
                this.peso = params.getString("peso");
                this.altura = params.getString("altura");

                tvNome = (TextView) findViewById(R.id.viewNome);
                tvPeso = (TextView) findViewById(R.id.viewPeso);
                tvAltura = (TextView) findViewById(R.id.viewAltura);

                tvNome.setText(nome);
                tvPeso.setText(peso);
                tvAltura.setText(altura);
            }
        }
    }

    public void calculaIMC(View v){
        Double pesoDouble = Double.parseDouble(this.peso);
        Double alturaDouble = Double.parseDouble(this.altura);
        Double imc = pesoDouble / (alturaDouble*alturaDouble);

        Intent resultado = new Intent();
        resultado.putExtra("imc", imc);
        setResult(200, resultado);
        finish();
    }
}
