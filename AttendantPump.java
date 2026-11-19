
/**
 * AttendantPump is another child class of PetrolPump.
 * It includes an attendant name and service fee.
 */
public class AttendantPump extends PetrolPump {

    // Two unique attributes
    private String attendantName;
    private double serviceFee;

    // Constructor
    public AttendantPump(int pumpID, String fuelType,
            double fuelPrice, double fuelAvailable,
            String attendantName, double serviceFee) {

        super(pumpID, fuelType, fuelPrice, fuelAvailable,
              0.0, 0.0, true);

        setAttendantName(attendantName);
        setServiceFee(serviceFee);
    }

    // Getter methods
    public String getAttendantName() {
        return attendantName;
    }

    public double getServiceFee() {
        return serviceFee;
    }

    // Setter methods
    public void setAttendantName(String attendantName) {
        if (attendantName != null && !attendantName.trim().isEmpty()) {
            this.attendantName = attendantName;
        }
    }

    public void setServiceFee(double serviceFee) {
        if (serviceFee >= 0) {
            this.serviceFee = serviceFee;
        }
    }

    /**
     * Polymorphism:
     * Calculates fuel cost and adds an attendant service fee.
     */
    @Override
    public double calculateTotalCost(double litres) {

        double fuelCost = litres * getFuelPrice();

        return fuelCost + serviceFee;
    }
}
