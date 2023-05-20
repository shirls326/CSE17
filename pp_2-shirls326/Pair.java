/***
 * @author Shirley Angos
 * @version 0.1
 * Date of creation: April 20 2023
 * Last Date modified: April 24 2023
 * Class to model entity Pair
 */
public class Pair<E1,E2>{
    //date types
    private E1 first;
    private E2 second;

    /***
     * Default constuctor
     */
    public Pair(){
        first = null;
        second = null;
    }
    /***
     * 2 arg constructor
     * @param f first
     * @param s second
     */
    Pair(E1 f, E2 s){
        first = f;
        second = s;
    }
    /***
     * getter
     * @return first
     */
    public E1 getFirst(){
        return first;
    }
    /***
     * getter
     * @return second
     */
    public E2 getSecond(){
        return second;
    }
    /**
     * Setter
     * @param f first
     */
    public void setFirst(E1 f){
        first = f;
    }
    /***
     * setter
     * @param s second
     */
    public void setSecond(E2 s){
        second = s;
    }
    /***
     * toString
     * @return toString for pair
     */
    public String toString(){
        return "(" + first.toString() + ", " + second.toString() + ")";
    }
    /***
     * Equals method
     * Checks if the pair is equal
     * @return if the pair is equal
     */
    public boolean equals(Object o){
        // downcast o to Pair
        if(o instanceof Pair){//safe downcasting
            Pair<E1,E2> pair = (Pair) o;// downcasting
            return this.getFirst().equals(pair.getFirst()) && // equals for type E1
                   this.getSecond().equals(pair.getSecond()); // equals() for type E2
        }
        return false;
    }
}