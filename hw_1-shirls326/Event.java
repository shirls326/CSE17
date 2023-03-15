/***
 * Class to model the entity Event
 * @author Shirley Angos
 * @version 0.1
 * Date of creation: January 29 2023
 * Last Date Motified: January 29 2023
 */

public class Event{

    //data fields
    private String description;
    private String location;
    private String date;
    private String time;

    //no arg constructor
    //no param
    // no return
    public Event(){
        description = null;
        location = null;
        date = null;
        time = null;
    }

    /***
     * 4 arg constructor
     * @param description
     * @param location
     * @param date
     * @param time
     */

    public Event(String description, String location, String date, String time){
        this.description = description;
        this.location = location;
        this.date = date;
        this.time = time;

    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTime(String time) {
        this.time = time;
    }


    // fuck
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("Description: %s\nLocation: %s\nDate: %s\nTime: %s\n",description,location,date,time);
    } 



}