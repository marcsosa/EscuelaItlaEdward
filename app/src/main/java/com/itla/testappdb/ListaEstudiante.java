package com.itla.testappdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.itla.testappdb.entidades.Estudiante;
import com.itla.testappdb.repositorio.AdaptadorEstudiante;
import com.itla.testappdb.repositorio.EstudianteRepositorio;
import com.itla.testappdb.repositorio.EstudianteRepositorioDblmpl;

import java.util.List;

public class ListaEstudiante extends AppCompatActivity {
    private RecyclerView.LayoutManager layoutManager;
Button Nuevo;
    EstudianteRepositorio estudianteRepositorio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_estudiante);
        Nuevo = (Button) findViewById(R.id.btnuevacarrera);

        estudianteRepositorio = new EstudianteRepositorioDblmpl(getBaseContext());

        List<Estudiante> estudiantes = estudianteRepositorio.buscar();

        RecyclerView recyclerViewEstudiantes = findViewById(R.id.recyclerViewCarrera);
        recyclerViewEstudiantes.setLayoutManager(new LinearLayoutManager(this));
        layoutManager = new LinearLayoutManager(this);
        AdaptadorEstudiante adapter = new AdaptadorEstudiante(estudiantes);
        recyclerViewEstudiantes.setAdapter(adapter);

        Nuevo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivityForResult(intent, 0);
            }
        });

    }
}
