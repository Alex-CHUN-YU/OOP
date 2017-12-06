package booking_information;

/**
 * Customer <-> Booking (一對多)，Booking <-> Movie (多對一).
 * @version 1.0 2017年12月04日
 * @author ALEX-CHUN-YU
 */
public class Booking {
    /**
     * Customer.
     */
    private Customer customer;

    /**
     * Movie.
     */
    private Movie movie;

    /**
     * Seat Number.
     */
    private String seatNumber;

    /**
     * Constructor(link).
     * @param customer customer
     * @param movie movie
     * @param seatNumber seatNumber
     */
    Booking(Customer customer, Movie movie, String seatNumber) {
        this.customer = customer;
        this.customer.addLinkToBooking(this);
        this.movie = movie;
        this.movie.addLinkToBooking(this);
        this.seatNumber	= seatNumber;
    }

    /**
     * Show Booking Information.
     */
    public void showInformationOfBooking() {
        System.out.print("消費者:" + customer.getName());
        System.out.print(" 電影名稱:" + movie.getName());
        System.out.println(" 座位號碼:" + seatNumber);
    }
}
