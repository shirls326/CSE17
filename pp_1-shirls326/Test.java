/***
 * @author Shirley Angos
 * @version 0.1
 * Date of Creation: March 4 2023
 * Last Date Modified: March 5 2023
 */


import java.util.Scanner;


public class Test{


    public static void main(String[] args){

        //initalize
        Calendar calendar = new Calendar("events.txt");
        boolean loopNeeded = true;
        Scanner in = new Scanner(System.in);

        while(loopNeeded){

            System.out.println("Select an operation:");
            System.out.println("1. View all events");
            System.out.println("2. Search event by description");
            System.out.println("3. Search events by date");
            System.out.println("4. Add a new event");
            System.out.println("5. Remove existing event");
            System.out.println("6. Sort events by date and time");
            System.out.println("7. Exit");
            
            String temp = in.nextLine();
            char choice = temp.isEmpty() ? ' ' : temp.charAt(0);

            switch(choice){

                case '1': calendar.viewEvents(); break;

                case '2':
                    //in.nextLine(); // clearing the scanner so it doesn't skip asking for a description
                    System.out.println("Enter a descrption:");
                    String description = in.nextLine();
                    if(calendar.findEvent(description) != null){
                        System.out.println(calendar.findEvent(description));
                        
                    }else {
                        System.out.println("Event not found!");
                    }
                    
                    break;

                
                case '3':

                    System.out.println("Enter a date in the format MM/DD/YYYY:");
                    
                    Event [] found = calendar.findEvents(in.nextLine());

                    for (int i = 0; i < found.length; i++) {
                        if(found[i] == null ){
                            continue;
                        } else {
                            System.out.println("Events found!\n");
                            System.out.println(found[i]);

                        }
                        
                    }

                    break;
                    

                case '4':

                String des;
                String location;
                String date;
                String time;
                String contact;
                String host;
                int guest;
                
                    System.out.println("Enter the type of event you want to create (meeting/appointment)");


                    String type = in.nextLine().toLowerCase();

                    try{
                        if(type.equals("meeting")){
                            System.out.println("Enter a description");
                            des = in.nextLine();
                            System.out.println("Enter a location");
                            location = in.nextLine();
                            System.out.println("Enter a date");
                            date = in.nextLine();
                            System.out.println("Enter a time");
                            time = in.nextLine();
                            System.out.println("Enter a host");
                            host = in.nextLine();
                            System.out.println("Enter number of guest");
                            guest = in.nextInt();
                            
                            Meeting m = new Meeting(des, location, date, time, host, guest);

                            calendar.addEvent(m);
    
    
    
                        }else if(type.equals("appointment")){

                            System.out.println("Enter a description");
                            des = in.nextLine();
                            System.out.println("Enter a location");
                            location = in.nextLine();
                            System.out.println("Enter a date");
                           

            
                            date = in.nextLine();
                            System.out.println("Enter a time");
                            time = in.nextLine();
                            System.out.println("Enter a contact");
                            contact = in.nextLine();
                            Appointment a = new Appointment(des, location, date, time, contact);

                            calendar.addEvent(a);
                          
    
    
                        }else{
                            System.out.println("Invalid type!");      
                        }


                    }catch(InvalidDateTimeException e){

                        System.out.println(e.getMessage());
                    }
                    

                    break;

                   
                    

                case '5':
                    System.out.println("Enter a description");
                    if(calendar.removeEvent(in.nextLine())){
                        System.out.println("event removed suecessfully!");
                    }else{
                        System.out.println("Couldn't find event!");
                    }
                    break;

                case '6':
                    System.out.println("Sorting events by date and time");
                    System.out.println("Unsorted List");
                    calendar.viewEvents();
                    System.out.println();
                    System.out.println("Sorted List:");
                    calendar.sortEvents();
                    calendar.viewEvents();
                    break;

                case '7':
                    loopNeeded = false;
                    System.out.println("Exiting program");
                    calendar.saveEvents("events.txt");
                    in.close();
                    break;
                    

                default:
                    System.out.println("Not a valid input! Please try again");


            }




        }



    


        
    }
}