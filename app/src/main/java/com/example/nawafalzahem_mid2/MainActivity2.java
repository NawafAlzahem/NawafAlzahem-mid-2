package com.example.nawafalzahem_mid2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        DatabaseHelper dbHelper = new DatabaseHelper(this);

        Button search=(Button)findViewById(R.id.bt_search);
        Button act1=(Button)findViewById(R.id.go_to_act1);
        Button act3=(Button)findViewById(R.id.go_to_act3_2);

        TextView Result= (TextView)findViewById(R.id.result);
        EditText input=(EditText)findViewById(R.id.et_keyWord);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor= dbHelper.getSpecificResult(input.getText().toString());
                if(cursor!=null){
                    Result.setText("match found: id= "+cursor.getString(0) +"\n name ="+cursor.getString(1));
                }
                else{
                    Toast.makeText(MainActivity2.this,"no match found",Toast.LENGTH_SHORT).show();
                }

            }
        });

        act1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity2.this, Intro.class));

            }
        });
        act3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity2.this,MainActivity3.class));
            }
        });


    }
}