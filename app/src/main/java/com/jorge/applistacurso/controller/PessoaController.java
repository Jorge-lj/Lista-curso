package com.jorge.applistacurso.controller;

import android.content.SharedPreferences;
import android.util.Log;
import androidx.annotation.NonNull;
import com.jorge.applistacurso.model.Pessoa;
import com.jorge.applistacurso.view.MainActivity;

public class PessoaController {

    Pessoa pessoa;

    SharedPreferences.Editor listaVip;
    public static final String NOME_PREFERENCES ="pref_listaVip";
    SharedPreferences preferences;

    public PessoaController (MainActivity mainActivity){
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES,0);
        listaVip = preferences.edit();
    }

    @NonNull
    @Override
    public String toString() {
        Log.d ("MVC_controller", "Controller iniciado");
        return super.toString();
    }

    public void limpar(Pessoa pessoa) {
        listaVip.clear();
        listaVip.apply();

        Log.d ("MVC_controller", "Dados limpos!");
    }

    public void salvar(Pessoa pessoa) {
        listaVip.putString("Primeiro Nome: ", pessoa.getPrimeiro_nome());
        listaVip.putString("Sobrenome: ", pessoa.getSobrenome());
        listaVip.putString("Curso desejado: ", pessoa.getCurso_desejado());
        listaVip.putString("Telefone de contato: ", pessoa.getTelefone_de_contato());
        listaVip.apply();

        Log.d ("MVC_controller", "Dados salvos!" + pessoa.toString());
    }

    public Pessoa buscar (Pessoa pessoa){
        pessoa.setPrimeiro_nome(preferences.getString("Primeiro Nome: ", ""));
        pessoa.setSobrenome(preferences.getString("Sobrenome: ", ""));
        pessoa.setCurso_desejado(preferences.getString("Curso desejado: ", ""));
        pessoa.setTelefone_de_contato(preferences.getString("Telefone de contato: ", ""));

        return pessoa;
    }

    public void finalizar(Pessoa pessoa) {
        Log.d ("MVC_controller", "App finalizado!");
    }
}