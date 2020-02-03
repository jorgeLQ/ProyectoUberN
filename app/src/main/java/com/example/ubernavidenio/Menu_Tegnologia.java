package com.example.ubernavidenio;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.ubernavidenio.fragments.CelularesFragment;
import com.example.ubernavidenio.fragments.ComputadorasFragment;
import com.example.ubernavidenio.fragments.Impresora;
import com.example.ubernavidenio.fragments.TelevisoresFragment;
import com.example.ubernavidenio.ui.main.SectionsPagerAdapterT;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

public class Menu_Tegnologia extends AppCompatActivity implements TelevisoresFragment.OnFragmentInteractionListener, ComputadorasFragment.OnFragmentInteractionListener, Impresora.OnFragmentInteractionListener, CelularesFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__tegnologia);
        SectionsPagerAdapterT sectionsPagerAdapterT = new SectionsPagerAdapterT(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapterT);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}