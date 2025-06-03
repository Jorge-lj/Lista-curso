package com.jorge.applistacurso.model;

import com.jorge.applistacurso.controller.PessoaController;

public class Pessoa {

    private PessoaController pessoaController;
    private String primeiro_nome;
    private String sobrenome;
    private String curso_desejado;
    private String telefone_de_contato;

    //CONSTRUTORES

    public Pessoa() {
    }

//    public Pessoa(String primeiro_nome, String sobrenome, String curso_desejado, String telefone_de_contato) {
//        this.primeiro_nome = primeiro_nome;
//        this.sobrenome = sobrenome;
//        this.curso_desejado = curso_desejado;
//        this.telefone_de_contato = telefone_de_contato;
//    }

    //GET AND SETTERS

    public String getCurso_desejado() {
        return curso_desejado;
    }

    public void setCurso_desejado(String curso_desejado) {
        this.curso_desejado = curso_desejado;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getPrimeiro_nome() {
        return primeiro_nome;
    }

    public void setPrimeiro_nome(String primeiro_nome) {
        this.primeiro_nome = primeiro_nome;
    }

    public String getTelefone_de_contato() {
        return telefone_de_contato;
    }
    public void setTelefone_de_contato(String telefone_de_contato) {
        this.telefone_de_contato = telefone_de_contato;
    }

    // TOSTRING

    @Override
    public String toString() {
        return "Pessoa{" +
                "curo_desejado='" + curso_desejado + '\'' +
                ", pessoaController=" + pessoaController +
                ", primeiro_nome='" + primeiro_nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", telefone_de_contato='" + telefone_de_contato + '\'' +
                '}';
    }

}
