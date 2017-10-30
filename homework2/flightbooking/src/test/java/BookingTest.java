import booking_information.Booking;
import booking_information.Customer;
import booking_information.Passenger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * This a Demo.
 */
public class BookingTest {
    /**
     * 消費者與乘客訂機票資訊.
     * @throws Exception exception
     */
    @Test
    public void bookingTest() throws Exception {
        // 消費者訂機票程序所要求之資訊
        Customer customer = new Customer("簡君聿", "CHUN-YU", "台灣", "0988719738");
        ArrayList<Passenger> passengers = new ArrayList<Passenger>();
        Passenger passenger1 = new Passenger("周星馳" , "Stephen-Chow");
        Passenger passenger2 = new Passenger("劉德華" , "Andy-Lau");
        passengers.add(passenger1);
        passengers.add(passenger2);
        Booking booking = new Booking(customer, passengers);
        System.out.print(booking.toString());

        Assert.assertEquals(booking.toString(),
                "訂機號碼:" + booking.getBookingNumber()
                        + "\n消費者資訊:\n"
                        + customer.toString()
                        + "\n乘客資訊:\n" + passengers.toString() + "\n\n");
    }
}
