/***
 * @author Shirley Angos
 * @version 0.1
 * Date of creation: March 12 2023
 * Date last modified: March 20 2023
 * Class to test a Stack with postfixexpressions and printrequest
 */


import java.util.Stack;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.io.File;
import java.io.FileNotFoundException;


public class Test{



    public static void main(String[] args) {

        
        // part 1
        boolean loopNeeded = true;
        Scanner in = new Scanner(System.in);
        
        while(loopNeeded){
            Stack<Integer> postFixStack = new Stack<>();

            System.out.println("Enter a postfix Expression");
            String expression = in.nextLine();
            String [] tokens = expression.split(" ");
    
            for (int i = 0; i < tokens.length; i++) {
                
                // testing for operator
                if(tokens[i].matches("\\d+") ){ // if it matches d is an integer
                    int num = Integer.parseInt(tokens[i]);
                    postFixStack.push(num); // addding it to the stack, pushing it into the stack
    
                } else{
                    try{
                        int num1 = postFixStack.pop();
                        int num2 = postFixStack.pop();
                        switch(tokens[i]){
    
                            case "+": postFixStack.push(num2 + num1); break; // num 2 MUST be first
    
                            case "-": postFixStack.push(num2 - num1); break;
    
                            case "/": postFixStack.push(num2 / num1); break;
    
                            case "*": postFixStack.push(num2 * num1); break;
    
                            default: 
                                System.out.println("Malformed Expression");
                                i = tokens.length;
                                break;
    
                        }
    
                    }catch(EmptyStackException e){
                        System.out.println("Malformed expression");
    
                    }
                }
                
            }
            try{
                int result = postFixStack.pop();
    
                if(postFixStack.isEmpty()){ // is empty can pretty much be used anywhere to check if there is any elements in  it
                    System.out.println("Result = "+ result);
    
    
                }else{
                    System.out.println("Malformed Expression");
                }
    
    
            }catch(EmptyStackException e){
                System.out.println("Malformed Expression");
    
            }

            System.out.println("Do you want to evulaute another post fix expression?");

            String choice = in.nextLine();
    
            switch(choice){
    
                case "no":
                    System.out.println("Goodbye");
                    loopNeeded = false;
                    break;
            }


        } // end of part 1


        // part 2

        // natural ordering
        PriorityQueue<PrintRequest> pQueue = new PriorityQueue<>(); // second constructor takes comparator object
        readRequest(pQueue,"requests.txt");

        long printSpeed = 10000;
        //processing the request
        while(!pQueue.isEmpty()){
            PrintRequest pr = pQueue.poll();
            long time = pr.getSize()/printSpeed; // time to print the request pr

            System.out.println(pr + formatTime(time));
        }

        
    }

    public static String formatTime(long time){

        return "00:00:00:00";

    }


     //part 2

     public static void readRequest(PriorityQueue<PrintRequest>p,String filename){
        File file = new File(filename);
        try{
            Scanner read = new Scanner(file);
            while(read.hasNext()){
                int id = read.nextInt();
                String group = read.next();
                long size = read.nextLong();
                PrintRequest pr = new PrintRequest(id, group, size);
                p.offer(pr);
            }
            read.close();
            
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }

            
     }

     
}