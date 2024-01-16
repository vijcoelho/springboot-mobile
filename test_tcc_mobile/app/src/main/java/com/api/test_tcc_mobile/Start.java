package com.api.test_tcc_mobile;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.start);

        MaterialButton profileButton = findViewById(R.id.profile_button);

        profileButton.setOnClickListener(view -> {
            AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.button_scale);
            animatorSet.setTarget(profileButton);
            animatorSet.start();

            startActivity(new Intent(Start.this, ProfileScene.class));
        });
    }
}
