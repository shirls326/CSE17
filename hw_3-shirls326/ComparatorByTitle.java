/***
 * @author Shirley Angos
 * @version 0.1
 * Date of creation: March 15 2023
 * Last Date Modified: March 15 2023
 * Class to model ComparatorByTitle
 */


import java.util.Comparator;

public class ComparatorByTitle implements Comparator<Note>{

    /***
     * compare method
     * @param note1
     * @param note2
     * @return int
     */
    public int compare(Note note1, Note note2){
       return note1.getTitle().compareTo(note2.getTitle());

    }
    
    
}
