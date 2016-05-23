package com.example.henrik.bussbolagandroid;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import Objects.TravelSuggestions;

public class Main2Activity extends AppCompatActivity {

    private List<TravelSuggestions> list;
    private TravelListAdapter travelListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        SqLiteDB sqLiteDB = new SqLiteDB(this);
        list = sqLiteDB.GetAllTravels();
        ListView listView = (ListView) findViewById(R.id.listViewTravel);
        travelListAdapter = new TravelListAdapter(this, list);
        listView.setAdapter(travelListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                createOptionsDialog(position);
            }
        });


    }



    public void createOptionsDialog(final int listPosition){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Edit");

        builder.setItems(new String[]{"Boka Resa", "Cancel"}, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int position) {
                if (position == 0) {
                    Intent intent = new Intent(getApplicationContext(), Main3Activity.class);
                    intent.putExtra("H",String.valueOf(list.get(listPosition).getTravelid()));
                    Log.v("HEj", String.valueOf(list.get(listPosition).getTravelid()));
                    startActivity(intent);


                } else {
                    //Gör ingenting
                }
            }
        });

        builder.show();

    }


}
