/***
 * @author Shirley Angos
 * @version 0.1
 * Date of creation: March 31 2023
 * Last date modified: March 31 2023
 * Class to model entity Flight in an ArrayList and queue and to interact with other classes via the main
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Queue;




public class Test {

    

    /***
     * Main class
     * @param args
     */
    public static void main(String[] args) throws InvalidDateTimeException {

        // landing
        ArrayList<Flight> landingList = new ArrayList<>();
        Queue<Flight> landingQueue = new LinkedList<>();


        //take off
        ArrayList<Flight> takeoffList = new ArrayList<>();
        Queue<Flight> takeoffQueue = new LinkedList<>();

    

        //reading in the file
     
        readFlights(landingList, "landing.txt");
        readFlights(takeoffList, "takeoff.txt");

   


        // simulations
        Time startingTime = new Time("12:00");
        int duration = 480;
        int landingTime = 12;
        int takeOffTime = 7;
        int runway = 0;
        int countLanding = 0;
        int countTakeOff=0;
        int sumLandingWaitTime = 0;
        int sumTakeOffTime = 0;
        String landingReport = "";
        String takeOffReport = "";

        for (int i = 0; i < 480; i++) {

        
            int indexLand = findLanding(landingList, startingTime);
            int indexTakeOff = findTakeoff(takeoffList, startingTime);

            while(indexLand != -1){ // checking if it repeats
                landingQueue.offer(landingList.get(indexLand));
                System.out.println("A landing request has been added to the landing queue at "+ landingList.get(indexLand).getArrival());
                landingList.remove(indexLand); // to remove that current value to check for duplicates
                indexLand = findLanding(landingList, startingTime); // finding index of flight, if -1, no flight
                
                
            }

           
            while(indexTakeOff != -1){
                takeoffQueue.offer(takeoffList.get(indexTakeOff));
                System.out.println("A takeoff request has been added to the takeoff queue at "+ takeoffList.get(indexTakeOff).getDeparture());
                takeoffList.remove(indexTakeOff); // to remove that current value to check for duplicates
                indexTakeOff = findTakeoff(takeoffList, startingTime); // finding index of flight, if -1, no flight
                
            }

            //if the runway is not free
            if(runway!=0){ // 
                runway--;
            }else{
                if(!landingQueue.isEmpty()){
                    Flight first = landingQueue.poll(); 
                    int waitingTime = startingTime.diff(first.getArrival());     
                    landingReport+=String.format("%s\t%-10s\t%-10d\n",first.toString(),startingTime.toString(),waitingTime);
                    runway = landingTime;
                    countLanding++;    
                    sumLandingWaitTime += waitingTime;
                    

                } else if(!takeoffQueue.isEmpty()){
                    Flight second = takeoffQueue.poll(); 
                    int waitingTime = startingTime.diff(second.getDeparture());    
                    takeOffReport+=String.format("%s\t%-10s\t%-10d\n",second.toString(),startingTime.toString(),waitingTime);
                    runway = takeOffTime;
                    countTakeOff++; // this will be used later to calculate the avg
                    sumTakeOffTime += waitingTime;
                   
                    

                }


            }

            



            startingTime.tick();

        }

        //landing report
        System.out.println("Landing report:");
        System.out.printf("%-10s\t%-10s\t%-10s\t%-10s\t%-10s\n","Flight","Departure","Arrival","Arrived","Waiting Time");
        System.out.println(landingReport);
        int averageLand = sumLandingWaitTime/countLanding;
        System.out.println("Average waiing time for landing request: " + averageLand + " minutes");

        //take off report
        System.out.println("Take off report report:");
        System.out.printf("%-10s\t%-10s\t%-10s\t%-10s\t%-10s\n","Flight","Departure","Arrival","Arrived","Waiting Time");
        System.out.println(takeOffReport);
        int averageTakeOff = sumTakeOffTime/countTakeOff;
        System.out.println("Average waiing time for landing request: " + averageTakeOff + " minutes");


    
    


        




         
    }

    /***
     * Reading in the flights method
     * @param list
     * @param filename
     * @throws InvalidDateTimeException
     */
    public static void readFlights(ArrayList<Flight> list, String filename) throws InvalidDateTimeException{
        File f = new File(filename);
        try{
            Scanner fs = new Scanner(f);
            while(fs.hasNext()){
                String flight = fs.next();
                Time depature = new Time(fs.next());
                Time arrival = new Time(fs.next());
                Flight fl = new Flight(flight, depature, arrival);
                list.add(fl);
            }
            fs.close();
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch(InvalidDateTimeException idte){
            System.out.println(idte.getMessage());
        }

    }


    /***
     * findingLanding
     * @param list
     * @param time
     * @return index
     */

    public static int findLanding(ArrayList<Flight> list, Time time){

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getArrival().equals(time)){
                return i; // index of where the flight is at
            }       
        }

        return -1; // if not found
    }


    /***
     * findTakeoff
     * @param list
     * @param time
     * @return index
     */
    public static int findTakeoff(ArrayList<Flight> list, Time time){

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getDeparture().equals(time)){
                return i; // index of where the flight is at
            }       
        }

        return -1; // if not found


    }

    
    
}
