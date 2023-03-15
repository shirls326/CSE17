/***
 * @author Shirley Angos
 * @version 0.1
 * Date of creation:
 * Date last modified:
 * Class to display the class entity Airplane and to allow seat reservation and modification of filo I/O practice
 */

import java.util.Scanner;
import java.util.Arrays;



public class SeatReservation {

    public static void main(String[] args) {


        //initializing
        Airplane myAirplane = new Airplane("seatsmap.txt");
        System.out.println(myAirplane); // no toString neccesary
        Scanner in = new Scanner(System.in);
        char choice = ' ';
        boolean loopNeeded = true;


        while(loopNeeded){

            System.out.println("Please enter an operation");
            System.out.println("1. Reserve a seat");
            System.out.println("2. Free a seat");
            System.out.println("3. Exit");

            choice = in.next().charAt(0);
            String seatnum = "";

            try {
                switch(choice){

                    case '1':
                        System.out.println("Enter a seat to reserve");
    
                        seatnum = in.next();
                        if(myAirplane.reserveSeat(seatnum)){
                            System.out.println(seatnum + " was reserved successfully!");
    
                        } else{
                            System.out.println(seatnum + " was already reserved!");
                        }
    
                        break;
    
    
                    case '2':

                        System.out.println("Enter a seat to free");
        
                        seatnum = in.next();
                        if(myAirplane.freeSeat(seatnum)){
                            System.out.println(seatnum + " was reserved freed!");

                        } else{
                            System.out.println(seatnum + " was already free!");
                        }

                    break;


                    
    
                    case '3':
                        myAirplane.saveMap("seatsmap.txt");
                        loopNeeded = false;
                        break;
                        
                        

    
    
                    default: // avoids using a try catch statement all together since it's unnessecary
                    System.out.println("Invalid choice, try again!");
    
    
    
                }
                
            } catch (InvalidSeatException e ) {

                System.out.println( e.getMessage());


            }

            


        }

        

        
    }
    
}
