package com.example.calculadorafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TabHost tbhConversores;
    TextView tempVal;
    Button btnConvertir;
    Spinner spnOptionDe, spnOptionA;
    conversores miConversor = new conversores();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbhConversores = findViewById(R.id.tabConversores);
        tbhConversores.setup();

        tbhConversores.addTab(tbhConversores.newTabSpec("Monedas").setContent(R.id.tabMonedas).setIndicator("M"));
        tbhConversores.addTab(tbhConversores.newTabSpec("Longitud").setContent(R.id.tabLongitud).setIndicator("L"));
        tbhConversores.addTab(tbhConversores.newTabSpec("Masa").setContent(R.id.tabMasa).setIndicator("P"));

        btnConvertir = findViewById(R.id.btncalcular);
        btnConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    tempVal = (EditText) findViewById(R.id.txtcantidad);
                    Double cantidad = Double.parseDouble(tempVal.getText().toString());

                    spnOptionDe = findViewById(R.id.cboDe);
                    spnOptionA = findViewById(R.id.cboA);

                    tempVal = findViewById(R.id.IblRespuesta);
                    tempVal.setText("Respuesta: " + miConversor.covertir(0, spnOptionDe.getSelectedItemPosition(), spnOptionA.getSelectedItemPosition(), cantidad));
                }catch(Exception ex){
                    tempVal =findViewById(R.id.IblRespuesta);
                    tempVal.setText("Por favor ingrese la cantidad");
                    Toast.makeText(getApplicationContext(), "Por favor ingrese los valores indicados "+ ex.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnConvertir = findViewById(R.id.btncalcularL);
        btnConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tempVal = (EditText) findViewById(R.id.txtcantidadL);
                Double cantidad = Double.parseDouble(tempVal.getText().toString());

                spnOptionDe = findViewById(R.id.cboDeL);
                spnOptionA = findViewById(R.id.cboDeAL);
                tempVal = findViewById(R.id.IblRespuestaL);

                tempVal.setText("Respuesta: " + miConversor.covertir(1, spnOptionDe.getSelectedItemPosition(), spnOptionA.getSelectedItemPosition(), cantidad));
            }

      });
    }
}

class conversores{

    Double[][]conversor = {
            {1.0, 8.85, 7.77, 24.05, 34.89, 608.72, 20.08, 0.83, 0.73, 105.0}, /*Monedas*/
            {1000000., 1000.,100., 39.37, 3.28,1.09, 1., 0.001, 0.000621,0.00054 }, /*Longitud*/
            {1.0}, /*Peso*/
    };
    public double covertir(int option, int de, int a, double cantidad){
     return conversor[option][a]/ conversor[option][de] * cantidad;
    }
}
