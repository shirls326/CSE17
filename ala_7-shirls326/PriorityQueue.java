/***
 * @author Shirley Angos
 * @version 0.1
 * Date of creation: March  28  2023
 * Last Date modified: March 28  2023
 * Purpose of class is to model eneity PriorityQueue
 */


import java.util.Comparator;
public class PriorityQueue<E> {
   private ArrayList<E> list;
   private Comparator<E> comparator;
   public PriorityQueue() { // using compareTo for the priority O(1)
     list = new ArrayList<>();
     comparator = null;
   }
   /***
    * default constructor
    * @param c
    */
   //O(1)
   public PriorityQueue(Comparator<E> c) { // using compare on the object comparator
      list = new ArrayList<>();
      comparator = c;
   }

   /***
    * poll
    * @return E
    */
   public E poll() { //O(n)
		E value = list.get(0);
		list.remove(0);
        return value;
   }
   /***
    * offer
    * @param item
    */
   public void offer(E item) { //O(n)
    int i, c;
    for(i=0; i<list.size(); i++){
        if(comparator == null)
            c = ((Comparable<E>)item).compareTo(list.get(i));
        else
	        c = comparator.compare(item, list.get(i));
	    if(c < 0)
            break;
    }
    list.add(i, item);
   }

   /***
    * peek
    * @return E
    */
   public E peek() { //O(1)
      return list.get(0);
   }

   /***
    * ToString
    @return toString
    */
   public String toString() { //O(n)
		return "Priority Queue: " + list.toString();
   }


   /***
    * size
    * @return int
    */
   public int size() { //O(1)
    return list.size();
   }
   /***
    * clear
    */
   public void clear() { //O(1)
    list.clear();
   }

   /***
    * Checking if empty
    * @return boolean
    */
   public boolean isEmpty() { //O(1)
    return list.isEmpty();
   }

   /***
    * contains
    * @param o
    * @return boolean
    */
   //O(n)
   public boolean contains(Object o){
      return list.contains(o);
   }


   /***
    * sort
    */
   //  O(n^2)
   public void sort(){
      list.sort();
   }

   /***
    * sort
    * @param c
    */

   //O(n^2)
   public void sort(Comparator<E> c){
      list.sort(c);
      comparator = c;
   }

   
}
