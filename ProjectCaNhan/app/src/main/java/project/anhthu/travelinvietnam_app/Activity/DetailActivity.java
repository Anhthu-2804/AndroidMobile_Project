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
    private ImageView picImg, back_arrow, play_btn;

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
        play_btn = findViewById(R.id.play_btn);


        play_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        play_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, PlayerVideoActivity.class);
                intent.putExtra("VIDEO_URL", "https://firebasestorage.googleapis.com/v0/b/traveling-online-app.appspot.com/o/The%20Best%204K%20Aquarium%20for%20Relaxation%20II%20%F0%9F%90%A0%20Relaxing%20Oceanscapes%20-%20Sleep%20Meditation%204K%20UHD%20Screensaver.mp4?alt=media&token=09a66289-851c-4da3-9f1f-433823e38949"); // Đường link của video
                startActivity(intent);
            }
        });


        locationTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this, ActivityGoogleMap.class);

                startActivity(intent);
            }
        });

    }
}