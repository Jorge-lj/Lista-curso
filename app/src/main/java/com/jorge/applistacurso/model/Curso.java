package com.jorge.applistacurso.model;

public class Curso {

    private String curso_desejado;

    public Curso() {
    }

    public Curso(String curso_desejado) {
        this.curso_desejado = curso_desejado;
    }

    public String getCurso_desejado() {
        return curso_desejado;
    }

    public void setCurso_desejado(String curso_desejado) {
        this.curso_desejado = curso_desejado;
    }
}
