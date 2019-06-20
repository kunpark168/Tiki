package com.anhtam.tikihome.services;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.anhtam.tikihome.base.BaseActivity;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class GPSService implements LocationListener {
    private double latitude, longtitude;
    private Geocoder geocoder;
    private List<Address> addressList;
    private Location location;
    LocationManager locationManager;
    public static GPSService instance;
    private static IGPSService listener;
    Criteria criteria;
    String Holder;
    private static Activity activity;

    public static GPSService getInstance() {
        if (instance == null)
            instance = new GPSService();
        return instance;
    }

    public GPSService() {
        initData();
    }

    public static void init (IGPSService mListener, Activity mActivity){
        listener = mListener;
        activity = mActivity;
    }

    @SuppressLint("MissingPermission")
    private void initData() {
        locationManager = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);
        geocoder = new Geocoder(activity, Locale.getDefault());
        criteria = new Criteria();
        Holder = locationManager.getBestProvider(criteria, false);
        if (Holder != null && !Holder.equals("")) {
            Location location = locationManager.getLastKnownLocation(Holder);
            locationManager.requestLocationUpdates(Holder, 20000, 1, this);
            if(location!=null) onLocationChanged(location);
        } else Log.d("GPS", "GPS Fail!");
    }

    public String getAddress (){
        String address = "";
        try {
            addressList = geocoder.getFromLocation(latitude,longtitude,1);
            String addressStr = addressList.get(0).getAddressLine(0);
            String areaStr = addressList.get(0).getLocality();
            String cityStr = addressList.get(0).getAdminArea();
            String countryStr = addressList.get(0).getCountryName();
            String postalcodeStr = addressList.get(0).getPostalCode();
            address = addressStr + ", " + areaStr + ", " + cityStr + ", " + countryStr + ", " + postalcodeStr;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return address;
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        latitude = location.getLatitude();
        longtitude = location.getLongitude();
        listener.onLocationChange();
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    public interface IGPSService {
        void onLocationChange ();
    }
}
