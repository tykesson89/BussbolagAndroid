package com.example.henrik.bussbolagandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private Spinner spinnerTravelFrom;
    private Spinner spinnerTravelTo;
    private Spinner spinnerDayOfWeek;
    private EditText etWeek;
    private EditText etTickets;
    private Button buttonSearchTravel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }


    public void initComponents(){
        spinnerDayOfWeek = (Spinner)findViewById(R.id.spinnerDayofWeek);
        spinnerTravelFrom = (Spinner)findViewById(R.id.spinnerTravelFrom);
        spinnerTravelTo = (Spinner)findViewById(R.id.spinnerTravelTo);
        etWeek = (EditText)findViewById(R.id.etWeek);
        etTickets = (EditText)findViewById(R.id.etTickets);
        buttonSearchTravel = (Button)findViewById(R.id.buttonSearchTravel);

    }
}
