package com.example.ubernavidenio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class registar_automotor_view_controler extends AppCompatActivity {

    private EditText txtnchasis, txtnplaca;

    Button btnaceptar;



    private DatabaseReference Rautomotor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registar_automotor_view_controler);

        Rautomotor= FirebaseDatabase.getInstance().getReference("Rautomotor");


        txtnchasis=(EditText) findViewById(R.id.txtNumeroChasis);
        txtnplaca=(EditText) findViewById(R.id.txtNumeroPlaca);
        btnaceptar=(Button) findViewById(R.id.btnRAAceptar);

        Button cerrar= (Button) findViewById(R.id.AACANCELAR);
        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        Button btnRegTarjet = (Button) findViewById(R.id.btnRAAceptar);
        btnRegTarjet.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                registrarAutomotor();
                Intent intent = new Intent (v.getContext(), ventana_entregador_view_controler.class);
                startActivityForResult(intent, 0);
            }
        });

    }


    public void registrarAutomotor(){

        String placa=txtnplaca.getText().toString();
        String chasis=txtnchasis.getText().toString();


        if(!TextUtils.isEmpty(placa)){

            String id= Rautomotor.push().getKey();
            Rautomotor automotor = new Rautomotor(id, placa, chasis);
            Rautomotor.child("Automotores").child(id).setValue(automotor);
            Toast.makeText(this, "Automotor Registrado", Toast.LENGTH_LONG).show();

        } else {

            Toast.makeText(this, "Debe introducir la placa del automotor", Toast.LENGTH_LONG).show();

        }

    }


}
