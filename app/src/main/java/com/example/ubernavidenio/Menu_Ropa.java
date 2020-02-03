package com.example.ubernavidenio;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.ubernavidenio.Interfaces.IComunicaInterface;
import com.example.ubernavidenio.fragments.Femenino;
import com.example.ubernavidenio.fragments.MasculinoFragment;
import com.example.ubernavidenio.fragments.UnixeFragment;
import com.example.ubernavidenio.ui.main.SectionsPagerAdapterR;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

public class Menu_Ropa extends AppCompatActivity implements MasculinoFragment.OnFragmentInteractionListener, Femenino.OnFragmentInteractionListener, UnixeFragment.OnFragmentInteractionListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__ropa);
        SectionsPagerAdapterR sectionsPagerAdapterR = new SectionsPagerAdapterR(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapterR);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    public void onClick(View view){

        Intent menus=null;

        switch (view.getId()){

            case R.id.ropapolo:
                menus=new Intent(Menu_Ropa.this,InfoEstablecimiento.class);
                break;
        }
        startActivity(menus);
    }
}