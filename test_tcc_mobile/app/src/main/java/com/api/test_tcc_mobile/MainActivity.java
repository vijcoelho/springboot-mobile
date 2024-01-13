package com.api.test_tcc_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

        TextInputEditText inputEditTextEmail = findViewById(R.id.textInputEmail);
        TextInputEditText textInputEditPassword = findViewById(R.id.textInputPassword);
        MaterialButton login_Button = findViewById(R.id.login_button);

        retrofit = new RetrofitServer();

        login_Button.setOnClickListener(view -> {
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
                        Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, Start.class));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Authentication failed", Toast.LENGTH_SHORT).show();
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
