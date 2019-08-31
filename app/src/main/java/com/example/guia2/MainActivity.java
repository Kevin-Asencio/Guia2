package com.example.guia2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {
    EditText edtContraseña, edtCorreo;
    Button btnIniciarSesion,btnDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        edtCorreo = findViewById(R.id.edtCorreo);
        edtContraseña = findViewById(R.id.edtContraseña);
        btnDatos = findViewById(R.id.btnDatos);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);

        btnDatos.setOnLongClickListener(this);
        btnIniciarSesion.setOnLongClickListener(this);
    }

    @Override
    public boolean onLongClick(View v) {
        switch (v.getId()){
            case R.id.btnIniciarSesion: {
                if (edtCorreo.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Rellene todos los Campos", Toast.LENGTH_LONG).show();
                } else {
                    if (edtContraseña.getText().toString().isEmpty()) {
                        Toast.makeText(this, "Rellene todos los Campos", Toast.LENGTH_LONG).show();
                    } else {
                        Intent in = new Intent(this, ActivitySecundaria.class);
                        startActivity(in);
                    }
                }
            }
            break;
            case R.id.btnDatos:{
                Intent datos = new Intent (this,datos.class);
                startActivity(datos);
            }
        }
        return false;
    }
}
