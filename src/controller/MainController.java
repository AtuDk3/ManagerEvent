/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Lenovo
 */
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import model.Event;
import model.Seminar;
import model.Talkshow;
import view.ConsoleView;

public class MainController {
    private List<Event> eventList = new ArrayList<>();
    private ConsoleView view = new ConsoleView();

    public void run() {
        int choice;
        do {
            choice = view.displayMainMenu();
            switch (choice) {
                case 1:
                    createEvent();
                    break;
                case 2:
                    printSeminars();
                    break;
                case 3:
                    printTalkshows();
                    break;
                case 4:
                    printAllEvents();
                    break;
                case 5:
                    searchEvents();
                    break;
                case 6:
                    view.displayMessage("Goodbye!");
                    break;
                default:
                    view.displayMessage("Invalid choice. Try again.");
            }
        } while (choice != 6);
    }

    private void createEvent() {
        String eventType = view.inputEventType();

        if (eventType.equalsIgnoreCase("S")) {
            Seminar seminar = new Seminar();
            seminar.inputAll();
            eventList.add(seminar);
        } else if (eventType.equalsIgnoreCase("T")) {
            Talkshow talkshow = new Talkshow();
            talkshow.inputAll();
            eventList.add(talkshow);
        } else {
            view.displayMessage("Invalid input. Please enter S for Seminar or T for Talkshow.");
        }
    }

    private void printSeminars() {
        List<Event> seminars = eventList.stream()
                                        .filter(event -> event instanceof Seminar)
                                        .collect(Collectors.toList());
        if (seminars.isEmpty()) {
            view.displayMessage("No seminars found.");
        } else {
            seminars.forEach(Event::printEventInfo);
        }
    }

    private void printTalkshows() {
        List<Event> talkshows = eventList.stream()
                                         .filter(event -> event instanceof Talkshow)
                                         .collect(Collectors.toList());
        if (talkshows.isEmpty()) {
            view.displayMessage("No talkshows found.");
        } else {
            talkshows.forEach(Event::printEventInfo);
        }
    }

    private void printAllEvents() {
        if (eventList.isEmpty()) {
            view.displayMessage("No events found.");
        } else {
            eventList.forEach(event -> {
                if (event instanceof Seminar) {
                    System.out.println("Seminar:");
                } else if (event instanceof Talkshow) {
                    System.out.println("Talkshow:");
                }
                event.printEventInfo();
            });
        }
    }

    private void searchEvents() {
        String query = view.inputSearchQuery();
        List<Event> results = eventList.stream()
                                       .filter(event -> event.getEventName().toLowerCase().contains(query.toLowerCase())
                                               || event.getLocation().toLowerCase().contains(query.toLowerCase()))
                                       .collect(Collectors.toList());
        if (results.isEmpty()) {
            view.displayMessage("No events found for the query: " + query);
        } else {
            results.forEach(Event::printEventInfo);
        }
    }
}

