package com.jorge.applistacurso.view;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jorge.applistacurso.R;
import com.jorge.applistacurso.controller.PessoaController;
import com.jorge.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;

    SharedPreferences.Editor listaVip;

    public static final String NOME_PREFERENCES ="pref_listaVip";
    SharedPreferences preferences;
    PessoaController controller;

    EditText primeiroNome;
    EditText segundoNome;
    EditText curso_desejado;
    EditText telefone_contato;

    Button limpar;
    Button salvar;
    Button finalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        preferences = getSharedPreferences(NOME_PREFERENCES,0);

        listaVip = preferences.edit();

        pessoa = new Pessoa();

        pessoa.setPrimeiro_nome(preferences.getString("Primeiro Nome: ", "NA"));
        pessoa.setSobrenome(preferences.getString("Sobrenome: ", "NA"));
        pessoa.setCurso_desejado(preferences.getString("Curso desejado: ", "NA"));
        pessoa.setTelefone_de_contato(preferences.getString("Telefone de contato: ", "NA"));

        controller = new PessoaController();

        controller.toString();

        primeiroNome = findViewById(R.id.editTextText_primeiroNome);
        segundoNome = findViewById(R.id.editTextText_SegundoNome);
        curso_desejado = findViewById(R.id.editTextText_Curso);
        telefone_contato = findViewById(R.id.editTextText_Telefone);

        limpar = findViewById(R.id.button_Limpar);
        salvar = findViewById(R.id.button_Salvar);
        finalizar = findViewById(R.id.button_Finalizar);

        primeiroNome.setText(pessoa.getPrimeiro_nome());
        segundoNome.setText(pessoa.getSobrenome());
        curso_desejado.setText(pessoa.getCurso_desejado());
        telefone_contato.setText(pessoa.getTelefone_de_contato());

        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.limpar(primeiroNome, segundoNome, curso_desejado, telefone_contato);
                Toast.makeText(MainActivity.this, "Dados limpos!", Toast.LENGTH_SHORT).show();

                listaVip.clear();
                listaVip.apply();
            }
        });

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pessoa pessoa = new Pessoa(primeiroNome.getText().toString(), segundoNome.getText().toString(), curso_desejado.getText().toString(), telefone_contato.getText().toString());

                listaVip.putString("Primeiro Nome: ", pessoa.getPrimeiro_nome());
                listaVip.putString("Sobrenome: ", pessoa.getSobrenome());
                listaVip.putString("Curso desejado: ", pessoa.getCurso_desejado());
                listaVip.putString("Telefone de contato: ", pessoa.getTelefone_de_contato());
                listaVip.apply();

                controller.salvar(pessoa, primeiroNome, segundoNome, curso_desejado, telefone_contato);
                Toast.makeText(MainActivity.this, "Dados salvos!" + pessoa.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.finalizar(pessoa);
                Toast.makeText(MainActivity.this, "Volte sempre!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

}
