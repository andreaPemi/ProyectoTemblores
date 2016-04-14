package com.example.andresandreamarcos.apptemblores;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;

import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by andrea on 11/3/16.
 */
public class GmapFragment extends Fragment implements OnMapReadyCallback {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_gmaps, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MapFragment fragment = (MapFragment)getChildFragmentManager().findFragmentById(R.id.map);
        fragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap map){
    //aqui van las coordenadas y la marca
       // map.addMarker(new MarkerOptions().position(new LatLng(10,10)).title("ESTO ES UNA MIERDA MARCOOOOSS!!!!!"));
        LatLng sydney = new LatLng(-34,151);

        map.addMarker(new MarkerOptions().position(sydney).title("ESTO ES UNA MIERDA MARCOOOOSS!!!!!"));
        map.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
