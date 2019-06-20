package com.anhtam.tikihome.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.anhtam.tikihome.R;
import com.anhtam.tikihome.base.BaseActivity;
import com.anhtam.tikihome.base.Constant;

public class SplashActivity extends BaseActivity {

    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        progressBar = findViewById(R.id.progressBar);
        run(() -> startLocationUpdates(), 1000);
    }

    @Override
    public void onRequestPermissionsResult(final int requestCode, @NonNull final String[] permissions, @NonNull final int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == Constant.LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted.
                Log.d("GPS", "Permission granted.");
                startLocationUpdates();
            } else {
                // User refused to grant permission. You can add AlertDialog here
                Toast.makeText(this, "You didn't give permission to access device location", Toast.LENGTH_LONG).show();
                new Intent(SplashActivity.this, MainActivity.class);
            }
        }
    }

    @Override
    public void onPermistionGranted() {
        super.onPermistionGranted();
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
    }
}
