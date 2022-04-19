package com.example.nawafalzahem_mid2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class Intro extends AppCompatActivity {
    private TextView reservation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        DatabaseHelper dbhelper= new DatabaseHelper(this);


        Button add=(Button)findViewById(R.id.add);
        Button act2=(Button)findViewById(R.id.go_to_act2);
        Button act3=(Button)findViewById(R.id.go_to_act3);

        reservation=(TextView)findViewById(R.id.rr);


        EditText et_id=(EditText)findViewById(R.id.et_ID);
        EditText et_name=(EditText)findViewById(R.id.et_Name);
        EditText et_email=(EditText)findViewById(R.id.et_Email);
        EditText et_phone=(EditText)findViewById(R.id.et_Phone);
        EditText et_pid=(EditText)findViewById(R.id.et_PersonalID);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(Intro.this,d,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                ).show();

                boolean myadd= dbhelper.insert(et_id.getText().toString(),
                        et_name.getText().toString(),et_email.getText().toString(),et_phone.getText().toString(),
                        et_pid.getText().toString());

                if(myadd){
                    Toast.makeText(Intro.this,"Added Successfully",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Intro.this,"error",Toast.LENGTH_SHORT).show();

                }
            }
        });

        act2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intro.this,MainActivity2.class));
            }
        });

        act3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intro.this,MainActivity3.class));
            }
        });

    }
    Calendar calendar= Calendar.getInstance();
    DateFormat dateFormat=DateFormat.getDateInstance();

    DatePickerDialog.OnDateSetListener d= new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
            calendar.set(Calendar.YEAR,year);
            calendar.set(Calendar.MONTH,month);
            calendar.set(Calendar.DAY_OF_MONTH,day);
            reservation.setText("your Reservation is set for "+dateFormat.format(calendar.getTime()));

        }

    };
}