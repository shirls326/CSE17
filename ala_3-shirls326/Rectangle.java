/***
 * @author Shirley Angos
 * @version 0.1
 * Date of creation: Febuary 16 2023
 * Date last modified: Feburary 16 2023
 * Class to model eneity Rectangle that extends Shape
 */

public class Rectangle extends Shape {


    //data types
    private double length;
    private double width;


    /*
     * Default constructor
     * no param
     * no return
     */
    public Rectangle(){
        super();
        length = width + 1.0;
    }


    /***
     * 3 arg consturctor
     * @param c
     * @param length
     * @param width
     * no return
     */
    public Rectangle(String c, double length, double width){
        super(c);
        this.length = length;
        this.width = width;

    }

    /***
     * Getter method
     * @return length
     * no param
     */
    public double getLength() {
        return length;
    }

    /***
     * Getter method
     * no param
     * @return width
     */
    public double getWidth() {
        return width;
    }
    /***
     * Setter method
     * @param length
     * no return
     */
    public void setLength(double length) {
        this.length = length;
    }
    /***
     * Setter method
     * @param width
     * no return
     */
    public void setWidth(double width) {
        this.width = width;
    }


    @Override
    /***
     * toString Method
     * penis
     */
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("%-10s\t%s\t%-10.2f\t%-10.2f\t%-10.2f\t%-10.2f", "Rectangle",super.toString(), width,length,getArea(),getPerimeter());
    }

    /***
     * method to get area
     * no param
     * @return area
     */
    @Override
    public double getArea() {
        
        return width*length;
    }

    /***
     * method to get perimeter
     * no parm
     * @return perimeter
     */
    @Override
    public double getPerimeter() {
        
        return 2*(width + length);
    }

    /***
     * Clone method
     * no param
     * @return Object
     */
    @Override
    public Object clone() {
        return new Rectangle(getColor(), length, width);
    }

    /***
     * Scale method
     * @param f
     * no return
     */
    @Override
    public void scale(double f) {
        
        length *= f;
        width *= f;
        
        
    }
    
}
