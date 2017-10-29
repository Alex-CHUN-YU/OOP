import booking_information.Booking;
import booking_information.Customer;
import booking_information.Passenger;
import flight_information.*;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static java.util.Arrays.asList;

/**
 * This a Demo.
 */
public class FlightBooking {
    /**
     * Random.
     */
    private static Random randomGenerator;

    /**
     * Date Format.
     */
    private static SimpleDateFormat sdf;

    /**
     * Airline Company Name List.
     */
    private static ArrayList<String> companyAirportName;

    /**
     * Airline Company Name List.
     */
    private static ArrayList<String> companyName;

    /**
     * City Name List.
     */
    private static ArrayList<String> cityName;

    /**
     * City Name List.
     */
    private static Airport airport;

    /**
     * Initial.
     */
    private static void initial () {
        randomGenerator = new Random();
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        companyAirportName = new ArrayList<String>(asList("桃園國際機場", "松山航空站", "高雄國際機場", "台南航空站"));
        companyName = new ArrayList<String>(asList("TPE", "TSA", "KHH", "TNN"));
        cityName = new ArrayList<String>(Arrays.asList("墨爾本機場", "巴黎戴高樂機場", "倫敦希斯路機場", "甘迺迪國際機場"));
    }

    @Test
    public void flightBooking() throws Exception {
        // 初始化，將所需資訊先載入
        initial ();
        // 亂數產生航空公司
        int companyIndex = randomGenerator.nextInt(companyName.size());
        AirlineCompany airlineCompany = new AirlineCompany(companyName.get(companyIndex));
        // 飛機航班並亂數產生出發及抵達的機場
        City departureCity = new City(companyAirportName.get(companyIndex));
        City arrivalCity = new City(cityName.get(randomGenerator.nextInt(cityName.size())));
        Airport departureAirport = new Airport(departureCity);
        Airport arrivalAirport = new Airport(arrivalCity);
        Flight flight = new Flight(10,
                sdf.parse("2017-10-18 13:00"), sdf.parse("2017-10-19 9:00"),
                departureAirport, arrivalAirport);
        // 消費者訂機票程序所要求之資訊
        Customer customer = new Customer("簡君聿", "Alex", "台灣", "0988719738");
        ArrayList<Passenger> passengers = new ArrayList<Passenger>();
        Passenger passenger1 = new Passenger("周星馳" , "Stephen Chow");
        Passenger passenger2 = new Passenger("劉德華" , "Andy Lau");
        passengers.add(passenger1);
        passengers.add(passenger2);
        Booking booking = new Booking(customer, passengers);
        // 提供飛機訂票資訊
        flight.openBooking(booking);
        for (Booking bookingPerson : flight.getBookings()) {
            System.out.print(bookingPerson);
        }
        // 機場人員新增修改飛機資訊
        airlineCompany.registerFlight(flight);
        // 輸出範例
        System.out.println("航班資訊:");
        for (int i = 0; i < airlineCompany.getFlights().size(); i++) {
            System.out.print("飛機名稱:" + airlineCompany.getName());
            System.out.println(airlineCompany.getFlights().get(i).getFlightNumber() + " ");
            System.out.println("有效期限:" + airlineCompany.getFlights().get(i).getValidityPeriod() + " ");
            System.out.print("出發時間:" + sdf.format(airlineCompany.getFlights().get(i).getDepartureTime()) + " ");
            System.out.println("抵達時間:" + sdf.format(airlineCompany.getFlights().get(i).getArrivalTime()) + " ");
            System.out.print("出發地點:" + airlineCompany.getFlights().get(i).getDepartureAirport() + " ");
            System.out.print("抵達地點:" + airlineCompany.getFlights().get(i).getArrivalAirport() + " ");
            System.out.println("總花費時間:" + airlineCompany.getFlights().get(i).getFlightTime() + "小時");
        }
    }
}
