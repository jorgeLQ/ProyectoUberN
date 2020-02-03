package com.example.ubernavidenio;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Button;
import android.widget.Toast;


public class ventana_entregador_view_controler extends AppCompatActivity implements OnMapReadyCallback {

    private SupportMapFragment mapFragment;
    private GoogleMap mGoogleMap;

   /* DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    DatabaseReference myrootchild = databaseReference.child("Hola mundo")*/

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_entregador_view_controler);
        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.toolbar);
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
        DrawerLayout drawer=findViewById(R.id.drawer_layout);
        NavigationView navigationView=findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration=new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController=Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ventana_entregador_view_controler, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController=Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
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
            } }
    }
    public void Pointers(GoogleMap googleMap) {
        mGoogleMap=googleMap;

        final LatLng punto1=new LatLng(-0.2104022, -78.4888627);
        final LatLng punto2=new LatLng(-0.2321669, -78.5055793);
        final LatLng punto3=new LatLng(-0.3005394, -78.4598161);
        final LatLng punto4=new LatLng(-0.2915984, -78.4008312);
        final LatLng punto5=new LatLng(-0.2318686,-78.450351);
        final LatLng punto6=new LatLng(-0.2118599, -78.4914343);
        final LatLng punto7=new LatLng(-0.2006809,-78.5045751);
        final LatLng punto8=new LatLng(-0.3006414,-78.4665587);
        final LatLng punto9=new LatLng(-0.2876241,-78.4418981);
        final LatLng punto10=new LatLng(-0.3849584,-78.514375);
        final LatLng punto11=new LatLng(-0.2737559,-78.4868863);
        final LatLng punto12=new LatLng(-0.230788,-78.5234213);



        mGoogleMap.addMarker(new MarkerOptions().position(punto1).title("EPN").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mGoogleMap.addMarker(new MarkerOptions().position(punto2).title("TREBOL").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        mGoogleMap.addMarker(new MarkerOptions().position(punto3).title("TRIANGULO").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        mGoogleMap.addMarker(new MarkerOptions().position(punto4).title("LA MERCED").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        mGoogleMap.addMarker(new MarkerOptions().position(punto5).title("ELLA NO TE AMA :´)").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mGoogleMap.addMarker(new MarkerOptions().position(punto6).title("CATOLICA").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));
        mGoogleMap.addMarker(new MarkerOptions().position(punto7).title("UCE").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mGoogleMap.addMarker(new MarkerOptions().position(punto8).title("ALANGASI").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        mGoogleMap.addMarker(new MarkerOptions().position(punto9).title("EL TINGO").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        mGoogleMap.addMarker(new MarkerOptions().position(punto10).title("AMAGUAÑA :)IRQC").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        mGoogleMap.addMarker(new MarkerOptions().position(punto11).title("ARMENIA").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mGoogleMap.addMarker(new MarkerOptions().position(punto12).title("PANECILLO").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));

        Polyline line=mGoogleMap.addPolyline(new PolylineOptions().add(punto1 , punto2).width(10).color(Color.BLACK));
        Polyline line2=mGoogleMap.addPolyline(new PolylineOptions().add(punto1, punto3).width(10).color(Color.RED));
        Polyline line3=mGoogleMap.addPolyline(new PolylineOptions().add(punto1, punto6).width(10).color(Color.BLUE));
        Polyline line4=mGoogleMap.addPolyline(new PolylineOptions().add(punto7, punto12).width(10).color(Color.YELLOW));
        Polyline line5=mGoogleMap.addPolyline(new PolylineOptions().add(punto7, punto6).width(10).color(Color.CYAN));
        Polyline line6=mGoogleMap.addPolyline(new PolylineOptions().add(punto3, punto8).width(10).color(Color.GRAY));
        Polyline line7=mGoogleMap.addPolyline(new PolylineOptions().add(punto3, punto9).width(10).color(Color.GREEN));
        Polyline line8=mGoogleMap.addPolyline(new PolylineOptions().add(punto3, punto11).width(10).color(Color.LTGRAY));
        Polyline line9=mGoogleMap.addPolyline(new PolylineOptions().add(punto2, punto10).width(10).color(Color.MAGENTA));
        Polyline line10=mGoogleMap.addPolyline(new PolylineOptions().add(punto9, punto10).width(10).color(Color.TRANSPARENT));
        Polyline line11=mGoogleMap.addPolyline(new PolylineOptions().add(punto9, punto5).width(10).color(Color.WHITE));
        Polyline line12=mGoogleMap.addPolyline(new PolylineOptions().add(punto9, punto4).width(10).color(Color.DKGRAY));
        Polyline line13=mGoogleMap.addPolyline(new PolylineOptions().add(punto4, punto1).width(10).color(Color.BLUE));
        Polyline line14=mGoogleMap.addPolyline(new PolylineOptions().add(punto4, punto10).width(10).color(Color.RED));

    }
}
