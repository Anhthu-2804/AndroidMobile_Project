package project.anhthu.travelinvietnam_app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import project.anhthu.travelinvietnam_app.R;

public class ProfileActivity extends AppCompatActivity {
    ImageView back ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        back = findViewById(R.id.back);
        back.setOnClickListener(v -> finish());

    }
}