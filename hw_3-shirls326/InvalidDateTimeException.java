/***
 * @author Shirley Angos
 * @version 0.1
 * Date of creation: March 15 2023
 * Last Date Modified: March 15 2023
 * Class to model InvalidDateTimeException
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