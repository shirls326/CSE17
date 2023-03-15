/***
 * Class to model the entity Appointment that extends Event
 * @author Shirley Angos
 * @version 0.1
 * Date of creation: January 29 2023
 * Last Date Motified: Febrary 1 2023
 */
public class Appointment extends Event {
    private String contact;

    
    /***
     * Default constructor
     * no return
     * no param
     */
    public Appointment(){
        super();
        contact = null;

    }
    /***
     * 5 param constructor
     * @param description
     * @param location
     * @param date
     * @param time
     * @param contact
     * @throws InvalidDateTimeException
     * no return
     */

    public Appointment(String description, String location, String date, String time, String contact) throws InvalidDateTimeException{

        super(description, location, date, time); // doesn't need to handle the exception in the appointment class because exception is thrown in the event class
        this.contact = contact;
        
    }

    /***
     * Getter method
     * no parzm
     * @return contact
     */
    public String getContact() {
        return contact;
    }
    
    /***
     * Setter method
     * no param
     * @param contact
     */
    public void setContact(String contact) {
        this.contact = contact;
    }


    @Override
    public String getType() {
        // TODO Auto-generated method stub
        return "Appointment";
    }


    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format(super.toString()+ "\t%-10s\t",contact);
    }
    
}
