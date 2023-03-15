/***
 * @author Shirley Angos
 * @version 0.1
 * Date of creation: 02/10/2023
 * Date last modified: 02/10/2023
 * Class to model the entity Time
 */

public class Time {

    private int hours;
    private int minutes;

    /***
     * Default constructor
     * 0 param
     * no return
     */

    public Time(){

        hours = 0;
        minutes = 0;

    }

    public Time(String date) throws InvalidDateTimeException { // regular expressions

        //if regex
        String [] parts = date.split(":");


        if(Integer.parseInt(parts[0]) >= 0 && Integer.parseInt(parts[0]) < 25){

            hours = Integer.parseInt(parts[0]);

        } else{

            throw new InvalidDateTimeException("Error! Invalid time!");
        }


        if(Integer.parseInt(parts[1]) >= 0 && Integer.parseInt(parts[0]) < 61){

            minutes = Integer.parseInt(parts[0]);

        } else{

            throw new InvalidDateTimeException();
        }


    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setHours(int hours) throws InvalidDateTimeException {

        if(hours >= 1 || hours < 25){

            this.hours = hours;

        } else throw new InvalidDateTimeException();


    }

    public void setMinutes(int minutes) throws InvalidDateTimeException {

        if(minutes > -1 || minutes < 61){

            this.minutes = minutes;

        } else throw new InvalidDateTimeException();

    }

    @Override
    public String toString() {
        
        return String.format("%02d:%02d", hours, minutes);

    }




    
}
