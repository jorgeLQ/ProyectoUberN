package com.example.ubernavidenio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.ubernavidenio.Interfaces.IComunicaInterface;
import com.example.ubernavidenio.fragments.InfoEstablecimientos;

public class InfoEstablecimiento extends AppCompatActivity implements IComunicaInterface,InfoEstablecimientos.OnFragmentInteractionListener {

    Fragment fragmentPolo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_establecimiento);

        fragmentPolo=new InfoEstablecimientos();
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragments,fragmentPolo).commit();

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void ropaPolo() {
        Intent intent=new Intent(this,MenuMasculinoR.class);
        startActivity(intent);
    }
}
