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
import androidx.appcompat.app.AppCompatActivity;
import com.example.healthcare.R.id;
import com.example.healthcare.R.layout;
import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {
    Button back;
    Button Gocart;
    ListView ListView;
    String[][] test = new String[][]{{"test1", "250", "good"}, {"test2", "253", "good"}, {"test3", "1000", "good"}};
    private String[] package_details = new String[]{"Blood Glucose Fasting\nComplete Hemogram\nHbA1c\nIron Studies\nKidney Function Test\nLDH Lactate Dehydrogenase, Serum\nLipid Profile\nLiver Function Test", "Blood Glucose Fasting", "COVID-19 Antibody - IgG"};
    ArrayList list;
    HashMap<String, String> hmap;

    public LabTestActivity() {
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(layout.activity_lab_test);
        this.back = (Button)this.findViewById(id.backlab);
        this.ListView = (ListView)this.findViewById(id.ListView);
        this.list = new ArrayList();

        for(int i = 0; i < this.test.length; ++i) {
            this.hmap = new HashMap();
            this.hmap = new HashMap();
            this.hmap.put("line1", this.test[i][0]);
            this.hmap.put("line2", this.test[i][1]);
            this.hmap.put("line3", this.test[i][2]);
            this.list.add(this.hmap);
        }

        SimpleAdapter sa = new SimpleAdapter(this, this.list, layout.activity_design, new String[]{"line1", "line2", "line3"}, new int[]{id.doct, id.tv1, id.tv22});
        this.ListView.setAdapter(sa);
        this.ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(LabTestActivity.this, LabTestDetailActivity.class);
                intent.putExtra("text1", LabTestActivity.this.test[position][0]);
                intent.putExtra("text2", LabTestActivity.this.package_details[position]);
                intent.putExtra("text3", LabTestActivity.this.test[position][1]);
                LabTestActivity.this.startActivity(intent);
            }
        });
        this.back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                LabTestActivity.this.finish();
                LabTestActivity.this.startActivity(new Intent(LabTestActivity.this, HomeActivity.class));
            }
        });
        this.Gocart = (Button)this.findViewById(id.Gocart);
        this.Gocart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                LabTestActivity.this.startActivity(new Intent(LabTestActivity.this, CardLadActivity.class));
            }
        });
    }
}
