package com.example.labexam_3;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Display extends Activity {
    DBHelper dbHelper;

    TextView codeName;
    TextView verNo;
    TextView relDate;
    TextView apiLevel;


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        codeName = findViewById(R.id.cName);
        verNo = findViewById(R.id.vNo);
        relDate = findViewById(R.id.rdate);
        apiLevel = findViewById(R.id.alevel);

        dbHelper = new DBHelper(this);

    }
}
