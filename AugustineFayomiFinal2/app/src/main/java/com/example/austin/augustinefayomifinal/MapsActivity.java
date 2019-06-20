package com.example.austin.augustinefayomifinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    LatLng toronto = new LatLng(43.65317, -79.3827);
    LatLng hawaii = new LatLng(21.3209, -157.8623);
    LatLng sydney = new LatLng(-33.86767, 151.2094);
    LatLng paris = new LatLng(48.86206, 2.343179);

    LatLng presentLoc;
    String location ="Toronto";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        Intent intent = getIntent();
        location = intent.getStringExtra("message");
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if(location == "Toronto"){
            presentLoc = toronto;
            mMap.addMarker(new MarkerOptions().position(toronto).title("Toronto"));
        }
        else if(location == "Hawaii"){
            presentLoc = hawaii;
            mMap.addMarker(new MarkerOptions().position(hawaii).title("Hawaii"));
        }
        else if(location == "Sydney"){
            presentLoc = sydney;
            mMap.addMarker(new MarkerOptions().position(hawaii).title("Sydney"));
        }
        else if(location =="Paris"){
            presentLoc = paris;
            mMap.addMarker(new MarkerOptions().position(hawaii).title("Paris"));

        }


        mMap.moveCamera(CameraUpdateFactory.newLatLng(presentLoc));
    }
}
