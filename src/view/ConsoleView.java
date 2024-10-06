/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author Lenovo
 */
import java.util.Scanner;

public class ConsoleView {
    private Scanner scanner = new Scanner(System.in);

    public int displayMainMenu() {
        System.out.println("*** Event Management ***");
        System.out.println("1. Create new event");
        System.out.println("2. Print all seminars");
        System.out.println("3. Print all talkshows");
        System.out.println("4. Print all events");
        System.out.println("5. Search events");
        System.out.println("6. Exit");
        System.out.print("Your choice: ");
        return scanner.nextInt();
    }

    public String inputEventType() {
        scanner.nextLine();  // Consume newline
        System.out.print("Seminar (S) or Talkshow (T): ");
        return scanner.nextLine();
    }

    public String inputSearchQuery() {
        scanner.nextLine();  // Consume newline
        System.out.print("Enter search query: ");
        return scanner.nextLine();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}

