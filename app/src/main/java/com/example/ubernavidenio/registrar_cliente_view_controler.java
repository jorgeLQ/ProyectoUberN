package com.example.ubernavidenio;

import android.os.Bundle;


import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class registrar_cliente_view_controler extends AppCompatActivity {

    private EditText TxtUserNamecl;
    private EditText TxtContrasenacl;
    private EditText TxtCContrasenacl;
    private EditText TxtNombrecl;
    private EditText TxtApellidocl;
    private EditText TxtEmailcl;
    private EditText TxtNCBancariacl;
    private RadioButton Masculinocl;
    private RadioButton Femeninocl;
    private EditText TxtFNacimientocl;
    private EditText TxtDireccioncl;


    private Button REGISTRARC;
    private Button CANCELARC;


    private FirebaseAuth mAuth;

    //Variable de datos que van a ser registrados

    private String userCli="";
    private String contrase="";
    private String ccontrase="";
    private String nameCli="";
    private String apecli="";
    private String mail="";
    private String cuenta="";
    private String fechana="";
    private String direccion="";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_cliente_view_controler);












    }
    private void registrarUsuarioCl(){




    }
}
