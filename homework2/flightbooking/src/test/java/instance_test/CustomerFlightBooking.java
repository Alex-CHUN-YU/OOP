package instance_test;

import booking_information.Booking;
import booking_information.Customer;
import booking_information.Passenger;
import constant_field.ConstantField;
import database.MysqlDatabaseController;
import database.SqlObject;

import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static java.util.Arrays.asList;

/**
 * This a Demo.
 */
public class CustomerFlightBooking {
    /**
     * Main Function.
     */
    public static void main(String[] argv) throws Exception {
        // 資料庫連結
        MysqlDatabaseController mysqlDatabaseController = new MysqlDatabaseController();
        // 初始化設定
        SqlObject customerSqlObject;
        SqlObject passengerSqlObject;
        Customer customer = null;
        Passenger passenger;
        ArrayList<Passenger> passengers;
        Booking booking;
        String bookingID;
        String customerName;
        ResultSet resultSet;
        String passengerName;
        String customerForeignName;
        String passengerForeignName;
        String address ;
        String phoneNumber;
        String airlineName;
        Integer flightNumber;
        // 系統開始運作
        Scanner scanner = new Scanner(System.in);
        System.out.println("你好 ~ 此為顧客訂票查詢系統 !");
        while (true) {
            System.out.println("輸入1為訂購機票 | 輸入2為查詢機票 | 輸入3取消機票 | 輸入4離開本系統 ");
            int userInput = scanner.nextInt();
            if (userInput == 4) {
                break;
            }
            switch (userInput) {
                case 1:
                    customerSqlObject = new SqlObject();
                    passengerSqlObject = new SqlObject();
                    passengers = new ArrayList<Passenger>();
                    System.out.println("歡迎進入訂票系統!");
                    System.out.println("請輸入出發地點:");
                    scanner.nextLine();
                    String departureCity = scanner.nextLine();
                    System.out.println("請輸入抵達地點:");
                    String arrivalCity = scanner.nextLine();
                    System.out.println("請輸入出發日期:(格式: 2017-11-03)");
                    String date = scanner.nextLine();
                    // SQL 語法邏輯運用，主要負責查詢是否有此航班資訊
                    resultSet = mysqlDatabaseController.execSelect(
                                "name, flight_number, departure_date",
                                ConstantField.AIRLINE_COMPANY_TABLE + " as a",
                                "a.departure_airport='" + departureCity + "'"
                                        + "and a.arrival_airport='" + arrivalCity + "'");
                    if (resultSet.next()) {
                        airlineName = resultSet.getString(1);
                        flightNumber = resultSet.getInt(2);
                        if (resultSet.getString(3).contains(date)) {
                            System.out.println("請輸入消費者姓名: ");
                            customerName = scanner.nextLine();
                            customerSqlObject.addSqlObject(ConstantField.CUSTOMER_NAME, customerName);

                            System.out.println("請輸入消費者護照英文名: ");
                            customerForeignName = scanner.nextLine();
                            customerSqlObject.addSqlObject(ConstantField.CUSTOMER_FOREIGN_NAME, customerForeignName);

                            System.out.println("請輸入消費者住址: ");
                            address = scanner.nextLine();
                            customerSqlObject.addSqlObject(ConstantField.CUSTOMER_ADDRESS, address);

                            System.out.println("請輸入消費者電話: ");
                            phoneNumber = scanner.nextLine();
                            customerSqlObject.addSqlObject(ConstantField.CUSTOMER_PHONE_NUMBER, phoneNumber);
                            customer = new Customer(customerName, customerForeignName, address, phoneNumber);
                            while (true) {
                                System.out.println("請輸入乘客姓名: ");
                                passengerName = scanner.nextLine();
                                System.out.println("請輸入乘客護照英文名: ");
                                passengerForeignName = scanner.nextLine();
                                System.out.println("如要繼續增加請輸入1，沒有請輸入 0 離開");
                                passenger = new Passenger(passengerName, passengerForeignName);
                                passengers.add(passenger);
                                int exitNumber = scanner.nextInt();
                                if (exitNumber == 0) {
                                    break;
                                }
                                scanner.nextLine();
                            }
                            booking = new Booking(customer, passengers);
                            // 隨機產生訂單號碼
                            Random random = new Random();
                            ArrayList<String> airlineCompanyList = new ArrayList<String>(asList("a", "b", "c", "d"));
                            int randomNumber = random.nextInt(9) + 1;
                            int randomNumber1 = random.nextInt(9) + 1;
                            int randomChar = random.nextInt(3) + 1;
                            System.out.println(randomChar);
                            bookingID = randomNumber + airlineName + randomNumber1 + airlineCompanyList.get(randomChar);
                            booking.setBookingNumber(bookingID);
                            // 寫入資料庫
                            customerSqlObject.addSqlObject(ConstantField.BOOKING_ID, booking.getBookingNumber());
                            customerSqlObject.addSqlObject(ConstantField.NAME, airlineName);
                            customerSqlObject.addSqlObject(ConstantField.FLIGHT_NUMBER, flightNumber);
                            mysqlDatabaseController.execInsert(ConstantField.CUSTOMER_BOOKING_ID_TABLE, customerSqlObject);
                            for (Passenger p : passengers) {
                                passengerSqlObject.addSqlObject(ConstantField.BOOKING_ID, booking.getBookingNumber());
                                passengerSqlObject.addSqlObject(ConstantField.PASSENGER_NAME, p.getPassengerName());
                                passengerSqlObject.addSqlObject(ConstantField.PASSENGER_FOREIGN_NAME, p.getPassengerForeignName());
                                mysqlDatabaseController.execInsert(ConstantField.PASSENGERS_TABLE, passengerSqlObject);
                            }
                            System.out.println("以下為你的航班資訊祝你有個愉快的旅程^^");
                            System.out.print(booking.toString());
                            resultSet = mysqlDatabaseController.execSelect(
                                    "name, flight_number, departure_date, arrival_date, validity_period",
                                    ConstantField.AIRLINE_COMPANY_TABLE + " as a",
                                    "a.name='" + airlineName + "' and a.flight_number='"
                                            + flightNumber + "'");
                            if (resultSet.next()) {
                                System.out.println(
                                        "飛機號碼:" + resultSet.getString(1)
                                                + resultSet.getString(2)
                                                + "\n出發時間:" + resultSet.getString(3)
                                                + " 抵達時間:" + resultSet.getString(4)
                                                + "\n出發地點:" + departureCity
                                                + " 抵達地點:" + arrivalCity
                                                + "\n機票有效期限:" + 	resultSet.getString(5) + "天\n");
                            }
                        } else {
                            System.out.println("此日期沒有開往之航班");
                        }
                    } else {
                        System.out.println("很抱歉沒有此航班資訊");
                    }
                    break;
                case 2:
                    passengers = new ArrayList<Passenger>();
                    System.out.println("請輸入機票訂單號碼: ");
                    scanner.nextLine();
                    bookingID = scanner.nextLine();
                    System.out.println("請輸入本名: ");
                    customerName = scanner.nextLine();
                    try {
                        // SQL 語法邏輯運用
                        resultSet = mysqlDatabaseController.execSelect(
                                "*", ConstantField.CUSTOMER_BOOKING_ID_TABLE + " as a,"
                                        + ConstantField.PASSENGERS_TABLE + " as b ",
                                "a.booking_id='" + bookingID + "' and a.booking_id=b.booking_id and a.customer_name='"
                                        + customerName + "'");
                        boolean flag = false;
                        while (resultSet.next()) {
                            if (!flag) {
                                customer = new Customer(resultSet.getString(4), resultSet.getString(5),
                                        resultSet.getString(6), resultSet.getString(7));
                                flag = true;
                            }
                            passengers.add(new Passenger(resultSet.getString(10), resultSet.getString(11)));
                        }
                        booking = new Booking(customer, passengers);
                        booking.setBookingNumber(bookingID);
                        System.out.println(booking.toString());
                    } catch (Exception e) {
                        System.out.println("查無此訂單！！");
                    }
                    break;
                case 3:
                    System.out.println("請輸入欲取消之訂單號碼: ");
                    scanner.nextLine();
                    bookingID = scanner.nextLine();
                    resultSet = mysqlDatabaseController.execSelect(
                            "*", ConstantField.CUSTOMER_BOOKING_ID_TABLE + " as a,"
                                    + ConstantField.PASSENGERS_TABLE + " as b ",
                            "a.booking_id='" + bookingID + "' and a.booking_id=b.booking_id");
                    if (resultSet.next()) {
                        // SQL 語法邏輯運用
                        mysqlDatabaseController.execDelete(ConstantField.CUSTOMER_BOOKING_ID_TABLE,
                                ConstantField.BOOKING_ID + "='" + bookingID + "'");
                        mysqlDatabaseController.execDelete(ConstantField.PASSENGERS_TABLE,
                                ConstantField.BOOKING_ID + "='" + bookingID + "'");
                        System.out.println("取消班機資訊成功!");
                    } else {
                        System.out.println("查無此訂單！！");
                    }
                    break;
                default:
                    System.out.println("請重新輸入!!");
                    break;
            }
        }
    }
}
