//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.healthcare;

import android.annotation.SuppressLint;
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

public class RegistretionActivity extends AppCompatActivity {
    EditText uname_reg;
    EditText uemail_reg;
    EditText upass_reg;
    EditText upass1_reg;
    Button register;
    TextView al_reg;

    public RegistretionActivity() {
    }

    @SuppressLint({"MissingInflatedId"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(layout.activity_registretion);
        this.uname_reg = (EditText)this.findViewById(id.uname_reg);
        this.uemail_reg = (EditText)this.findViewById(id.uemail_reg);
        this.upass_reg = (EditText)this.findViewById(id.upass_reg);
        this.upass1_reg = (EditText)this.findViewById(id.upass1_reg);
        this.register = (Button)this.findViewById(id.BookTest);
        this.al_reg = (TextView)this.findViewById(id.al_reg);
        final DataBase db = new DataBase(this.getApplicationContext(), "healthcare", (SQLiteDatabase.CursorFactory)null, 1);
        this.register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String username = RegistretionActivity.this.uname_reg.getText().toString();
                String email = RegistretionActivity.this.uemail_reg.getText().toString();
                String password = RegistretionActivity.this.upass_reg.getText().toString();
                String pass = RegistretionActivity.this.upass_reg.getText().toString();
                String pass1 = RegistretionActivity.this.upass1_reg.getText().toString();
                if (RegistretionActivity.this.uname_reg.length() != 0 && RegistretionActivity.this.uemail_reg.length() != 0 && RegistretionActivity.this.upass_reg.length() != 0) {
                    if (RegistretionActivity.this.upass1_reg.length() != 0 && pass.equals(pass1)) {
                        db.register(username, email, password);
                        Toast.makeText(RegistretionActivity.this, "Register sucessfull", Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedPreferences = RegistretionActivity.this.getSharedPreferences("name", 0);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("username", username);
                        editor.apply();
                        Intent intent = new Intent(RegistretionActivity.this, LoginActivity.class);
                        RegistretionActivity.this.startActivity(intent);
                    } else {
                        Toast.makeText(RegistretionActivity.this, "Check the password", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(RegistretionActivity.this, "plese fill all details ", Toast.LENGTH_SHORT).show();
                }

            }
        });
        this.al_reg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(RegistretionActivity.this, LoginActivity.class);
                RegistretionActivity.this.startActivity(intent);
            }
        });
    }
}
