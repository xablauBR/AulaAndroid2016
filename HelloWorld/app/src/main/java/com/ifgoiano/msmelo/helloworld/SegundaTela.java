package com.ifgoiano.msmelo.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SegundaTela extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);
        Log.d("SegundoTela", "Aplicação no onCreate!");
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("SegundoTela", "Aplicação no onStart!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("SegundoTela", "Aplicação no onResume!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("SegundoTela", "Aplicação no onPause!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("SegundoTela", "Aplicação no onStop!");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("SegundoTela", "Aplicação no onRestart!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("SegundoTela", "Aplicação no onDestroy!");
    }
}
