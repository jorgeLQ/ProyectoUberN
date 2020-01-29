package com.example.ubernavidenio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class registrar_targeta_view_controler extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_targeta_view_controler);




        Button cerrar= (Button) findViewById(R.id.CANCELAR);
        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button btnRegTarjet = (Button) findViewById(R.id.ValidarR);
        btnRegTarjet.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), ventana_usuario_view_controler.class);
                startActivityForResult(intent, 0);
            }
        });


    }
}
