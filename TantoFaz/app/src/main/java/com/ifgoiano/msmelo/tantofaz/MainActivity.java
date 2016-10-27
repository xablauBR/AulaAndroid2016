package com.ifgoiano.msmelo.tantofaz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt = (Button) findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nome = (EditText) findViewById(R.id.nome_usuario);
                String nomeUsuario = nome.getText().toString();

                TextView exibir = (TextView) findViewById(R.id.result);
                exibir.setText("Bem vindo, "+nomeUsuario+"!");
                Toast.makeText(MainActivity.this, "Bem vindo, "+nomeUsuario+"!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
