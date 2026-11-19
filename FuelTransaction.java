
/**
 * FuelTransaction stores information about a fuel purchase.
 * It helps keep a record of customer fuel transactions.
 */
public class FuelTransaction {

    private int transactionID;
    private String fuelType;
    private double litresPurchased;
    private double totalAmount;

    // Constructor
    public FuelTransaction(int transactionID, String fuelType,
            double litresPurchased, double totalAmount) {

        this.transactionID = transactionID;
        this.fuelType = fuelType;
        this.litresPurchased = litresPurchased;
        this.totalAmount = totalAmount;
    }

    // Getters
    public int getTransactionID() {
        return transactionID;
    }

    public String getFuelType() {
        return fuelType;
    }

    public double getLitresPurchased() {
        return litresPurchased;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    // Setters
    public void setTransactionID(int transactionID) {
        if (transactionID > 0) {
            this.transactionID = transactionID;
        }
    }

    public void setFuelType(String fuelType) {
        if (fuelType != null && !fuelType.trim().isEmpty()) {
            this.fuelType = fuelType;
        }
    }

    public void setLitresPurchased(double litresPurchased) {
        if (litresPurchased >= 0) {
            this.litresPurchased = litresPurchased;
        }
    }

    public void setTotalAmount(double totalAmount) {
        if (totalAmount >= 0) {
            this.totalAmount = totalAmount;
        }
    }

    // Display transaction information
    public void displayTransaction() {
        System.out.println("\n===== TRANSACTION RECEIPT =====");
        System.out.println("Transaction ID: " + transactionID);
        System.out.println("Fuel Type: " + fuelType);
        System.out.printf("Litres Purchased: %.2f%n", litresPurchased);
        System.out.printf("Total Amount: RM %.2f%n", totalAmount);
    }
}
