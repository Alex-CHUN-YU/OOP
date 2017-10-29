package flight_information;

/**
 * 存取城市資訊.
 * @version 1.0 2017年10月28日
 * @author ALEX-CHUN-YU
 */
public class City {
    /**
     * City Name.
     */
    private String name = null;

    /**
     * Constructor About City Information.
     * @param name city name
     */
    public City(String name) {
        this.setName(name);
    }

    /**
     * Set City Information About City Name.
     * @param name city name
     */
    private void setName(String name) {
        this.name = name;
    }

    /**
     * Get City Information About City Name.
     * @return city name
     */
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass().equals(this.getClass())) {
            City city = (City) obj;
            if (city.getName().equals(this.name)) {
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
