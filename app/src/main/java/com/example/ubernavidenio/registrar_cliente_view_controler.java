package com.example.ubernavidenio;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

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


        mAuth = FirebaseAuth.getInstance();


        TxtUserNamecl = (EditText) findViewById(R.id.TxtUserNamecl);
        TxtContrasenacl = (EditText) findViewById(R.id.TxtContrasenacl);
        TxtCContrasenacl = (EditText) findViewById(R.id.TxtCContrasenacl);
        TxtNombrecl = (EditText) findViewById(R.id.TxtNombrecl);
        TxtApellidocl = (EditText) findViewById(R.id.TxtApellidocl);
        TxtEmailcl = (EditText) findViewById(R.id.TxtEmailcl);
        TxtNCBancariacl = (EditText) findViewById(R.id.TxtNCBancariacl);
        Masculinocl = (RadioButton) findViewById(R.id.Masculino);
        Femeninocl = (RadioButton) findViewById(R.id.Femenino);
        TxtFNacimientocl = (EditText) findViewById(R.id.TxtFNacimientocl);
        TxtDireccioncl = (EditText) findViewById(R.id.TxtDireccioncl);


        REGISTRARC = (Button) findViewById(R.id.REGISTRARC);
        CANCELARC = (Button) findViewById(R.id.CANCELARC);





        REGISTRARC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userCli = TxtUserNamecl.getText().toString();
                contrase = TxtContrasenacl.getText().toString();
                ccontrase = TxtCContrasenacl.getText().toString()
                nameCli = TxtNombrecl.getText().toString();
                apecli = TxtApellidocl.getText().toString();
                mail = TxtEmailcl.getText().toString();
                cuenta = TxtNCBancariacl.getText().toString();
                fechana = TxtFNacimientocl.getText().toString();
                direccion = TxtDireccioncl.getText().toString();
            }
        
        });



        /*
        Button btnRegTarjet = (Button) findViewById(R.id.REGISTRARC);
        btnRegTarjet.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), registrar_targeta_view_controler.class);
                startActivityForResult(intent, 0);
            }
        });

        */




        /*
        Button cerrar= (Button) findViewById(R.id.CANCELARC);
        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        */



    }
    private void registrarUsuarioCl(){
        String UNamecl=TxtUserNamecl.getText().toString().trim();
        String Contrasenacl=TxtContrasenacl.getText().toString().trim();
        String CContrasenacl=TxtCContrasenacl.getText().toString().trim();
        String Nombrecl=TxtNombrecl.getText().toString().trim();
        String Apellidocl=TxtApellidocl.getText().toString().trim();
        String Emailcl=TxtEmailcl.getText().toString().trim();
        String CBancariacl=TxtNCBancariacl.getText().toString().trim();
        String FNacimientocl=TxtFNacimientocl.getText().toString().trim();
        String Direccioncl=TxtDireccioncl.getText().toString().trim();

        if(TextUtils.isEmpty(UNamecl)){
            Toast.makeText(this,"Se debe ingresar un Usuario",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(Contrasenacl)){
            Toast.makeText(this,"Se debe ingresar una Contraseña",Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(CContrasenacl)){
            Toast.makeText(this,"Se debe Repetir la Contraseña",Toast.LENGTH_LONG).show();
            return;
        }
        if(Contrasenacl.equals(CContrasenacl)){
            Toast.makeText(this,"Las contraseñas Coiciden",Toast.LENGTH_LONG).show();
            return;
        }else{
            Toast.makeText(this,"Las contraseñas No son Iguales",Toast.LENGTH_LONG).show();
            return;
        }



    }
}
