package company_information;

/**
 * Cinema <-> Company (一對一).
 * @version 1.0 2017年12月05日
 * @author ALEX-CHUN-YU
 */
public class Company {
    /**
     * Cinema.
     */
    private Cinema cinema;

    /**
     * Company Name.
     */
    private	String name;

    /**
     * Constructor.
     * @param name company name
     */
    public Company(String name) {
        this.name = name;
    }

    /**
     * Get Company Name.
     * @return company name
     */
    public String getName() {
        return name;
    }

    /**
     * Add Cinema(link).
     * @param cinemaOne cinema one
     */
    public void addLinkToCinema(Cinema cinemaOne) {
        this.cinema = cinemaOne;
    }

    /**
     * Get All Booking Of Customer(association).
     */
    public void getCinemaOfCompany() {
        System.out.println("\n" + this.getName() + "你好~以下為你名下電影院資訊:");
        System.out.println("電影院:" + this.cinema.getName() + "影城");
    }
}
