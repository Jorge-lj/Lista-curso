package com.jorge.applistacurso.model;

public class Curso {

    private String curso_desejado;

    // CONSTRUTORES

    public Curso() {
    }

    public Curso(String curso_desejado) {
        this.curso_desejado = curso_desejado;
    }

    // GET

    public String getCurso_desejado() {
        return curso_desejado;
    }

    // TOSTRING

    @Override
    public String toString() {
        return "Curso{" +
                "curso_desejado='" + curso_desejado + '\'' +
                '}';
    }

}
