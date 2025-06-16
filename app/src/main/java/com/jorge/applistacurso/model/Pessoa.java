package com.jorge.applistacurso.model;

public class Pessoa {

    private String primeiro_nome;
    private String sobrenome;
    private String curso_desejado;
    private String telefone_de_contato;

    public Pessoa() {
    }

    public Pessoa(String primeiro_nome, String sobrenome, String curso_desejado, String telefone_de_contato) {

        this.primeiro_nome = primeiro_nome;
        this.sobrenome = sobrenome;
        this.curso_desejado = curso_desejado;
        this.telefone_de_contato = telefone_de_contato;
    }

    public String getPrimeiro_nome() {
        return primeiro_nome;
    }

    public void setPrimeiro_nome(String primeiro_nome) {
        this.primeiro_nome = primeiro_nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCurso_desejado() {
        return curso_desejado;
    }

    public void setCurso_desejado(String curso_desejado) {
        this.curso_desejado = curso_desejado;
    }

    public String getTelefone_de_contato() {
        return telefone_de_contato;
    }

    public void setTelefone_de_contato(String telefone_de_contato) {
        this.telefone_de_contato = telefone_de_contato;
    }

    @Override
    public String toString() {
        return '\n' + "Pessoa" + '\n' +
                "Primeiro Nome: '" + primeiro_nome + '\'' + '\n' +
                "Sobrenome: '" + sobrenome + '\'' + '\n' +
                "Curso Desejado: '" + curso_desejado + '\'' + '\n' +
                "Telefone de contato: '" + telefone_de_contato + '\'';
    }
}