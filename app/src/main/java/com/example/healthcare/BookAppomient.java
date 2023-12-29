//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.healthcare;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.KeyListener;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import androidx.appcompat.app.AppCompatActivity;
import com.example.healthcare.R.id;
import com.example.healthcare.R.layout;
import java.util.Calendar;

public class BookAppomient extends AppCompatActivity {
    EditText name_doct;
    EditText amount;
    EditText rateing;
    Button timeButton;
    Button dateButton;
    Button Back;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;

    public BookAppomient() {
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(layout.activity_book_appomient);
        this.name_doct = (EditText)this.findViewById(id.uname_reg);
        this.amount = (EditText)this.findViewById(id.uemail_reg);
        this.rateing = (EditText)this.findViewById(id.upass_reg);
        this.timeButton = (Button)this.findViewById(id.time_btn);
        this.dateButton = (Button)this.findViewById(id.date_btn);
        this.Back = (Button)this.findViewById(id.B_back);
        this.name_doct.setKeyListener((KeyListener)null);
        this.amount.setKeyListener((KeyListener)null);
        this.rateing.setKeyListener((KeyListener)null);
        Intent intent = this.getIntent();
        String name = intent.getStringExtra("text1");
        String amo = intent.getStringExtra("text2");
        String rat = intent.getStringExtra("text3");
        this.name_doct.setText(name);
        this.amount.setText(amo);
        this.rateing.setText(rat);
        this.initDatePicker();
        this.dateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                BookAppomient.this.datePickerDialog.show();
            }
        });
        this.initTimePicker();
        this.timeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                BookAppomient.this.timePickerDialog.show();
            }
        });
        this.Back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BookAppomient.this.finish();
                BookAppomient.this.startActivity(new Intent(BookAppomient.this, DoctorDetailActivity.class));
            }
        });
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                ++month;
                BookAppomient.this.dateButton.setText(dayOfMonth + "/" + month + "/" + year);
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

    private void initTimePicker() {
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                BookAppomient.this.timeButton.setText(hourOfDay + ":" + minute);
            }
        };
        Calendar cal = Calendar.getInstance();
        int hrs = cal.get(11);
        int min = cal.get(12);
        int style = 2;
        this.timePickerDialog = new TimePickerDialog(this, style, timeSetListener, hrs, min, true);
    }
}
