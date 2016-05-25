package com.example.henrik.bussbolagandroid;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import Objects.Customer;
import Objects.CustomerExists;

public class Main4Activity extends AppCompatActivity {
    private EditText editTextPersonalNumber;
    private TextView textViewtotalprice;
    private Button buttonCompleteBooking;
    private String fullPrice;
    private String tickets;
    private int travelId;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        fullPrice = getIntent().getStringExtra("H");
        tickets = getIntent().getStringExtra("M");
        String id = getIntent().getStringExtra("T");
        travelId = Integer.parseInt(id);
        initComponents();
        textViewtotalprice.setText(fullPrice);
        initListeners();
    }


    public void initComponents(){
        editTextPersonalNumber = (EditText)findViewById(R.id.editTextPersonalNumber);
        textViewtotalprice = (TextView)findViewById(R.id.textViewtotalprice);
        buttonCompleteBooking = (Button)findViewById(R.id.buttonCompleteBooking);
    }

    public void initListeners(){
        buttonCompleteBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomerExists customerExists = new CustomerExists(travelId, Integer.parseInt(tickets), Long.parseLong(editTextPersonalNumber.getText().toString()));
                new SendExistingCustomer().execute(customerExists);
            }
        });
    }


    public class SendExistingCustomer extends AsyncTask<CustomerExists, Void, String> {
        private static final String ip = "192.168.56.1";
        private static final int port = 40001;
        private ObjectOutputStream objectOut;
        private ObjectInputStream objectIn;
        private String response = "Something Went Wrong";

        @Override
        protected String doInBackground(CustomerExists... params) {

            try {
                Socket socket = new Socket(ip, port);

                objectOut = new ObjectOutputStream(socket.getOutputStream());
                objectIn = new ObjectInputStream(socket.getInputStream());
                objectOut.writeObject("Existing Customer");
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
            }else if(s.equals("Customer doesent exists")){
                editTextPersonalNumber.setError("Personnummer finns inte registrerat");
            }

        }
    }
}
