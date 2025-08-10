
import java.time.LocalDateTime;
import java.util.*;

public class Flight {
    private String flightNumber, origin, destination;
    private LocalDateTime departureTime;
    private ArrayList<Passenger> passengers = new ArrayList<>();
    private int capacity;

    public Flight(String flightNumber, String origin, String destination, int capacity) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.capacity = capacity;
        this.departureTime = LocalDateTime.now();
    }

    public String getFlightNumber() { return flightNumber; }
    public String getOrigin() { return origin; }
    public String getDestination() { return destination; }

    public boolean isFull() {
        return passengers.size() >= capacity;
    }

    public void addPassenger(Passenger p) throws OverbookingException, DuplicateSeatException {
        if (isFull()) {
            throw new OverbookingException("Flight " + flightNumber + " is full.");
        }

        for (Passenger existing : passengers) {
            if (existing.getSeatNumber().equals(p.getSeatNumber())) {
                throw new DuplicateSeatException("Seat number " + p.getSeatNumber() + " is already taken.");
            }
        }

        passengers.add(p);
    }

    public void flightInfo() {
        System.out.println("Flight No: " + flightNumber + " | From: " + origin + " → To: " + destination);
        System.out.println("Departure: " + departureTime);
        System.out.println("Passengers:");
        passengers.forEach(p -> System.out.println("  - " + p.getName() + " (" + p.getSeat() + ")"));
        System.out.println("Capacity: " + capacity);
        System.out.println();
    }

    public Optional<Passenger> findPassengerBy(String passportNumber) {
        return passengers.stream()
                .filter(p -> p.getPassportNumber().equals(passportNumber))
                .findFirst();
    }

    public void removePassenger(String passportNumber) {
        boolean removed = passengers.removeIf(p -> p.getPassportNumber().equals(passportNumber));
        if (removed) {
            System.out.println("Passenger with passport number " + passportNumber + " removed successfully.");
        } else {
            System.out.println("Passenger with passport number " + passportNumber + " not found.");
        }
    }


}
