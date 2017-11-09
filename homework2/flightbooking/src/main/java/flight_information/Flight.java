package flight_information;

import booking_information.Booking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * 主要負責預定機票之類別.
 *
 * @version 1.0 2017年10月23日
 * @author Alex
 *
 */
public class Flight extends GenericFlight {
    /**
     * Booking Identification.
     */
    private String bookingId = null;

    /**
     * Booking List.
     */
    private final List<Booking> bookings = new ArrayList<Booking>();

    /**
     * Constructor About Flight Information.
     * @param validityPeriod validity period
     * @param departureTime departure time
     * @param arrivalTime arrival time
     * @param departureAirport departure airport
     * @param arrivalAirport arrival airport
     */
    public Flight(final long validityPeriod,
                  final Date departureTime, final Date arrivalTime,
                  final Airport departureAirport, final Airport arrivalAirport) {
        super(validityPeriod, departureTime, arrivalTime, departureAirport, arrivalAirport);
    }

    /**
     * Open Booking On The Flight.
     * @param booking flight booking.
     */
    public void openBooking(final Booking booking) {
        // Set booking number
        this.bookings.add(booking);
    }

    /**
     * Close Booking For The Flight.
     * @param booking flight booking.
     */
    public void closeBooking(final Booking booking) {
        this.bookings.remove(booking);
    }

    /**
     * Get Flight Information About Flight Bookings.
     * @return booking result
     */
    public List<Booking> getBookings() {
        return Collections.unmodifiableList(this.bookings);
    }
}
