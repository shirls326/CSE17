/***
 * @author Shirley Angos
 * @version 0.1
 * Date of creation:
 * Date last modified:
 */
public class InvalidDateTimeException extends Exception{


    /***
     * 0 arg constructor
     * no param
     * @return void
     */
    public InvalidDateTimeException(){
        this("InvalidDateTimeException");
    }

    /***
     * 1 arg constructor
     * @param message
     * @return void
     */

    public InvalidDateTimeException(String message){
        super(message);
    }





}
