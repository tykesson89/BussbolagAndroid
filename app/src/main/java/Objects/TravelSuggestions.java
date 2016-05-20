package Objects;

import java.io.Serializable;
import java.sql.Time;

/**
 * Created by Henrik on 2016-05-20.
 */
public class TravelSuggestions implements Serializable {
    private static final long serialVersionUID = 1L;
    private String from;
    private String to;
    private String dayOfWeek;
    private int week;
    private int seats;
    private int price;
    private Time departure;
    private Time Arrival;

    public TravelSuggestions(){

    }


    public TravelSuggestions(String from, String to, String dayOfWeek, int week, int seats, int price, Time departure, Time arrival) {
        this.from = from;
        this.to = to;
        this.dayOfWeek = dayOfWeek;
        this.week = week;
        this.seats = seats;
        this.price = price;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public int getWeek() {
        return week;
    }

    public int getSeats() {
        return seats;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Time getArrival() {
        return Arrival;
    }

    public Time getDeparture() {
        return departure;
    }

    public int getPrice() {
        return price;
    }

    public void setArrival(Time arrival) {
        Arrival = arrival;
    }

    public void setDeparture(Time departure) {
        this.departure = departure;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
