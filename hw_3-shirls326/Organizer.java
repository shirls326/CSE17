/***
 * @author Shirley Angos
 * @version 0.1
 * Date of creation: March 15 2023
 * Last Date Modified: March 15 2023
 * Class to model Organizer
 */

import java.util.ArrayList;
import java.util.Comparator;

public class Organizer<E extends Comparable<E>> {

    private ArrayList<E> elements;
    private Comparator<E> comparator;


    /***
     * 1 arg constructor
     * @param cap
     * big o: O(1)
     */
    public Organizer(int cap) {

        elements = new ArrayList<>(cap);
        comparator = null;

    }


    /***
     * 2 arg constructor
     * @param cap
     * @param comp
     * big o: O(1)
     */
    public Organizer(int cap, Comparator<E> comp) {

        elements = new ArrayList<>(cap);
        comparator = comp;

    }

    /***
     * addElement method
     * @param e
     * big o: O(n)
     */
    public void addElement(E e) {

        int i, c;
        for (i = 0; i < elements.size(); i++) {
            if (comparator == null)
                c = ((Comparable<E>) e).compareTo(elements.get(i));
            else
                c = comparator.compare(e, elements.get(i));
            if (c < 0) // will be placed after something that is equal
                break;
        }
        elements.add(i, e);


    }

    // big o: log(n)
    // The method findElement uses a recursive binary search algorithm to search for an element in the sorted arraylist.
    /***
     * Method to find element
     * @param e
     * @return E
     * big o: O(logn)
     */
    public E findElement(E e) { // binary search

        int first = 0;
        int last = elements.size() - 1;

        return binarySearch(e, first, last);

    }


    /***
     * binarySearch method
     * @return index where the element is
     * big o: O(logn)
     */
    private E binarySearch(E key, int first, int last){
        if(first > last){
            return null;
        }
        int mid = (last + first) / 2;
        E test = elements.get(mid);

        if (test.compareTo(key) == 0) {
            return test;
        } else if (test.compareTo(key) < 0) {
            return binarySearch(key, mid+1, last);
        } else {
            return binarySearch(key, first, mid-1);
        }
       


    }

   

    /***
     * RemoveElement method
     * @param item
     * @return E
     * big o: O(n)
     * 
     */
    public E removeElement(E item) {
        return elements.remove(item) ? item : null;  // only returns the item if sucessfully removed
    }

    /***
     * setter method
     * @param comparator
     * big O: O(nLogn)
     * reason: the sort being used is merge sort from Arrays.sort (shift click on sort for details)
     * 
     *  */

    public void setComparator(Comparator<E> comparator) {
        this.comparator = comparator;
        elements.sort(comparator);
    }


    /***
     * toString
     * Big o: O(n)
     */
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        String result = "";

        for (E element : elements) {
            result += element.toString() + "\n";
        }

        return result;
    }

}
