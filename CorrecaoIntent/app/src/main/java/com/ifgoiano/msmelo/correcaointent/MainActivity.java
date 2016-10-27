package com.ifgoiano.msmelo.correcaointent;

import android.Manifest;
import android.app.SearchManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import static android.provider.MediaStore.ACTION_IMAGE_CAPTURE;

public class MainActivity extends AppCompatActivity {

    public final static int CHAMAR_CONTATOS = 1;
    public final static int CHAMAR_OUTRA = 2;
    public final static int RESULT_OK = 1;
    public final static int RESULT_NOK= 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void callPhone(View v) {
        Uri telefone = Uri.parse("tel:96368898");
        Intent it = new Intent(Intent.ACTION_CALL, telefone);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(it);
    }

    public void openBrowser(View v){
        Uri url = Uri.parse("http://www.google.com/");
        Intent it = new Intent(Intent.ACTION_VIEW, url);
        startActivity(it);
    }

    public void openContacts(View v){
        Uri contacts = Uri.parse("content://com.android.contacts/contacts/");
        Intent it = new Intent(Intent.ACTION_PICK, contacts);
        startActivityForResult(it, MainActivity.CHAMAR_CONTATOS);
    }

    public void openMaps(View v){
        Uri endereco = Uri.parse("geo://0,0?q=Rondon+Pacheco,Uberlândia");
        Intent it = new Intent(Intent.ACTION_VIEW, endereco);
        startActivity(it);
    }

    public void openCamera(View v){
        Intent it = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(it);
    }

    public void doSearch(View v){
        Intent it = new Intent(Intent.ACTION_WEB_SEARCH);
        it.putExtra(SearchManager.QUERY, "Documentação Android");
        startActivity(it);
    }

    public void forResult(View v){
        Intent it = new Intent(MainActivity.this, SegundaTela.class);
        startActivityForResult(it, MainActivity.CHAMAR_OUTRA);
    }

    public void onActivityResult(int cod, int result, Intent it){
        if(cod == MainActivity.CHAMAR_CONTATOS) {
            Uri contatoSelecionado = it.getData();
            Toast.makeText(MainActivity.this, "Contato Selecionado: " + contatoSelecionado, Toast.LENGTH_LONG).show();
            Intent it2 = new Intent(Intent.ACTION_VIEW, contatoSelecionado);
            startActivity(it2);
        }else if(cod == MainActivity.CHAMAR_OUTRA){
            if(result == MainActivity.RESULT_OK){
                String retorno = it.getStringExtra("retorno");
                Toast.makeText(MainActivity.this, retorno, Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(MainActivity.this, "Não clicou, deu ruim!", Toast.LENGTH_LONG).show();
            }
        }
    }

}
