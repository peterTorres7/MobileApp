package com.example.helloworld;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MatchesFragment extends Fragment {

    ArrayList matchesList = new ArrayList();
    MatchesViewModel matchesViewModel = new MatchesViewModel();

    RecyclerView recyclerView;
    MatchesData matchesData;
    LocationManager locationManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_matches, container, false);
        locationManager = (LocationManager)getActivity().getSystemService(Context.LOCATION_SERVICE);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false));


//        Using local data
        List<MatchesData> matchesDataList = new ArrayList<>();
        matchesData = new MatchesData(R.drawable.coco, getString(R.string.coco));
        matchesDataList.add(matchesData);
        matchesData = new MatchesData(R.drawable.cookie, getString(R.string.cookie));
        matchesDataList.add(matchesData);
        matchesData = new MatchesData(R.drawable.evie, getString(R.string.evie));
        matchesDataList.add(matchesData);
        matchesData = new MatchesData(R.drawable.honey, getString(R.string.honey));
        matchesDataList.add(matchesData);
        matchesData = new MatchesData(R.drawable.lola, getString(R.string.lola));
        matchesDataList.add(matchesData);
        matchesData = new MatchesData(R.drawable.luna, getString(R.string.luna));
        matchesDataList.add(matchesData);
        matchesData = new MatchesData(R.drawable.nala, getString(R.string.nala));
        matchesDataList.add(matchesData);
        matchesData = new MatchesData(R.drawable.sky, getString(R.string.sky));
        matchesDataList.add(matchesData);
        matchesData = new MatchesData(R.drawable.star, getString(R.string.star));
        matchesDataList.add(matchesData);

        MatchesCardRecyclerViewAdapter adapter = new MatchesCardRecyclerViewAdapter(matchesDataList, getContext());
        recyclerView.setAdapter(adapter);
        return view;
    }

    public boolean isLocationEnabled() {
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    public void showAlert() {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this.getContext());
        dialog.setTitle(R.string.enable_location)
                .setMessage(getString(R.string.location_message))
                .setPositiveButton(R.string.location_settings, (paramDialogInterface, paramInt) -> {
                    Intent myIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                })
                .setNegativeButton(R.string.location_cancel, (paramDialogInterface, paramInt) -> {});
        dialog.show();
    }

    private final LocationListener locationListenerNetwork = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
//            longitudeNetwork = location.getLongitude();
//            latitudeNetwork = location.getLatitude();

        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };



//    if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
//            == PackageManager.PERMISSION_GRANTED) ||
//            ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)
//            == PackageManager.PERMISSION_GRANTED) {
//        Location.requestLocationUpdates(LocationManager.GPS_PROVIDER, 60 * 1000, 10,
//                locationListenerNetwork);
//        Toast.makeText(this, R.string.network_provider_started_running, Toast.LENGTH_LONG).show());
//        button.setText(R.string.pause);
//    }
//
//    locationManager.removeUpdates(locationListenerNetwork)
//    button.setText(R.string.resume);

}
