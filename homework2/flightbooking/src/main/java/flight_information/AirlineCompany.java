package flight_information;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 存取航空公司資訊.
 * 存: 公司名、增加飛機、減少飛機
 * 取: 公司名、所有飛機
 * @version 1.0 2017年10月28日
 * @author ALEX-CHUN-YU
 */
public class AirlineCompany {
    /**
     * Airline Company Name.
     */
    private String name = null;

    /**
     * Airline Company Flights.
     */
    private final Map<Integer, GenericFlight> flights = new HashMap<Integer, GenericFlight>();

    /**
     * Constructor for the AirlineCompany class which takes the default name.
     * @param name Airline Company Name.
     */
    public AirlineCompany(final String name) {
        this.setName(name);
    }

    /**
     * Set Airline Company Information About Airline Company Name.
     * @param name company name.
     */
    private void setName(final String name) {
        this.name = name;
    }

    /**
     * Get Company Information About Company Name.
     * @return Airline Company Name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Register a flight with the airline company.
     * @param flight flight
     * @return number.
     */
    public Integer registerFlight(final GenericFlight flight) {
        Integer num = this.flights.size();
        this.flights.put(num, flight);
        flight.setFlightNumber(num);
        return num;
    }

    /**
     * Unregister Flight With The Airline Company.
     * @param flightNumber Flight Number.
     */
    public void unregisterFlight(final Integer flightNumber) {
        if (this.flights.containsKey(flightNumber)) {
            this.flights.get(flightNumber).setFlightNumber(null);
            this.flights.put(flightNumber, null);
        }
    }

    /**
     * Get All Registered Flights For This Airline Company.
     * @return Unmodifiable list of registered flights.
     */
    public Map<Integer, GenericFlight> getFlights() {
        return Collections.unmodifiableMap(this.flights);
    }
}
