public class Passenger extends Person {
    private String seatNumber;
    private Seat seat;
    private Ticket ticket;

    public Passenger(String name, String passportNumber, String seatNumber, Seat seat, Ticket ticket) {
        super(name, passportNumber);
        this.seatNumber = seatNumber;
        this.seat = seat;
        this.ticket = ticket;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public Seat getSeat() {
        return seat;
    }

    public Ticket getTicket() {
        return ticket;
    }

    @Override
    void displayInfo() {
        System.out.println("\n===PASSENGER INFO===\n");
        System.out.println("passenger name : "+name);
        System.out.println("passport number : "+passportNumber);
        System.out.println("seat number "+seatNumber);
        System.out.println("seat type : "+seat);
        System.out.println("\n===TICKET INFO===\n");
        getTicket().displayTicketInfo();


    }
}