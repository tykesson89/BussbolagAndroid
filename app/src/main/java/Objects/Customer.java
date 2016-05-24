package Objects;

import java.io.Serializable;

/**
 * Created by Henrik on 2016-05-23.
 */
public class Customer implements Serializable{
    private static final long serialVersionUID = 1L;
    private long personalNumber;
    private String email;
    private String phoneNumber;
    private String address;
    private String name;
    private int travelId;
    private int seats;


    public Customer(long personalNumber, String email, String phoneNumber, String address, String name, int travelId, int seats) {
        this.personalNumber = personalNumber;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.name = name;
        this.travelId = travelId;
        this.seats = seats;
    }

    public long getPersonalNumber() {
        return personalNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public int getTravelId() {
        return travelId;
    }

    public int getSeats() {
        return seats;
    }

    public void setPersonalNumber(long personalNumber) {
        this.personalNumber = personalNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTravelId(int travelId) {
        this.travelId = travelId;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "personalNumber=" + personalNumber +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", asdress='" + address + '\'' +
                ", name='" + name + '\'' +
                ", travelId=" + travelId +
                ", seats=" + seats +
                '}';
    }
}
