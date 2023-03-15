/***
 * @author Shirley Angos
 * @version 0.1
 * Date of creation: Febuary 16 2023
 * Last date modified: Feburary 16 202
 * Class to model entity Triangle that extends Shape
 */
public class Triangle extends Shape{

    // data types
    private double side1;
    private double side2;
    private double side3;


    /***
     * Default constructor
     * no param
     * no return
     */
    public Triangle(){
        super();
        side1 = 1;
        side2 = 1;
        side3 = 1;
    }

    /***
     * 4 arg constructor
     * @param c
     * @param s1
     * @param s2
     * @param s3
     * no return
     */
    public Triangle(String c, double s1, double s2, double s3){
        super(c);
        side1 = s1;
        side2 = s2;
        side3 = s3;
    }


    /***
     * Getter method
     * @return side1
     */
    public double getSide1() {
        return side1;
    }
    /***
     * Getter method
     * @return side2
     */
    public double getSide2() {
        return side2;
    }
    /***
     * Getter method
     * @return side3
     */
    public double getSide3() {
        return side3;
    }

    /***
     * Setter method
     * @param side1
     */
    public void setSide1(double side1) {
        this.side1 = side1;
    }

    /***
     * Setter method
     * @param side2
     */
    public void setSide2(double side2) {
        this.side2 = side2;
    }
    
    /***
     * Setter method
     * @param side3
     */
    public void setSide3(double side3) {
        this.side3 = side3;
    }

    /***
     * toString method
     * no param
     * @return String
     */
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("%-10s\t%s\t%-10.2f\t%-10.2f\t%-10.2f\t%-10.2f\t%-10.2f", "Triangle", super.toString(),side1, side2, side3, getArea(),getPerimeter());
    }

    /***
     * get Area
     * @return double area
     */
    @Override
    public double getArea() {

        double p = (side1 + side2 + side3)/2;
        return Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
    }

    /***
     * get Perimet
     * @return double perimeter
     */
    @Override
    public double getPerimeter() {
        
        return side1 + side2 + side3;
    }

    /***
     * clone method
     * @return Object 
     */
    @Override
    public Object clone() {
        
        return new Triangle(getColor(), side1, side2, side3);
    }


    /***
     * scale method
     * @param f
     */
    @Override
    public void scale(double f) {
        
        side1 *= f;
        side2 *= f;
        side3 *= f;
        
    }




    
}
