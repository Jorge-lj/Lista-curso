package com.jorge.applistacurso.controller;

import java.util.ArrayList;
import java.util.List;

public class CursoController {

    private List<String> listaCursos;

    public List<String> getListaCursos() {
        listaCursos = new ArrayList<>();
        listaCursos.add("Técnico em Informática");
        listaCursos.add("Técnico em Desenvolvimento de Sistemas");
        listaCursos.add("Técnico em Programação de Jogos");
        return listaCursos;
    }

    public ArrayList<String> dadosSpinner() {
        return new ArrayList<>(getListaCursos());
    }
}
