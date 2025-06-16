package com.jorge.applistacurso.view;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jorge.applistacurso.R;
import com.jorge.applistacurso.controller.CursoController;
import com.jorge.applistacurso.controller.PessoaController;
import com.jorge.applistacurso.model.Pessoa;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;
    PessoaController controller;
    CursoController controllerCurso;

    EditText primeiroNome;
    EditText segundoNome;
    EditText telefone_contato;

    Spinner spinner;

    Button limpar;
    Button salvar;
    Button finalizar;

    List<String> nomeCurso;

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

        pessoa = new Pessoa();
        controller = new PessoaController(this);
        controllerCurso = new CursoController();

        controller.buscar(pessoa);

        nomeCurso = controllerCurso.dadosSpinner();

        primeiroNome = findViewById(R.id.editTextText_primeiroNome);
        segundoNome = findViewById(R.id.editTextText_SegundoNome);
        telefone_contato = findViewById(R.id.editTextText_Telefone);

        spinner = findViewById(R.id.spinner);

        limpar = findViewById(R.id.button_Limpar);
        salvar = findViewById(R.id.button_Salvar);
        finalizar = findViewById(R.id.button_Finalizar);

        primeiroNome.setText(pessoa.getPrimeiro_nome());
        segundoNome.setText(pessoa.getSobrenome());
        telefone_contato.setText(pessoa.getTelefone_de_contato());

    //SPNER
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,
                nomeCurso);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        if (pessoa.getCurso_desejado() != null && !pessoa.getCurso_desejado().isEmpty()) {
            int posicao = adapter.getPosition(pessoa.getCurso_desejado());
            if (posicao >= 0) {
                spinner.setSelection(posicao);
            }
        }

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // Lógica ao selecionar item
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) 

            }
        });

        limpar.setOnClickListener(view -> {
            primeiroNome.setText("");
            segundoNome.setText("");
            telefone_contato.setText("");
            spinner.setSelection(0);
            controller.limpar(pessoa);
            Toast.makeText(MainActivity.this, "Dados limpos!", Toast.LENGTH_SHORT).show();
        });

        salvar.setOnClickListener(view -> {
            pessoa.setPrimeiro_nome(primeiroNome.getText().toString());
            pessoa.setSobrenome(segundoNome.getText().toString());
            pessoa.setCurso_desejado(spinner.getSelectedItem().toString());
            pessoa.setTelefone_de_contato(telefone_contato.getText().toString());

            controller.salvar(pessoa);
            Toast.makeText(MainActivity.this, "Dados salvos!" + pessoa.toString(), Toast.LENGTH_SHORT).show();
        }

        });

        finalizar.setOnClickListener(view -> {
            controller.finalizar();
            Toast.makeText(MainActivity.this, "Volte sempre!", Toast.LENGTH_SHORT).show();
            finish();
        });

        controller.toString();
    }
}