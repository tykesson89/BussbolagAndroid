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
    private int travelid;
    private int seatsLeft;

    public TravelSuggestions(int travelid, int week, int seats, int price, String dayOfWeek, String departure, String arraival, String from, String to, int seatsLeft) {
        this.from = from;
        this.to = to;
        this.dayOfWeek = dayOfWeek;
        this.week = week;
        this.seats = seats;
        this.price = price;
        this.travelid = travelid;
        this.departure = Time.valueOf(departure);
        this.Arrival = Time.valueOf(arraival);
        this.seatsLeft = seatsLeft;


    }

    public int getTravelid() {
        return travelid;
    }

    @Override
    public String toString() {
        return "TravelSuggestions{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", dayOfWeek='" + dayOfWeek + '\'' +
                ", week=" + week +
                ", seats=" + seats +
                ", price=" + price +
                ", departure=" + departure +
                ", Arrival=" + Arrival +
                ", travelid=" + travelid +
                '}';
    }

    public void setTravelid(int travelid) {
        this.travelid = travelid;
    }


    public void setSeatsLeft(int seatsLeft) {
        this.seatsLeft = seatsLeft;
    }

    public int getSeatsLeft() {

        return seatsLeft;
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
