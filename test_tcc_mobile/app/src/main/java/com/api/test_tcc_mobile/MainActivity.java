package com.api.test_tcc_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.api.test_tcc_mobile.model.User;
import com.api.test_tcc_mobile.retrofit.RetrofitServer;
import com.api.test_tcc_mobile.retrofit.UserRetrofit;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.logging.Level;
import java.util.logging.Logger;

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

        Call<String> call = userRetrofit.authenticateUser(user);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    showToast("Login successful");
                } else {
                    showToast("Authentication failed: " + response.message());
                }
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                showToast("Error during authentication");
                Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, "ERROR:", t);
            }
        });
    }

    private void showToast(String message) {
        runOnUiThread(() -> Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show());
    }
}

