package com.api.test_tcc_mobile;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.start);

        MaterialButton logoutButton = findViewById(R.id.logout_button);
        MaterialButton profileButton = findViewById(R.id.profile_button);

        logoutButton.setOnClickListener(view -> {
            startActivity(new Intent(Start.this, MainActivity.class));
        });

        profileButton.setOnClickListener(view -> {
            startActivity(new Intent(Start.this, ProfileScene.class));
        });
    }
}
