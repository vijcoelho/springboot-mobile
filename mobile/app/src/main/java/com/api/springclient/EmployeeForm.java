package com.api.springclient;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.api.springclient.model.Employee;
import com.api.springclient.retrofit.EmployeeApi;
import com.api.springclient.retrofit.RetrofitService;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeeForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeComponents();
    }

    public void initializeComponents() {
        TextInputEditText inputEditTextName = findViewById(R.id.form_textFieldName);
        TextInputEditText inputEditTextBranch = findViewById(R.id.form_textFieldBranch);
        TextInputEditText inputEditTextLocation = findViewById(R.id.form_textFieldLocation);
        MaterialButton buttonSave = findViewById(R.id.form_buttonSave);

        RetrofitService retrofitService = new RetrofitService();
        EmployeeApi employeeApi = retrofitService.getRetrofit().create(EmployeeApi.class);

        buttonSave.setOnClickListener(view -> {
//          String name = inputEditTextName.getText().toString();   U can do like this too!
//          String branch = inputEditTextBranch.getText().toString();
//          String location = inputEditTextLocation.getText().toString();

            String name = String.valueOf(inputEditTextName.getText());
            String branch = String.valueOf(inputEditTextBranch.getText());
            String location = String.valueOf(inputEditTextLocation.getText());

            Employee employee = new Employee();
            employee.setName(name);
            employee.setBranch(branch);
            employee.setLocation(location);

            employeeApi.save(employee)
                    .enqueue(new Callback<Employee>() {
                        @Override
                        public void onResponse(Call<Employee> call, Response<Employee> response) {
                            Toast.makeText(EmployeeForm.this, "Save successful!", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<Employee> call, Throwable t) {
                            Toast.makeText(EmployeeForm.this, "Save falied!!!", Toast.LENGTH_SHORT).show();
                            Logger.getLogger(EmployeeForm.class.getName()).log(Level.SEVERE, "ERROR:", t);
                        }
                    });
        });
    }
}