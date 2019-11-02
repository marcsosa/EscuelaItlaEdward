package com.itla.testappdb.repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.itla.testappdb.entidades.Carrera;
import com.itla.testappdb.entidades.CarreraMateria;
import com.itla.testappdb.entidades.Materia;

import java.util.ArrayList;
import java.util.List;


public class CarreraRepositorioDblmpl implements CarreraRepositorio{

    private static final String TABLE ="carrera";
    private DbConexion dbConexion;

    public CarreraRepositorioDblmpl(Context context) {
        this.dbConexion = new DbConexion(context);
    }

    @Override
    public void crear(Carrera carreras) {

        ContentValues cv = new ContentValues();
        cv.put("nombre", carreras.getNombre());

        SQLiteDatabase db = dbConexion.getWritableDatabase();
       long id = db.insert(TABLE,null,cv );
       if (id <= 0) {
           Log.i("CarreraReposit","Ocurrio un error al crear la carrera");
       } else {
           Log.i("CarreraReposit", "La carrera se ha creado exitosa id=" + id);
       }
    }

    @Override
    public void actualizar(Carrera carreras) {

    }

    @Override
    public void borrar(Carrera carreras) {

    }

    @Override
    public void buscar(Carrera carreras) {

    }

    @Override
    public Carrera buscar(int id) {
        return null;
    }

    @Override
    public List<Carrera> buscar() {

        List<Carrera> carreras = new ArrayList<>();

        SQLiteDatabase db = dbConexion.getReadableDatabase();

        Cursor c = dbConexion.getReadableDatabase()
                .rawQuery("SELECT c.*, count(m.nombre) as materias, sum(m.creditos) as creditos FROM carrera c \n" +
                        "INNER JOIN carrera_materia cm ON c.id = cm.carrera_id\n" +
                        "INNER JOIN materia m ON cm.materia_id = m.id\n" +
                        "GROUP BY c.id",null);
        Carrera est;
        while (c.moveToNext()){
           int id =  c.getInt(c.getColumnIndex("id"));
            String nombre = c.getString(c.getColumnIndex("nombre"));
            int materias = (c.getInt(c.getColumnIndex("materias")));
            int creditos = (c.getInt(c.getColumnIndex("creditos")));

            est = new Carrera(id, nombre);
            est.setId(id);
            est.setNombre(nombre);
            est.setMateria(materias);
            est.setCreditos(creditos);
            carreras.add(est);

        }

        c.close();
        return carreras;
    }
}
