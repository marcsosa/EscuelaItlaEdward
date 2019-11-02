package com.itla.testappdb.entidades;

public class CarreraMateria {

    private Integer carrera_id;
    private Integer materia_id;

    public CarreraMateria(Integer carrera_id, Integer materia_id) {
        this.carrera_id = carrera_id;
        this.materia_id = materia_id;
    }
    public Integer getCarrera_id() {
        return carrera_id;
    }

    public void setCarrera_id(Integer carrera_id) {
        this.carrera_id = carrera_id;
    }

    public Integer getMateria_id() {
        return materia_id;
    }

    public void setMateria_id(Integer materia_id) {
        this.materia_id = materia_id;
    }
}
