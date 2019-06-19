package com.anhtam.tikihome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout csCheckBox;
    private boolean isTikiNow = true;
    private ImageView imgCheckBox;
    private TextView tvLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView ();
        initData ();
        initControls ();
    }

    private void initView (){
        csCheckBox = findViewById(R.id.csCheckBox);
        imgCheckBox = findViewById(R.id.imgCheckBox);
        tvLocation = findViewById(R.id.tvLocation);
    }

    private void initData (){
        String htmlString="<u>" + getResources().getString(R.string.address_example)+ "</u>";
        tvLocation.setText(Html.fromHtml(htmlString));
    }

    private void initControls (){
        csCheckBox.setOnClickListener(v -> onCheckTikiNow ());
    }

    private void onCheckTikiNow (){
        isTikiNow = !isTikiNow;
        imgCheckBox.setImageDrawable(isTikiNow ? getResources().getDrawable(R.drawable.ic_tick) : getResources().getDrawable(R.drawable.ic_untick));
    }
}
