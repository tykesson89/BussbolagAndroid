package com.example.henrik.bussbolagandroid;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import Objects.Travel;
import Objects.TravelSuggestions;

public class MainActivity extends AppCompatActivity {
    private Spinner spinnerTravelFrom;
    private Spinner spinnerTravelTo;
    private Spinner spinnerDayOfWeek;
    private EditText etWeek;
    private EditText etTickets;
    private Button buttonSearchTravel;
    private List<String> cities;
    private List<String> dayOfWeek;
    private String from;
    private String to;
    private String dayOfWeekString;
    private RadioButton radioButtonTur;
    private RadioButton radioButtonRetur;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new GetAllCities().execute();
        cities = new ArrayList<>();
        cities.add("Inga städer");
        initComponents();
        initSpinnerTravelFrom();
        initSpinnerTravelTo();
        initDayOfWeek();
        initSpinnerDayOfWeek();
        initListeners();
        SqLiteDB sqLiteDB = new SqLiteDB(this);
        sqLiteDB.getWritableDatabase();
    }
    public void initListeners(){
        buttonSearchTravel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etTickets.getText().length() == 0){
                    etTickets.setError("Du måste ange antal biljetter");
                }
                if(etWeek.getText().length() == 0){
                    etWeek.setError("Du måste ange en vecka");
                }else {
                    int seats = Integer.parseInt(etTickets.getText().toString());
                    int week = Integer.parseInt(etWeek.getText().toString());
                    Travel travel = new Travel(from, to, dayOfWeekString, week, seats);
                    new SendSearch().execute(travel);
                }
            }
        });

        spinnerTravelFrom.setOnItemSelectedListener(new spinnerTravelFromListener());
        spinnerTravelTo.setOnItemSelectedListener(new spinnerTravelToListener());
        spinnerDayOfWeek.setOnItemSelectedListener(new spinnerDayOfWeekListener());
    }


    public void initComponents(){
        spinnerDayOfWeek = (Spinner)findViewById(R.id.spinnerDayofWeek);
        spinnerTravelFrom = (Spinner)findViewById(R.id.spinnerTravelFrom);
        spinnerTravelTo = (Spinner)findViewById(R.id.spinnerTravelTo);
        etWeek = (EditText)findViewById(R.id.etWeek);
        etTickets = (EditText)findViewById(R.id.etTickets);
        buttonSearchTravel = (Button)findViewById(R.id.buttonSearchTravel);
        radioButtonRetur = (RadioButton)findViewById(R.id.radioButtonRetur);
        radioButtonTur = (RadioButton)findViewById(R.id.radioButtonTur);

    }
    public void initSpinnerTravelFrom(){
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cities);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTravelFrom.setAdapter(dataAdapter);
    }
    public void initSpinnerTravelTo(){
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cities);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTravelTo.setAdapter(dataAdapter);
    }
    public void initSpinnerDayOfWeek(){
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dayOfWeek);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDayOfWeek.setAdapter(dataAdapter);
    }
    public void initDayOfWeek(){
        dayOfWeek = new ArrayList<>();
        dayOfWeek.add("Måndag");
        dayOfWeek.add("Tisdag");
        dayOfWeek.add("Onsdag");
        dayOfWeek.add("Torsdag");
        dayOfWeek.add("Fredag");
        dayOfWeek.add("Lördag");
        dayOfWeek.add("Söndag");
    }
    public class spinnerTravelFromListener implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            from = parent.getItemAtPosition(pos).toString();
        }

        public void onNothingSelected(AdapterView parent) {
            // Do nothing.
        }
    }
    public class spinnerTravelToListener implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            to = parent.getItemAtPosition(pos).toString();
        }

        public void onNothingSelected(AdapterView parent) {
            // Do nothing.
        }
    }
    public class spinnerDayOfWeekListener implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            dayOfWeekString = parent.getItemAtPosition(pos).toString();
        }

        public void onNothingSelected(AdapterView parent) {
            // Do nothing.
        }
    }


    class GetAllCities extends AsyncTask<Void, Void, Void>{
        private static final String ip = "192.168.56.1";
        private static final int port = 40001;
        private ObjectOutputStream objectOut;
        private ObjectInputStream objectIn;
        @Override
        protected Void doInBackground(Void... params) {

            try {
                Socket socket = new Socket(ip, port);

                objectOut = new ObjectOutputStream(socket.getOutputStream());
                objectIn = new ObjectInputStream(socket.getInputStream());
                objectOut.writeObject("All Cities As List");
                cities = (List<String>)objectIn.readObject();
                Log.v("List hämtad", "");
            }catch (Exception e){
                e.printStackTrace();
            }


            initSpinnerTravelTo();
            initSpinnerTravelFrom();




            return null;
        }


    }
    class SendSearch extends AsyncTask<Travel, Void, String>{
        private static final String ip = "192.168.56.1";
        private static final int port = 40001;
        private ObjectOutputStream objectOut;
        private ObjectInputStream objectIn;
        private List<TravelSuggestions> list;
        @Override
        protected String doInBackground(Travel... params) {

            try {
                Socket socket = new Socket(ip, port);

                objectOut = new ObjectOutputStream(socket.getOutputStream());
                objectIn = new ObjectInputStream(socket.getInputStream());
                objectOut.writeObject("Search");
                objectOut.writeObject(params[0]);
                Object obj = objectIn.readObject();
                if(obj instanceof List){
                    list = (List<TravelSuggestions>)obj;
                    return "Success";
                }else {
                    return "No Travels";

                }


            }catch (Exception e){
                e.printStackTrace();
            }







            return null;
        }

        @Override
        protected void onPostExecute(String params) {
            super.onPostExecute(params);
            if(params.equals("No Travels")){
                buttonSearchTravel.setError("Inga resor hittades");

                Toast.makeText(getApplicationContext(), "Inga resor hittades", Toast.LENGTH_LONG).show();

            }else {


                    SqLiteDB sqLiteDB = new SqLiteDB(getApplicationContext());
                    sqLiteDB.deleteAll();
                    sqLiteDB.addTravel(list.get(0));
                    Intent intent = new Intent(getApplicationContext(),
                            Main2Activity.class);
                    startActivity(intent);

            }
        }
    }
}
