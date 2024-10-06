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

public class Talkshow extends Event {
    private String speakerNames;

    public Talkshow() {
        super();
        this.speakerNames = "";
    }

    @Override
    public void inputAll() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter talkshow name: ");
        this.eventName = scanner.nextLine();

        System.out.print("Enter talkshow date (yyyy-MM-dd): ");
        this.eventDate = LocalDate.parse(scanner.nextLine());

        System.out.print("Enter talkshow location: ");
        this.location = scanner.nextLine();

        while (true) {
            System.out.print("Enter speaker names (comma-separated): ");
            this.speakerNames = scanner.nextLine();
            if (!speakerNames.isEmpty()) break;
            System.out.println("Invalid input. Speaker names cannot be empty.");
        }
    }

    @Override
    public void printEventInfo() {
        super.printEventInfo();
        System.out.printf("Speakers: %s\n", speakerNames);
    }
}

