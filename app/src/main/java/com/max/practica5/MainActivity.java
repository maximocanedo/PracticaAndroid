package com.max.practica5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Controles
        EditText txtNombre = findViewById(R.id.txtNombre);
        CheckBox cbEsProgramador = findViewById(R.id.cbEsProgramador);
        RadioButton radioHombre = findViewById(R.id.radioHombre);
        RadioButton radioMujer = findViewById(R.id.radioMujer);
        TextView txtResultado = findViewById(R.id.txtResultado);
        Button btnAceptar = findViewById(R.id.btnAceptar);

        txtNombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Ocurre antes de que el texto se cambie.
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Justo cuando se cambia el texto
                boolean estaVacio = (charSequence.toString().trim().length() == 0);
                btnAceptar.setEnabled(!estaVacio);
                txtNombre.setError((!estaVacio) ? null : "Completá este campo");
            }
            @Override
            public void afterTextChanged(Editable editable) {
                // Luego de que el texto se cambia
            }
        });

        btnAceptar.setOnClickListener(view -> {
            String salida = "";
            salida += "Nombre: " + txtNombre.getText().toString() + "\n";
            salida += "Ocupación: " + (String)(cbEsProgramador.isChecked()?"Programador":"No es programador") + "\n";
            salida += "Sexo: " + (String)(radioHombre.isChecked()?"Hombre":"Mujer") + "\n";
            txtResultado.setText(salida);
        });
    }
}