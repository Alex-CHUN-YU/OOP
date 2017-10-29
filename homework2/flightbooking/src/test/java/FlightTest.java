import flight_information.*;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;

/**
 * This a Demo.
 */
public class FlightTest {
    /**
     * Date Format.
     */
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    /**
     * Airline Company Name List.
     */
    private AirlineCompany airlineCompany;

    /**
     * Flight.
     */
    private Flight flight1, flight2, flight3;

    /**
     * Initial.
     * @throws Exception exception
     */
    private void companyFlightInitial() throws Exception {
        airlineCompany = new AirlineCompany("TPE");
        // 機場及地點
        City taoyuan = new City("Taoyuan");
        Airport taoyuanAirport = new Airport(taoyuan);
        City taichung = new City("Taichung");
        Airport taichungAirport = new Airport(taichung);
        City tainan = new City("Tainan");
        Airport tainanAirport = new Airport(tainan);
        // 飛機一號
        flight1 = new Flight(10,
                sdf.parse("2017-10-19 13:00"), sdf.parse("2017-10-19 14:00"),
                tainanAirport, taichungAirport);
        // 飛機二號
        flight2 = new Flight(10,
                sdf.parse("2017-10-19 15:00"), sdf.parse("2017-10-19 16:00"),
                taichungAirport, taoyuanAirport);
        // 飛機三號
        flight3 = new Flight(10,
                sdf.parse("2017-10-19 13:00"), sdf.parse("2017-10-19 16:00"),
                tainanAirport, taoyuanAirport);
    }

    /**
     * 增加航班.
     * @throws Exception exception
     */
    @Test
    public void addCompanyFlightTest() throws Exception {
        companyFlightInitial();
        System.out.println("新增後的航班資訊:");
        airlineCompany.registerFlight(flight1);
        airlineCompany.registerFlight(flight2);
        airlineCompany.registerFlight(flight3);
        for (Integer flightNumber : airlineCompany.getFlights().keySet()) {
            if (airlineCompany.getFlights().get(flightNumber) != null) {
                System.out.println("飛機代碼:" + airlineCompany.getName() + flightNumber);
                System.out.println(airlineCompany.getFlights().get(flightNumber).toString());
            }
        }
    }

    /**
     * 移除航班.
     * @throws Exception exception
     */
    @Test
    public void removeCompanyFlightTest() throws Exception {
        addCompanyFlightTest();
        System.out.println("刪除 " + airlineCompany.getName()
                + flight2.getFlightNumber() + " 後的航班資訊:");
        airlineCompany.unregisterFlight(flight2.getFlightNumber());
        for (Integer flightNumber : airlineCompany.getFlights().keySet()) {
            if (airlineCompany.getFlights().get(flightNumber) != null) {
                System.out.println("飛機代碼:" + airlineCompany.getName() + flightNumber);
                System.out.println(airlineCompany.getFlights().get(flightNumber).toString());
            }
        }
    }

    /**
     * 增加 Stopover 之航班.
     * @throws Exception exception
     */
    @Test
    public void addStopoverTest() throws Exception {
        airlineCompany = new AirlineCompany("TPE");
        // 機場及地點
        City taoyuan = new City("Taoyuan");
        Airport taoyuanAirport = new Airport(taoyuan);
        City tainan = new City("Tainan");
        Airport tainanAirport = new Airport(tainan);
        // 飛機三號
        flight3 = new Flight(10,
                sdf.parse("2017-10-19 13:00"), sdf.parse("2017-10-19 16:00"),
                tainanAirport, taoyuanAirport);
        // Add Stopover
        City taichung = new City("Taichung");
        Airport taichungAirport = new Airport(taichung);
        Stopover stopover = new Stopover(sdf.parse("2017-10-19 14:00"),
                sdf.parse("2017-10-19  15:00"), taichungAirport);
        flight3.addStopover(stopover);
        airlineCompany.registerFlight(flight3);
        System.out.println("飛機代碼:" + airlineCompany.getName() + flight3.getFlightNumber());
        System.out.print(airlineCompany.getFlights().get(flight3.getFlightNumber()).toString());
        System.out.println(airlineCompany.getFlights().get(flight3.getFlightNumber()).
                getStopovers().get(0));
    }
}
