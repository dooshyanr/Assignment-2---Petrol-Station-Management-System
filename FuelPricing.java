
/**
 * FuelPricing interface.
 * Provides a common method for calculating fuel costs.
 * This supports polymorphism in the petrol station system.
 */
public interface FuelPricing {

    // Both pump types must implement their own calculation.
    double calculateTotalCost(double litres);
}
