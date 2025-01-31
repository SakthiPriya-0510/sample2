import java.util.Random;
import java.util.Scanner;
public class RandomNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
        int totalAttempts = 0;
        int rounds = 0;

        while (playAgain) {
            rounds++;
            System.out.println("\nRound " + rounds + " begins!");
            totalAttempts += playGame(scanner);

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("\nGame Over! You played " + rounds + " round(s) with a total of " + totalAttempts + " attempts.");
        System.out.printf("Average attempts per round: %.2f%n", (double) totalAttempts / rounds);
        scanner.close();
    }

    public static int playGame(Scanner scanner) {
        Random random = new Random();
        int number = random.nextInt(100) + 1;
        int attempts = 0;
        int guess = -1;

        while (guess != number) {
            System.out.print("Enter your guess (1-100): ");
            try {
                guess = scanner.nextInt();
                attempts++;

                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                } else if (guess < number) {
                    System.out.println("Too low! Try again.");
                } else if (guess > number) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.next(); // Clear invalid input
            }
        }
        return attempts;
    }
}