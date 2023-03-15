/***
 * @author Shirley Angos
 * @version 0.1
 * Date of creation: February 9 2023
 * Last Date modified: Feburary 11 2023
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;




public class Test {

    public static void main(String[] args) {

        //initlize
        Event [] events = new Event[50];
        int elements = 0;
        elements = readEvents(events,"events.txt");
        boolean loopNeeded = true;
        Scanner in = new Scanner(System.in);




        while(loopNeeded){

            System.out.println("Select an operation:");
            System.out.println("1. View all events");
            System.out.println("2. Search event by description");
            System.out.println("3. Search events by date");
            System.out.println("4. Sort events by date and time");
            System.out.println("5. exit");

            char choice = in.next().charAt(0);

            switch(choice){

                case '1':
                   
                    printEvents(events, elements);
                    break;

                case '2':
                    String junk = in.nextLine(); // clearing the scanner so it doesn't skip asking for a description
                    System.out.println("Enter a descrption:");
                    String description = in.nextLine();
                    if (findEvent(events,description,elements) == -1){
                        System.out.println("Event is not found!");

                    } else{
                        int tempIndex = findEvent(events,description,elements);
                        System.out.println("Event found at index "+ tempIndex);
                        System.out.println();
                        System.out.println(events[tempIndex]);
                    }

                    break;
                    


                case '3':

                    String aaa = in.nextLine();
                    
                    System.out.println("Enter a date in the format MM/DD/YYYY:");

                    String temp = in.nextLine();
                    try{

                        Date d = new Date(temp);

                        Event [] found = findEvents(events, d, elements);

                        for (int i = 0; i < found.length; i++) {
                            if (found[i] == null){
                                continue;
                            } else{
                                System.out.println("Events found!\n");
                                System.out.println(found[i]);
                            }
                            
                        }

                        
                        

                    }catch(InvalidDateTimeException e){
                        
                        System.out.println(e.getMessage());

                    }


                    break;


                case '4':
                    System.out.println("Events sorted by date and time:\n");
                    sortEvents(events,elements);
                    printEvents(events, elements);
                    break;

                case '5':
                    loopNeeded = false;
                    System.out.println("Goodbye");
                    break;


                default:
                    System.out.println("Not a valid input! Try again!");

            }

        }

    }





    /**
     * Method to read events in from the txtfile
     * @param list
     * @param filename
     * @return int i
     */

    public static int readEvents(Event[] list, String filename){

        //initializing 
        int i = 0;
        String eventType;
        String description;
        String location;
        String date;
        String time;
        String contact;
        String host;
        int guest;
        

        File f = new File(filename);

        try{

            Scanner fScan = new Scanner(f);

            while(fScan.hasNext()){


                eventType = fScan.nextLine(); // we're going to use this to check line by line, specifically for what type of event it is

                switch(eventType){

                    case "appointment":
                        description = fScan.nextLine();
                        location = fScan.nextLine();
                        date = fScan.nextLine();
                        time = fScan.nextLine();
                        contact = fScan.nextLine();
                        list[i++] = new Appointment(description,location,date,time,contact);
                        break;


                    case "meeting":
                        description = fScan.nextLine();
                        location = fScan.nextLine();
                        date = fScan.nextLine();
                        time = fScan.nextLine();
                        host = fScan.nextLine();
                        guest = fScan.nextInt();
                        list[i++] = new Meeting(description, location, date, time, host, guest);
                        break;

                    default:

                }

            }
            fScan.close();
            

        }catch(FileNotFoundException fnf){

            System.out.println(fnf.getMessage());


        } catch(InvalidDateTimeException e){

            System.out.println(e.getMessage());

        }
        return i;


    }




    /***
     * Method to print events
     * @param e
     * @param elements
     * return void
     */
    public static void printEvents(Event[] e, int elements){


        System.out.printf("%-10s\t %-20s\t %-20s\t %-10s\t %-10s\t%-10s\t%-10s\n","Type","Description","Location","Date","Time","Contact/Host", "Guest");
        for (int i = 0; i < elements; i++) {
        
            System.out.println(e[i]);
        }

    }


    /***
     * Method to sort Event [] events 
     * @param list
     * @param elements
     * no return
     */

    public static void sortEvents(Event [] list,int elements){

        for (int i = 1; i < elements; i++) {
            int j = i;
            Event currentVal = list[i];

          
            while (j > 0 && compare(currentVal,list[j-1]) < 0) {
                list[j] = list[j - 1];
                j--;
            }
            list[j] = currentVal;
        }


    }



    /***
     * method to find an event by descrption
     * @param list
     * @param description
     * @param elements
     * @return index
     */
    public static int findEvent(Event[] list, String description, int elements) {
        int index = -1; // this will be used later if the index is not found
        for (int i = 0; i < elements; i++) { // change from list.length() to elements sinc there are null elements in the array and we don't want those to print
            if (list[i].getDescription().equals(description)) { // linear search
                index = i;
                break;
            }
        }
        return index;
    }

    /***
     * Method to find events
     * @param list
     * @param date
     * @param elements
     * @return Event [] e
     */

    public static Event[] findEvents(Event[] list, Date date, int elements) {
        Event[] e = new Event[10];
        int j = 0;

        for (int i = 0; i < elements; i++) {
            if ((list[i].getDate().toString()).equals(date.toString())) { // had to do toString instead of equals since not overridden in Date.java
                e[j] = list[i];
                j++;

            }
        }

        if(j == 0){ // to print out events if there is nothing found
            System.out.println("No events found!\n");
        }

        return e;

    }

    
    public static int compare(Event e1, Event e2){


        if(e1.getDate().getYear() == e2.getDate().getYear()){
            if(e1.getDate().getMonth() == e2.getDate().getMonth()){
                if(e1.getDate().getDay() == e2.getDate().getDay()){
                    if(e1.getTime().getHours() == e2.getTime().getHours()){
                        return e1.getTime().getMinutes() - e2.getTime().getMinutes();
                    } else{
                        return e1.getTime().getHours() - e2.getTime().getHours();
                    }

                } else{
                    return e1.getDate().getDay() - e2.getDate().getDay();
                }

            }else{
                return e1.getDate().getMonth() - e2.getDate().getMonth();
            }
            
        } else{

            return e1.getDate().getYear() - e2.getDate().getYear();
        }




    }


    
}
