import booking_information.Customer;
import booking_information.Movie;

/**
 * 一對多以及多對一測試類別.
 */
class BookingTest {
    /**
     * This is test.
     * @param args system default
     */
    public static void main(String[] args) {
        // 電影院中存在兩部電影
        Movie movieOne = new Movie("玩命關頭7");
        Movie movieSecond = new Movie("可可夜總會");
        // 以下三位顧客進行訂票
        Customer customerOne = new Customer("簡君聿");
        Customer customerSecond = new Customer("劉德華");
        Customer customerThird = new Customer("張忠謨");
        //將電影以及座位號碼給予消費者訂票資訊(實際 Link)
        customerOne.makeBooking(movieOne, "L8");
        customerOne.makeBooking(movieSecond, "P7");
        customerSecond.makeBooking(movieSecond, "P8");
        customerThird.makeBooking(movieOne, "L9");
        // 查看某個顧客的訂票清單(Association)
        customerOne.getAllBookingOfCustomer();
        // 查看某部電影的訂票資料(Association)
        movieOne.getAllBookingOfMovie();
        movieSecond.getAllBookingOfMovie();
    }
}