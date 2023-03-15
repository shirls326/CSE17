/***
 * @author Shirley Angos
 * @version 0.1
 * Date of creation:
 * Last date modified:
 * Class to model the entity Event
 */
public class Event {

    private String description;
    private String location;
    private Date date;
    private Time time;


    /***
     * Default constructor
     * no returno
     * no param
     */
    public Event(){

        description = null;
        location = null;
        date = new Date();
        time = new Time();

    }
    /***
     * 4 arg constructor
     * @param description
     * @param location
     * @param date
     * @param time
     * no return
     */

    public Event(String description, String location, String date, String time) throws InvalidDateTimeException { // said on the PDF of HW 2 that the constructor should throw it??
        this.description = description;
        this.location = location;

        try{
            this.date = new Date(date);
            this.time = new Time(time);

        }catch(InvalidDateTimeException e){

            System.out.println(e.getMessage());
        }
    }

    /***
     * Getter method
     * no param
     * @return Description
     */

    public String getDescription() {
        return description;
    }

    /***
     * Getter method
     * no param
     * @return location
     */

    public String getLocation() {
        return location;
    }

    /***
     * Getter method
     * no param
     * @return date
     */

    public Date getDate() {
        return date;
    }
    /***
     * Getter method
     * no param
     * @return time
     */
    public Time getTime() {
        return time;
    }
    /***
     * setter method
     * @param description
     * no return
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /***
     * setter method
     * @param location
     * no return
     */

    public void setLocation(String location) {
        this.location = location;
    }


    /***
     * Setter method
     * @param date
     * no return
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /***
     * Setter method
     * @param time
     * no return
     */
    public void setTime(Time time) {
        this.time = time;
    }

    /***
     * Method to get type
     * no param
     * @return type
     * 
     */

    public String getType(){
        return "Type";
    }

    @Override

    /***   
     * Method toString
     * no param
     * @return String
     */
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("%-10s\t %-20s\t %-20s\t %-10s\t %-10s",getType(),description,location,date,time);
    }
    
}
