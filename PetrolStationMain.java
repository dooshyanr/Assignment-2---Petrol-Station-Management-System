
import java.util.Scanner;

/**
 * PetrolStationMain is the main application class.
 * It connects all petrol station classes and demonstrates
 * inheritance, polymorphism, encapsulation and control structures.
 */
public class PetrolStationMain {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Ask user to enter customer information.
System.out.println("\n===== CUSTOMER REGISTRATION =====");

System.out.print("Enter Customer ID: ");
int customerID = input.nextInt();

input.nextLine(); // Clear the input buffer

System.out.print("Enter Customer Name: ");
String customerName = input.nextLine();

System.out.print("Enter Phone Number: ");
String phoneNumber = input.nextLine();

// Create customer object using entered information.
FuelCustomer customer = new FuelCustomer(
    customerID, customerName, phoneNumber
);

        // Create derived class objects.
        SelfServicePump selfPump = new SelfServicePump(
            101, "RON95", 2.05, 1000.0, 5.0
        );

        AttendantPump attendantPump = new AttendantPump(
            102, "RON95", 2.05, 1000.0,
            "Arun", 0.50
        );

        // Demonstrate polymorphism using a base class array.
        PetrolPump[] pumps = {selfPump, attendantPump};

        // Display application heading.
        System.out.println("==================================");
        System.out.println(" PETROL STATION MANAGEMENT SYSTEM");
        System.out.println("==================================");

        // Display customer information.
        customer.displayCustomer();

        // Demonstrate a for loop to display pump options.
        System.out.println("\nAvailable Petrol Pumps:");

        for (int i = 0; i < pumps.length; i++) {
            System.out.println(
                (i + 1) + ". Pump ID: " + pumps[i].getPumpID()
            );
        }

        // Select a pump.
        System.out.print("\nSelect pump (1-2): ");
        int pumpChoice = input.nextInt();

        // Validate pump selection using if-else.
        if (pumpChoice < 1 || pumpChoice > 2) {
            System.out.println("Invalid pump selection.");
            input.close();
            return;
        }

        // Parent class reference points to a child class object.
        PetrolPump selectedPump = pumps[pumpChoice - 1];

        // Display pump type using polymorphism.
        if (selectedPump instanceof SelfServicePump) {
            System.out.println("Selected: Self-Service Pump");
            System.out.println("Discount: " +
                ((SelfServicePump) selectedPump).getDiscountPercentage()
                + "%");

        } else {
            System.out.println("Selected: Attendant Pump");
            System.out.println("Attendant: " +
                ((AttendantPump) selectedPump).getAttendantName());
        }

        // Demonstrate switch for fuel selection.
        System.out.println("\nAvailable Fuel Types:");
        System.out.println("1. RON95");
        System.out.println("2. RON97");
        System.out.println("3. Diesel");

        System.out.print("Select fuel type (1-3): ");
        int fuelChoice = input.nextInt();

        switch (fuelChoice) {

            case 1:
                selectedPump.setFuelType("RON95");
                selectedPump.setFuelPrice(2.05);
                break;

            case 2:
                selectedPump.setFuelType("RON97");
                selectedPump.setFuelPrice(3.10);
                break;

            case 3:
                selectedPump.setFuelType("Diesel");
                selectedPump.setFuelPrice(2.15);
                break;

            default:
                System.out.println("Invalid selection. Defaulting to RON95.");
                selectedPump.setFuelType("RON95");
                selectedPump.setFuelPrice(2.05);
        }

        System.out.println("\nSelected Fuel: " +
            selectedPump.getFuelType());

        System.out.printf("Fuel Price: RM %.2f per litre%n",
            selectedPump.getFuelPrice());

        // Demonstrate while loop for repeated transactions.
        String continueTransaction = "yes";

        int transactionNumber = 1;

        while (continueTransaction.equalsIgnoreCase("yes")) {

            System.out.printf(
                "\nAvailable Fuel: %.2f litres%n",
                selectedPump.getFuelAvailable()
            );

            System.out.print("Enter litres to purchase: ");
            double litres = input.nextDouble();

            // Check whether the pump is operational.
            if (selectedPump.isOperational()) {

                // Dispense fuel using the selected pump.
                boolean success = selectedPump.dispenseFuel(litres);

                if (success) {

                    System.out.println("\nFuel dispensed successfully!");

                    // Display fuel purchase information.
                    System.out.printf("Litres Purchased: %.2f%n",
                        selectedPump.getLitresDispensed());

                    System.out.printf("Total Amount: RM %.2f%n",
                        selectedPump.getTotalAmount());

                    // Create a payment object.
                    System.out.print(
                        "\nSelect payment method (1-Cash, 2-Card): "
                    );

                    int paymentChoice = input.nextInt();

                    String paymentMethod;

                    // Demonstrate switch for payment selection.
                    switch (paymentChoice) {
                        case 1:
                            paymentMethod = "Cash";
                            break;

                        case 2:
                            paymentMethod = "Card";
                            break;

                        default:
                            paymentMethod = "Cash";
                            System.out.println(
                                "Invalid selection. Defaulting to Cash."
                            );
                    }

                    Payment payment = new Payment(paymentMethod);

                    // Process customer payment.
                    boolean paid = payment.processPayment(
                        selectedPump.getTotalAmount()
                    );

                    if (paid) {

                        // Create a transaction record.
                        FuelTransaction transaction =
                            new FuelTransaction(
                                transactionNumber,
                                selectedPump.getFuelType(),
                                selectedPump.getLitresDispensed(),
                                payment.getPaymentAmount()
                            );

                        // Display transaction receipt.
                        transaction.displayTransaction();

                        System.out.println(
                            "Payment Method: " +
                            payment.getPaymentMethod()
                        );

                        System.out.println(
                            "Payment Status: " +
                            payment.isPaymentSuccessful()
                        );

                        transactionNumber++;
                    }

                } else {
                    System.out.println(
                        "Transaction unsuccessful. Please try again."
                    );
                }

            } else {
                System.out.println("Pump is not operational.");
                break;
            }

            // Ask whether the customer wants another transaction.
            System.out.print(
                "\nDo you want another transaction? (yes/no): "
            );

            continueTransaction = input.next();
        }

        // Display final pump information using getters.
        System.out.println("\n===== FINAL PUMP INFORMATION =====");

        System.out.println("Pump ID: " +
            selectedPump.getPumpID());

        System.out.println("Fuel Type: " +
            selectedPump.getFuelType());

        System.out.printf("Remaining Fuel: %.2f litres%n",
            selectedPump.getFuelAvailable());

        System.out.println("\nThank you for using our petrol station!");

        input.close();
    }
}
