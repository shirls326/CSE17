/***
 * @author Shirley Angos
 * @version 0.1
 * Date of creation: April 24 2023
 * Date last modified: April 24 2023
 * Test class to test BST and Heap dataStructures
 */

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {

    /***
     * main class
     * @param args
     */
    public static void main(String[] args) {
        BST<String> animalBST = new BST<>();
        Heap<String> animalHeap = new Heap<>();
        ArrayList<String> animalAL = new ArrayList<>();
        System.out.println("testing add()");

        readAnimals(animalBST, animalHeap, animalAL, "animals.txt");

        //test contains
        System.out.println("Testing Contains():");
        testContains(animalBST,animalHeap,animalAL);

        System.out.println("Testing Remove():");
        testRemove(animalBST,animalHeap,animalAL);

        //BST
        System.out.println("\nBST Height: "+ animalBST.height()); // number is small
        System.out.println("BST is balanced? "+ animalBST.isBalanced());

        //heap
        System.out.println("\nHeap Height: "+ animalHeap.height()); // always balanced
        System.out.println("Heap is balanced? "+ animalHeap.isBalanced());
        
        animalBST.clear();
        animalHeap.clear();
        java.util.Collections.sort(animalAL);
        for (String animal : animalAL) {
            animalBST.add(animal);
            animalHeap.add(animal);
            
        }

         //BST
        System.out.println("\nBST Height: "+ animalBST.height()); // looks like a linkedlist, therefore inefficient, the number is actually the amount of animals stored since the list is sorted
        System.out.println("BST is balanced? "+ animalBST.isBalanced());

        //heap
        System.out.println("\nHeap Height: "+ animalHeap.height()); // always balanced
        System.out.println("Heap is balanced? "+ animalHeap.isBalanced());
        
        
    }


    /***
     * method to readAnimals
     * @param bst
     * @param heap
     * @param al
     * @param filename
     */

    public static void readAnimals(BST<String> bst, Heap<String> heap, ArrayList<String> al, String filename){
        
        File file = new File(filename);
        int index = 0;
        int totalBST = 0, totalHeap = 0;
        try{
            Scanner read = new Scanner(file);
            System.out.printf("%-30s\t%-15s\t%-15s\n", "Animal Name", "BST(iterations)", "Heap(Iterations)");
            while(read.hasNextLine()){
                String animal = read.nextLine();
                totalBST += BST.iterations;
                totalHeap += Heap.iterations;
                bst.add(animal);
                heap.add(animal);
                al.add(animal);
                if(index % 24 == 0){
                    System.out.printf("%-30s\t%-15d\t%-15d\n", animal, BST.iterations, Heap.iterations);
                }
                index++;
            }
            System.out.printf("%-30s\t%-15d\t%-15d\n", "Average", totalBST/al.size(), totalHeap/al.size());
            read.close();
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    /***
     * testContains method
     * @param bst
     * @param heap
     * @param al
     */
    public static void testContains(BST<String> bst, Heap<String> heap, ArrayList<String> al){

        System.out.printf("%-30s\t%-15s\t%-15s\n", "Animal Name", "BST(iterations)", "Heap(Iterations)");
        int totalBST = 0, totalHeap = 0;
        
        for (int i = 0; i < 20; i++) {
            int randomIndex = (int)(Math.random() * al.size());
            String animal = al.get(randomIndex);
            bst.contains(animal);
            heap.contains(animal);
            totalBST += BST.iterations;
            totalHeap += Heap.iterations;
            System.out.printf("%-30s\t%-15d\t%-15d\n", animal, BST.iterations, Heap.iterations);
            
        }

        System.out.printf("%-30s\t%-15d\t%-15d\n", "Average", totalBST/20, totalHeap/20);


    }

    /***
     * testRemove
     * @param bst
     * @param heap
     * @param al
     */
    public static void testRemove(BST<String> bst, Heap<String> heap, ArrayList<String> al){

        System.out.printf("%-30s\t%-15s\t%-15s\n", "Animal Name", "BST(iterations)", "Heap(Iterations)");
        int totalBST = 0, totalHeap = 0;
        
        for (int i = 0; i < 20; i++) {
            int randomIndex = (int)(Math.random() * al.size());
            String animal = al.get(randomIndex);
            bst.remove(animal);
            heap.remove(); // no parameters needed, will just remove the root and then rearrange
            totalBST += BST.iterations;
            totalHeap += Heap.iterations;
            System.out.printf("%-30s\t%-15d\t%-15d\n", animal, BST.iterations, Heap.iterations);
            
        }

        System.out.printf("%-30s\t%-15d\t%-15d\n", "Average", totalBST/20, totalHeap/20);


        
    }


    
}
