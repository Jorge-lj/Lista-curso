package com.jorge.applistacurso.controller;

import android.util.Log;
import android.widget.EditText;
import androidx.annotation.NonNull;
import com.jorge.applistacurso.model.Pessoa;

public class PessoaController {

    @NonNull
    @Override
    public String toString() {
        Log.d ("MVC_controller", "Controller iniciado");
        return super.toString();
    }

    public void salvar(EditText primeiroNome, EditText segundoNome, EditText curso_desejado, EditText telefone_contato) {
        Pessoa pessoa = new Pessoa(primeiroNome.getText().toString(), segundoNome.getText().toString(), curso_desejado.getText().toString(), telefone_contato.getText().toString());
        Log.d ("MVC_controller", "Dados salvos!" + pessoa.toString());
    }

    public void limpar(EditText primeiroNome, EditText segundoNome, EditText curso_desejado, EditText telefone_contato) {
        primeiroNome.setText("");
        segundoNome.setText("");
        curso_desejado.setText("");
        telefone_contato.setText("");
        Log.d ("MVC_controller", "Dados limpos!");
    }

    public void finalizar(Pessoa pessoa) {
        Log.d ("MVC_controller", "App finalizado!");
    }
}
