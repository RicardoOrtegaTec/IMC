package com.ricardortega.android.imc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Declarando variables y para ser usadas más adelante en el programa.
    private EditText campo_peso;
    private EditText campo_estatura;
    private Button boton_calcular;
    private Button  boton_limpiar;
    private TextView imc_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        campo_peso = (EditText) findViewById(R.id.campo_peso);
        campo_estatura = (EditText) findViewById(R.id.campo_estatura);
        boton_calcular = (Button) findViewById(R.id.boton_calcular);
        boton_limpiar = (Button) findViewById(R.id.boton_limpiar);
        imc_resultado = (TextView) findViewById(R.id.imc_resultado);

        boton_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void  onClick(View v) {
                String peso = campo_peso.getText().toString();
                double peso_persona = Double.parseDouble(peso);
                String estatura = campo_estatura.getText().toString();
                double estatura_persona = Double.parseDouble(estatura);
                double imc = peso_persona / (estatura_persona * estatura_persona);
                String imc_persona = String.format("%2.2f", imc);
                imc_resultado.setText(imc_persona);
            }
        });
        boton_limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                campo_peso.setText("");
                campo_estatura.setText("");
                imc_resultado.setText("0.0");
            }
        });
    }
}
