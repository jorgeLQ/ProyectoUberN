package com.example.ubernavidenio;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class registrar_targeta_view_controler extends AppCompatActivity {
    private EditText cv;
    private EditText ntarjeta;
    private EditText fexpira;
    private DatabaseReference Rtarjeta;
    private RadioGroup radiobtn;
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



        cv=(EditText) findViewById(R.id.txtcv);
        ntarjeta=(EditText) findViewById(R.id.txttarjeta);
        fexpira=(EditText) findViewById(R.id.txtfechaex);
        Rtarjeta= FirebaseDatabase.getInstance().getReference("RTarjeta");
        radiobtn = (RadioGroup) findViewById(R.id.GROUPRADIOBTN);



        //tipotarjeta=(EditText) findViewById(R);




        Button btnRegTarjet = (Button) findViewById(R.id.ValidarR);
        btnRegTarjet.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                registrarTarjeta();
                Intent intent = new Intent (v.getContext(), ventana_usuario_view_controler.class);
                startActivityForResult(intent, 0);
            }
        });


    }
    public void registrarTarjeta() {
        String CV=cv.getText().toString();
        String TARJETA=ntarjeta.getText().toString();
        String FECHA=fexpira.getText().toString();
        String TIPO="";
        if (radiobtn.getCheckedRadioButtonId() == R.id.VISA) {
           TIPO= "VISA" ;
        }
        if (radiobtn.getCheckedRadioButtonId() == R.id.MASTERCARD) {
            TIPO= "MASTERCARD" ;
        }
        if (!TextUtils.isEmpty(CV)) {

            String id=Rtarjeta.push().getKey();
            RTarjeta DatosTrjeta=new RTarjeta(CV, TARJETA, FECHA, TIPO);
            Rtarjeta.child("Tarjeta").child(id).setValue(DatosTrjeta);
            Toast.makeText(this, "Tarjeta Registrada", Toast.LENGTH_LONG).show();

        }else {

            Toast.makeText(this, "LLENE TODOS LOS CAMPOS", Toast.LENGTH_LONG).show();
        }
    }
}


