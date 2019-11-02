package com.itla.testappdb.repositorio;

import com.itla.testappdb.entidades.Carrera;
import com.itla.testappdb.entidades.Estudiante;

import java.util.List;

public interface CarreraRepositorio {

    void crear(Carrera carrera);
    void actualizar(Carrera carrera);
    void borrar(Carrera carrera);
    void buscar(Carrera carrera);

    Carrera buscar(int id);
    List<Carrera> buscar();
}
