//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.healthcare;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.appcompat.app.AppCompatActivity;
import com.example.healthcare.R.id;
import com.example.healthcare.R.layout;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class CardLadActivity extends AppCompatActivity {
    ListView items;
    TextView total1;
    Button backcart;
    Button checkout;
    Button dateButton;
    Button timeButton;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
    ArrayList list;
    SimpleAdapter sa;
    HashMap<String, String> item;

    public CardLadActivity() {
    }

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(layout.activity_card_lad);
        this.items = (ListView)this.findViewById(id.items);
        this.total1 = (TextView)this.findViewById(id.total1);
        this.backcart = (Button)this.findViewById(id.backcart);
        this.checkout = (Button)this.findViewById(id.checkout);
        this.dateButton = (Button)this.findViewById(id.date);
        this.timeButton = (Button)this.findViewById(id.time1);
        SharedPreferences sharedPreferences = this.getSharedPreferences("shared_pref", 0);
        String username = sharedPreferences.getString("username", "").toString();
        DataBase db = new DataBase(this.getApplicationContext(), "healthcare", (SQLiteDatabase.CursorFactory)null, 1);
        LinkedHashMap<String, Float> dbData = db.getCartData(username, "lab");
        ArrayList<String> displayData = new ArrayList();
        Iterator var7 = dbData.entrySet().iterator();

        while(var7.hasNext()) {
            Map.Entry<String, Float> entry = (Map.Entry)var7.next();
            String productPriceString = "Product: " + (String)entry.getKey() + ", Price: " + entry.getValue();
            displayData.add(productPriceString);
        }

        float sum = 0.0F;

        float val;
        for(Iterator var11 = dbData.values().iterator(); var11.hasNext(); sum += val) {
            val = (Float)var11.next();
        }

        String tsum = String.valueOf(sum);
        this.total1.setText(tsum);
        ArrayAdapter<String> adp = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, displayData);
        this.items.setAdapter(adp);
        this.initDatePicker();
        this.dateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CardLadActivity.this.datePickerDialog.show();
            }
        });
        this.initTimePicker();
        this.timeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CardLadActivity.this.timePickerDialog.show();
            }
        });
        this.backcart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CardLadActivity.this.finish();
                CardLadActivity.this.startActivity(new Intent(CardLadActivity.this, LabTestActivity.class));
            }
        });
        this.checkout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(CardLadActivity.this, LabTestBookActivity.class);
                intent.putExtra("price", CardLadActivity.this.total1.getText());
                intent.putExtra("date", CardLadActivity.this.dateButton.getText());
                intent.putExtra("Time", CardLadActivity.this.timeButton.getText());
                CardLadActivity.this.startActivity(intent);
            }
        });
    }

    private void initTimePicker() {
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                CardLadActivity.this.timeButton.setText(hourOfDay + ":" + minute);
            }
        };
        Calendar cal = Calendar.getInstance();
        int hrs = cal.get(11);
        int min = cal.get(12);
        int style = 2;
        this.timePickerDialog = new TimePickerDialog(this, style, timeSetListener, hrs, min, true);
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                ++month;
                CardLadActivity.this.dateButton.setText(dayOfMonth + "/" + month + "/" + year);
            }
        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(1);
        int month = cal.get(2);
        int day = cal.get(5);
        int style = 2;
        this.datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
        this.datePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis() + 86400000L);
    }
}
