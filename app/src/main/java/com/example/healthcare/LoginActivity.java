//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.healthcare;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.healthcare.R.id;
import com.example.healthcare.R.layout;

public class LoginActivity extends AppCompatActivity {
    EditText user_name;
    EditText user_password;
    Button login_button;
    TextView Register_new;

    public LoginActivity() {
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(layout.activity_login);
        this.user_name = (EditText)this.findViewById(id.uname_reg);
        this.user_password = (EditText)this.findViewById(id.upass_reg);
        this.login_button = (Button)this.findViewById(id.BookTest);
        this.Register_new = (TextView)this.findViewById(id.al_reg);
        final DataBase db = new DataBase(this.getApplicationContext(), "healthcare", (SQLiteDatabase.CursorFactory)null, 1);
        this.login_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String name = LoginActivity.this.user_name.getText().toString();
                String pass = LoginActivity.this.user_password.getText().toString();
                if (name.length() != 0 && pass.length() != 0) {
                    if (db.login(name, pass) == 1) {
                        Toast.makeText(LoginActivity.this, "sucessfull", Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedPreferences = LoginActivity.this.getSharedPreferences("shared_pref", 0);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("username", name);
                        editor.apply();
                        LoginActivity.this.startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                    } else {
                        Toast.makeText(LoginActivity.this, "Plese check login details", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "fill all details", Toast.LENGTH_SHORT).show();
                }

            }
        });
        this.Register_new.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                LoginActivity.this.startActivity(new Intent(LoginActivity.this, RegistretionActivity.class));
            }
        });
    }
}
