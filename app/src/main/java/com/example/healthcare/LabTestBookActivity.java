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
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.healthcare.R.id;
import com.example.healthcare.R.layout;

public class LabTestBookActivity extends AppCompatActivity {
    EditText FullName;
    EditText Addres;
    EditText Ph;
    EditText PinCode;
    Button BookTest;

    public LabTestBookActivity() {
    }

    @SuppressLint({"MissingInflatedId"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(layout.activity_lab_test_book);
        this.FullName = (EditText)this.findViewById(id.FullName);
        this.Addres = (EditText)this.findViewById(id.Adderse);
        this.Ph = (EditText)this.findViewById(id.Ph);
        this.PinCode = (EditText)this.findViewById(id.PinCode);
        this.BookTest = (Button)this.findViewById(id.BookTest);
        Intent intent = this.getIntent();
        final String price = intent.getStringExtra("price");
        final String date = intent.getStringExtra("date");
        final String time = intent.getStringExtra("Time");
        this.BookTest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences sharedPreferences = LabTestBookActivity.this.getSharedPreferences("shared_pref", 0);
                String username = sharedPreferences.getString("username", "").toString();
                DataBase db = new DataBase(LabTestBookActivity.this.getApplicationContext(), "healthcare", (SQLiteDatabase.CursorFactory)null, 1);
                db.addOrder(username, LabTestBookActivity.this.FullName.getText().toString(), LabTestBookActivity.this.Addres.getText().toString(), LabTestBookActivity.this.Ph.getText().toString(), Integer.parseInt(LabTestBookActivity.this.PinCode.getText().toString()), date.toString(), time.toString(), Float.parseFloat(price.toString()), "lab");
                db.removecart(username, "lab");
                Toast.makeText(LabTestBookActivity.this, "orderSucessfull", 0).show();
                LabTestBookActivity.this.startActivity(new Intent(LabTestBookActivity.this, HomeActivity.class));
            }
        });
    }
}
