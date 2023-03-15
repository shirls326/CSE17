/***
 * Class to model the entity Meeting that extends Event
 * @author Shirley Angos
 * @version 0.1
 * Date of creation: January 29 2023
 * Last Date Motified: Febrary 1 2023
 */

 public class Meeting extends Event{

    private String host;
    private int guest;

    /***
     * Default constructor
     * no param
     * no return
     */
    public Meeting(){
        super();
        host = null;
        guest = 0;
    }

    /***
     * 6 parm constructor
     * @param description
     * @param location
     * @param date
     * @param time
     * @param host
     * @param guest
     * @throws InvalidDateTimeException
     * no return
     */
    public Meeting(String description, String location, String date, String time, String host, int guest) throws InvalidDateTimeException {

        super(description, location, date, time);
        this.host = host;
        this.guest = guest;
    }

    public String getHost() {
        return host;
    }
    public int getGuest() {
        return guest;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setGuest(int guest) {
        this.guest = guest;
    }


    @Override
    public String getType() {
        // TODO Auto-generated method stub
        return "meeting";
    }

    // come back to later
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format(super.toString()+ "\t%-10s\t%-10d\t",host,guest);
    }
    
}
