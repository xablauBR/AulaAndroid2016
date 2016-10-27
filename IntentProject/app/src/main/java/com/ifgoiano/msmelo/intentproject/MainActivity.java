package com.ifgoiano.msmelo.intentproject;

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

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    private final static int COD_CONTACTS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void callPhone(View v) {
        Uri phone = Uri.parse("tel:96368898");
        Intent it = new Intent(Intent.ACTION_CALL, phone);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(it);
    }

    public void openBrowser(View v) {
        Uri url = Uri.parse("http://www.google.com");
        Intent it = new Intent(Intent.ACTION_VIEW, url);
        startActivity(it);
    }

    public void openContacts(View v) {
        Uri contacts = Uri.parse("content://com.android.contacts/contacts/");
        Intent it = new Intent(Intent.ACTION_PICK, contacts);
        startActivityForResult(it, MainActivity.COD_CONTACTS);
    }

    public void onActivityResult(int cod, int result, Intent it){
        if(it == null){
            Toast.makeText(MainActivity.this, "Nenhum Retorno", Toast.LENGTH_LONG).show();
        }
        if(cod == MainActivity.COD_CONTACTS){
            Uri contatoSelecionado = it.getData();
            Toast.makeText(MainActivity.this, "Contato Selecionado:"+contatoSelecionado, Toast.LENGTH_LONG).show();
            Intent it2 = new Intent(Intent.ACTION_VIEW, contatoSelecionado);
            startActivity(it2);
        }
    }

    public void openMaps(View v) {
        Uri localizacao = Uri.parse("geo:-25.443195, -49,280977");
        Intent it = new Intent(Intent.ACTION_VIEW, localizacao);
        startActivity(it);
    }

    public void openCamera(View v) {
        Intent it = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(it);
    }

    public void doSearch(View v){
        Intent it = new Intent(Intent.ACTION_WEB_SEARCH);
        it.putExtra(SearchManager.QUERY, "Documentação Android");
        startActivity(it);
    }

}
