
package com.itla.testappdb.repositorio;

import com.itla.testappdb.entidades.Estudiante;

import java.util.List;

public interface EstudianteRepositorio {

    void crear(Estudiante estudiante);
    void actualizar(Estudiante estudiante);
    void borrar(Estudiante estudiante);
    void buscar(Estudiante estudiante);

    Estudiante buscar(int id);
    List<Estudiante> buscar();
}

