package com.api.test_tcc_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
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
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private CheckBox rememberMeCheckBox;
    private MaterialButton login_Button;
    private TextInputEditText inputEditTextEmail, textInputEditPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        retrofit = new RetrofitServer();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        sharedPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        inputEditTextEmail = findViewById(R.id.textInputEmail);
        textInputEditPassword = findViewById(R.id.textInputPassword);
        login_Button = findViewById(R.id.login_button);
        rememberMeCheckBox = findViewById(R.id.rememberMe_checkBox);

        boolean rememberMe = sharedPreferences.getBoolean("rememberMe", false);
        if(rememberMe) {
            String savedEmail = sharedPreferences.getString("email", "");
            String savedPassword = sharedPreferences.getString("password", "");
            inputEditTextEmail.setText(savedEmail);
            textInputEditPassword.setText(savedPassword);
            rememberMeCheckBox.setChecked(true);
        }

        login_Button.setOnClickListener(v -> loginOnClick(v));
    }

    public void loginOnClick(View view) {
        if(view == login_Button) {
            AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.button_scale);
            animatorSet.setTarget(login_Button);
            animatorSet.start();

            String email = String.valueOf(inputEditTextEmail.getText());
            String password = String.valueOf(textInputEditPassword.getText());

            User user = new User();
            user.setEmail(email);
            user.setPassword(password);

            authenticateUser(user);
        }
    }

    private void authenticateUser(User user) {
        UserRetrofit userRetrofit = retrofit.getAuthUser();

        Call<ResponseBody> call = userRetrofit.authenticateUser(user);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        if(rememberMeCheckBox.isChecked()) {
                            editor.putBoolean("rememberMe", true);
                            editor.putString("email", user.getEmail());
                            editor.putString("password", user.getPassword());
                            editor.apply();
                        } else {
                            editor.putBoolean("rememberMe", false);
                            editor.remove("email");
                            editor.remove("password");
                            editor.apply();
                        }
                        startActivity(new Intent(MainActivity.this, Start.class));
                        finish();
                    } catch(Exception e) {
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
