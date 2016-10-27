package com.ifgoiano.msmelo.dbsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void inserirUser(View v){
        EditText etName = (EditText) findViewById(R.id.editTextName);
        EditText etCpf = (EditText) findViewById(R.id.editTextCPF);

        String name = etName.getText().toString();
        String cpf = etCpf.getText().toString();

        UserDAO dao = new UserDAO(MainActivity.this);
        dao.insertUser(name, cpf);

    }

    public void getAllUsers(View v){
        UserDAO dao = new UserDAO(MainActivity.this);
        dao.getAllUsers();
    }
}
