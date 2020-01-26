package com.example.ubernavidenio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class registro_entregador_view_controller extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_entregador_view_controller);

        Button btnAutomor = (Button) findViewById(R.id.btnREntregador);
        btnAutomor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), registrar_automotor.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}
