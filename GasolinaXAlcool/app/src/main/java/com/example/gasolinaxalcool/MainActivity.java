package com.example.gasolinaxalcool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtGasolina;
    EditText edtAlcool;
    Button btnCalcular;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        carregaComponentes();
        configurarBotaoCalcular();
    }

    protected void carregaComponentes() {
        edtGasolina = findViewById(R.id.edtGasolina);
        edtAlcool = findViewById(R.id.edtAlcool);
        btnCalcular = findViewById(R.id.btnCalcularPreco);
        txtResultado = findViewById(R.id.txtResultado);
    }

    protected void configurarBotaoCalcular() {
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String resultado = realizaCalculo();
                exibiResultado(resultado);
                limpaCampos();
            }
        });
    }

    protected String realizaCalculo() {
        float Gasolina = Float.parseFloat(edtGasolina.getText().toString());
        float Alcool = Float.parseFloat(edtAlcool.getText().toString());

        String resultado;

        double Regra;

        Regra = Gasolina * 0.7;

        if(Regra > Alcool) {
            resultado = "O Álcool é a melhor opção";

        }else {
            resultado = "A Gasolina é a melhor opção";

        }
        return resultado;
    }

    protected void exibiResultado(String resultado) {
        txtResultado.setText(resultado);
    }

    protected void limpaCampos() {
        edtGasolina.setText("");
        edtAlcool.setText("");
        edtAlcool.requestFocus();
    }
}