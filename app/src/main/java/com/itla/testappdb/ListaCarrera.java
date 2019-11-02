package com.itla.testappdb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.itla.testappdb.entidades.Carrera;
import com.itla.testappdb.entidades.CarreraMateria;
import com.itla.testappdb.entidades.Materia;
import com.itla.testappdb.repositorio.AdaptadorCarrera;
import com.itla.testappdb.repositorio.CarreraMateriaRepositorio;
import com.itla.testappdb.repositorio.CarreraMateriaRepositorioDbImpl;
import com.itla.testappdb.repositorio.CarreraRepositorio;
import com.itla.testappdb.repositorio.CarreraRepositorioDblmpl;
import com.itla.testappdb.repositorio.MateriaRepositorio;
import com.itla.testappdb.repositorio.MateriaRepositorioDblmpl;

import java.util.List;

public class ListaCarrera extends AppCompatActivity {
    private RecyclerView.LayoutManager layoutManager;
    Button Nuevo;
    CarreraRepositorio CarreraRepositorio;
    MateriaRepositorio MateriaRepositorio;
    CarreraMateriaRepositorio CarreraMateriaRepositorio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_carrera);
        Nuevo = (Button) findViewById(R.id.btnuevacarrera);
        MateriaRepositorio = new MateriaRepositorioDblmpl(getBaseContext());
        CarreraRepositorio = new CarreraRepositorioDblmpl(getBaseContext());
        CarreraMateriaRepositorio  = new CarreraMateriaRepositorioDbImpl(getBaseContext());
        List<Carrera> Carreras = CarreraRepositorio.buscar();

        RecyclerView recyclerViewCarreras = findViewById(R.id.recyclerViewCarrera);
        recyclerViewCarreras.setLayoutManager(new LinearLayoutManager(this));
        layoutManager = new LinearLayoutManager(this);
        AdaptadorCarrera adapter = new AdaptadorCarrera(Carreras);
        recyclerViewCarreras.setAdapter(adapter);



            CarreraRepositorioDblmpl carreraRepositorioDblmpl = new CarreraRepositorioDblmpl(this);

            Materia mat1 = new Materia();
            mat1.setNombre("Informatica 1");
            mat1.setCreditos(3);
            MateriaRepositorio.crear(mat1);
            CarreraMateria cm = new CarreraMateria(1,1);
            CarreraMateriaRepositorio.crear(cm);

            Materia mat2 = new Materia();
            mat2.setNombre("Contabilidad 2");
            mat2.setCreditos(4);
            MateriaRepositorio.crear(mat2);
            CarreraMateria cm2 = new CarreraMateria(1,3);
            CarreraMateriaRepositorio.crear(cm2);


        Nuevo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivityForResult(intent, 0);
            }
        });

    }
}
