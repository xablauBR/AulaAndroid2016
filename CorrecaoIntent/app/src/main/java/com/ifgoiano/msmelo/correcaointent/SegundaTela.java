package com.ifgoiano.msmelo.correcaointent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SegundaTela extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);
    }

    public void clicou(View v){
        Intent it = new Intent();
        it.putExtra("retorno", "O cara clicou no botao");
        setResult(MainActivity.RESULT_OK, it);
        finish();
    }
}
