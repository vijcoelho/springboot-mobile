package com.api.test_tcc_mobile;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.start);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        MaterialButton profileButton = findViewById(R.id.profile_button);

        profileButton.setOnClickListener(view -> {
            AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.button_scale);
            animatorSet.setTarget(profileButton);
            animatorSet.start();

            startActivity(new Intent(Start.this, ProfileScene.class));
            overridePendingTransition(R.animator.slide_in_left, R.animator.slide_out_right);
            finish();
        });
    }
}
