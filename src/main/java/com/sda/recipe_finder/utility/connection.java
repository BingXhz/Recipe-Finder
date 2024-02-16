import java.util.InputMismatchException;
import java.util.Scanner;

public class connection {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Main menu loop
        boolean quit = false;
        while (!quit) {
            // Display main menu options
            System.out.println("Main Menu:");
            System.out.println("1. Option 1");
            System.out.println("2. Option 2");
            System.out.println("3. Quit");

            // Prompt user for input
            System.out.print("Enter your choice: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                // Process user choice
                switch (choice) {
                    case 1:
                        option1(scanner);
                        break;
                    case 2:
                        option2(scanner);
                        break;
                    case 3:
                        quit = true;
                        System.out.println("Exiting program...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number from the menu.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear input buffer
            }
        }

        // Close scanner
        scanner.close();
    }

    // Method for option 1
    private static void option1(Scanner scanner) {
        boolean returnToMainMenu = false;
        while (!returnToMainMenu) {
            // Display option 1 menu
            System.out.println("Option 1 Menu:");
            System.out.println("1. Sub-option 1");
            System.out.println("2. Sub-option 2");
            System.out.println("3. Back to Main Menu");

            // Prompt user for input
            System.out.print("Enter your choice: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                // Process user choice
                switch (choice) {
                    case 1:
                        System.out.println("You selected Sub-option 1.");
                        // Implement functionality for Sub-option 1
                        break;
                    case 2:
                        System.out.println("You selected Sub-option 2.");
                        // Implement functionality for Sub-option 2
                        break;
                    case 3:
                        returnToMainMenu = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number from the menu.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear input buffer
            }
        }
    }

    // Method for option 2
    private static void option2(Scanner scanner) {
        boolean returnToMainMenu = false;
        while (!returnToMainMenu) {
            // Display option 2 menu
            System.out.println("Option 2 Menu:");
            System.out.println("1. Sub-option 1");
            System.out.println("2. Sub-option 2");
            System.out.println("3. Back to Main Menu");

            // Prompt user for input
            System.out.print("Enter your choice: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                // Process user choice
                switch (choice) {
                    case 1:
                        System.out.println("You selected Sub-option 1.");
                        // Implement functionality for Sub-option 1
                        break;
                    case 2:
                        System.out.println("You selected Sub-option 2.");
                        // Implement functionality for Sub-option 2
                        break;
                    case 3:
                        returnToMainMenu = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number from the menu.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear input buffer
            }
        }
    }
}
