package com.example.ubernavidenio;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class registrar_entregador_view_controler extends AppCompatActivity {

EditText txtNombre, txtapellido, txtedad, txttelef, txtcorreo, txtcuentaahorro, txtcontra, txtcontra2;
Button btnregistrar;

     private DatabaseReference Rentregador;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_entregador_view_controler);
        Rentregador= FirebaseDatabase.getInstance().getReference("Rentregador");




        txtNombre=(EditText) findViewById(R.id.nombreentregador);
        txtapellido=(EditText) findViewById(R.id.apellidoentregador);
        txtedad=(EditText) findViewById(R.id.edadentregador);
        txttelef=(EditText) findViewById(R.id.telefentregador);
        txtcorreo=(EditText) findViewById(R.id.correoentregador);
        txtcuentaahorro=(EditText) findViewById(R.id.cuentaahorro);
        txtcontra=(EditText) findViewById(R.id.contraentregador1);
        txtcontra2=(EditText) findViewById(R.id.contraentregador2);
        btnregistrar=(Button) findViewById(R.id.BtnRegistar);


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



    }

     public void registrarEntregador(){

        String nombre=txtNombre.getText().toString();
        String apellido=txtapellido.getText().toString();
        String edad=txtedad.getText().toString();
        String telefono=txttelef.getText().toString();
        String correo=txtcorreo.getText().toString();
        String ctaahorro=txtcuentaahorro.getText().toString();
        String contrasenia1=txtcontra.getText().toString();
        String contrasenia2=txtcontra2.getText().toString();


         if(!TextUtils.isEmpty(nombre)){

         String id= Rentregador.push().getKey();
         Rentregador entregador = new Rentregador(id, nombre, apellido, edad, telefono, correo, ctaahorro, contrasenia1, contrasenia2);
         Rentregador.child("Entregadores").child(id).setValue(entregador);
         Toast.makeText(this, "Entregador Registrado", Toast.LENGTH_LONG).show();

         } else {

             Toast.makeText(this, "Debe introducir el nombre", Toast.LENGTH_LONG).show();

         }

     }

    }



