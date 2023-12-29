//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.healthcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.example.healthcare.R.id;
import com.example.healthcare.R.layout;

public class FindDoctorActivity extends AppCompatActivity {
    CardView Back;
    CardView FamilyPhysicians;
    CardView Dietician;
    CardView Dentist;
    CardView Cardiologist;
    CardView surgeon;

    public FindDoctorActivity() {
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(layout.activity_find_doctor);
        this.FamilyPhysicians = (CardView)this.findViewById(id.FamilyPhysicians);
        this.Dietician = (CardView)this.findViewById(id.Dietician);
        this.Dentist = (CardView)this.findViewById(id.Dentist);
        this.Cardiologist = (CardView)this.findViewById(id.Cardiologist);
        this.surgeon = (CardView)this.findViewById(id.surgeon);
        this.FamilyPhysicians.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(FindDoctorActivity.this, DoctorDetailActivity.class);
                intent.putExtra("title", "FamilyPhysicians");
                FindDoctorActivity.this.startActivity(intent);
            }
        });
        this.Dietician.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(FindDoctorActivity.this, DoctorDetailActivity.class);
                intent.putExtra("title", "Dietician");
                FindDoctorActivity.this.startActivity(intent);
            }
        });
        this.Dentist.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(FindDoctorActivity.this, DoctorDetailActivity.class);
                intent.putExtra("title", "Dentist");
                FindDoctorActivity.this.startActivity(intent);
            }
        });
        this.Cardiologist.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(FindDoctorActivity.this, DoctorDetailActivity.class);
                intent.putExtra("title", "Cardiologist");
                FindDoctorActivity.this.startActivity(intent);
            }
        });
        this.surgeon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(FindDoctorActivity.this, DoctorDetailActivity.class);
                intent.putExtra("title", "surgeon");
                FindDoctorActivity.this.startActivity(intent);
            }
        });
        this.Back = (CardView)this.findViewById(id.Back);
        this.Back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FindDoctorActivity.this.finish();
                Intent intent = new Intent(FindDoctorActivity.this, BookAppomient.class);
                FindDoctorActivity.this.startActivity(intent);
            }
        });
    }
}
