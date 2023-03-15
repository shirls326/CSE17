

/***
 * @author Shirley Angos
 * @version 0.1
 * Date of Creation: Feburary 16 2023
 * Last Date Modified: Feburry 16 2023
 * Class to model Entity Circle that extends shape
 */

public class Circle extends Shape {


    //data types
    private double radius;


    /***
     * Default constructor
     * no param
     * no return
     */
    public Circle(){
        super();
        radius = 1.0;
    }


    /***
     * 
     * 2 arg constructor
     * @param color
     * @param r
     * no return
     */
    public Circle(String color, double r){
        super(color);
        radius = r;

    }

    /**
     * Getter method
     * no param
     * @return radius
     */
    public double getRadius() {
        return radius;
    }
    /***
     * setter method
     * @param radius
     * no return
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }


    /***
     * ToString method
     * no param
     * @return String
     */
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("%-10s\t%s\t%-10.2f\t%-10.2f\t%-10.2f","Circle", super.toString(), radius,getArea(),getPerimeter());
    }


    /***
     * getArea method
     * no param
     * @return double Area
     */
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    /***
     * getPerimeter Method
     * no param
     * @return double Perimeter
     */
    @Override
    public double getPerimeter() {

        return 2*Math.PI*radius;
    }


    /***
     * clone Method (deep copy)
     * no param
     * @return Object
     */
    @Override
    public Object clone() {
   
        return new Circle(getColor(),radius);
    }

    /***
     * Scale method
     * @param f
     * no return
     */
    @Override
    public void scale(double f) {
        
        radius = radius*f;
        
    }


    
}
