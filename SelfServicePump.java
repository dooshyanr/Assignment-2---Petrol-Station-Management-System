
/**
 * SelfServicePump is a child class of PetrolPump.
 * It provides a discount for customers using self-service pumps.
 */
public class SelfServicePump extends PetrolPump {

    // Unique attribute
    private double discountPercentage;

    // Constructor
    public SelfServicePump(int pumpID, String fuelType,
            double fuelPrice, double fuelAvailable,
            double discountPercentage) {

        super(pumpID, fuelType, fuelPrice, fuelAvailable,
              0.0, 0.0, true);

        this.discountPercentage = discountPercentage;
    }

    // Getter
    public double getDiscountPercentage() {
        return discountPercentage;
    }

    // Setter
    public void setDiscountPercentage(double discountPercentage) {
        if (discountPercentage >= 0 && discountPercentage <= 100) {
            this.discountPercentage = discountPercentage;
        }
    }

    /**
     * Polymorphism:
     * Calculates fuel cost after applying a discount.
     */
    public double calculateTotalCost(double litres) {

        double originalCost = litres * getFuelPrice();

        double discount = originalCost *
                (discountPercentage / 100);

        return originalCost - discount;
    }
}
