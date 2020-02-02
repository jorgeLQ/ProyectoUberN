package com.example.ubernavidenio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
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
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;

public class login_view_controler extends AppCompatActivity implements View.OnClickListener {

    private EditText TxtUserName;
    private EditText TxtContrasena;
    private Button loginu;
    private ProgressDialog progressDialog;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_view_controler);

        mAuth = FirebaseAuth.getInstance();

        TxtUserName = (EditText) findViewById(R.id.username);
        TxtContrasena = (EditText) findViewById(R.id.password);
        loginu = (Button) findViewById(R.id.login);

        progressDialog = new ProgressDialog(this);

        loginu.setOnClickListener((View.OnClickListener) this);

    }

    private void loguearUsuario() {
        //Obtenemos el email y la contraseña desde las cajas de texto
        String UName = TxtUserName.getText().toString().trim();
        String Contrasena = TxtContrasena.getText().toString().trim();

        //Verificamos que las cajas de texto no esten vacías
        if (TextUtils.isEmpty(UName)) {//(precio.equals(""))
            Toast.makeText(this, "Se debe ingresar un email", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(Contrasena)) {
            Toast.makeText(this, "Falta ingresar la contraseña", Toast.LENGTH_LONG).show();
            return;
        }


        progressDialog.setMessage("Verificando...");
        progressDialog.show();

        //loguear usuario
        mAuth.signInWithEmailAndPassword(UName, Contrasena)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if (task.isSuccessful()) {
                            Toast.makeText(login_view_controler.this, "Bienvenido a Uber Navideño", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent (getApplication(), ventana_usuario_view_controler.class);
                            startActivityForResult(intent, 0);
                            /*Intent intencion = new Intent(getApplication(), ventana_usuario_view_controler.class);
                            startActivity(intencion);*/
                        } else {
                            if (task.getException() instanceof FirebaseAuthInvalidUserException) {//si se presenta una colisión
                                Toast.makeText(login_view_controler.this,"El usuario no existe",Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(login_view_controler.this,"Contraseña incorrecta",Toast.LENGTH_LONG).show();
                            }
                        }
                        progressDialog.dismiss();
                    }
                });
    }



        public void onClick(View view){
            loguearUsuario();
        }

    }

