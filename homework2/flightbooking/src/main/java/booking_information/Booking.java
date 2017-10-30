package booking_information;

import java.util.ArrayList;
import java.util.Date;

/**
 * 主要負責存取機票預訂資訊.
 * 存:預定號碼、預定飛機時間、消費者資訊、乘客資訊
 * 取:預定號碼、預定飛機時間、消費者資訊、乘客資訊
 * @version 1.0 2017年10月28日
 * @author ALEX-CHUN-YU
 */
public class Booking {
    /**
     * Booking Number.
     */
    private Integer number = 0;

    /**
     * Booking Date.
     */
    private Date date = new Date();

    /**
     * Customer Information.
     */
    private Customer customer;

    /**
     * Passengers Information.
     */
    private ArrayList<Passenger> passengers;

    /**
     * Constructor About Booking Information.
     * @param customer customer
     * @param passengers passengers
     */
    public Booking(Customer customer, ArrayList<Passenger> passengers) {
        this.setCustomer(customer);
        this.setPassengers(passengers);
    }

    /**
     * Set Booking Information About Booking Number.
     * @param number booking number.
     */
    public void setBookingNumber(Integer number) {
        this.number = number;
    }

    /**
     * Get Booking Information About Booking Number.
     */
    public Integer getBookingNumber() {
        return this.number;
    }

    /**
     * Set Booking Information About Booking Date.
     * @param date booking date
     */
    public void setBookingDate(Date date) {
        this.date = date;
    }

    /**
     * Get Booking Information About Booking Date.
     */
    public Date getBookingDate() {
        return this.date;
    }

    /**
     * Set Booking Information About Customer.
     * @param customer booking customer
     */
    private void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Get Booking Information About Customer.
     */
    public Customer getCustomer() {
        return this.customer;
    }

    /**
     * Set Booking Information About Passengers.
     * @param passengers booking passenger
     */
    private void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    /**
     * Get Booking Information About Passengers.
     */
    public ArrayList<Passenger> getPassengers() {
        return this.passengers;
    }

    @Override
    public String toString() {
        return "訂機號碼:" + this.number
                + "\n消費者資訊:\n" + this.customer.toString()
                + "\n乘客資訊:\n" + this.passengers.toString() + "\n\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass().equals(this.getClass())) {
            Booking booking = (Booking) obj;
            if (booking.getBookingNumber().equals(this.number)
                    && booking.getBookingDate().equals(this.date)
                    && booking.getCustomer().equals(this.customer)
                    && booking.getPassengers().equals(this.passengers)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
