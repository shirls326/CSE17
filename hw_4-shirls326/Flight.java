/***
 * @author Shirley Angos
 * @version 0.1
 * Date of creation: April 2 2023
 * Last Date Modified: April 2 2023
 * Class to model the entity flight
 */
public class Flight {

    private String flight;
    private Time departure;
    private Time arrival;


    /***
     * 3 arg constructor
     * @param flight
     * @param departure
     * @param arrival
     */
    public Flight(String flight, Time departure, Time arrival){
        this.flight = flight;
        this.departure = departure;
        this.arrival = arrival;



    }

    //getters
   public String getFlight() {
       return flight;
   }

   public Time getDeparture() {
       return departure;
   }

   public Time getArrival() {
       return arrival;
   }

   //setters
   public void setFlight(String flight) {
       this.flight = flight;
   }

   public void setArrival(Time arrival) {
       this.arrival = arrival;
   }

   public void setDeparture(Time departure) {
       this.departure = departure;
   }

   @Override
   public String toString() {
       
       return String.format("%-10s\t%-10s\t%-10s", flight,departure,arrival);
   }




    
}
 