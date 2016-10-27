package com.ifgoiano.msmelo.imc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final int codSegundaTela = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mandarDadosPraFrente(View v){
        EditText etNome, etPeso, etAltura;
        String nome, peso, altura;

        etNome = (EditText) findViewById(R.id.editText);
        etPeso = (EditText) findViewById(R.id.editText2);
        etAltura = (EditText) findViewById(R.id.editText3);

        nome = etNome.getText().toString();
        peso = etPeso.getText().toString();
        altura = etAltura.getText().toString();

        Intent it = new Intent(MainActivity.this, SegundaTela.class);
        Bundle param = new Bundle();
        param.putString("nome", nome);
        param.putString("peso", peso);
        param.putString("altura", altura);
        it.putExtras(param);
        startActivityForResult(it, this.codSegundaTela);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == this.codSegundaTela){
            if(resultCode == 200){
                Bundle param = data.getExtras();
                Double imc = param.getDouble("imc");
                Intent it = new Intent(MainActivity.this, TerceiraTela.class);
                it.putExtra("imc", imc);
                startActivity(it);
            }
        }
    }
}
