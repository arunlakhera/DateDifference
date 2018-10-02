package com.pikchillytechnologies.datedifference;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int mYear, mMonth, mDay;
    Button mDateButton1;
    Button mDateButton2;
    Button mDateButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDateButton1 = findViewById(R.id.button1);
        mDateButton2 = findViewById(R.id.button2);
        mDateButton3 = findViewById(R.id.button3);

        mDateButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Get Current Date
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);

                setDate();
            }
        });


        mDateButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Get Current Date
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);

                setDate2();
            }
        });
    }

    public void setDate(){

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        mDateButton1.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    public void setDate2(){

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        mDateButton2.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        showDateDiff();
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    public void showDateDiff(){

        SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");

        String startDate = String.valueOf(mDateButton1.getText());
        String endDate = String.valueOf(mDateButton2.getText());

        try {
            Date dateBefore = myFormat.parse(startDate);
            Date dateAfter = myFormat.parse(endDate);

            long difference = dateAfter.getTime() - dateBefore.getTime();
            float daysBetween = (difference / (1000*60*60*24));

            mDateButton3.setText(String.valueOf(daysBetween));
        }catch (Exception e){

        }


    }
}
