package project.anhthu.travelinvietnam_app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import project.anhthu.travelinvietnam_app.Domain.PopularDomain;
import project.anhthu.travelinvietnam_app.R;

public class DetailActivity extends AppCompatActivity {
    private TextView titleTxt, locationTxt, sunTxt, temperatureTxt, wifiTxt, descriptionTxt, scoreTxt;
    private PopularDomain items;
    private ImageView picImg, back_arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initView();
        setVariable();
    }

    private void setVariable(){
        items = (PopularDomain) getIntent().getSerializableExtra("object");
        titleTxt.setText(items.getTitle());
        locationTxt.setText(items.getLocation());
        sunTxt.setText(items.getSun());
        temperatureTxt.setText(items.getTemperature() + "C");
        descriptionTxt.setText(items.getDescription());
        scoreTxt.setText("" + (int)items.getScore());

        if(items.isWifi()){
            wifiTxt.setText("Wifi");
        } else {
            wifiTxt.setText("No-Wifi");
        }



        int drawableResId = getResources().getIdentifier(items.getPic(), "drawable", getPackageName());
        Glide.with(this).load(drawableResId).into(picImg);
        back_arrow.setOnClickListener(v -> finish());

    }

    private void initView(){
        titleTxt = findViewById(R.id.titleTxt);
        locationTxt = findViewById(R.id.locationTxt);
        sunTxt = findViewById(R.id.sunTxt);
        temperatureTxt = findViewById(R.id.temperatureTxt);
        wifiTxt = findViewById(R.id.wifiTxt);
        descriptionTxt = findViewById(R.id.descriptionTxt);
        scoreTxt = findViewById(R.id.scoreTxt);
        back_arrow = findViewById(R.id.back_arrow);
        picImg = findViewById(R.id.picImg);

        locationTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, ActivityGoogleMap.class);

                startActivity(intent);
            }
        });

    }
}