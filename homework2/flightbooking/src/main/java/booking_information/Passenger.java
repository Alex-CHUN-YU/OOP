package booking_information;

/**
 * 主要負責存取消費者所購買之乘客資訊.
 * 存: 乘客名子、乘客外國名
 * 取: 乘客名子、乘客外國名
 * @version 1.0 2017年10月27日
 * @author ALEX-CHUN-YU
 */
public class Passenger {
    /**
     * Passenger Name.
     */
    private String name = null;

    /**
     * Passenger Foreign Name.
     */
    private String foreignName = null;

    /**
     * Constructor About Passenger Information.
     * @param name passenger name
     * @param foreignName passenger foreign name
     */
    public Passenger(String name, String foreignName) {
        this.setPassengerName(name);
        this.setPassengerForeignName(foreignName);
    }

    /**
     * Set Booking Information About Passenger Name.
     * @param name passenger name
     */
    private void setPassengerName(String name) {
        this.name = name;
    }

    /**
     * Get Booking Information About Passenger Name.
     * @return passenger name
     */
    public String getPassengerName() {
        return this.name;
    }

    /**
     * Set Booking Information About Passenger Foreign Name.
     * @param foreignName passenger foreign name
     */
    private void setPassengerForeignName(String foreignName) {
        this.foreignName = foreignName;
    }

    /**
     * Get Booking Information About Passenger Foreign Name.
     * @return passenger foreign name
     */
    public String getPassengerForeignName() {
        return this.foreignName;
    }

    @Override
    public String toString() {
        return "姓名:" + this.name + " 外國名:" + this.foreignName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass().equals(this.getClass())) {
            Passenger passenger = (Passenger) obj;
            if (passenger.getPassengerName().equals(this.name)
                    && passenger.getPassengerForeignName().equals(this.foreignName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
