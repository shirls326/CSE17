/***
 * @author Shirley Angos
 * @version 0.1
 * Date of creation: Febuary 16 2023
 * Last date modified: feburary 16 2023
 * Class to model entity shape
 */

public abstract class Shape implements Comparable<Shape>, Cloneable {

    private String color;


    /***
     * Default constructor
     * no param
     * no return
     */
    protected Shape(){
        color = null;
    }

    /***
     * 1 arg constructor
     * @param color
     * no return
     */

    protected Shape(String color){
        this.color = color;
    }

    /***
     * Getter method
     * no param
     * @return color
     */
    public String getColor() {
        return color;
    }

    /***
     * Setter method
     * @param color
     * no return
     */
    public void setColor(String color) {
        this.color = color;
    }



    /***
     * toString Method
     * no param
     * @return string
     */
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("%-10s", color);
    }


    /***
     * compareTo method
     * @param o
     * @return int
     */
    @Override
    public int compareTo(Shape o) {

        if(this.getArea() == (o.getArea())){
            return 0;
        } else if(this.getArea() > (o.getArea())){
            return 1;
        } else{
            return -1;
        }
    }


    /***
     * Abstract getArea Method
     * no param
     * @return double
     */
    public abstract double getArea();

    /***
     * Abstract getPerimeter method
     * no param
     * @return double
     */

    public abstract double getPerimeter();


    /***
     * Abstract Object Clone method
     * no param
     * @return Object
     */
    public abstract Object clone();


    /***
     * Abstract scale method
     * @param f
     * no return
     */
    public abstract void scale(double f);
    
}
