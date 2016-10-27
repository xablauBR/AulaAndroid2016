package com.ifgoiano.msmelo.dbsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class UserDAO {
    private OpenDB conexao;

    public UserDAO(Context ctx) {

        this.conexao = new OpenDB(ctx);
    }

    public void insertUser(String name, String cpf){

        SQLiteDatabase db = conexao.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("name", name);
        valores.put("cpf", cpf);

        db.insert("users", null, valores);
        db.close();
    }

    public void updateUser(int idUser, String newName, String newCpf){
        SQLiteDatabase db = conexao.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("name", newName);
        valores.put("cpf", newCpf);

        db.update("users", valores, "_id=?", new String[]{String.valueOf(idUser)});
        db.close();
    }

    public void deleteUser(int idUser){
        SQLiteDatabase db = conexao.getWritableDatabase();

        db.delete("users", "_id=?", new String[]{String.valueOf(idUser)});
        db.close();
    }

    public void getAllUsers(){
        SQLiteDatabase db = conexao.getReadableDatabase();
        Cursor cursor = db.query("users", new String[]{}, null, null, null, null,null);

        while(cursor.moveToNext()){
            Log.d("USER", String.valueOf(cursor.getInt(cursor.getColumnIndex("_id"))));
            Log.d("USER", cursor.getString(cursor.getColumnIndex("name")));
            Log.d("USER", cursor.getString(cursor.getColumnIndex("cpf")));
        }

        db.close();

    }
}
