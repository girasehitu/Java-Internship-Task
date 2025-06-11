import java.util.Scanner;

public class ATMInterface {

    private static double balance = 5000.00; // Default balance
    private static final String USER_PIN = "1234"; // Default PIN

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("==============================");
        System.out.println("💳 Welcome to ATM Interface");
        System.out.println("==============================");

        // PIN Verification
        System.out.print("Enter your 4-digit PIN: ");
        String enteredPin = sc.nextLine();

        if (!enteredPin.equals(USER_PIN)) {
            System.out.println("❌ Incorrect PIN. Access Denied.");
            return;
        }

        int choice;
        do {
            System.out.println("\n------ ATM Menu ------");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Amount");
            System.out.println("3. Withdraw Amount");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.printf("✅ Your balance is: ₹%.2f\n", balance);
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = sc.nextDouble();
                    if (depositAmount > 0) {
                        balance += depositAmount;
                        System.out.println("💰 Amount deposited successfully.");
                    } else {
                        System.out.println("⚠️ Invalid deposit amount.");
                    }
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = sc.nextDouble();
                    if (withdrawAmount > 0 && withdrawAmount <= balance) {
                        balance -= withdrawAmount;
                        System.out.println("💸 Withdrawal successful.");
                    } else {
                        System.out.println("❌ Insufficient balance or invalid amount.");
                    }
                    break;

                case 4:
                    System.out.println("👋 Thank you for using the ATM. Goodbye!");
                    break;

                default:
                    System.out.println("⚠️ Invalid choice. Please select from the menu.");
            }

        } while (choice != 4);

        sc.close();
    }
}
