package com.api.test_tcc_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import com.api.test_tcc_mobile.model.User;
import com.api.test_tcc_mobile.retrofit.RetrofitServer;
import com.api.test_tcc_mobile.retrofit.UserRetrofit;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RetrofitServer retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        TextInputEditText inputEditTextEmail = findViewById(R.id.textInputEmail);
        TextInputEditText textInputEditPassword = findViewById(R.id.textInputPassword);

        ColorStateList colorStateList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.black));
        ViewCompat.setBackgroundTintList(inputEditTextEmail, colorStateList);
        ViewCompat.setBackgroundTintList(textInputEditPassword, colorStateList);

        MaterialButton login_Button = findViewById(R.id.login_button);

        retrofit = new RetrofitServer();

        login_Button.setOnClickListener(view -> {
            AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.button_scale);
            animatorSet.setTarget(login_Button);
            animatorSet.start();

            String email = String.valueOf(inputEditTextEmail.getText());
            String password = String.valueOf(textInputEditPassword.getText());

            User user = new User();
            user.setEmail(email);
            user.setPassword(password);

            authenticateUser(user);
        });
    }

    private void authenticateUser(User user) {
        UserRetrofit userRetrofit = retrofit.getAuthUser();

        Call<ResponseBody> call = userRetrofit.authenticateUser(user);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        String responseBodyString = response.body().string();
                        startActivity(new Intent(MainActivity.this, Start.class));
                        finish();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    if (response.errorBody() != null) {
                        try {
                            String errorBody = response.errorBody().string();
                            Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, "Error Body:", errorBody);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error during authentication", Toast.LENGTH_SHORT).show();
                Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, "ERROR:", t);
            }
        });
    }
}
