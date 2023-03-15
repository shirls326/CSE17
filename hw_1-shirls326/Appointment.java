/***
 * Class to model the entity Appointment that extends Event
 * @author Shirley Angos
 * @version 0.1
 * Date of creation: January 29 2023
 * Last Date Motified: Febrary 1 2023
 */
public class Appointment extends Event {
    private String contact;

    public Appointment(){
        super();
        contact = null;

    }

    public Appointment(String description, String location, String date, String time, String contact){

        super(description, location, date, time);
        this.contact = contact;
        
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    // come back to later to display and go to office hours for assistance
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format(super.toString()+ "Contact: %s\n",contact);
    }
    
}
