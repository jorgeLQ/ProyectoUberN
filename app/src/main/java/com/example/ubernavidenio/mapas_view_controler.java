package com.example.ubernavidenio;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import android.Manifest;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Point;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.libraries.places.api.Places;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class mapas_view_controler extends FragmentActivity implements OnMapReadyCallback {

    private SupportMapFragment mapFragment;
    private GoogleMap mGoogleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapas_view_controler);
        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Button btnsatelite = (Button)findViewById(R.id.MAPASATELITAL);
        btnsatelite.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            mGoogleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            }
        });
        Button btnNormal = (Button)findViewById(R.id.MAPANORMAL);
        btnNormal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mGoogleMap.setMyLocationEnabled(true);
        mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mGoogleMap.getUiSettings().setZoomControlsEnabled(true);
        Pointers(googleMap);

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            } else {
                Toast.makeText(this, "No cuentas con los permisos necesarios, cierra y abre de nuevo la aplicación", Toast.LENGTH_SHORT).show();
            } } }

    public void Pointers(GoogleMap googleMap) {
        mGoogleMap=googleMap;


        final LatLng punto1=new LatLng(-0.2104022, -78.4888627);
        final LatLng punto2=new LatLng(-0.2321669, -78.5055793);
        final LatLng punto3=new LatLng(-0.3005394, -78.4598161);
        final LatLng punto4=new LatLng(-0.2915984, -78.4008312);
        final LatLng punto5=new LatLng(-0.2883114, -78.4034727);
        final LatLng punto6=new LatLng(-0.2118599, -78.4914343);
        final LatLng punto7=new LatLng(-0.2006809,-78.5045751);
        final LatLng punto8=new LatLng(-0.3006414,-78.4665587);
        final LatLng punto9=new LatLng(-0.2876241,-78.4418981);
        final LatLng punto10=new LatLng(-0.3849584,-78.514375);
        final LatLng punto11=new LatLng(-0.2737559,-78.4868863);
        final LatLng punto12=new LatLng(-0.230788,-78.5234213);

        mGoogleMap.addMarker(new MarkerOptions().position(punto1).title("PIKA").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mGoogleMap.addMarker(new MarkerOptions().position(punto2).title("KFC").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        mGoogleMap.addMarker(new MarkerOptions().position(punto3).title("CAMISERIA INGLESA").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        mGoogleMap.addMarker(new MarkerOptions().position(punto4).title("CREACIONES J.").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        mGoogleMap.addMarker(new MarkerOptions().position(punto5).title("ELECTRONICA QUITO").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mGoogleMap.addMarker(new MarkerOptions().position(punto6).title("ELECTROMUNDO").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));
        mGoogleMap.addMarker(new MarkerOptions().position(punto7).title("TIA").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mGoogleMap.addMarker(new MarkerOptions().position(punto8).title("SUPERMAXI").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        mGoogleMap.addMarker(new MarkerOptions().position(punto9).title("CANTUÑA").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        mGoogleMap.addMarker(new MarkerOptions().position(punto10).title("AMAGUAÑA :)IRQC").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        mGoogleMap.addMarker(new MarkerOptions().position(punto11).title("CREACIONES ARMENIA").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mGoogleMap.addMarker(new MarkerOptions().position(punto12).title("RESTAURANT QUITO").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));

    }

}




