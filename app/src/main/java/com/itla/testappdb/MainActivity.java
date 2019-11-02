package com.itla.testappdb;

import androidx.appcompat.app.AppCompatActivity;

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

import com.itla.testappdb.entidades.Estudiante;
import com.itla.testappdb.repositorio.CarreraRepositorio;
import com.itla.testappdb.repositorio.EstudianteRepositorio;
import com.itla.testappdb.repositorio.EstudianteRepositorioDblmpl;
import com.itla.testappdb.repositorio.CarreraRepositorioDblmpl;
import com.itla.testappdb.entidades.Carrera;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    static int result;
    Button guardar;
    Button cancelar;
    EditText nombre;
    EditText matricula;
    TextView carreraid;
    Button Mostrarlista;
    Button Agregarcarreras;
    Spinner spinnercarreras;
    EstudianteRepositorio estudianteRepositorio;
    CarreraRepositorio carreraRepositorio;
    Carrera carrera;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        guardar = (Button) findViewById(R.id.btnguardar);
        cancelar = (Button) findViewById(R.id.btcancelar);
        nombre = (EditText) findViewById(R.id.etnombre);
        matricula = (EditText) findViewById(R.id.etmatricula);
        spinnercarreras = (Spinner) findViewById(R.id.spinnercarrera);
        estudianteRepositorio = new EstudianteRepositorioDblmpl(this.getBaseContext());
        carreraRepositorio = new CarreraRepositorioDblmpl(this.getBaseContext());
        Mostrarlista = (Button) findViewById(R.id.btnshow);
        Agregarcarreras = (Button) findViewById(R.id.Btnagregarcarrera);
        loadSpinnerData();

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (carrera==null){

                    return;
                }
                Estudiante est2 = new Estudiante();
                est2.setNombre(nombre.getText().toString());
                est2.setMatricula(matricula.getText().toString());
                est2.setCarrera(carrera);
                estudianteRepositorio.crear(est2);
                Toast.makeText(MainActivity.this, "Creado con Exito", Toast.LENGTH_SHORT).show();

                List<Estudiante> estudianteList = estudianteRepositorio.buscar();

                for (Estudiante e : estudianteList) {
                    Log.i("Estudiante", e.getNombre() + e.getMatricula());
                }
            }
        });

        Agregarcarreras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), AgregarCarreras.class);
                startActivityForResult(intent, 0);


            }
        });
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre.setText("");
                matricula.setText("");
            }
        });

        Mostrarlista.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ListaEstudiante.class);
                startActivityForResult(intent, 0);
            }
        });

    }

    private void loadSpinnerData() {
        List<Carrera> carreras = carreraRepositorio.buscar();

        // Creating adapter for spinner
        ArrayAdapter<Carrera> dataAdapter = new ArrayAdapter<Carrera>(this, android.R.layout.simple_spinner_item, carreras);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnercarreras.setAdapter(dataAdapter);

        spinnercarreras.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                result = position;
                Carrera c = (Carrera) adapterView.getItemAtPosition(position);
                if (c != null) {
                    Toast.makeText(MainActivity.this, c.toString(),
                            Toast.LENGTH_SHORT).show();

                    carrera = c;
                }
                Toast.makeText(MainActivity.this, "Selected",
                        Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // TODO Auto-generated method stub

            }
        });


    }
}
