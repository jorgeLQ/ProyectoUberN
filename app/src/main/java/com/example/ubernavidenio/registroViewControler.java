package com.example.ubernavidenio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class registroViewControler extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_view_controler);

        Button btnRegCliente = (Button) findViewById(R.id.RegistrarUsuario);
        btnRegCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), registrar_cliente_view_controler.class);
                startActivityForResult(intent, 0);
            }
        });

    }


}
