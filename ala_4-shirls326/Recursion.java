import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;




public class Recursion{


    public static void main(String[] args) {

        // /Users/shirleyangos/Documents/GitHub example file directory

        Scanner in = new Scanner(System.in);
        System.out.println("Enter a file path:");
        String path = in.nextLine();
        long size = getSize(path);

        double formatSize = 0;
        String unit = " bytes";

        if(size > 1000000000){
            unit = " Gbytes";

            formatSize = size / (double) 1000000000;



        } else if (size > 1000000){

            unit = " Mbytes";

            formatSize = size / (double) 1000000;


        } else if (size > 1000){

            unit = " Kbytes";

            formatSize = size / (double) 1000;


        } else {

            formatSize = size;


        }

        System.out.println("Size of "+ path +": "+ formatSize+unit);


        System.out.println("Enter a path: ");
        
        path = in.nextLine();

        System.out.println("Enter a word to search for:");

        String word = in.nextLine();

        findWord(path, unit);






        
    }

    // public static String findFile(String folder, String filename){






    // }

    public static void findWord(String folder, String word){

        File file = new File(folder);

        if(file.exists()){
            if(file.isDirectory()){

                File [] files = file.listFiles();
                if (files != null){
                    for (int i = 0; i < files.length; i++) {
                        findWord(files[i].getAbsolutePath(),word);
                        
                    }
                }


            }else if(file.isFile()){
                // where we need to open the file and to read EVERYTHING in and find # of occ in word

                int counter = countWord(file, word);

                if(counter != 0){
                    System.out.println(word + " appears "+ counter + " times in the file "+ file.getAbsolutePath());
                }

            }


        }else{
            System.out.println("Invalid Directory!");
        }

    }

    public static int countWord(File file, String word){

        int count = 0;

        try{
            Scanner scan = new Scanner(file);

            while(scan.hasNextLine()){

                String line = scan.nextLine();
                int index = line.indexOf(word,0);

                while(index != -1){
                    count++;
                    index = line.indexOf(word,index + 1);

                }
            }

            scan.close(); 

        }catch(FileNotFoundException fnf){

            System.out.println(fnf.getMessage());
            return 0;
        }

        return count;


    }



    public static long getSize(String folder){

        File file = new File(folder);
        long size = 0;

        if(file.isDirectory()){
            // find the size of everything in the folder
            File [] files = file.listFiles(); // list out all the files in the directory
            if(files != null){
                
                for (int i = 0; i < files.length; i++) {

                   if(files[i].isFile()){

                    size += files[i].length();

                   }
                   if(files[i].isDirectory()){

                    size += getSize(files[i].getAbsolutePath());
                   }
                    
                }
            }

        }else if(file.isFile()){

            //find the size of the file directly
            size = file.length(); // retutns the size 

        }
        return size; 


    }











}