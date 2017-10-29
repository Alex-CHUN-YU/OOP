package flight_information;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * 此為通用於飛機航班抽象類別.
 * 飛機號碼、有效期限、出發時間、抵達時間
 * 出發地點、抵達地點、飛行時間、中途停留
 * @version 1.0 2017年10月28日
 * @author ALEX-CHUN-YU
 */
public abstract class GenericFlight {
    /**
     * Flight Number.
     */
    private Integer flightNumber = 0;

    /**
     * Validity Period.
     */
    private long validityPeriod = 0;

    /**
     * Departure Time.
     */
    private Date departureTime = null;

    /**
     * Arrival Time.
     */
    private Date arrivalTime = null;

    /**
     * Departure Airport.
     */
    private Airport departureAirport = null;

    /**
     * Arrival Airport.
     */
    private Airport arrivalAirport = null;

    /**
     * Airport Stopover.
     */
    private final List<Stopover> stopovers = new ArrayList<Stopover>();

    /**
     * Constructor About Generic Flight Information.
     * @param validityPeriod validity period
     * @param departureTime departure time
     * @param arrivalTime arrival time
     * @param departureAirport departure airport
     * @param arrivalAirport arrival airport
     */
    public GenericFlight(final long validityPeriod,
                         final Date departureTime, final Date arrivalTime,
                         final Airport departureAirport, final Airport arrivalAirport) {
        this.setValidityPeriod(validityPeriod);
        this.setDepartureTime(departureTime);
        this.setArrivalTime(arrivalTime);
        this.setDepartureAirport(departureAirport);
        this.setArrivalAirport(arrivalAirport);
    }

    /**
     * Set Generic Flight Information About Flight Number.
     * @param flightNumber flight number
     */
    public void setFlightNumber(Integer flightNumber) {
        this.flightNumber = flightNumber;
    }

    /**
     * Get Generic Flight Information About Flight Number.
     * @return flightNumber flight number
     */
    public Integer getFlightNumber() {
        return this.flightNumber;
    }

    /**
     * Set Generic Flight Information About Validity Period.
     * @param validityPeriod validity period
     */
    private void setValidityPeriod(long validityPeriod) {
        this.validityPeriod = validityPeriod;
    }

    /**
     * Get Generic Flight Information About Validity Period.
     * @return validity period
     */
    public long getValidityPeriod() {
        return this.validityPeriod;
    }

    /**
     * Set Generic Flight Information About Departure Time.
     * @param departureTime departure time
     */
    private void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    /**
     * Get Generic Flight Information About Departure Time.
     * @return departure time
     */
    public Date getDepartureTime() {
        return this.departureTime;
    }

    /**
     * Set Generic Flight Information About Arrival Time.
     * @param arrivalTime arrival time
     */
    private void setArrivalTime(Date arrivalTime) {
        if (arrivalTime != null) {
            if ((this.getDepartureTime() == null)
                    || arrivalTime.after(this.getDepartureTime())) {
                this.arrivalTime = arrivalTime;
            } else {
                throw new NullPointerException();
            }
        } else {
            throw new NullPointerException();
        }
    }

    /**
     * Get Generic Flight Information About Arrival Time.
     * @return arrival time
     */
    public Date getArrivalTime() {
        return this.arrivalTime;
    }

    /**
     * Set Generic Flight Information About Departure Airport.
     * @param departureAirport departure airport
     */
    private void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    /**
     * Get Generic Flight Information About Departure Airport.
     * @return departure airport
     */
    public Airport getDepartureAirport() {
        return this.departureAirport;
    }

    /**
     * Set Generic Flight Information About Arrival Airport.
     * @param arrivalAirport arrival airport
     */
    private void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    /**
     * Get Generic Flight Information About Arrival Airport.
     * @return arrival airport
     */
    public Airport getArrivalAirport() {
        return this.arrivalAirport;
    }

    /**
     * Get Stopover Information About Flight Time.
     * @return Flight length.
     */
    public long getFlightTime() {
        if ((this.getArrivalTime() != null)
                && (this.getDepartureTime() != null)) {
            return (this.getArrivalTime().getTime()
                    - this.getDepartureTime().getTime())
                    / Integer.parseInt("3600000");
        } else {
            throw new NullPointerException();
        }
    }

    /**
     * Add a stopover to the flight. The stopover must be within the time of the
     * entire flight.
     * @param stopover stopover
     */
    public void addStopover(final Stopover stopover) {
        if (((stopover.getDepartureTime() != null) && (stopover
                .getDepartureTime().getTime() < this.getArrivalTime().getTime()))
                && ((stopover.getArrivalTime() != null) && (stopover
                .getArrivalTime().getTime() > this.getDepartureTime()
                .getTime()))) {
            this.stopovers.add(stopover);

        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Remove A Stopover Based On Its Values.
     * @param stopover stopover to remove.
     */
    public void removeStopover(final Stopover stopover) {
        this.stopovers.remove(stopover);
    }

    /**
     * Getter For A Read-Only Version Of The Stopovers List.
     * @return stopovers list.
     */
    public List<Stopover> getStopovers() {
        return Collections.unmodifiableList(this.stopovers);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return "出發時間:" + sdf.format(this.departureTime)
                + " 抵達時間:" + sdf.format(this.arrivalTime)
                + "\n出發地點:" + this.departureAirport
                + " 抵達地點:" + this.arrivalAirport
                + "\n總花費時間:" + this.getFlightTime() + "小時\n";
    }
}
