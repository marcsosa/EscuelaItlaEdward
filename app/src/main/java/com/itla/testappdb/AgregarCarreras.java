package com.itla.testappdb;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.itla.testappdb.entidades.Carrera;
import com.itla.testappdb.entidades.Estudiante;
import com.itla.testappdb.repositorio.CarreraRepositorio;
import com.itla.testappdb.repositorio.CarreraRepositorioDblmpl;
import com.itla.testappdb.repositorio.EstudianteRepositorio;
import com.itla.testappdb.repositorio.EstudianteRepositorioDblmpl;

import java.util.List;


public class AgregarCarreras extends AppCompatActivity {

    Button guardarcarreras;
    Button cancelar;
    EditText nombre;
    Button Mostrarlista;
    Button Agregarcarreras;
    EstudianteRepositorio estudianteRepositorio;
    CarreraRepositorio carreraRepositorio;
    Carrera carrera;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregarcarrera);
        guardarcarreras = (Button) findViewById(R.id.btnguardar2);
        cancelar = (Button) findViewById(R.id.btcancelar);
        nombre = (EditText) findViewById(R.id.etnombre);
        estudianteRepositorio = new EstudianteRepositorioDblmpl(this.getBaseContext());
        carreraRepositorio = new CarreraRepositorioDblmpl(this.getBaseContext());
        Mostrarlista = (Button) findViewById(R.id.btnshow);
        Agregarcarreras = (Button) findViewById(R.id.Btnagregarcarrera);


        guardarcarreras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Carrera ca2 = new Carrera();
                ca2.setNombre(nombre.getText().toString());
                 carreraRepositorio.crear(ca2);
                Toast.makeText(AgregarCarreras.this, "Creado con Exito", Toast.LENGTH_SHORT).show();

                List<Carrera> carreralist = carreraRepositorio.buscar();

                for (Carrera e : carreralist) {
                    Log.i("CARRERA", e.getNombre() + e.getId());
                }
            }
        });


        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre.setText("");
            }
        });

        Mostrarlista.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ListaCarrera.class);
                startActivityForResult(intent, 0);
            }
        });

    }


    }

