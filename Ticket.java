

public class Ticket {
    private String ticketId;
    private double price;
    private Flight flight;

    public Ticket(String ticketId, double price, Flight flight) {
        this.ticketId = ticketId;
        this.price = price;
        this.flight = flight;
    }

    public void displayTicketInfo() {
        System.out.println("Ticket ID: " + ticketId);
        System.out.println("Price: " + price);
        System.out.println("Flight: " + flight.getFlightNumber() + " (" + flight.getOrigin() + " → " + flight.getDestination() + ")");
    }
}
