
/**
 * Payment handles payment processing.
 * It stores payment information and checks payment amounts.
 */
public class Payment {

    private String paymentMethod;
    private double paymentAmount;
    private boolean paymentSuccessful;

    // Constructor
    public Payment(String paymentMethod) {
        setPaymentMethod(paymentMethod);
        paymentAmount = 0.0;
        paymentSuccessful = false;
    }

    // Getters
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public boolean isPaymentSuccessful() {
        return paymentSuccessful;
    }

    // Setters
    public void setPaymentMethod(String paymentMethod) {
        if (paymentMethod != null && !paymentMethod.trim().isEmpty()) {
            this.paymentMethod = paymentMethod;
        }
    }

    public void setPaymentAmount(double paymentAmount) {
        if (paymentAmount >= 0) {
            this.paymentAmount = paymentAmount;
        }
    }

    public void setPaymentSuccessful(boolean paymentSuccessful) {
        this.paymentSuccessful = paymentSuccessful;
    }

    // Additional payment processing method
    public boolean processPayment(double amount) {

        if (amount > 0) {
            paymentAmount = amount;
            paymentSuccessful = true;

            System.out.println("Payment successful!");
            return true;
        }

        paymentSuccessful = false;
        System.out.println("Payment failed.");
        return false;
    }
}
