/***
 * @author Shirley Angos
 * @version 0.1
 * Date of creation: March 9 2023
 * Last Date Modified: March 9 2023
 * Class to Test the classes Pair, CompareByFirst and ComparebySecond
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Test {


    /***
     * Main method
     */
    public static void main(String[] args) { // java Test
        Scanner in = new Scanner(System.in);


        //validate the arguments
        if(args.length == 0){
            System.out.println("No arguments provided (states or trees)");
            System.exit(0); // will end the program
        }


        if(args.length > 1){
            System.out.println("Too many arguments (one argument trees or states)");
            System.exit(0);
        }

        String type = args[0]; // get the commmand line arguments

        if(!type.equals("trees") && !type.equals("states")){
            System.out.println("Invalid data type. states and trees are the only types available.");
            System.exit(0);
        }

        switch(type){

            case "trees":
                treesOperations(in);
                break;


            case "states":
                statesOperations(in);
                break;


        }


        
    }

    /***
     * Method to display operations when the file is trees
     * @param in
     */
    public static void treesOperations(Scanner in){
        ArrayList<Pair<String,Integer>> trees = new ArrayList<>(50); // create a list with a capacity = 10
        readTrees(trees, "trees.txt");
        boolean loopNeeded = true;
        while(loopNeeded){

            printMenu("trees");
            char choice = in.nextLine().charAt(0);
            switch(choice){

                case '1': // view
                    print(trees);
                    break;
                case '2': // search
                    System.out.println("Enter a tree name");
                    String name = in.nextLine();
                    int index = search(trees,name); // puts in the parameters into the search method
                    if(index == -1){
                        System.out.println("Tree not found!");
                    }else{
                        System.out.println("Tree found: " + trees.get(index)); // returning the state at the index
                    }
                    break;
                case '3': // sort by name
                    trees.sort(new ComparatorByFirst());
                    print(trees);
                    break;
                case '4': // sort by capital
                    trees.sort(new ComparatorBySecond());
                    print(trees);
                    break;
                case '5': // exit
                    System.out.println("Exiting program");
                    loopNeeded = false;
                    break;

    

                default: System.out.println("Not a valid input try again!"); break;

            }

        }



    }


    /***
     * Method to show operations when file is states
     * @param in
     */
    public static void statesOperations(Scanner in){
        ArrayList<Pair<String,String>> states = new ArrayList<>(50); // create a list with a capacity = 10
        readStates(states, "states.txt");
        boolean loopNeeded = true;


        while(loopNeeded){

            printMenu("states");
            char choice = in.nextLine().charAt(0);
            switch(choice){

                case '1': // view
                    print(states);
                    break;
                case '2': // search
                    System.out.println("Enter a state name");
                    String name = in.nextLine();
                    int index = search(states,name); // puts in the parameters into the search method
                    if(index == -1){
                        System.out.println("State not found!");
                    }else{
                        System.out.println("State found: " + states.get(index)); // returning the state at the index
                    }
                    break;
                case '3': // sort by name
                    states.sort(new ComparatorByFirst());
                    print(states);
                    break;
                case '4': // sort by capital
                    states.sort(new ComparatorBySecond());
                    print(states);
                    break;
                case '5': // exit
                    System.out.println("Exiting program");
                    loopNeeded = false;
                    break;

    

                default: System.out.println("Not a valid input try again!"); break;



            }




        }



    }

    /***
     * Method to print out pairs
     * @param <E>
     * @param list
     */
    public static <E> void print(ArrayList<E> list){

        for (E e : list) {
            System.out.println(e);
        }

    }


    /***
     * Method to print out menus
     * @param type
     */
    public static void printMenu(String type){

        switch(type){
            case "trees":
                System.out.println("Select an operation");
                System.out.println("1. View all trees");
                System.out.println("2. Search trees by name");
                System.out.println("3. Sort trees by name");
                System.out.println("4. Sort trees by height");
                System.out.println("5. Exit");
                break;
            case "states":
                System.out.println("Select an operation");
                System.out.println("1. View all states");
                System.out.println("2. Search states by name");
                System.out.println("3. Sort states by name");
                System.out.println("4. Sort states by capital");
                System.out.println("5. Exit");
                break;
        }
        


    }

    /***
     * Method to read in the states
     * @param list
     * @param filename
     */
    public static void readStates(ArrayList<Pair<String,String>> list, String filename){
        File file = new File(filename);

     

        try {
            Scanner f = new Scanner(file);
            while(f.hasNextLine()){
                String line = f.nextLine();
                String[] items = line.split("\\|"); // "(ab|cd)" looking for ab or cd it means or, you need \\ to actually read it as the character
                String name = items[0];
                String capital = items[1];
                Pair<String, String> state = new Pair<>(name, capital); // name is E1, capital is E2
                list.add(state); // adding the state to the arraylist
            }
            f.close();
            
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            
        }


    }

    /***
     * Method to read in trees
     * @param list
     * @param filename
     */
    public static void readTrees(ArrayList<Pair<String,Integer>> list, String filename){
        File file = new File(filename);

     

        try {
            Scanner f = new Scanner(file);
            while(f.hasNextLine()){
                String line = f.nextLine();
                String[] items = line.split("\\|"); // "(ab|cd)" looking for ab or cd it means or, you need \\ to actually read it as the character
                String name = items[0];
                Integer height = Integer.parseInt(items[1]);
                Pair<String, Integer> tree = new Pair<>(name, height); // name is E1, capital is E2
                list.add(tree); // adding the state to the arraylist
            }
            f.close();
            
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            
        }


    }



    /***
     * Method to search 
     * @param <E1>
     * @param <E2>
     * @param list
     * @param key
     * @return
     */
    public static <E1,E2> int search(ArrayList<Pair<E1,E2>> list, E1 key){
        for (int i = 0; i < list.size(); i++) {
            Pair<E1,E2> pair = list.get(i); // get the pair at index 1
            E1 pairFirst = pair.getFirst(); // getting the first element of the pair
            if(pairFirst.equals(key)){
                return i;
            }
        }
        return -1; // if it didn't finx the key
    }


    
}
