package com.example.henrik.bussbolagandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Time;

import Objects.TravelSuggestions;

public class Main3Activity extends AppCompatActivity {
    private TextView textViewFrom;
    private TextView textViewTo;
    private TextView textViewWeek;
    private TextView textViewDayOfWeek;
    private TextView textViewDeparture;
    private TextView textViewArraival;
    private TextView textViewTickets;
    private TextView textViewPrice;
    private TextView textViewTotalPrice;
    private Button buttonBokaResa;
    private int travelId;
    private TravelSuggestions travelSuggestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initComponentes();

        SqLiteDB sqLiteDB = new SqLiteDB(this);
        String id = getIntent().getStringExtra("H");
        travelId = Integer.parseInt(id);
        Log.v("heeej", String.valueOf(travelId));
        travelSuggestions = sqLiteDB.getOneTravel(travelId);
        setText(travelSuggestions.getArrival(),
                travelSuggestions.getDayOfWeek(),
                travelSuggestions.getDeparture(),
                travelSuggestions.getSeats(),
                travelSuggestions.getPrice(),
                travelSuggestions.getFrom(),
                travelSuggestions.getTo(),
                travelSuggestions.getWeek());





    }
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (resultCode == RESULT_OK) {
            travelId = Integer.parseInt(intent.getStringExtra("H"));
            Log.v("DEBUG", "check iSelectedItem = " + travelId);
        }
    }



    public void setText(Time arraival, String dayOfWeek, Time departure, int tickets, int price, String from, String to, int week){
        textViewTo.setText(to);
        textViewTickets.setText(Integer.toString(tickets));
        textViewDeparture.setText(departure.toString());
        textViewDayOfWeek.setText(dayOfWeek);
        textViewFrom.setText(from);
        textViewArraival.setText(arraival.toString());
        textViewWeek.setText(Integer.toString(week));
        textViewPrice.setText(Integer.toString(price));
        int totalPrice = tickets * price;
        textViewTotalPrice.setText(Integer.toString(totalPrice));

    }


    public void initComponentes(){
        textViewArraival = (TextView)findViewById(R.id.textViewArrival);
        textViewDayOfWeek = (TextView)findViewById(R.id.textViewDayOfWeek);
        textViewDeparture = (TextView)findViewById(R.id.textViewDeparture);
        textViewTickets = (TextView)findViewById(R.id.textViewTickets);
        textViewPrice = (TextView)findViewById(R.id.textViewPrice);
        textViewTotalPrice = (TextView)findViewById(R.id.textViewTotalPrice);
        textViewFrom = (TextView)findViewById(R.id.textViewFrom);
        textViewTo = (TextView)findViewById(R.id.textViewTo);
        textViewWeek = (TextView)findViewById(R.id.textViewWeek);
        buttonBokaResa = (Button)findViewById(R.id.buttonBokaResa);
    }
}
