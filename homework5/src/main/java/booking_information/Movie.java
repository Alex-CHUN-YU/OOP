package booking_information;

import company_information.Cinema;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Booking <-> Movie (多對一)，Movie <-> Cinema (多對多).
 * @version 1.0 2017年12月04日
 * @author ALEX-CHUN-YU
 */
public class Movie {
    /**
     * Booking List.
     */
    private ArrayList<Booking> bookings = new ArrayList<Booking>();

    /**
     * Cinemas List.
     */
    private ArrayList<Cinema> cinemas = new ArrayList<Cinema>();

    /**
     * Movie Name.
     */
    private String name;

    /**
     * Constructor.
     *
     * @param name movie name
     */
    public Movie(String name) {
        this.name = name;
    }

    /**
     * Get Movie Name.
     *
     * @return movie name
     */
    public String getName() {
        return name;
    }

    /**
     * Make Booking(link).
     * @param bookOne book one
     */
    void addLinkToBooking(Booking bookOne) {
        bookings.add(bookOne);
    }

    /**
     * Get All Booking Of Movie(association).
     */
    public void getAllBookingOfMovie() {
        System.out.println("\n" + "電影:" + this.getName());
        Iterator<Booking> iterator = bookings.iterator();
        while (iterator.hasNext()) {
            iterator.next().showInformationOfBooking();
        }
    }

    /**
     * Make Cinema(link).
     * @param cinema cinema
     */
    public void addLinkToCinema(Cinema cinema) {
        cinemas.add(cinema);
    }

    /**
     * Find Cinema(link).
     * @param cinemaOne cinema
     */
    public void findCinema(Cinema cinemaOne) {
        Iterator<Cinema> iterator = cinemas.iterator();
        while (iterator.hasNext()) {
            if (cinemaOne.equals(iterator.next())) {
                System.out.println("\n你所找到的電影院:" + cinemaOne.getName());
            }
        }
    }

    /**
     * Get All Cinema Of Movie(association).
     */
    public void getAllCinemaOfMovie() {
        System.out.println("\n" + this.getName() + "電影，目前為以下電影院所擁有:");
        Iterator<Cinema> iterator = cinemas.iterator();
        while (iterator.hasNext()) {
            iterator.next().showInformationOfCinema();
        }
    }

    /**
     * Show Movie Information.
     */
    public void showInformationOfMovie() {
        System.out.println("電影名稱:" + this.getName());
    }
}
