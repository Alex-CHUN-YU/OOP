package flight_information;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 存取中途停留機場以及時間.
 * @version 1.0 2017年10月29日
 * @author ALEX-CHUN-YU
 */
public class Stopover {
    /**
     * Departure Time.
     */
    private Date departureTime = null;

    /**
     * Arrival Time.
     */
    private Date arrivalTime = null;

    /**
     * Airport Stopover .
     */
    private Airport airport = null;

    /**
     * Constructor About Stopover Information.
     * @param departureTime departureTime
     * @param arrivalTime arrivalTime
     * @param airport airport
     */
    public Stopover(final Date departureTime, final Date arrivalTime, final Airport airport) {
        this.setDepartureTime(departureTime);
        this.setArrivalTime(arrivalTime);
        this.setAirport(airport);
    }

    /**
     * Set Stopover Information About Departure Time.
     * @param departureTime departure time.
     */
    private void setDepartureTime(final Date departureTime) {
        if (departureTime != null) {
            if ((this.getArrivalTime() == null)
                    || departureTime.before(this.getArrivalTime())) {
                this.departureTime = departureTime;
            } else {
                throw new NullPointerException();
            }
        } else {
            throw new NullPointerException();
        }
    }

    /**
     * Get Stopover Information About Departure Time.
     * @return departure time.
     */
    public Date getDepartureTime() {
        return this.departureTime;
    }

    /**
     * Set Stopover Information About Arrival Time.
     * @param arrivalTime arrival time.
     */
    private void setArrivalTime(final Date arrivalTime) {
        // Check if the new the departure time is not null;
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
     * Get Stopover Information About Arrival Time.
     * @return arrival time.
     */
    public Date getArrivalTime() {
        return this.arrivalTime;
    }

    /**
     * Set Stopover Information About Airport Stopover.
     * @param airport stop airport
     */
    private void setAirport(final Airport airport) {
        this.airport = airport;
    }

    /**
     * Get Stopover Information About Airport Stopover.
     * @return airport.
     */
    public Airport getAirport() {
        return this.airport;
    }

    /**
     * Get Generic Flight Information About Flight Time.
     * @return Flight length.
     */
    public long getStopTime() {
        if ((this.getArrivalTime() != null)
                && (this.getDepartureTime() != null)) {
            return (this.getArrivalTime().getTime()
                    - this.getDepartureTime().getTime())
                    / Integer.parseInt("3600000");
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return "轉機的機場:" + this.airport + " | 抵達時間:" + sdf.format(this.departureTime)
                + " | 出發時間:" + sdf.format(this.arrivalTime) + " | 休息時間:"
                + this.getStopTime() + "小時";
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj.getClass().equals(this.getClass())) {
            Stopover other = (Stopover) obj;
            return (other.getDepartureTime() == this.getDepartureTime())
                    && (other.getArrivalTime() == this.getArrivalTime())
                    && (other.getAirport() == this.getAirport());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
