/***
 * @author Shirley Angos
 * @version 0.1
 * Date of creation: 02/10/2023
 * Date last modified: 02/10/2023
 * Class to model the entity Date
 */

public class Date implements Comparable<Date> {

    private int month;
    private int day;
    private int year;


    /***
     * Default Constructor
     * no param
     * no return
     */

    public Date(){
        month = 0;
        day = 0;
        year = 0;


    }

    /***
     * 1 arg constructor
     * @param date
     * @throws InvalidDateTimeException
     * no return
     */

    public Date(String date) throws InvalidDateTimeException{ // regular expressions

        if(date.matches("\\d{2}/\\d{2}/\\d{4}")){

            String [] parts = date.split("/");

    

            if(Integer.parseInt(parts[0]) > 0 && Integer.parseInt(parts[0]) < 13){ // month
                
    
                month = Integer.parseInt(parts[0]);
                
            } else throw new InvalidDateTimeException();
    
    
    
            if(Integer.parseInt(parts[1]) > 0 && Integer.parseInt(parts[1]) < 32){ // day
    
                day = Integer.parseInt(parts[1]);
                
               
            } else throw new InvalidDateTimeException();
    
    
            if(Integer.parseInt(parts[2]) > 0){ // year
                
                year = Integer.parseInt(parts[2]);
    
            } else throw new InvalidDateTimeException();


        } else throw new InvalidDateTimeException("ERROR: Date not in the correct format!");


    }

    /***
     * getter method
     * no parm
     * @return day
     */

    public int getDay() {
        return day;
    }

    /***
     * getter method
     * no param
     * @return month
     */

    public int getMonth() {
        return month;
    }


    /***
     * Getter method
     * no param
     * @return year
     */

    public int getYear() {
        return year;
    }


    /***
     * Setter method
     * @param month
     * @throws InvalidDateTimeException
     * no return
     */

    public void setMonth(int month) throws InvalidDateTimeException {

        if(month > 0 || month < 13){

            this.month = month;

        } else throw new InvalidDateTimeException("ERROR: Invalid month!");


    }

    /***
     * Setter method
     * @param day
     * @throws InvalidDateTimeException
     * no return
     */

    public void setDay(int day) throws InvalidDateTimeException {

        if(day > 0 || day < 32){

            this.day = day;
    

        } else throw new InvalidDateTimeException();

    }

    /***
     * Setter method
     * @param year
     * @throws InvalidDateTimeException
     * no return
     */

    public void setYear(int year) throws InvalidDateTimeException {

        if(year > 0){
            this.year = year;
        } else throw new InvalidDateTimeException();

    }


    /***
     * Method toString
     * no param
     * @return String
     */

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("%02d/%02d/%d", month, day, year);
    }

    @Override
    public int compareTo(Date o) {

        int lhs = this.getYear()*100000 + this.getMonth()*100 + this.getDay();
        
        // 2003/08/25 -> 20030825
        // 2003/03/26 -> 20030326
        // 20030000
        //     0300
        //       26

        int rhs = o.getYear()*100000 + o.getMonth()*100 + o.getDay();

        
        
        return lhs - rhs;
    }


    
}
