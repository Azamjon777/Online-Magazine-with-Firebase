package com.example.mymagazine.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mymagazine.R;
import com.example.mymagazine.Model.Users;
import com.example.mymagazine.Prevalent.Prevalent;
import com.example.mymagazine.UI.Admin.AdminCategoryChangeActivity;
import com.example.mymagazine.UI.Users.HomeActivity;
import com.example.mymagazine.UI.Users.MainActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rey.material.widget.CheckBox;

import io.paperdb.Paper;

public class LoginActivity extends AppCompatActivity {
    private Button loginBtn;
    private EditText usernameInput, phoneInput, passwordInput;
    private ProgressDialog loadingBar;
    private TextView adminLink, notAdminLink;

    private String parentDbName = "Users";
    private CheckBox checkBoxRememberMe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBtn = findViewById(R.id.login_btn);
        phoneInput = findViewById(R.id.login_phone_input);
        passwordInput = findViewById(R.id.login_password_input);
        loadingBar = new ProgressDialog(this);
        checkBoxRememberMe = findViewById(R.id.login_checkbox);
        Paper.init(this);

        adminLink = findViewById(R.id.admin_panel_link);
        notAdminLink = findViewById(R.id.not_admin_panel_link);

        loginBtn.setOnClickListener((v) -> { loginUser(); });

        adminLink.setOnClickListener(v -> {
            adminLink.setVisibility(View.INVISIBLE);
            notAdminLink.setVisibility(View.VISIBLE);
            loginBtn.setText("???????? ?????? ????????????");
            parentDbName = "Admins";
        });
        
        notAdminLink.setOnClickListener((v -> {
            adminLink.setVisibility(View.VISIBLE);
            notAdminLink.setVisibility(View.INVISIBLE);
            loginBtn.setText("??????????");
            parentDbName = "Users";
        }));
    }

    private void loginUser() {
        String phone = phoneInput.getText().toString();
        String password = passwordInput.getText().toString();
        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "?????????????? ?????????? ????????????????", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "?????????????? ????????????", Toast.LENGTH_SHORT).show();
        }
        else {
            loadingBar.setTitle("???????? ?? ??????????????");
            loadingBar.setMessage("???????????????????? ??????????????????...");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();

            ValidateUser( phone, password);
        }
    }

    private void ValidateUser(String phone, String password) {

        if (checkBoxRememberMe.isChecked()){
            Paper.book().write(Prevalent.UserPhoneKey, phone);
            Paper.book().write(Prevalent.UserPasswordKey, password);
        }

        final DatabaseReference rootRefLogin;
        rootRefLogin = FirebaseDatabase.getInstance().getReference();
        rootRefLogin.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.child(parentDbName).child(phone).exists()){
                    Users usersData = snapshot.child(parentDbName).child(phone).getValue(Users.class);
                    assert usersData != null;
                    if (usersData.getPhone().equals(phone)) {
                        if (usersData.getPassword().equals(password)) {
                            if (parentDbName.equals("Users")){
                                loadingBar.dismiss();
                                Toast.makeText(LoginActivity.this, "???????????????? ????????!", Toast.LENGTH_SHORT).show();
                                Intent homeIntent = new Intent(LoginActivity.this, HomeActivity.class);
                                startActivity(homeIntent);
                                finish();
                            }else if (parentDbName.equals("Admins")){
                                loadingBar.dismiss();
                                Toast.makeText(LoginActivity.this, "???????????????? ????????!", Toast.LENGTH_SHORT).show();
                                Intent adminIntent = new Intent(LoginActivity.this, AdminCategoryChangeActivity.class);
                                startActivity(adminIntent);
                                finish();
                            }
                        }else{
                            loadingBar.dismiss();
                            Toast.makeText(LoginActivity.this, "???????????? ????????????????????????", Toast.LENGTH_SHORT).show();
                        }
                    }
                }else {
                    loadingBar.dismiss();
                    Toast.makeText(LoginActivity.this, "?????????????? ?? ?????????????? " + phone + " ???? ????????????????????",
                            Toast.LENGTH_SHORT).show();
                    Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                    startActivity(registerIntent);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}