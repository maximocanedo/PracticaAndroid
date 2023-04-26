package com.max.practica5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAceptar = findViewById(R.id.btnAceptar);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView txtResultado = findViewById(R.id.txtResultado);
                EditText txtApellido = findViewById(R.id.txtApellido);
                EditText txtNombre = findViewById(R.id.txtNombre);
                EditText txtEdad = findViewById(R.id.txtEdad);
                EditText txtDireccion = findViewById(R.id.txtDireccion);
                String apellido = txtApellido.getText().toString();
                String nombre = txtNombre.getText().toString();
                String edad = txtEdad.getText().toString();
                String direccion = txtDireccion.getText().toString();
                String finalMessage = "¡Bienvenido " + nombre + " " + apellido + "! \n"
                + "Tenés " + edad + " años. \nVivís en: " + direccion + ". ";
                txtResultado.setText(finalMessage);
            }
        });

    }
}