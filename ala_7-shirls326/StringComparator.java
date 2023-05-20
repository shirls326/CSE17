/***
 * @author Shirley Angos
 * @version 0.1
 *          Date of creation: March 28 2023
 *          Last Date modified: March 28 2023
 *          Purpose of class is to model eneity StringComparator
 */
import java.util.Comparator;

public class StringComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        // TODO Auto-generated method stub
        return o1.length() - o2.length();
    }
    
}
