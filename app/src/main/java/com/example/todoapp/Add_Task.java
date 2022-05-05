package com.example.todoapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Add_Task extends AppCompatActivity {

    Button btn_Color, btn_Save,task_color;
    EditText txt_taskTitle, txt_taskDetail;
    TextView txt_modified;
    String Color_value;
    Boolean IsColorSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_back_arrow);

        txt_taskTitle = findViewById(R.id.input_text_taskTitle);
        txt_taskDetail = findViewById(R.id.input_text_taskDetails);
       task_color = findViewById(R.id.task_colorTV2);

        Date src_date = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());

        String modified = df.format(src_date);
        String date = df.format(src_date);



        btn_Color = findViewById(R.id.button_setColor);
        btn_Save = findViewById(R.id.button_save);

        btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txt_taskTitle.getText().length()==0){
                    txt_taskTitle.setError("Please Add Title");
                    txt_taskTitle.requestFocus();
                }
                else if (txt_taskDetail.getText().length()==0){
                    txt_taskDetail.setError("Please Add Details");
                    txt_taskDetail.requestFocus();
                }

                else if (IsColorSelected==false){
                    Toast.makeText(Add_Task.this,"Please Select Task Color First",Toast.LENGTH_LONG).show();
                    return;
                }
                else {
                Class_Database add_db = new Class_Database(Add_Task.this);
                add_db.p_add_task(txt_taskTitle.getText().toString().trim(),
                                    date.toString().trim(),
                                    modified.toString().trim(),
                                    txt_taskDetail.getText().toString().trim(),
                                    Color_value.toString().trim());
                finish();
            }}
        });
        btn_Color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Color_Picker();

            }
        });

    }

    public boolean onOptionsItemSelected(MenuItem back){
        switch (back.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(back);

    }
    private void Color_Picker(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Add_Task.this);
        builder.setCancelable(false);
        View view = getLayoutInflater().inflate(R.layout.alertdialouge_layout,null);
        Button cancel = view.findViewById(R.id.Cancel);

        Button C1 = view.findViewById(R.id.c1);
        Button C2 = view.findViewById(R.id.c2);
        Button C3 = view.findViewById(R.id.c3);
        Button C4 = view.findViewById(R.id.c4);
        Button C5 = view.findViewById(R.id.c5);
        Button C6 = view.findViewById(R.id.c6);
        builder.setView(view);
        AlertDialog alertDialog = builder.create();
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        C1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(Add_Task.this,"Color 1 Selected",Toast.LENGTH_SHORT).show();
                Color_value = "#00E676";
                IsColorSelected = true;
                task_color.setBackgroundColor(Color.parseColor(Color_value));
                alertDialog.dismiss();
            }
        });
        C2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(Add_Task.this,"Color 2 Selected",Toast.LENGTH_SHORT).show();
                Color_value= "#D500F9";
                IsColorSelected = true;
                task_color.setBackgroundColor(Color.parseColor(Color_value));
                alertDialog.dismiss();

            }
        });
        C3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(Add_Task.this,"Color 3 Selected",Toast.LENGTH_SHORT).show();
                Color_value = "#2979FF";
                IsColorSelected = true;
                task_color.setBackgroundColor(Color.parseColor(Color_value));
                alertDialog.dismiss();

            }
        });
        C4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(Add_Task.this,"Color 4 Selected",Toast.LENGTH_SHORT).show();
                Color_value= "#FFEA00";
                IsColorSelected = true;
                task_color.setBackgroundColor(Color.parseColor(Color_value));
                alertDialog.dismiss();

            }
        });
        C5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(Add_Task.this,"Color 5 Selected",Toast.LENGTH_SHORT).show();
                Color_value= "#00E5FF";
                IsColorSelected = true;
                task_color.setBackgroundColor(Color.parseColor(Color_value));
                alertDialog.dismiss();

            }
        });
        C6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(Add_Task.this,"Color 6 Selected",Toast.LENGTH_SHORT).show();
                Color_value= "#F50057";
                IsColorSelected = true;
                task_color.setBackgroundColor(Color.parseColor(Color_value));
                alertDialog.dismiss();

            }
        });


        alertDialog.show();
    }

}
