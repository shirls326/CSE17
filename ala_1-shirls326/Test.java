/***
 * Class to test all of the classes and to create an array of people and to sort through them
 * @author Shirley Angos
 * @version 0.1
 * Date of creation: January 23, 2023
 * Last date Modified: January 28, 2023
 */

public class Test{

    public static void main(String[] args) {


        //initializing
        Person[] people = new Person[4];

        //filling the array with people given from the ALA 1 Documentation
        people[0] = new Person("Helen Brown", "222 10th Street Bethlehem", "610-334-2288", "hbrown@gmail.com");
        people[1] = new Student("Paul Leister", "972 4th Street Allentown","610-331-7177","pleister@gmail.com",12345,"CSE");
        people[2] = new Employee("Beth Down","234 Main Street Philadelphia","484-222-4433","bdown@gmail.com",33442,"Systems Administrator",4467654);
        people[3] = new Faculty("Mark Jones", "21 Orchid Street Bethlehem","610-333-2211","mjones@gmail.com",22222,"Faculty",123456763,"Associate Professor");

        /***
         * Calling the methods printArray(), sortArray(), then printArray() again to print the sorted list
         */
        printArray(people);
        sortArray(people);
        System.out.println("Sorted list");
        printArray(people);
        
    }


    /***
     * Method to print the array of People 
     * @param p for the array of people
     * no return value
     */
    public static void printArray(Person[] p){

        for (int i = 0; i < p.length; i++) {
            System.out.println(p[i]);
            
        }
    }

    /***
     * Method to sort array
     * @param list of people
     * no return value
     */
    public static void sortArray(Person[] list){ // selection sort

        for(int i=0; i<list.length; i++){
            int minIndex = i;
            for(int j=i+1; j<list.length; j++)     
                if(list[j].getName().compareTo(list[minIndex].getName()) < 0 )  // lessthan 0, second one first
                       minIndex=j;
            Person temp = list[i];
            list[i] = list[minIndex];
            list[minIndex] = temp;


    }

}




}