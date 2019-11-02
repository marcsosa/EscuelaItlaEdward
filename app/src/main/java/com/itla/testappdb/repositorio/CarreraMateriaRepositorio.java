package com.itla.testappdb.repositorio;

import com.itla.testappdb.entidades.CarreraMateria;

import java.util.List;

public interface CarreraMateriaRepositorio {

    void crear(CarreraMateria carreraMateria);
    void actualizar(CarreraMateria carreraMateria);
    void borrar(CarreraMateria carreraMateria);
    void buscar(CarreraMateria carreraMateria);

    CarreraMateria buscar(int id);
    List<CarreraMateria> buscar();
}
