import java.util.Comparator;

/***
 * @author Shirley Angos
 * @version 0.1
 *          Date of creation: March 28 2023
 *          Last Date modified: March 28 2023
 *          Purpose of class is to model eneity Stack
 */

public class Stack<E> {
    private ArrayList<E> elements;


    /***
     * Default constructor
     * 
     */
    public Stack() {
        elements = new ArrayList<>(); // creates an empty stack with capacity 10
    }

   /***
    * method push
    * @param item
    */
    public void push(E item) {
        elements.add(item);// add at the end of elements (top of the stack)
    }

    
    /***
     * Peek
     * @return E
     */
    public E peek() {
        int lastIndex = elements.size() - 1; // get the index of the top
        return elements.get(lastIndex); // return the value at the top
    }

    /***
     * Pop
     * @return E
     */

    public E pop() {
        int lastIndex = elements.size() - 1; // get the index of the top
        E value = elements.get(lastIndex);// get the value of the top
        elements.remove(lastIndex); // remove the top
        return value;
    }

    /***
     * isempty
     * @return boolean
     */
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    /***
     * size
     * @return int
     */
    public int size() {
        return elements.size();
    }

    
    /***
     * Tostring
     * @return String
     */
    public String toString() {
        return "Stack: " + elements.toString();
    }

    /***
     * contains method
     * @param o
     * @return boolen
     */
    // O(n)
    public boolean contains(Object o) {
        return elements.contains(o);
    }

    // O(n^2)
    public void sort() {
        elements.sort();

    }

    //O(n^2)
    public void sort(Comparator<E> c){
        elements.sort(c);
    }
}
