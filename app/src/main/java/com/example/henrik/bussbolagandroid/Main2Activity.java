package com.example.henrik.bussbolagandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import Objects.TravelSuggestions;

public class Main2Activity extends AppCompatActivity {
    private ListView listViewTravel;
    private List<TravelSuggestions> list;
    private TravelSuggestions travelSuggestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
      list = (List<TravelSuggestions>)  getIntent().getSerializableExtra("MyClass");
        travelSuggestions = list.get(0);
        String[] str = new String[1];
        String st = travelSuggestions.getFrom() + " - " + travelSuggestions.getTo();
        str[0] = st;
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, str);

        ListView listView = (ListView) findViewById(R.id.listViewTravel);
        listView.setAdapter(adapter);

    }



}
