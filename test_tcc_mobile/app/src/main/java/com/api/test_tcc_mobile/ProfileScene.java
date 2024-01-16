package com.api.test_tcc_mobile;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.api.test_tcc_mobile.model.User;
import com.api.test_tcc_mobile.retrofit.RetrofitServer;
import com.api.test_tcc_mobile.retrofit.UserRetrofit;
import com.google.android.material.button.MaterialButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileScene extends AppCompatActivity {

    private RetrofitServer retrofit;
    private UserRetrofit userRetrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profilescene);

        MaterialButton homeProfile = findViewById(R.id.home_profile);

        homeProfile.setOnClickListener(view -> {
            AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.button_scale);
            animatorSet.setTarget(homeProfile);
            animatorSet.start();

            startActivity(new Intent(ProfileScene.this, Start.class));
        });

        TextView textViewName = findViewById(R.id.textViewName);
        TextView textViewEmail = findViewById(R.id.textViewEmail);
        TextView textViewAddress = findViewById(R.id.textViewAddress);

        retrofit = new RetrofitServer();
        userRetrofit = retrofit.getRetrofit().create(UserRetrofit.class);

        Call<User> call = userRetrofit.getCurrentUser();
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()) {
                    User currentUser = response.body();

                    if(currentUser != null) {
                        textViewName.setText(currentUser.getName());
                        textViewEmail.setText(currentUser.getEmail());
                        textViewAddress.setText(currentUser.getAddress());
                    }
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(ProfileScene.this, "Error to find the user information's", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
