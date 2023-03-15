/***
 * @author Shirley Angos
 * @version 0.1
 * Date of creation: March 9 2023
 * Last Date Modified: March 9 2023
 * Class to model the entity Pair
 */
public class Pair<E1,E2>{

    // data types
    private E1 first;
    private E2 second;


    /***
     * default constructor
     */
    public Pair(){
        first = null;
        second = null;
    }

    /***
     * 2 arg constructor
     * @param f
     * @param s
     */
    public Pair(E1 f, E2 s){

        first = f;
        second = s;
    }

    /***
     * getter method
     * @return E1
     */
    public E1 getFirst() {
        return first;
    }

    /***
     * getter method
     * @return E2
     */
    public E2 getSecond() {
        return second;
    }

    /***
     * Setter method
     * @param first
     */
    public void setFirst(E1 first) {
        this.first = first;
    }

   /***
    * setter method
    * @param second
    */
    public void setSecond(E2 second) {
        this.second = second;
    }


    /***
     * toString
     * @return String
     */
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "(" + first.toString() + ", " + second.toString() + ")";
    }

    /***
     * equals
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub

        // downcast o to pair
        if(obj instanceof Pair){ // safe downcasting
            Pair<E1,E2> pair = (Pair) obj; // downcasting
            return this.getFirst().equals(pair.getFirst()) && this.getSecond().equals(pair.getSecond()); // equals for type E1
        }
        return false;
    }



}