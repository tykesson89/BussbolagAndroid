package Objects;

import java.io.Serializable;

/**
 * Created by Henrik on 2016-05-20.
 */
public class Travel implements Serializable {
    private static final long serialVersionUID = 1L;
    private String from;
    private String to;
    private String dayOfWeek;
    private int week;
    private int seats;

    public Travel(String from, String to, String dayOfWeek, int week, int seats) {
        this.from = from;
        this.to = to;
        this.dayOfWeek = dayOfWeek;
        this.week = week;
        this.seats = seats;
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

    @Override
    public String toString() {
        return "Travel{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", dayOfWeek='" + dayOfWeek + '\'' +
                ", week=" + week +
                ", seats=" + seats +
                '}';
    }
}
