/***
 * @author Shirley Angos
 * @version 0.1
 * Date of creation: March 9 2023
 * Last Date Modified: March 9 2023
 * Class to model the entity compareByFirst (regarding the first element in pair)
 */
import java.util.Comparator;

public class ComparatorByFirst<E1 extends Comparable<E1>,E2> implements Comparator<Pair<E1,E2>> {

    /***
     * comparemethod pair
     * @param pair1
     * @param pair2
     * @return int
     */
    public int compare(Pair<E1,E2> pair1, Pair<E1,E2> pair2){
        E1 p1First = pair1.getFirst();
        E1 p2First = pair2.getFirst();
        return p1First.compareTo(p2First);


    }


    
}
