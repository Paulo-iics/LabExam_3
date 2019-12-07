package com.example.labexam_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText cn, vn, rd, al;
    DBHelper helper = new DBHelper(this);
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = new DBHelper(this);
        //cursor = helper.getTable();
        cn = findViewById(R.id.ent1);
        vn = findViewById(R.id.ent2);
        rd = findViewById(R.id.ent3);
        al = findViewById(R.id.ent4);
    }

    public void addRecord(View v){
        String codeName = cn.getText().toString();
        String verNo = vn.getText().toString();
        String rDate = rd.getText().toString();
        String api = al.getText().toString();
        long isInserted = helper.insert(codeName, verNo, rDate, api);
        if(isInserted == -1){
            Toast.makeText(this, "record is not saved...", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "record is saved...", Toast.LENGTH_LONG).show();
        }
    }

    public void UpdateRecord(View v){
        String codeName = cursor.getString(1);
        String verNo = cursor.getString(2);
        String rDate = cursor.getString(3);
        String api = cursor.getString(4);
        String id = cursor.getString(0);
        int numUpdated = helper.update(id, codeName, verNo, rDate, api);
        if(numUpdated == 1){
            Toast.makeText(this, "record updated...", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "update failed...", Toast.LENGTH_LONG).show();
        }
    }

    public void DeleteRecord(View v){
        String id = cursor.getString(0);
        int numDeleted = helper.delete(id);
        if (numDeleted == 1){
            Toast.makeText(this, "record removed...", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "deletion failed...", Toast.LENGTH_LONG).show();
        }

    }

    public void moveFirst(View v){
        //Cursor cursor = helper.getTable();
        cursor.moveToFirst();
        String codeName = cursor.getString(1);
        String verNo = cursor.getString(2);
        String relDate = cursor.getString(3);
        String apiLevel = cursor.getString(4);
        cn.setText(codeName);
        vn.setText(verNo);
        rd.setText(relDate);
        al.setText(apiLevel);
    }

    public void moveNext(View v){
        cursor.moveToNext();
        String codeName = cursor.getString(1);
        String verNo = cursor.getString(2);
        String relDate = cursor.getString(3);
        String apiLevel = cursor.getString(4);
        cn.setText(codeName);
        vn.setText(verNo);
        rd.setText(relDate);
        al.setText(apiLevel);
    }

    public void viewData(View v){
        startActivity(new Intent(MainActivity.this, Display.class));
    }


}
