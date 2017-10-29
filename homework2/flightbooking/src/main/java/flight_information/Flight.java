package flight_information;

import booking_information.Booking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * 主要負責預定機票之類別.
 */
public class Flight extends GenericFlight {
    /**
     * Booking Identification.
     */
    private int bookingId = 1;

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
        booking.setBookingNumber(this.bookingId);
        this.bookings.add(booking);
        // Increment booking number.
        this.bookingId++;
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
