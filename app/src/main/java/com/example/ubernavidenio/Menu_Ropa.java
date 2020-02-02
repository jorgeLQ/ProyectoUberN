package com.example.ubernavidenio;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

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