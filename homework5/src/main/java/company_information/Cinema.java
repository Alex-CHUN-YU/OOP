package company_information;

import booking_information.Movie;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Movie <-> Cinema (多對多)，Cinema <-> Company(一對一).
 * @version 1.0 2017年12月04日
 * @author ALEX-CHUN-YU
 */
public class Cinema {
    /**
     * Movie List.
     */
    private ArrayList<Movie> movies = new ArrayList<Movie>();

    /**
     * Company.
     */
    private Company company;

    /**
     * Cinema Name.
     */
    private	String name;

    /**
     * Constructor.
     * @param name cinema name
     */
    public Cinema(String name) {
        this.name = name;
    }

    /**
     * Get Cinema Name.
     * @return cinema name
     */
    public String getName() {
        return name;
    }

    /**
     * Make Movie(link).
     * @param movie movie
     */
    public void addLinkToMovie(Movie movie) {
        movies.add(movie);
    }

    /**
     * Find Movie(link).
     * @param movie movie
     */
    public void findMovie(Movie movie) {
        Iterator<Movie> iterator = movies.iterator();
        while (iterator.hasNext()) {
            if (movie.equals(iterator.next())) {
                System.out.println("\n你所找到的電影:" + movie.getName());
            }
        }
    }

    /**
     * Get All Movie Of Cinema(association).
     */
    public void getAllMovieOfCinema() {
        System.out.println("\n" + this.getName() + "電影院目前所上映:");
        Iterator<Movie> iterator = movies.iterator();
        while (iterator.hasNext()) {
            iterator.next().showInformationOfMovie();
        }
    }

    /**
     * Show Cinema Information.
     */
    public void showInformationOfCinema() {
        System.out.println("電影院:" + this.getName() + " ");
    }

    /**
     * Add Company(link).
     * @param companyOne company one
     */
    public void addLinkToCompany(Company companyOne) {
        this.company = companyOne;
    }

    /**
     * Get All Booking Of Customer(association).
     */
    public void getCompanyOfCinema() {
        System.out.print("\n" + this.getName() + "影城~\n目前所屬的公司為:");
        System.out.println(this.company.getName());
    }
}
