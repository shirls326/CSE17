
/***
 * Class to test the other clases in the file
 * @author Shirley Angos
 * @version 0.1
 * Date of creation: January 29 2023
 * Last Date Motified: Febrary 1 2023
 */
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        // initalizing
        Event[] events = new Event[10];
        Scanner in = new Scanner(System.in);
        boolean loopNeeded = true;
        events[0] = new Appointment("Dentist", "Lehigh Dentists", "01/26/2023", "10:30", "Beth Clark");
        events[1] = new Meeting("Science Club", "PA-220", "02/03/2023", "16:30", "Will Johns", 25);
        events[2] = new Meeting("Movie Club", "PA-220", "01/31/2023", "17:00", "Grace Williams", 10);
        events[3] = new Appointment("Instructor", "PA-254", "01/30/2023", "11:15", "Mark Jones");
        events[4] = new Meeting("Provost", "Memorial Building", "05/05/2023", "14:30", "Lisa Zuppe", 100);
        events[5] = new Meeting("Group work", "Zoom", "02/07/2023", "18:45", "Jack Taylor", 5);
        events[6] = new Appointment("Doctor", "Lehigh Doctors", "04/22/2023", "13:45", "Kathy Bell");
        events[7] = new Meeting("Programming Club", "PA-220", "03/15/2023", "19:00", "Billy Steward", 20);
        events[8] = new Appointment("Advising", "PA-252", "03/11/2023", "12:15", "Sharon Kraft");
        events[9] = new Appointment("Bank Account", "Wells Fargo", "03/25/2023", "10:30", "Sarah Thomson");

        while (loopNeeded) {
            System.out.println("Select an operation:");
            System.out.println("1: view all events");
            System.out.println("2: search event by description");
            System.out.println("3: search events by location");
            System.out.println("4: sort events by location");
            System.out.println("5: exit");

            int choice = in.nextInt();
          

            switch (choice) {

                case 1:
                    printEvent(events);
                    break;

                case 2:
                    String junk = in.nextLine();
                    System.out.println("Enter a description:");
                    String d = in.nextLine();
                    System.out.println(d);
                    int index = findEvent(events, d);
                    if (index == -1) {
                        System.out.println("Event is not found");
                    } else {
                        System.out.println("Event is found at index " + index);
                    }
                    break;

                case 3:
                    System.out.println("enter a location:");
                    String l=in.next();
                    Event[] x=findEvents(events, l);
                    for(int i=0;i<3;i++){
                    if(x[i]==null){
                        break;
                    }
                    else
                    System.out.println(x[i]);
                    }
                    break;

                
                case 4:
                    sortEvents(events);
                    printEvent(events);
                    break;


                case 5:
                    System.out.println("Goodbye");
                    loopNeeded = false;
                    break;

                default:
                    System.out.println("Invalid input! Try again");


            }

        }

    }

    public static void printEvent(Event[] list) {

        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }

    }

    public static Event[] findEvents(Event[] list, String loc) {
        Event[] e = new Event[10];
        int j = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i].getLocation().equals(loc)) {
                e[j] = list[i];
                j++;
            }
        }
        return e;
    }

    public static int findEvent(Event[] list, String d) {
        int index = -1; // this will be used later if the index is not found
        for (int i = 0; i < list.length; i++) {
            if (list[i].getDescription().equals(d)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void sortEvents(Event[] list) {
        //given selection sort
        for (int i = 1; i < list.length; i++) {
            int j = i;
            Event currentVal = list[i];
            while (j > 0 && currentVal.getLocation().compareTo(list[j - 1].getLocation()) < 0) {
                list[j] = list[j - 1];
                j--;
            }
            list[j] = currentVal;
        }
    }

}
