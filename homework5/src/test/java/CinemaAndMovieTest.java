import booking_information.Movie;
import company_information.Cinema;

/**
 *  多對多測試類別.
 */
class CinemaAndMovieTest {
    /**
     * This is test.
     * @param args system default
     */
    public static void main(String[] args) {
        // 產生兩個電影院
        Cinema cinemaOne = new Cinema("威秀");
        Cinema cinemaSecond = new Cinema("日新");
        // 電影院中存在兩部電影
        Movie movieOne = new Movie("玩命關頭7");
        Movie movieSecond = new Movie("可可夜總會");
        // 將電影加入並秀出此電影院目前上映的有哪些電影(實際 Link)
        cinemaOne.addLinkToMovie(movieOne);
        cinemaOne.addLinkToMovie(movieSecond);
        cinemaSecond.addLinkToMovie(movieOne);
        // 秀出目前電影院所有電影(Association)
        cinemaOne.getAllMovieOfCinema();
        cinemaSecond.getAllMovieOfCinema();
        // 將電影院加入當前電影目前售予的電影院(實際 Link)
        movieOne.addLinkToCinema(cinemaOne);
        movieOne.addLinkToCinema(cinemaSecond);
        movieSecond.addLinkToCinema(cinemaOne);
        // 秀出目前電影歸屬的電影院(Association)
        movieOne.getAllCinemaOfMovie();
        movieSecond.getAllCinemaOfMovie();
        // 此電影院擁有的電影名稱 (實際 Link)
        cinemaSecond.findMovie(movieOne);
    }
}