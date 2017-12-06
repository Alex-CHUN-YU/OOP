package booking_information;


import java.util.ArrayList;
import java.util.Iterator;

/**
 * Customer <-> Booking (一對多).
 * @version 1.0 2017年12月04日
 * @author ALEX-CHUN-YU
 */
public class Customer {
    /**
     * Booking List.
     */
    private ArrayList<Booking> bookings = new ArrayList<Booking>();

    /**
     * Customer Name.
     */
    private	String name;

    /**
     * Constructor.
     * @param name customer name
     */
    public Customer(String name) {
        this.name = name;
    }

    /**
     * Get Customer Name.
     * @return customer name
     */
    public String getName() {
        return name;
    }

    /**
     * Make Booking.
     * @param movie movie
     * @param seatNumber seat Number
     */
    public void makeBooking(Movie movie, String seatNumber) {
        new	Booking(this, movie, seatNumber);
    }

    /**
     * Add Booking(link).
     * @param bookOne book one
     */
    void addLinkToBooking(Booking bookOne) {
        bookings.add(bookOne);
    }

    /**
     * Get All Booking Of Customer(association).
     */
    public void getAllBookingOfCustomer() {
        System.out.println("\n" + this.getName() + "你好~以下為你電影訂票資訊:");
        Iterator<Booking> iterator = bookings.iterator();
        while (iterator.hasNext()) {
            iterator.next().showInformationOfBooking();
        }
    }
}
