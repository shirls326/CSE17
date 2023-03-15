/***
 * @author Shirley Angos
 * @version 0.1
 * Date of creation: Febuary 16 2023
 * Last date modified: febuary 16 2023
 * Test class
 */

public class TestShapes {

    public static void main(String[] args) {

        Shape [] shapes = new Shape[8];
        shapes[0] = new Circle("Black",2.5);
        shapes[1] = new Triangle("Green",6,6,6);
        shapes[2] = new Rectangle("Red", 5,3);
        shapes[3] = new Pentagon("Yellow", 7);
        shapes[4] = (Shape) shapes[0].clone();
        shapes[5] = (Shape) shapes[1].clone();
        shapes[6] = (Shape) shapes[2].clone();
        shapes[7] = (Shape) shapes[3].clone();
        shapes[4].scale(2.0);
        shapes[5].setColor("Orange");
        ((Rectangle)shapes[6]).setLength(10.0);
        ((Pentagon)shapes[7]).setSide(4.0);
        System.out.println("Original list");
        printArray(shapes);
        java.util.Arrays.sort(shapes);
        System.out.println("\nSorted list: ");
        printArray(shapes);
        System.out.println("Average Perimeter: "+ getAveragePerimeter(shapes));
  
        

    }

    public static void printArray(Shape[] list){

        for (Shape shape : list) {

            System.out.println(shape);
            
        }
    }

    public static double getAveragePerimeter(Shape[] list){
        double p = 0;

        for (Shape shape : list) {

            p+= shape.getPerimeter();
            
        }

        return p / list.length;

    }
    
}
