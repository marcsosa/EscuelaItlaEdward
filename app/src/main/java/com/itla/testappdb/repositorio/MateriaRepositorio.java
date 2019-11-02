package com.itla.testappdb.repositorio;

import com.itla.testappdb.entidades.Materia;

import java.util.List;

public interface MateriaRepositorio {
    void crear(Materia materias);

    void actualizar(Materia materias);

    void borrar(Materia materias);

    void buscar(Materia materias);

    Materia buscar(int id);

    List<Materia> buscar();
}
