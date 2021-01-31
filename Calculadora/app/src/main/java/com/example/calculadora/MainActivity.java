package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.calculadora.R.id.numero1;

public class MainActivity extends AppCompatActivity {

    private Button btn_suma;
    private Button btn_resta;
    private Button btn_division;
    private Button btn_multiplicacion;
    private Button btn_factorial;
    private Button btn_porcentaje;
    private Button btn_exponeracion;
    private Button btn_raiz;
    private Button btn_modulo;
    private Button btn_mayor;

    private TextView text_respuesta;

    private int edit_numero1;
    private EditText edit_numero2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_respuesta = findViewById(R.id.respuesta);

        edit_numero1 = findViewById(R.id.numero1);
        edit_numero2 = findViewById(R.id.numero2);


        btn_suma = findViewById(R.id.button_suma);
        btn_suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_respuesta.setText(suma(Integer.parseInt(edit_numero1.getText().toString()), Integer.parseInt(edit_numero2.getText().toString())) + "");
            }
        });
        btn_resta = findViewById(R.id.button_resta);
        btn_resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_respuesta.setText(resta(Integer.parseInt(edit_numero1.getText().toString()), Integer.parseInt(edit_numero2.getText().toString())) + "");
            }
        });

        btn_division = findViewById(R.id.button_division);
        btn_division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_respuesta.setText(division(Integer.parseInt(edit_numero1.getText().toString()), Integer.parseInt(edit_numero2.getText().toString())) + "");
            }
        });

        btn_multiplicacion = findViewById(R.id.button_multiplicacion);
        btn_multiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_respuesta.setText(multiplicacion(Integer.parseInt(edit_numero1.getText().toString()), Integer.parseInt(edit_numero2.getText().toString())) + "");
            }
        });

        btn_porcentaje = findViewById(R.id.button_porcentaje);
        btn_porcentaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_respuesta.setText(porcentaje(Integer.parseInt(edit_numero1.getText().toString()), Integer.parseInt(edit_numero2.getText().toString())) + "");
            }
        });
    }

    public double suma(int a, int b) {
        return a + b;
    }

    public double resta(int a, int b) {
        return a - b;
    }

    public double division(int a, int b) {
        int respuesta = 0;
        if (b != 0) {
            respuesta = a / b;
        }
        return respuesta;
    }

    public double multiplicacion(int a, int b) {
        return a * b;
    }

    public double porcentaje(int a, int b) {
        int respuesta = 0;
        if (b != 0) {
            respuesta = a / b * 100;
        }
        return respuesta;
    }

}