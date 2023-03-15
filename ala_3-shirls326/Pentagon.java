/***
 * @author Shirley Angos
 * @version 0.1
 * Date of creation: Feburary 16 2023
 * Last Date modified: Febuary 16 2023
 * Class to model the entity Pentagon that extends Shape
 */
public class Pentagon extends Shape {

    //data type
    private double side;

    /***
     * default construtor
     */
    public Pentagon(){
        super();
        side = 1;

    }


    /***
     * 2 arg constructor
     * @param c color
     * @param s side
     */
    public Pentagon(String c, double s){
        super(c);
        side = s;


    }

    /***
     * getter method
     * @return side
     */
    public double getSide() {
        return side;
    }

    /***
     * Setter method
     * @param side
     */
    public void setSide(double side) {
        this.side = side;
    }

    /***
     * toString method
     * @return String
     */
    @Override
    public String toString() {
        
        return String.format("%-10s\t%s\t%-10.2f\t%-10.2f\t%-10.2f","Pentagon",super.toString(),side,getArea(),getPerimeter());
    }

    /***
     * Get area Method
     * @return double area
     */
    @Override
    public double getArea() {
        double a = 0.25 * Math.sqrt(5+(5+2*Math.sqrt(5)));
        a *= side * side;
        return a;
    }


    /***
     * Get Perimeter method
     * @return double
     */
    @Override
    public double getPerimeter() {
   
        return side*5;
    }


    /***
     * create clone method (deep copy)
     * @return object
     */
    @Override
    public Object clone() {
        
        return new Pentagon(getColor(), side);
    }


    /***
     * Scale method
     * @param f
     */
    @Override
    public void scale(double f) {
        
        side *= f;
        
    }


    
}
