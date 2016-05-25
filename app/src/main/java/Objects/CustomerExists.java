package Objects;

import java.io.Serializable;

/**
 * Created by Henrik on 2016-05-25.
 */
public class CustomerExists implements Serializable {
    private static final long serialVersionUID = 1L;
    private long personalNumber;
    private int seats;
    private int travelId;

    public CustomerExists(int travelId, int seats, long personalNumber) {
        this.travelId = travelId;
        this.seats = seats;
        this.personalNumber = personalNumber;
    }

    public int getTravelId() {
        return travelId;
    }

    public int getSeats() {
        return seats;
    }

    public long getPersonalNumber() {
        return personalNumber;
    }

    public void setTravelId(int travelId) {
        this.travelId = travelId;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void setPersonalNumber(long personalNumber) {
        this.personalNumber = personalNumber;
    }

    @Override
    public String toString() {
        return "CustomerExists{" +
                "personalNumber=" + personalNumber +
                ", seats=" + seats +
                ", travelId=" + travelId +
                '}';
    }
}
