/***
 * @author Shirley Angos
 * @version 0.1
 * Date of creation: March 4 2023
 * Last Date modified: March 4 2023
 * Class to model the entity Calendar 
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;


public class Calendar {

    //data types
    private Event [] events;
    private int count;


    /***
     * Default constructor
     * 
     */
    public Calendar(){
        events = new Event[50];
        count = 0;


    }

    /***
     * 1 arg constructor
     * @param filename
     */

    public Calendar(String filename){

        events = new Event[50];
        count = 0;
        readEvents(filename); 


    }

    /***
     * Method to read Events
     * @param filename
     */
    private void readEvents(String filename){

      //initializing 
      String eventType, description, location, date, time, contact, host;
      int guest;

      File f = new File(filename);

      try{

          Scanner fScan = new Scanner(f);

          while(fScan.hasNextLine()){


              eventType = fScan.nextLine(); // we're going to use this to check line by line, specifically for what type of event it is

              switch(eventType){

                  case "appointment":
                      description = fScan.nextLine();
                      location = fScan.nextLine();
                      date = fScan.nextLine();
                      time = fScan.nextLine();
                      contact = fScan.nextLine();
                      events[count++] = new Appointment(description,location,date,time,contact);
                      break;


                  case "meeting":
                      description = fScan.nextLine();
                      location = fScan.nextLine();
                      date = fScan.nextLine();
                      time = fScan.nextLine();
                      host = fScan.nextLine();
                      guest = fScan.nextInt();
                      events[count++] = new Meeting(description, location, date, time, host, guest);
                      break;

                  default:

              }

          }
          fScan.close();
        
          

      }catch(FileNotFoundException fnf){

          System.err.println(fnf.getMessage());


      } catch(InvalidDateTimeException e){

          System.err.println(e.getMessage());

      }


    }

    /***
     * method to save Events
     * @param filename
     */

    public void saveEvents(String filename){

        File f = new File(filename);

        try{

            PrintWriter p = new PrintWriter(f);
            for (int i = 0; i < count; i++) {

                if(events[i] instanceof Meeting){
                   Meeting m = (Meeting)events[i];
                   p.println(m.getType());
                   p.println(m.getDescription());
                   p.println(m.getLocation());
                   p.println(m.getDate());
                   p.println(m.getTime());
                   p.println(m.getHost());
                   p.println(m.getGuest());

                }else{
                   Appointment a = (Appointment)events[i];
                   p.println(a.getType());
                   p.println(a.getDescription());
                   p.println(a.getLocation());
                   p.println(a.getDate());
                   p.println(a.getTime());
                   p.println(a.getContact());

                }              
            }
            p.close();

        }catch(FileNotFoundException e){

            System.err.println(e);
        }



    }

    /***
     * Method to find event
     * @param description
     * @return e
     */
    public Event findEvent(String description){

        for (int i = 0; i < count; i++) {
            if(events[i].getDescription().equals(description)){
                return events[i];
            }       
            
        }

        return null;
        
    } 

    public Event[] findEvents(String date){

        Event[] e = new Event[10];
        int j = 0;

        try{
            Date d = new Date(date);
            for (int i = 0; i < count; i++) {
                if ((events[i].getDate().compareTo(d) == 0)) { // had to do toString instead of equals since not overridden in Date.java
                    e[j] = events[i];
                    j++;
    
                }
            }
    
            if(j == 0){ // to print out events if there is nothing found
                System.out.println("No events found!\n");
            }


        }catch(InvalidDateTimeException err){

            System.err.println(err.getMessage());
        
        }


        return e;


    }

    /***
     * Method to add an event
     * @param e
     * @return boolean
     */

    public boolean addEvent(Event e){

        if(e.getDate() == null || e.getTime() == null){
            System.out.println("Invalid date/time, event not added!");
            return false;
        }

        if(count != events.length){
            events[count] = e;

            count++;
            System.out.println("Event sucessfully added!");
            return true;

        }
        System.out.println("Event not added!");
        return false;        

    }

    /***
     * Method to remove event
     * @param description
     * @return boolean
     */

    public boolean removeEvent(String description){

        int index = -1;
        for (int i = 0; i < count; i++) {

            if(events[i].getDescription().equals(description)){
                index = i;
                events[index] = null; // removing the event
                count--; // making the size smaller since an event was removed
                
                break;
            }
            
        }
    

        if(index == -1) return false; // breaks it off here so it doesn't have to go through all the code if the event is not found


        for (int j = index; j < count; j++) { // shift the boys back
            Event temp = events[j+1];
            events[j+1] = events[j];
            events[j] = temp;
            
                
        }
        
        return true;

    }


    /*** 
     * Method to view Events
     * no param
     * no return
     */
    public void viewEvents(){

        System.out.printf("%-10s\t %-20s\t %-20s\t %-10s\t %-10s\t%-10s\t%-10s\n","Type","Description","Location","Date","Time","Contact/Host", "Guest");

        for (int i = 0; i < count; i++) {

            System.out.println(events[i]);
            
            
        }


    }

    /***
     * Method to sort Events
     * no param
     * no return
     */

    public void sortEvents(){

        java.util.Arrays.sort(events, 0, count);


    }






    
}
