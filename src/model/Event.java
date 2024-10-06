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

public abstract class Event {
    protected static int eventCounter = 0;
    protected int id;
    protected String eventName;
    protected LocalDate eventDate;
    protected String location;

    public Event() {
        this.id = ++eventCounter;
        this.eventName = "";
        this.eventDate = LocalDate.now();
        this.location = "";
    }

    public int getId() {
        return id;
    }

    public String getEventName() {
        return eventName;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public String getLocation() {
        return location;
    }

    public abstract void inputAll();

    public void printEventInfo() {
        System.out.printf("ID: %d - Name: %s - Date: %s - Location: %s\n", id, eventName, eventDate, location);
    }
}

