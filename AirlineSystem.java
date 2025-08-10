
import java.util.ArrayList;

public class AirlineSystem {
    public static void main(String[] args) {
        ArrayList<Flight>flights=new ArrayList<>();
        ArrayList<Passenger>passengers=new ArrayList<>();


        flights.add(new Flight("F001","KARACHI","LONDON",2));
        flights.add(new Flight("F002","ISLAMABAD","GERMANY",9));


        Ticket t1=new Ticket("T101",25000,flights.get(0));
        Ticket t2=new Ticket("T102",9500,flights.get(1));
        Ticket t3=new Ticket("T103",7000,flights.get(1));
        Ticket t4=new Ticket("T104",6500,flights.get(1));
        Ticket t5=new Ticket("T105",6000,flights.get(1));


        passengers .add(new Passenger("asif","P123456","S01",Seat.BUSINESS,t1));
        passengers.add(new Passenger("jacky","p2384773","S02",Seat.BUSINESS,t2));
        passengers.add(new Passenger("suresh","P231244","S03",Seat.FIRST_CLASS,t3));
        passengers.add(new Passenger("bob","p731846","S04",Seat.ECONOMY,t4));
        passengers.add(new Passenger("ayesha","p988977","S05",Seat.BUSINESS,t5));

        try{
            flights.get(0).addPassenger(passengers.get(0));
            flights.get(0).addPassenger(passengers.get(1));
            flights.get(0).addPassenger(passengers.get(2));
            flights.get(1).addPassenger(passengers.get(3));

        }
        catch (DuplicateSeatException|OverbookingException e){
            System.out.println("EXCEPTION : "+e.getMessage());
        }

// duplicate seat number exception
        try {
            flights.get(1).addPassenger(passengers.get(3));
        }
        catch (DuplicateSeatException|OverbookingException e){
            System.out.println(e.getMessage());
        }


        System.out.println("\n===ALL FLIGHT DETAILS AND THEIR PASSENGER");
        for (Flight flight : flights) {
            flight.flightInfo();

        }



        System.out.println("\n===ALL BUSSINESS CLASS PASSENEGERS===\n");
        passengers.stream()
                .filter(passenger -> passenger.getSeat().equals(Seat.BUSINESS))
                .map(passenger -> passenger.name)
                .forEach(System.out::println);




        System.out.println("\n===FIND PASSENGER BY PASSPORT NUMBER===\n");
        flights.get(0).findPassengerBy("P123456").ifPresent(Passenger::displayInfo);

        System.out.println("\n=== REMOVE A PASSENGER ===");
        flights.get(0).removePassenger("P123456"); //REMOVE ASIF








    }
}