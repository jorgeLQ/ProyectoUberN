package com.example.ubernavidenio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;

public class login_view_controler extends AppCompatActivity {

    private EditText TxtUserName;
    private EditText TxtContrasena;
    private Button loginu;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mAuth = FirebaseAuth.getInstance();

        TxtUserName = (EditText) findViewById(R.id.username);
        TxtContrasena = (EditText) findViewById(R.id.password);
        loginu = (Button) findViewById(R.id.login);

        loginu.setOnClickListener((View.OnClickListener) this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_view_controler);

        Button btnRegistroCliente = (Button) findViewById(R.id.login);
        btnRegistroCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), ventana_usuario_view_controler.class);
                startActivityForResult(intent, 0);
            }
        });
    }

    private void login(){
        String UName = TxtUserName.getText().toString().trim();
        String Contrasena = TxtContrasena.getText().toString().trim();

        if (TextUtils.isEmpty(UName)) {
            Toast.makeText(this, "Se debe ingresar un Usuario", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(Contrasena)) {
            Toast.makeText(this, "Se debe ingresar una Contraseña", Toast.LENGTH_LONG).show();
            return;
        }


        mAuth.createUserWithEmailAndPassword(UName, Contrasena)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(login_view_controler.this,"Bienvenido a la Aplicación Uber Navideño",Toast.LENGTH_LONG).show();
                        } else {
                            if(task.getException()instanceof FirebaseAuthUserCollisionException){
                                Toast.makeText(login_view_controler.this,"El Usuario no Existe",Toast.LENGTH_LONG).show();
                            }
                            Toast.makeText(login_view_controler.this,"No se encuentra registrado",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }


        public void onClick(View view){
            login();
        }

    }

