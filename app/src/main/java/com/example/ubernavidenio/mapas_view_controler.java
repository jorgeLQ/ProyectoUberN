package com.example.ubernavidenio;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class mapas_view_controler extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapas_view_controler);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

     //  int status =GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());
       //if(status== ConnectionResult.SUCCESS){
        SupportMapFragment mapFragment=(SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    //}
   // else{
       // Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status,(Activity)getApplicationContext(),10);
       // dialog.show();
    //}

    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap=googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        mMap.getUiSettings().setMyLocationButtonEnabled(true);
       if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED &&
               ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
           return;
       }
        mMap.setMyLocationEnabled(true);


        //UiSettings uiSettings =mMap.getUiSettings();
        //uiSettings.setZoomControlsEnabled(true);


        // Add a marker in Sydney and move the camera
       //LatLng sydney=new LatLng(-0.288209, 78.403413);
       //mMap.addMarker(new MarkerOptions().position(sydney).title("Quito").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
       //float zoomlevel=16;
       //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, zoomlevel));
    }
}
