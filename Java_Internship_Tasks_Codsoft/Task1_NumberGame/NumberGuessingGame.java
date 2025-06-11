import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    private static final int MAX_ATTEMPTS = 5;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display welcome message
        displayWelcomeMessage();

        // Generate random number
        int targetNumber = generateRandomNumber();

        // Start game loop
        boolean isGuessed = playGame(scanner, targetNumber);

        // Show result
        if (isGuessed) {
            System.out.println("\n🎉 Congratulations! You guessed the correct number.");
        } else {
            System.out.println("\n❌ Sorry! You've used all attempts.");
            System.out.println("The correct number was: " + targetNumber);
        }

        scanner.close();
    }

    // Method to show welcome message
    private static void displayWelcomeMessage() {
        System.out.println("=======================================");
        System.out.println("     🎮 Number Guessing Game 🎮");
        System.out.println("=======================================");
        System.out.println("Guess a number between " + MIN_NUMBER + " and " + MAX_NUMBER);
        System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess correctly.");
        System.out.println("---------------------------------------\n");
    }

    // Method to generate random number
    private static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
    }

    // Method that contains the main game logic
    private static boolean playGame(Scanner scanner, int targetNumber) {
        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
            System.out.print("🔢 Attempt " + attempt + ": Enter your guess: ");
            int userGuess;

            // Check for valid input
            try {
                userGuess = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Invalid input! Please enter a number.");12422
                attempt--; // Don't count invalid attempt
                continue;
            }

            if (userGuess == targetNumber) {
                return true;
            } else if (userGuess < targetNumber) {
                System.out.println("📉 Too low! Try a higher number.\n");
            } else {
                System.out.println("📈 Too high! Try a lower number.\n");
            }
        }
        return false;
    }
}
