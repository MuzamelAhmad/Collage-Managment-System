package com.example.myapplication.Fregments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class LocationFragment extends Fragment implements OnMapReadyCallback {

    GoogleMap googleMaps;

    SupportMapFragment mapFragment;
    public LocationFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_location, container, false);


        return view;
    }




    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        googleMaps = googleMap;

        LatLng latLng = new LatLng(34.002534609976, 71.531695439477);
        MarkerOptions markerOptions = new MarkerOptions().position(latLng).title("F.G Degree College For Boys (مردانہ)");
        googleMaps.addMarker(markerOptions);

        googleMaps.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMaps.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,16f));

    }
}