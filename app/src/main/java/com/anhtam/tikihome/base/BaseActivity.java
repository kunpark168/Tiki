package com.anhtam.tikihome.base;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;

import com.anhtam.tikihome.R;
import com.anhtam.tikihome.services.GPSService;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.os.Handler;
import android.os.ResultReceiver;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class BaseActivity extends AppCompatActivity implements GPSService.IGPSService {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        GPSService.init(this, this);
    }

    @SuppressWarnings("MissingPermission")
    public void startLocationUpdates() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    Constant.LOCATION_PERMISSION_REQUEST_CODE);
        } else onPermistionGranted();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onLocationChange() {

    }

    public void run (Runnable runnable, long milisecond){
        new Handler().postDelayed(runnable, milisecond);
    }

    public void onPermistionGranted (){

    }
}
