package com.example.homework_4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener  {
EditText birtday,registration,name,number;
CheckBox grade;
Button clickBtn;
int hour, minute;
String a,b,c,d,e;
Spinner spn;
ArrayList arrayList;
ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        birtday = findViewById(R.id.editTextTextPersonName);
        registration= findViewById(R.id.editTextTextPersonName2);
        clickBtn = findViewById(R.id.button3);
        number = findViewById(R.id.numberedt);
        name = findViewById(R.id.nameedt);
        grade = findViewById(R.id.checkBox);
        spn = findViewById(R.id.spinner);
        arrayList = new ArrayList<>();
        arrayList.add("Bachelor");
        arrayList.add("Master");
        arrayList.add("Doctorate");
        arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,arrayList);
        spn.setAdapter(arrayAdapter);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             showdate();
            }
        });
        clickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (grade.isChecked()) {
                    a = birtday.getText().toString();
                    b = registration.getText().toString();
                    c = name.getText().toString();
                    d = number.getText().toString();
                    e = spn.getSelectedItem().toString();

                    Intent int1 = new Intent(MainActivity.this,MainActivity2.class);
                    int1.putExtra("date",a);
                    int1.putExtra("time",b);
                    int1.putExtra("name",c);
                    int1.putExtra("number",d);
                    int1.putExtra("spinner",e);
                    startActivity(int1);
                }else {
                    Toast.makeText(MainActivity.this, "Please click the Agree button if you would like to continue the process", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void showdate(){
        DatePickerDialog dgg = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
                );
        dgg.show();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
       String date = i2 + "/" + (i1 + 1) + "/" + i;
       birtday.setText(date);
    }

    public void tmpicker(){
        TimePickerDialog.OnTimeSetListener tmr = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                hour = selectedHour;
                minute = selectedMinute;
                registration.setText(String.format(Locale.getDefault(),"%02d:%02d",hour,minute));
            }
        };
        TimePickerDialog newdg = new TimePickerDialog(this,tmr,hour,minute,true);
        newdg.show();
    }


    public void tmp(View view) {
        tmpicker();
    }
}