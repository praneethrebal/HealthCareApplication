//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.healthcare;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.method.KeyListener;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.healthcare.R.id;
import com.example.healthcare.R.layout;

public class LabTestDetailActivity extends AppCompatActivity {
    TextView package_name;
    TextView total;
    EditText editText;
    Button backlab;
    Button cart1;

    public LabTestDetailActivity() {
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(layout.activity_lab_test_detail);
        this.package_name = (TextView)this.findViewById(id.package_name);
        this.total = (TextView)this.findViewById(id.total);
        this.editText = (EditText)this.findViewById(id.editText);
        this.editText.setKeyListener((KeyListener)null);
        final Intent intent = this.getIntent();
        this.package_name.setText(intent.getStringExtra("text1"));
        this.editText.setText(intent.getStringExtra("text2"));
        this.total.setText(intent.getStringExtra("text3"));
        Log.d("tot", ".." + this.total);
        this.cart1 = (Button)this.findViewById(id.cart1);
        this.cart1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences sharedPreferences = LabTestDetailActivity.this.getSharedPreferences("shared_pref", 0);
                String username = sharedPreferences.getString("username", "").toString();
                String product = LabTestDetailActivity.this.package_name.getText().toString();
                String prices = intent.getStringExtra("text3");
                float price = Float.parseFloat(prices);
                Log.d("price", ".." + price);
                DataBase db = new DataBase(LabTestDetailActivity.this.getApplicationContext(), "healthcare", (SQLiteDatabase.CursorFactory)null, 1);
                if (db.checkcart(username, product) == 1) {
                    Toast.makeText(LabTestDetailActivity.this.getApplicationContext(), "present", Toast.LENGTH_SHORT).show();
                } else {
                    db.addcart(username, product, price, "lab");
                    Toast.makeText(LabTestDetailActivity.this.getApplicationContext(), "added", Toast.LENGTH_SHORT).show();
                }

            }
        });
        this.backlab = (Button)this.findViewById(id.backlab);
        this.backlab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                LabTestDetailActivity.this.finish();
                LabTestDetailActivity.this.startActivity(new Intent(LabTestDetailActivity.this, LabTestActivity.class));
            }
        });
    }
}
