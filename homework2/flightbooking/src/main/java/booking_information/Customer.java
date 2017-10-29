package booking_information;

/**
 * 主要負責存取購買機票之消費者資訊.
 * 存: 消費者名子、消費者外國名、地址、連絡電話
 * 取: 消費者名子、消費者外國名、地址、連絡電話
 * @version 1.0 2017年10月27日
 * @author ALEX-CHUN-YU
 */
public class Customer {
    /**
     * Customer Name.
     */
    private String name = null;

    /**
     * Customer Foreign Name.
     */
    private String foreignName = null;

    /**
     * Customer Address.
     */
    private String address = null;

    /**
     * Customer Phone Number.
     */
    private String phoneNumber = null;

    /**
     * Constructor About Customer Information.
     * @param name customer name
     * @param foreignName customer foreign name
     * @param address customer address
     * @param phoneNumber customer phone number
     */
    public Customer(String name, String foreignName, String address, String phoneNumber) {
        this.setCustomerName(name);
        this.setCustomerForeignName(foreignName);
        this.setCustomerAddress(address);
        this.setCustomerPhoneNumber(phoneNumber);
    }

    /**
     * Set Booking Information About Customer Name.
     * @param name customer name
     */
    private void setCustomerName(String name) {
        this.name = name;
    }

    /**
     * Get Booking Information About Customer Name.
     * @return customer name
     */
    public String getCustomerName() {
        return this.name;
    }

    /**
     * Set Booking Information About Customer Foreign Name.
     * @param foreignName customer foreign name
     */
    private void setCustomerForeignName(String foreignName) {
        this.foreignName = foreignName;
    }

    /**
     * Get Booking Information About Customer Foreign Name.
     * @return costumer foreign name
     */
    public String getCustomerForeignName() {
        return this.foreignName;
    }

    /**
     * Set Booking Information About Customer Address.
     * @param address customer address
     */
    private void setCustomerAddress(String address) {
        this.address = address;
    }

    /**
     * Get Booking Information About Customer Address.
     * @return customer address
     */
    public String getCustomerAddress() {
        return this.address;
    }

    /**
     * Set Booking Information About Customer Phone Number.
     * @param phoneNumber customer phone number
     */
    private void setCustomerPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Get Booking Information About Customer Phone Number.
     * @return customer phone number
     */
    public String getCustomerPhoneNumber() {
        return this.phoneNumber;
    }

    @Override
    public String toString() {
        return "姓名:" + this.name + " 外國名:" + this.foreignName + " 住址:"
                + this.address + " 行動電話:" + this.phoneNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass().equals(this.getClass())) {
            Customer customer = (Customer) obj;
            if (customer.getCustomerName().equals(this.name)
                    && customer.getCustomerForeignName().equals(this.foreignName)
                    && customer.getCustomerPhoneNumber().equals(this.phoneNumber)
                    && customer.getCustomerAddress().equals(this.address)) {
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
