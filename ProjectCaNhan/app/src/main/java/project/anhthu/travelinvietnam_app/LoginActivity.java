package project.anhthu.travelinvietnam_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.Firebase;

public class LoginActivity extends AppCompatActivity {
    private TextInputLayout emailInput, passwordInput;
    private Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    emailInput = findViewById(R.id.textInputLayout2);



    }
}