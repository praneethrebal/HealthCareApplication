//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.healthcare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.healthcare.R.id;
import com.example.healthcare.R.layout;
import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailActivity extends AppCompatActivity {
    TextView DefultText;
    ListView listView;
    String[][] str1 = new String[][]{{"doctoe1", "500", "4.5"}, {"doctoe2", "500", "4.00"}, {"doctoe3", "500", "3.5"}};
    String[][] str2 = new String[][]{{"doctoe1", "500", "4.5"}, {"doctoe2", "500", "4.00"}, {"doctoe3", "500", "3.5"}};
    String[][] str3 = new String[][]{{"doctoe1", "500", "4.5"}, {"doctoe2", "500", "4.00"}, {"doctoe3", "500", "3.5"}};
    String[][] str4 = new String[][]{{"doctoe1", "500", "4.5"}, {"doctoe2", "500", "4.00"}, {"doctoe3", "500", "3.5"}};
    String[][] str5 = new String[][]{{"doctoe1", "500", "4.5"}, {"doctoe2", "500", "4.00"}, {"doctoe3", "500", "3.5"}};
    String[][] str = new String[0][];
    ArrayList list;
    HashMap<String, String> item;
    Button back;

    public DoctorDetailActivity() {
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(layout.activity_doctor_detail);
        this.back = (Button)this.findViewById(id.backlab);
        this.DefultText = (TextView)this.findViewById(id.package_name);
        Intent intent = this.getIntent();
        String name = intent.getStringExtra("title");
        this.DefultText.setText(name);
        this.listView = (ListView)this.findViewById(id.ListView);
        this.back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DoctorDetailActivity.this.finish();
                Intent intent = new Intent(DoctorDetailActivity.this, FindDoctorActivity.class);
                DoctorDetailActivity.this.startActivity(intent);
            }
        });
        this.list = new ArrayList();
        if (name.compareTo("FamilyPhysicians") == 0) {
            this.str = this.str1;
        } else if (name.compareTo("Dietician") == 0) {
            this.str = this.str2;
        } else if (name.compareTo("Dentist") == 0) {
            this.str = this.str3;
        } else if (name.compareTo("Cardiologist") == 0) {
            this.str = this.str4;
        } else if (name.compareTo("surgeon") == 0) {
            this.str = this.str5;
        }

        for(int i = 0; i < this.str.length; ++i) {
            this.item = new HashMap();
            this.item = new HashMap();
            this.item.put("Line 1", this.str[i][0]);
            this.item.put("Line 2", this.str[i][1]);
            this.item.put("Line 3", this.str[i][2]);
            this.list.add(this.item);
        }

        SimpleAdapter sa = new SimpleAdapter(this, this.list, layout.activity_design, new String[]{"Line 1", "Line 2", "Line 3"}, new int[]{id.doct, id.tv1, id.tv22});
        this.listView.setAdapter(sa);
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(DoctorDetailActivity.this, BookAppomient.class);
                intent.putExtra("text1", DoctorDetailActivity.this.str[i][0]);
                intent.putExtra("text2", DoctorDetailActivity.this.str[i][1]);
                intent.putExtra("text3", DoctorDetailActivity.this.str[i][2]);
                DoctorDetailActivity.this.startActivity(intent);
            }
        });
    }
}
