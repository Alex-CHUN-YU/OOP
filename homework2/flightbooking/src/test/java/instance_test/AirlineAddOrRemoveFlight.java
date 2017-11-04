package instance_test;

import constant_field.ConstantField;
import database.MysqlDatabaseController;
import database.SqlObject;
import flight_information.AirlineCompany;
import flight_information.Airport;
import flight_information.City;
import flight_information.Flight;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * This a Demo.
 */
public class AirlineAddOrRemoveFlight {

    public static MysqlDatabaseController mysqlDatabaseController;
    public static SqlObject sqlObject;
    public static SimpleDateFormat sdf;
    public static Flight flight;
    public static City departureCity, arrivalCity;
    public static Airport departureAirport, arrivalAirport;
    public static String departureDate, arrivalDate;
    public static Integer validityPeriod;
    public static AirlineCompany airlineCompany;
    public static Scanner scanner;

    /**
     * Load Airline Information in DB.
     */
    private static void loadAirlineInformation() throws Exception {
        // 資料庫連結
        mysqlDatabaseController = new MysqlDatabaseController();
        // 初始化設定
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        // 系統開始運作
        scanner = new Scanner(System.in);
        System.out.println("請輸入航班公司代號: ");
        airlineCompany = new AirlineCompany(scanner.nextLine());
        // SQL 語法邏輯運用
        ResultSet resultSet = mysqlDatabaseController.execSelect(
                "*", ConstantField.AIRLINE_COMPANY_TABLE,
                "name='" + airlineCompany.getName() + "'");
        // 取出航空資訊
        while (resultSet.next()) {
            departureCity = new City(resultSet.getString(4));
            departureAirport = new Airport(departureCity);
            departureDate = resultSet.getString(5);
            arrivalCity = new City(resultSet.getString(6));
            arrivalAirport = new Airport(arrivalCity);
            arrivalDate = resultSet.getString(7);
            validityPeriod = resultSet.getInt(8);
            flight = new Flight(validityPeriod
                    , sdf.parse(departureDate), sdf.parse(arrivalDate),
                    departureAirport, arrivalAirport);
            flight.setFlightNumber(resultSet.getInt(3));
            airlineCompany.registerFlight(flight);
        }
    }

    /**
     * Main Function.
     */
    public static void main(String[] argv) throws Exception {
        loadAirlineInformation();
        System.out.println("歡迎 " + airlineCompany.getName() + " 航空公司登入本系統~");
        while (true) {
            System.out.println("你好 ~ 此為航空公司增加航班系統 !");
            System.out.println("輸入1為增加航班資訊 | 輸入2為刪除航班 | 輸入3為查詢目前所有航班資訊 | 輸入4離開本系統 ");
            int userInput = scanner.nextInt();
            if (userInput == 4) {
                break;
            }
            switch (userInput) {
                case 1 :
                    while (true) {
                        sqlObject = new SqlObject();
                        sqlObject.addSqlObject(ConstantField.NAME, airlineCompany.getName());
                        System.out.println("請填寫以下航班資訊:");
                        System.out.println("輸入出發城市之機場:");
                        scanner.nextLine();
                        departureCity = new City(scanner.nextLine());
                        departureAirport = new Airport(departureCity);
                        sqlObject.addSqlObject(ConstantField.DEPARTURE_AIRPORT, departureAirport.getCity().getName());

                        System.out.println("輸入出發時間:(EX:2017-10-19 13:00)");
                        departureDate = scanner.nextLine();
                        sqlObject.addSqlObject(ConstantField.DEPARTURE_DATE, departureDate);

                        System.out.println("輸入抵達城市之機場:");
                        arrivalCity = new City(scanner.nextLine());
                        arrivalAirport = new Airport(arrivalCity);
                        sqlObject.addSqlObject(ConstantField.ARRIVAL_AIRPORT, arrivalAirport.getCity().getName());

                        System.out.println("輸入抵達時間:(EX:2017-10-19 13:00)");
                        arrivalDate = scanner.nextLine();
                        sqlObject.addSqlObject(ConstantField.ARRIVAL_DATE, arrivalDate);

                        System.out.println("輸入航班定票有效期限:");
                        validityPeriod = scanner.nextInt();
                        sqlObject.addSqlObject(ConstantField.VALIDITY_PERIOD, validityPeriod);
                        flight = new Flight(validityPeriod
                                , sdf.parse(departureDate), sdf.parse(arrivalDate),
                                departureAirport, arrivalAirport);
                        airlineCompany.registerFlight(flight);
                        sqlObject.addSqlObject(ConstantField.FLIGHT_NUMBER, flight.getFlightNumber());
                        mysqlDatabaseController.execInsert(ConstantField.AIRLINE_COMPANY_TABLE, sqlObject);
                        System.out.println("增加航班資訊成功!(如沒有要繼續增加航班請輸入0)");
                        scanner.nextLine();
                        if (scanner.nextLine().equals("0")) {
                            break;
                        }
                    } break;
                case 2 :
                    while (true) {
                        System.out.println("請輸入航班號碼:");
                        Integer flightNumber = scanner.nextInt();
                        airlineCompany.unregisterFlight(flightNumber);
                        mysqlDatabaseController.execDelete(ConstantField.AIRLINE_COMPANY_TABLE,
                                ConstantField.NAME + "='" + airlineCompany.getName()
                                        + "' and " + ConstantField.FLIGHT_NUMBER + "=" + flightNumber);
                        System.out.println("(如沒有要繼續刪除航班請輸入0)");
                        scanner.nextLine();
                        if (scanner.nextLine().equals("0")) {
                            break;
                        }
                    } break;
                case 3 :
                    break;
                default:
                    System.out.println("請重新輸入!!");
                    break;
            }
            System.out.println("以下為 " + airlineCompany.getName() + " 航空公司目前所有航班資訊:");
            for (Integer flightNumber : airlineCompany.getFlights().keySet()) {
                if (airlineCompany.getFlights().get(flightNumber) != null) {
                    System.out.println("航空代碼:" + airlineCompany.getName() + "00" + flightNumber);
                    System.out.println(airlineCompany.getFlights().get(flightNumber).toString());
                }
            }
            if (airlineCompany.getFlights().size() == 0) {
                System.out.println("目前沒有任何航班資訊。\n");
            }
        }
    }
}
