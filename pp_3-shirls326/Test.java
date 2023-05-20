import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {

        
        TreeMap<String,String> tm = new TreeMap<>(new StringComparator());
        HashMapLP<String,String> lp = new HashMapLP<>(100000);
        HashMapSC<String,String> sc = new HashMapSC<>(100000);
        readFile("emails.txt", tm,lp,sc);

        // counting iterations

        /***
         * I got the results from the get method by adding in a static variable
         * called iterations in all 3 data structures and counted the iterations anytime the get method
         * was called so I was able to call on that variable later to get the number of iterations
         * so I would be able to also collect the average
         * (Same thing as ALA10)
         */
        System.out.println("Testing Get\n");
        int totalLP = 0, totalSC = 0, totalTM = 0, count = 0;

        System.out.printf("%-20s\t%-15s\t%-15s\t%-15s\n", "Username","TreeMap", "Hashmap LP","HashMap SC");

        try(Scanner scan = new Scanner(new File("mailingList.txt"))){
            while(scan.hasNextLine()){
                String[] parts = scan.nextLine().split(" ");
                String email = parts[0];

                tm.get(email);
                lp.get(email);
                sc.get(email);



                if(count++ % 5 == 0){
                    System.out.printf("%-20s\t%-15d\t%-15d\t%-15d\n", email,TreeMap.iterations, HashMapLP.iterations,HashMapSC.iterations);
                }

                totalTM += TreeMap.iterations;
                totalLP += HashMapLP.iterations;
                totalSC += HashMapSC.iterations;


            }

            



        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());


        }

        System.out.printf("%-20s\t%-15d\t%-15d\t%-15d\n", "Average",totalTM/100, totalLP/100,totalSC/100);


        //Testing sort
        System.out.println("Testing sort() \n");

        tm.sortedKeys();
        sc.sortedKeys(new StringComparator());
        lp.sortedKeys(new StringComparator());
        System.out.printf("%-20s\t%-15d\n","TreeMap",TreeMap.iterations);
        System.out.printf("%-20s\t%-15d\n","HashMapSC",HashMapSC.iterations);
        System.out.printf("%-20s\t%-15d\n","HashMapLP",HashMapLP.iterations);


        /***
         * Treemap is more efficient sorting
         * less iterations
         * SC second best
         * LP is lowkey the worse but itsok
         */

        System.out.println("Testing put() \n");

        
        System.out.printf("%-20s\t%-15s\t%-15s\n","Size","HashMapSC", "HashMapLP");
        
        for (int i = 50000; i <= 500000; i+=50000) {
            HashMapSC.collisions = 0;
            HashMapLP.collisions = 0;
            HashMapSC<String, String> scTest = new HashMapSC<>(i);
            HashMapLP<String,String> lpTest = new HashMapLP<>(i);

            readFile("emails.txt", tm, lpTest, scTest);

            System.out.printf("%-20d\t%-15d\t%-15d\n", i, HashMapSC.collisions, HashMapLP.collisions);

            scTest.clear();
            lpTest.clear();

            
        }

        /***
         * For both, as the capacity increases, the number of collisions goes down
         * SC appears to be more efficient with bring the collisions down while LP is slightly higher
         */






        
    }


    public static void readFile(String filename, TreeMap<String,String> treeMap, HashMapLP<String,String> lp, HashMapSC<String,String> sc){


        try (Scanner scan = new Scanner(new File(filename))) {
            while(scan.hasNextLine()){
                String[] parts = scan.nextLine().split(" ");
                treeMap.add(parts[0], parts[1]);
                lp.put(parts[0], parts[1]);
                sc.put(parts[0], parts[1]);
            }


        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }


    }

  
    
}
