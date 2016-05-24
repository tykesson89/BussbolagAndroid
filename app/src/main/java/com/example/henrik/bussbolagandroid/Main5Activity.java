package com.example.henrik.bussbolagandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main5Activity extends AppCompatActivity {
    private EditText editTextNumber;
    private EditText editTextEmail;
    private EditText editTextName;
    private EditText editTextPersonnummer;
    private EditText editTextAdress;
    private TextView textViewprice;
    private Button buttonCompleteBooking;
    private String fullPrice;
    private String tickets;
    private int travelId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        fullPrice = getIntent().getStringExtra("H");
        tickets = getIntent().getStringExtra("M");
        String id = getIntent().getStringExtra("T");
        travelId = Integer.parseInt(id);
        initComponents();
        textViewprice.setText(fullPrice);
    }






    public void initComponents(){
        editTextNumber = (EditText)findViewById(R.id.editTextNumber);
        editTextEmail = (EditText)findViewById(R.id.editTextEmail);
        editTextName = (EditText)findViewById(R.id.editTextName);
        editTextPersonnummer = (EditText)findViewById(R.id.editTextPersonnummer);
        editTextAdress = (EditText)findViewById(R.id.editTextAdress);
        textViewprice = (TextView)findViewById(R.id.textViewprice);
        buttonCompleteBooking = (Button)findViewById(R.id.buttonCompleteBooking);
    }

   public void initListeners(){
        buttonCompleteBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
