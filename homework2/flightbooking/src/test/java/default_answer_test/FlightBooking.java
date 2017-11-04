package default_answer_test;

import booking_information.Booking;
import booking_information.Customer;
import booking_information.Passenger;
import flight_information.AirlineCompany;
import flight_information.Airport;
import flight_information.City;
import flight_information.Flight;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static java.util.Arrays.asList;

/**
 * This a Test.
 */
public class FlightBooking {
    @Test
    public void flightBooking() throws Exception {
        // 初始化，將所需資訊先載入
        Random randomGenerator = new Random();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        ArrayList<String> departureAirportList =
                new ArrayList<String>(asList("Taoyuan International", "Songshan"
                , "Kaohsiung International", "Tainan"));
        ArrayList<String> arrivalAirportList =
                new ArrayList<String>(Arrays.asList("Melbourne", "Charles de Gaulle",
                "Heathrow", "John F. Kennedy International"));
        ArrayList<String> airlineCompanyList = new ArrayList<String>(asList("BR", "CI", "GE", "FE"));
        // 亂數產生航空公司
        AirlineCompany airlineCompany = new AirlineCompany(airlineCompanyList.get(randomGenerator.nextInt(airlineCompanyList.size())));
        // 飛機航班並亂數產生出發及抵達的機場
        City departureCity = new City(departureAirportList.get(randomGenerator.nextInt(departureAirportList.size())));
        City arrivalCity = new City(arrivalAirportList.get(randomGenerator.nextInt(arrivalAirportList.size())));
        Airport departureAirport = new Airport(departureCity);
        Airport arrivalAirport = new Airport(arrivalCity);
        Flight flight = new Flight(10,
                sdf.parse("2017-10-18 13:00"), sdf.parse("2017-10-19 9:00"),
                departureAirport, arrivalAirport);
        // 消費者訂機票程序所要求之資訊
        Customer customer = new Customer("簡君聿", "CHUN-YU", "台灣", "0988719738");
        ArrayList<Passenger> passengers = new ArrayList<Passenger>();
        Passenger passenger1 = new Passenger("周星馳" , "Stephen-Chow");
        Passenger passenger2 = new Passenger("劉德華" , "Andy-Lau");
        passengers.add(passenger1);
        passengers.add(passenger2);
        Booking booking = new Booking(customer, passengers);
        // 提供飛機訂票資訊
        flight.openBooking(booking);
        // 印出消費者及乘客資訊
        for (Booking bookingPerson : flight.getBookings()) {
            System.out.print(bookingPerson);
        }
        // 機場人員新增飛機資訊
        airlineCompany.registerFlight(flight);
        // 顯示航班資訊
        System.out.println("航班資訊:");
        for (int i = 0; i < airlineCompany.getFlights().size(); i++) {
            System.out.print("飛機代碼:" + airlineCompany.getName() + "00");
            System.out.println(airlineCompany.getFlights().get(i).getFlightNumber() + " ");
            System.out.println("有效期限:" + airlineCompany.getFlights().get(i).getValidityPeriod() + "天");
            System.out.print("出發時間:" + sdf.format(airlineCompany.getFlights().get(i).getDepartureTime()) + " ");
            System.out.println("抵達時間:" + sdf.format(airlineCompany.getFlights().get(i).getArrivalTime()) + " ");
            System.out.print("出發地點:" + airlineCompany.getFlights().get(i).getDepartureAirport() + " ");
            System.out.print("抵達地點:" + airlineCompany.getFlights().get(i).getArrivalAirport() + " ");
            System.out.println("總花費時間:" + airlineCompany.getFlights().get(i).getFlightTime() + "小時");
        }
    }
}
