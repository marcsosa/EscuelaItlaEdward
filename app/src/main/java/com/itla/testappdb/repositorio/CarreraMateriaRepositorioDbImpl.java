package com.itla.testappdb.repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.itla.testappdb.entidades.CarreraMateria;

import java.util.List;

public class CarreraMateriaRepositorioDbImpl implements CarreraMateriaRepositorio {

    private static final String TABLE ="carrera_materia";
    private DbConexion dbConexion;

    public CarreraMateriaRepositorioDbImpl(Context context) {
        this.dbConexion = new DbConexion(context);
    }

    @Override
    public void crear(CarreraMateria CarreraMateria) {

        ContentValues cv = new ContentValues();
        cv.put("carrera_id", CarreraMateria.getCarrera_id());
        cv.put("materia_id", CarreraMateria.getMateria_id());
        SQLiteDatabase db = dbConexion.getWritableDatabase();
        long id = db.insert(TABLE,null,cv );
        if (id <= 0) {
            Log.i("CMR","Ocurrio un error al crear la CMR");
        } else {
            Log.i("CMR", "La carrera se ha creado exitosa id=" + id);
        }
    }

    @Override
    public void actualizar(CarreraMateria carreraMateria) {

    }

    @Override
    public void borrar(CarreraMateria carreraMateria) {

    }

    @Override
    public void buscar(CarreraMateria carreraMateria) {

    }

    @Override
    public CarreraMateria buscar(int id) {
        return null;
    }

    @Override
    public List<CarreraMateria> buscar() {
        return null;
    }
}
