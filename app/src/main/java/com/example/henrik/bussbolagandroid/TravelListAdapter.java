package com.example.henrik.bussbolagandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import Objects.TravelSuggestions;


/**
 * Created by Henrik on 2016-05-23.
 */
public class TravelListAdapter extends ArrayAdapter<TravelSuggestions> {

        private Context context;
        private List<TravelSuggestions> travelSuggestionsList;

        public TravelListAdapter(Context context, List<TravelSuggestions> travelSuggestionsList) {
            super(context, -1, travelSuggestionsList);
            this.context = context;
            this.travelSuggestionsList = travelSuggestionsList;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater =
                    (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View rowView = inflater.inflate(R.layout.row_layout_company_settings, parent, false);

            TextView fromCity = (TextView)rowView.findViewById(R.id.fromCity);
            TextView toCity = (TextView)rowView.findViewById(R.id.toCity);
            TextView price = (TextView)rowView.findViewById(R.id.price);
            TextView departureTime = (TextView)rowView.findViewById(R.id.departureTime);
            TextView arraivalTime = (TextView)rowView.findViewById(R.id.arraivalTime);
            TextView seatsLeft = (TextView)rowView.findViewById(R.id.seatsLeft);


            fromCity.setText(" " + travelSuggestionsList.get(position).getFrom()+" ");
            toCity.setText(" " + travelSuggestionsList.get(position).getTo() + " ");
            price.setText(" " + travelSuggestionsList.get(position).getPrice()+" kr");
            departureTime.setText(" " + travelSuggestionsList.get(position).getDeparture().toString() + " ");
            arraivalTime.setText(" " + travelSuggestionsList.get(position).getArrival().toString() +" ");
            seatsLeft.setText(" " + travelSuggestionsList.get(position).getSeatsLeft());




            return rowView;
        }

}
