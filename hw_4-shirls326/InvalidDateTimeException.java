/***
 * @author Shirley Angos
 * @version 0.1
 * Date of creation: April 2 2023
 * Last Date Modified: April 2 2023
 * Class to model the entity flight
 */

public class InvalidDateTimeException extends Exception{

    /***
     * Default constructor
     */
    public InvalidDateTimeException(){
        super("Invalid Date Format.");
    }
    /***
     * 1 arg constructor
     * @param message
     */
    public InvalidDateTimeException(String message){
        super(message);
    }
}