package com.itla.testappdb.repositorio;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;


// DAO (Database Access Object)
public class DbConexion extends SQLiteOpenHelper {


    private final static int VERSION = 1;
    private final static String NAME_DB = "Escuelaitla.db";


    public DbConexion(@Nullable Context context) {
        super(context, NAME_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("CREATE TABLE \"estudiante\"(\"id\"\tINTEGER PRIMARY KEY AUTOINCREMENT,\"nombre\" TEXT NOT NULL,\"matricula\" TEXT NOT NULL,\"carrera_id\" INTEGER NOT NULL)");
    db.execSQL("CREATE TABLE \"carrera\"(\"id\" INTEGER PRIMARY KEY AUTOINCREMENT,\"nombre\" TEXT NOT NULL)");
    db.execSQL("CREATE TABLE \"materia\"(\"id\" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\"nombre\" TEXT NOT NULL,\"creditos\" INTEGER NOT NULL)");
    db.execSQL("CREATE TABLE \"carrera_materia\"(\"carrera_id\"\tINTEGER NOT NULL,\"materia_id\" INTEGER NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}