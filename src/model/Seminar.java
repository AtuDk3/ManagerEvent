/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Lenovo
 */
import java.time.LocalDate;
import java.util.Scanner;

public class Seminar extends Event {
    private int numberOfTopics;

    public Seminar() {
        super();
        this.numberOfTopics = 0;
    }

    @Override
    public void inputAll() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter seminar name: ");
        this.eventName = scanner.nextLine();

        System.out.print("Enter seminar date (yyyy-MM-dd): ");
        this.eventDate = LocalDate.parse(scanner.nextLine());

        System.out.print("Enter seminar location: ");
        this.location = scanner.nextLine();

        while (true) {
            System.out.print("Enter number of topics: ");
            this.numberOfTopics = scanner.nextInt();
            if (numberOfTopics > 0) break;
            System.out.println("Invalid input. Number of topics must be greater than 0.");
        }
    }

    @Override
    public void printEventInfo() {
        super.printEventInfo();
        System.out.printf("Number of topics: %d\n", numberOfTopics);
    }
}

