package com.example.ubernavidenio;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import android.Manifest;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

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
            }
        }
    }

    public void Pointers(GoogleMap googleMap) {
        mGoogleMap=googleMap;
        final LatLng punto1=new LatLng(-0.2104022, -78.4888627);
        final LatLng punto2=new LatLng(-0.2321669, -78.5055793);
        final LatLng punto3=new LatLng(-0.3005394, -78.4598161);
        final LatLng punto4=new LatLng(-0.2915984, -78.4008312);
        final LatLng punto5=new LatLng(-0.2883114,-78.4034727);
        final LatLng punto6=new LatLng(-0.2118599,-78.4914343);
        final LatLng punto7=new LatLng(-0.2118599,-78.4914343);
        final LatLng punto8=new LatLng(-0.2111253,-78.4934015);
        final LatLng punto9=new LatLng(-0.2110242,-78.4935961);
        final LatLng punto10=new LatLng(-0.2088898,-78.4901733);

        mGoogleMap.addMarker(new MarkerOptions().position(punto1).title("EPN").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mGoogleMap.addMarker(new MarkerOptions().position(punto2).title("TREBOL").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        mGoogleMap.addMarker(new MarkerOptions().position(punto3).title("TRIANGULO").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        mGoogleMap.addMarker(new MarkerOptions().position(punto4).title("LA MERCED").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        mGoogleMap.addMarker(new MarkerOptions().position(punto5).title("MI CASA").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        mGoogleMap.addMarker(new MarkerOptions().position(punto6).title("EPN").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mGoogleMap.addMarker(new MarkerOptions().position(punto7).title("").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        mGoogleMap.addMarker(new MarkerOptions().position(punto8).title("").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        mGoogleMap.addMarker(new MarkerOptions().position(punto9).title("").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        mGoogleMap.addMarker(new MarkerOptions().position(punto10).title("").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));

    }

}
