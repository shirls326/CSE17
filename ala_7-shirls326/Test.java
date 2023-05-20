/***
 * @author Shirley Angos
 * @version 0.1
 *          Date of creation: March 28 2023
 *          Last Date modified: March 28 2023
 *          Purpose of class is to model eneity StringComparator
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Test {


    /***
     * Maain class
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<String> animalAL = new ArrayList<>();
        Stack<String> animalStack  = new Stack<>();
        PriorityQueue<String> animalPQ =  new PriorityQueue<>();
        readAnimals("animals.txt",animalAL,animalStack,animalPQ);
        // Testing contains()
        int alTotal = 0, sTotal = 0, pqTotal = 0;

        for (int i = 0; i <  20; i++) {
            int randomIndex = (int)(Math.random() * animalAL.size());
            String randomAnimal = animalAL.get(randomIndex);
            animalAL.contains(randomAnimal);
            int alIter = ArrayList.containsIter;
            alTotal += alIter;
            animalStack.contains(randomAnimal);
            int stackIter = ArrayList.containsIter;
            sTotal += stackIter;
            animalPQ.contains(randomAnimal);
            int pqIter = ArrayList.containsIter;
            pqTotal += pqIter;
            System.out.printf("%-30s\t%-10d\t%-10d\t%-10d\n", randomAnimal, alIter, stackIter, pqIter);

            
        }

        System.out.printf("%-30s\t%-10d\t%-10d\t%-10d\n", "Average", alTotal/20, sTotal/20, pqTotal/20);

        //testing sort

        System.out.println("\nArrayList: "+ animalAL);
        System.out.println();
        System.out.println(animalStack);
        System.out.println();
        System.out.println(animalPQ);

        System.out.println("\nSort by compareTo:");
        animalAL.sort();
        int alSortN = ArrayList.sortIter;
        animalStack.sort();
        int stackSortN = ArrayList.sortIter;
        animalPQ.sort();
        int pqSortN = ArrayList.sortIter;

        System.out.println("\n\nArrayList: "+ animalAL);
        System.out.println();
        System.out.println(animalStack);
        System.out.println();
        System.out.println(animalPQ);



        System.out.println("\nSort by Comparator:");
        StringComparator sc = new StringComparator();
        animalAL.sort(sc);
        int alSortC = ArrayList.comparatorSortIter;
        animalStack.sort(sc);
        int stackSortC = ArrayList.comparatorSortIter;
        animalPQ.sort(sc);
        int pqSortC = ArrayList.comparatorSortIter;

        System.out.println("\n\nArrayList: "+ animalAL);
        System.out.println();
        System.out.println(animalStack);
        System.out.println();
        System.out.println(animalPQ);

        System.out.printf("%-20s\t%-10d\t%-10d\t%-10d\n", "sort()", alSortN, stackSortN, pqSortN);
        System.out.printf("%-20s\t%-10d\t%-10d\t%-10d\n", "sort(Comparator)", alSortC, stackSortC, pqSortC);







        
    }

    /***
     * Reading inanimals method
     * @param filename
     * @param al
     * @param s
     * @param pq
     */
    public static void readAnimals(String filename, ArrayList<String> al, Stack<String> s, PriorityQueue<String> pq){

        File file = new File(filename);

        try{
            Scanner f = new Scanner(file); 
            while(f.hasNextLine()){
                String animal = f.nextLine();
                al.add(animal);
                s.push(animal);
                pq.offer(animal);
            }
            f.close();
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }



    }


    
}
