package default_answer_test;

import flight_information.*;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;

/**
 * This a Test.
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
    private Flight flight1, flight2, flight3, flight4;

    /**
     * Airport.
     */
    private Airport taoyuanAirport, taichungAirport, kaohsiungAirport, shanghaiPudongAirport;

    /**
     * Initial.
     * @throws Exception exception
     */
    private void companyFlightInitial() throws Exception {
        // 航空公司
        airlineCompany = new AirlineCompany("BR");
        // 機場及地點
        City taoyuan = new City("Taoyuan");
        taoyuanAirport = new Airport(taoyuan);
        City taichung = new City("Taichung");
        taichungAirport = new Airport(taichung);
        City kaohsiung = new City("Kaohsiung International");
        kaohsiungAirport = new Airport(kaohsiung);
        City shanghaiPudong = new City("Shanghai Pudong International");
        shanghaiPudongAirport = new Airport(shanghaiPudong);
        // 飛機一號
        flight1 = new Flight(10,
                sdf.parse("2017-10-19 13:00"), sdf.parse("2017-10-19 14:00"),
                taoyuanAirport, taichungAirport);
        // 飛機二號
        flight2 = new Flight(10,
                sdf.parse("2017-10-19 15:00"), sdf.parse("2017-10-19 17:00"),
                kaohsiungAirport, taoyuanAirport);
        // 飛機三號
        flight3 = new Flight(10,
                sdf.parse("2017-10-19 13:00"), sdf.parse("2017-10-19 18:00"),
                kaohsiungAirport, shanghaiPudongAirport);
    }

    /**
     * 航空公司增加航班資訊.
     * @throws Exception exception
     */
    @Test
    public void addCompanyFlightTest() throws Exception {
        // 初始化資料
        companyFlightInitial();
        // 航空公司增加航班
        System.out.println("新增後的航班資訊:");
        airlineCompany.registerFlight(flight1);
        airlineCompany.registerFlight(flight2);
        airlineCompany.registerFlight(flight3);
        for (Integer flightNumber : airlineCompany.getFlights().keySet()) {
            if (airlineCompany.getFlights().get(flightNumber) != null) {
                System.out.println("飛機代碼:" + airlineCompany.getName() + "00" + flightNumber);
                System.out.println(airlineCompany.getFlights().get(flightNumber).toString());
            }
        }
    }

    /**
     * 航空公司移除航班資訊.
     * @throws Exception exception
     */
    @Test
    public void removeCompanyFlightTest() throws Exception {
        // 航空公司增加航班
        addCompanyFlightTest();
        // 航空公司刪除航班
        System.out.println("刪除 " + airlineCompany.getName()
                + "00" + flight2.getFlightNumber() + " 後的航班資訊:");
        airlineCompany.unregisterFlight(flight2.getFlightNumber());
        for (Integer flightNumber : airlineCompany.getFlights().keySet()) {
            if (airlineCompany.getFlights().get(flightNumber) != null) {
                System.out.println("飛機代碼:" + airlineCompany.getName() + "00" + flightNumber);
                System.out.println(airlineCompany.getFlights().get(flightNumber).toString());
            }
        }
    }

    /**
     * 航空公司增加轉機休息資訊.
     * @throws Exception exception
     */
    @Test
    public void addStopoverTest() throws Exception {
        // 航空公司增加航班
        addCompanyFlightTest();
        // Add Stopover 香港機場
        City hongKong = new City("Hong Kong International");
        Airport hongKongAirport = new Airport(hongKong);
        Stopover stopover = new Stopover(sdf.parse("2017-10-19 14:30"),
                sdf.parse("2017-10-19  16:30"), hongKongAirport);
        // 飛機三號進行增加轉機機場
        flight3.addStopover(stopover);
        System.out.println("飛機代碼:" + airlineCompany.getName() + "00" + flight3.getFlightNumber());
        System.out.print(airlineCompany.getFlights().get(flight3.getFlightNumber()).toString());
        System.out.println(airlineCompany.getFlights().get(flight3.getFlightNumber()).
                getStopovers().get(0));
    }
}
