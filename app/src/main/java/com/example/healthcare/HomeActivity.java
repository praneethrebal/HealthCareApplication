//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.healthcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.example.healthcare.R.id;
import com.example.healthcare.R.layout;

public class HomeActivity extends AppCompatActivity {
    CardView Logoutcv;
    CardView Labtestcv;
    CardView Buymecidencv;
    CardView Finddoctorcv;
    CardView Helpdoctorcv;
    CardView Orderdetailscv;

    public HomeActivity() {
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(layout.activity_home);
        this.Labtestcv = (CardView)this.findViewById(id.cardLabtest);
        this.Buymecidencv = (CardView)this.findViewById(id.cardBuyMecdien);
        this.Finddoctorcv = (CardView)this.findViewById(id.cardFindDoctor);
        this.Helpdoctorcv = (CardView)this.findViewById(id.cardHelpDoctor);
        this.Orderdetailscv = (CardView)this.findViewById(id.cardOrderDetails);
        this.Logoutcv = (CardView)this.findViewById(id.cardLogout);
        this.Finddoctorcv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, FindDoctorActivity.class);
                HomeActivity.this.startActivity(intent);
            }
        });
        this.Helpdoctorcv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Comming soon...", 0).show();
            }
        });
        this.Orderdetailscv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                HomeActivity.this.startActivity(new Intent(HomeActivity.this, OrderDetailsActivity.class));
            }
        });
        this.Labtestcv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, LabTestActivity.class);
                HomeActivity.this.startActivity(intent);
            }
        });
        this.Labtestcv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                HomeActivity.this.startActivity(new Intent(HomeActivity.this, LabTestActivity.class));
            }
        });
        this.Logoutcv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                HomeActivity.this.finish();
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                HomeActivity.this.startActivity(intent);
            }
        });
        this.Buymecidencv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Comming soon...", 0).show();
            }
        });
    }
}
