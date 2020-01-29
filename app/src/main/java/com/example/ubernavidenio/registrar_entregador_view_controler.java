package com.example.ubernavidenio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class registrar_entregador_view_controler extends AppCompatActivity {

EditText txtNombre;
Button btnregistrar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_entregador_view_controler);

        Button btnAutomor = (Button) findViewById(R.id.BtnRegistar);
        btnAutomor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), registar_automotor_view_controler.class);
                startActivityForResult(intent, 0);
            }
        });
        Button cerrar= (Button) findViewById(R.id.CANCELAR2);
        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        txtNombre=(EditText) findViewById(R.id.nombreentregador);

    }






}
