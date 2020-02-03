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



public class registrar_cliente_view_controler extends AppCompatActivity {

    private EditText TxtUserNamecl, TxtContrasenacl, TxtCContrasenacl, TxtNombrecl, TxtApellidocl, TxtEmailcl,
     TxtNCBancariacl, TxtFNacimientocl, TxtDireccioncl;

    private RadioGroup mGender;
    private RadioButton mGenderOption;


    String strGender;
    Button REGISTRARC;
    Button CANCELARC;


    private DatabaseReference Rcliente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_cliente_view_controler);
        Rcliente= FirebaseDatabase.getInstance().getReference("Rcliente");

        // mAuth = FirebaseAuth.getInstance();

        //Button CANCELARC= (Button) findViewById(R.id.btncancelar);



        TxtUserNamecl = (EditText) findViewById(R.id.TxtUserNamecl);
        TxtContrasenacl = (EditText) findViewById(R.id.TxtContrasenacl);
        TxtCContrasenacl = (EditText) findViewById(R.id.TxtCContrasenacl);
        TxtNombrecl = (EditText) findViewById(R.id.TxtNombrecl);
        TxtApellidocl = (EditText) findViewById(R.id.TxtApellidocl);
        TxtEmailcl = (EditText) findViewById(R.id.TxtEmailcl);
        TxtNCBancariacl = (EditText) findViewById(R.id.TxtNCBancariacl);

        mGender = findViewById(R.id.rg_gender);
        mGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                mGenderOption = mGender.findViewById(checkedId);

                switch (checkedId){
                    case R.id.rb_masculino:
                        strGender = mGenderOption.getText().toString();
                        break;
                    case R.id.rb_femenino:
                        strGender = mGenderOption.getText().toString();
                        break;

                    default:

                }
            }
        });



        TxtFNacimientocl = findViewById(R.id.TxtFNacimientocl);
        TxtDireccioncl = findViewById(R.id.TxtDireccioncl);

        CANCELARC = (Button) findViewById(R.id.btncancelar);
        CANCELARC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        REGISTRARC = (Button) findViewById(R.id.REGISTRARC);

        //CANCELARC = (Button) findViewById(R.id.btncancelar);

        //REGISTRARC.setOnClickListener((View.OnClickListener) this);
       // CANCELARC.setOnClickListener((View.OnClickListener) this);


        //radio button




        //tarjeta


        //Button btnRegTarjet = (Button) findViewById(R.id.REGISTRARC);

        REGISTRARC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarUsuarioCl();
                Intent intent = new Intent(v.getContext(), registrar_targeta_view_controler.class);
                startActivityForResult(intent, 0);
            }
        });


        //Validacion cuando los campos estan vacios

        /*REGISTRARC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userCli = TxtUserNamecl.getText().toString();
                contrase = TxtContrasenacl.getText().toString();
                ccontrase = TxtCContrasenacl.getText().toString();
                nameCli = TxtNombrecl.getText().toString();
                apecli = TxtApellidocl.getText().toString();
                mail = TxtEmailcl.getText().toString();
                cuenta = TxtNCBancariacl.getText().toString();
                fechana = TxtFNacimientocl.getText().toString();
                direccion = TxtDireccioncl.getText().toString();


                /*
               if (!userCli.isEmpty() && !contrase.isEmpty() && !ccontrase.isEmpty() && !nameCli.isEmpty()
                        && !apecli.isEmpty() && !mail.isEmpty() && !cuenta.isEmpty() && !fechana.isEmpty() && !direccion.isEmpty()){

                    if(contrase.length()>=6){
                    }
                    else{
                        Toast.makeText(registrar_cliente_view_controler.this, "La contraseña debe tener almenos 6 caracteres",
                                Toast.LENGTH_SHORT).show();
                    }
                    // registrarUsuarioCl();
                }
                else{
                    Toast.makeText(registrar_cliente_view_controler.this, "Debe completar todos los campos",
                            Toast.LENGTH_SHORT).show();
                }

            }

        });*/


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

        String sexo = mGenderOption.getText().toString().trim();


        if(!TextUtils.isEmpty(Contrasenacl)){

            String id=Rcliente.push().getKey();

            Rcliente cliente = new Rcliente(id, UNamecl,Contrasenacl, CContrasenacl, Nombrecl, Apellidocl, Emailcl, CBancariacl, sexo , FNacimientocl,Direccioncl);

            Rcliente.child("Clientes").child(id).setValue(cliente);
            Toast.makeText(this, "Cliente Registrado", Toast.LENGTH_LONG).show();

        } else {

            Toast.makeText(this, "Debe introducir la contraseña", Toast.LENGTH_LONG).show();

        }

    }
}
