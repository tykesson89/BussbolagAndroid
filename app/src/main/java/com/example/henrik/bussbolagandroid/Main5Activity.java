package com.example.henrik.bussbolagandroid;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import Objects.Customer;

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
        initListeners();
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
                Customer customer = new Customer(Long.parseLong(editTextPersonnummer.getText().toString()),
                        editTextEmail.getText().toString(),
                        editTextNumber.getText().toString(),
                        editTextAdress.getText().toString(),
                        editTextName.getText().toString(),
                        travelId,
                        Integer.parseInt(tickets));

                new SendNewCustomer().execute(customer);


            }
        });
    }


    public class SendNewCustomer extends AsyncTask<Customer, Void, String>{
        private static final String ip = "192.168.56.1";
        private static final int port = 40001;
        private ObjectOutputStream objectOut;
        private ObjectInputStream objectIn;
        private String response = "Something Went Wrong";

        @Override
        protected String doInBackground(Customer... params) {

            try {
                Socket socket = new Socket(ip, port);

                objectOut = new ObjectOutputStream(socket.getOutputStream());
                objectIn = new ObjectInputStream(socket.getInputStream());
                objectOut.writeObject("New Customer");
                objectOut.writeObject(params[0]);
                response = (String)objectIn.readObject();


            }catch (Exception e){
                e.printStackTrace();
            }


            return response;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(s.equals("Success")){
                Intent intent = new Intent(getApplicationContext(),
                        Main6Activity.class);
                startActivity(intent);
            }

        }
    }
}
