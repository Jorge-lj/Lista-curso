package com.jorge.applistacurso.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import com.jorge.applistacurso.model.Pessoa;
import com.jorge.applistacurso.view.MainActivity;

public class PessoaController {

    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;
    public static final String NOME_PREFERENCES = "pref_listaVip";

    public PessoaController(MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }

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
        Log.d("MVC_controller", "Controller iniciado");
        return super.toString();
    }

    public void limpar(Pessoa pessoa) {
        listaVip.clear();
        listaVip.apply();
        Log.d("MVC_controller", "Dados limpos!");
    }

    public void salvar(Pessoa pessoa) {
        listaVip.putString("primeiro_nome", pessoa.getPrimeiro_nome());
        listaVip.putString("sobrenome", pessoa.getSobrenome());
        listaVip.putString("telefone_contato", pessoa.getTelefone_de_contato());
        listaVip.putString("curso_desejado", pessoa.getCurso_desejado());
        listaVip.apply();

        Log.d("MVC_controller", "Dados salvos!" + pessoa.toString());
    }

    public Pessoa buscar(Pessoa pessoa) {
        pessoa.setPrimeiro_nome(preferences.getString("primeiro_nome", ""));
        pessoa.setSobrenome(preferences.getString("sobrenome", ""));
        pessoa.setCurso_desejado(preferences.getString("curso_desejado", ""));
        pessoa.setTelefone_de_contato(preferences.getString("telefone_contato", ""));

        Log.d ("MVC_controller", "Dados limpos!");
    }

        return pessoa;
    }

    public void finalizar() {
        Log.d("MVC_controller", "App finalizado!");
    }
}