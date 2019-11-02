package com.itla.testappdb.repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.itla.testappdb.entidades.Materia;

import java.util.ArrayList;
import java.util.List;

    public class MateriaRepositorioDblmpl implements MateriaRepositorio{

        private static final String TABLE ="materia";
        private DbConexion dbConexion;

        public MateriaRepositorioDblmpl(Context context) {
            this.dbConexion = new DbConexion(context);
        }

        @Override
        public void crear(Materia materias) {

            ContentValues cv = new ContentValues();
            cv.put("nombre", materias.getNombre());
            cv.put("creditos", materias.getCreditos());


            SQLiteDatabase db = dbConexion.getWritableDatabase();
            long id = db.insert(TABLE,null,cv );
            if (id <= 0) {
                Log.i("MateriaRepositorio","Ocurrio un error al crear la materia");
            } else {
                Log.i("MateriaRepositorio", "La materia se ha creado exitosa id=" + id);
            }
        }

        @Override
        public void actualizar(Materia materias) {

        }

        @Override
        public void borrar(Materia materias) {

        }

        @Override
        public void buscar(Materia materias) {

        }

        @Override
        public Materia buscar(int id) {
            return null;
        }

        @Override
        public List<Materia> buscar() {

            List<Materia> materias = new ArrayList();

            SQLiteDatabase db = dbConexion.getReadableDatabase();

            Cursor c = db.query(TABLE, new String[]{"id","nombre"}, null,null,null,null,null);

            Materia est;
            while (c.moveToNext()){
                int id =  c.getInt(c.getColumnIndex("id"));
                String nombre = c.getString(c.getColumnIndex("nombre"));
            String matricula = c.getString(c.getColumnIndex("matricula"));

                est = new Materia();
                materias.add(est);
            }

            c.close();
            return materias;
        }
    }
