/***
 * @author Shirley Angos
 * @version 0.1
 * Date of creation: 02/07/23
 * Date last modified:
 * Class to model entity InvalidSeatException that extends Exception
 */

public class InvalidSeatException extends Exception{



    /***
     * default constructor
     * no param
     * no return void
     */

    public InvalidSeatException(){
        this("InvalidSeatException");
    }


    /***
     * 1 arg constructor
     * @param message
     * no return value
     */
    public InvalidSeatException(String  message){
        super(message);
    }


}