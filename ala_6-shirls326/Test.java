import java.util.Stack;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.PriorityQueue;


public class Test{



    public static void main(String[] args) {

        Stack<Integer> postFixStack = new Stack<>();
        Scanner in = new Scanner(System.in);

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


       

        
    }


     //part 2

     public static void readRequest(PriorityQueue<PrintRequest>p,String filename){

            
     }

     
}