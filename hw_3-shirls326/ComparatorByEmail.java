/***
 * @author Shirley Angos
 * @version 0.1
 * Date of creation: March 15 2023
 * Last Date Modified: March 15 2023
 * Class to model ComparatorByEmail
 */

import java.util.Comparator;

public class ComparatorByEmail implements Comparator<Contact> {


    /***
     * compare method
     * @param c1
     * @param c2
     * @param int
     */
    public int compare(Contact c1, Contact c2){
        return c1.getEmail().compareTo(c2.getEmail());
 
     }
     
    
}
