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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.healthcare.R.layout;
import java.util.ArrayList;

public class OrderDetailsActivity extends AppCompatActivity {
    ListView OrderData;
    Button BackOrd;

    public OrderDetailsActivity() {
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(layout.activity_order_details);
        SharedPreferences sharedPreferences = this.getSharedPreferences("shared_pref", 0);
        String username = sharedPreferences.getString("username", "").toString();
        DataBase db = new DataBase(this.getApplicationContext(), "healthcare", (SQLiteDatabase.CursorFactory)null, 1);
        ArrayList<String> arr = db.getOrder(username);
        ArrayAdapter<String> adp = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, arr);
        this.OrderData.setAdapter(adp);
        this.BackOrd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                OrderDetailsActivity.this.finish();
                OrderDetailsActivity.this.startActivity(new Intent(OrderDetailsActivity.this, HomeActivity.class));
            }
        });
    }
}
