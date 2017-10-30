package flight_information;

/**
 * 存取機場資訊.
 * @version 1.0 2017年10月28日
 * @author ALEX-CHUN-YU
 */
public class Airport {
    /**
     * Airport City.
     */
    private City city = null;

    /**
     * Constructor About Airport Information.
     * @param city city
     */
    public Airport(City city) {
        this.setCity(city);
    }

    /**
     * Set Airport Information About City.
     * @param city city
     */
    private void setCity(City city) {
        this.city = city;
    }

    /**
     * Get Airport Information About City.
     * @return city city
     */
    public City getCity() {
        return this.city;
    }

    @Override
    public String toString() {
        return this.city.toString() + " Airport";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass().equals(this.getClass())) {
            Airport airport = (Airport) obj;
            if (airport.getCity().equals(this.city)) {
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
