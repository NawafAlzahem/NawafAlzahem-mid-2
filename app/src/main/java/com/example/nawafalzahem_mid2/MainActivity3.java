package com.example.nawafalzahem_mid2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        TextView firstRow=(TextView)findViewById(R.id.firstRow);
        Button readRow1=(Button)findViewById(R.id.readRow1);
        Button deleteRow1=(Button)findViewById(R.id.deleteRow1);
        Button go_to_act1_2=(Button)findViewById(R.id.go_to_act1_2);
        Button go_to_act3_3=(Button)findViewById(R.id.go_to_act3_3);

        DatabaseHelper dbHelper = new DatabaseHelper(this);

        go_to_act1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity3.this,Intro.class));

            }
        });

        go_to_act3_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity3.this,MainActivity2.class));

            }
        });



        readRow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor cursor= dbHelper.getFirstRow();
                if(cursor!=null){
                    firstRow.setText(cursor.getString(0) + "\n"+
                            cursor.getString(1) + "\n"+
                            cursor.getString(2) + "\n"+
                            cursor.getString(3) + "\n"+
                            cursor.getString(4) + "\n");
                }
                else{
                    Toast.makeText(MainActivity3.this,"no data found",Toast.LENGTH_SHORT).show();
                }



            }
        });

        deleteRow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor=dbHelper.deleteFirstRow();
                Toast.makeText(MainActivity3.this,"First row is deleted",Toast.LENGTH_SHORT).show();


            }
        });

    }
}