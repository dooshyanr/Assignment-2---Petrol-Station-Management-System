
/**
 * FuelCustomer stores the customer's information.
 * Private attributes protect customer data.
 */
public class FuelCustomer {

    private int customerID;
    private String customerName;
    private String phoneNumber;

    // Constructor
    public FuelCustomer(int customerID, String customerName,
                        String phoneNumber) {
        setCustomerID(customerID);
        setCustomerName(customerName);
        setPhoneNumber(phoneNumber);
    }

    // Getters
    public int getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Setters
    public void setCustomerID(int customerID) {
        if (customerID > 0) {
            this.customerID = customerID;
        }
    }

    public void setCustomerName(String customerName) {
        if (customerName != null && !customerName.trim().isEmpty()) {
            this.customerName = customerName;
        }
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber != null && !phoneNumber.trim().isEmpty()) {
            this.phoneNumber = phoneNumber;
        }
    }

    // Display customer information
    public void displayCustomer() {
        System.out.println("\nCustomer Information");
        System.out.println("Customer ID: " + customerID);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Phone Number: " + phoneNumber);
    }
}
