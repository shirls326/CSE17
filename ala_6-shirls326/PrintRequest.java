/***
 * @author Shirley Angos
 * @version 0.1
 * Date of creation: March 12 2023
 * Date last modified: March 20 2023
 * Class to model entity PrintRequest
 */



public class PrintRequest implements Comparable<PrintRequest> {

    //data members
    private int id;
    private String group;
    private long size;



    /***
     * Default constructor
     */
    public PrintRequest(){
        id = 0;
        group = "batch";
        size = 0;



    }

    /***
     * 3 arg constructor
     * @param id
     * @param group
     * @param size
     */
    public PrintRequest(int id, String group, long size){
        this.id = id;
        this.group = group;
        this.size = size;


    }

    /***
     * Getter
     * @return id
     */
    public int getId() {
        return id;
    }

    /***
     * Getter
     * @return group
     */
    public String getGroup() {
        return group;
    }

    /***
     * Getter
     * @return size
     */
    public long getSize() {
        return size;
    }

    /***
     * Setter
     * @param group
     */

    public void setGroup(String group) {
        this.group = group;
    }

    /***
     * Setter
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /***
     * Setter
     * @param size
     */
    public void setSize(long size) {
        this.size = size;
    }


    /***
     * toString
     * @return String
     */

    @Override
    public String toString() {

        long temp = size;
        String out = "";


        if(size > 1000000000){
    
            temp = temp / 1000000000;
            out = temp + "GB";



        } else if (size > 1000000){

            

            temp = temp /1000000;
            out = temp + "MB";


        } else if (size > 1000){

          

            temp = temp / 1000;
            out = temp + "KB";


        } else {

            out = size + "Bytes";


        }

        return String.format("%-10d\t%-10s\t%-10s", id, group, out);
    }


    /***
     * getPriority Method
     * @return int
     */
    private int getPriority(){

      


        String[] priorities = {"root","admin","user","batch"};
        
        for (int i = 0; i < priorities.length; i++) {

            if(this.group.equals(priorities[i])){
                return i;
            }
            
        }

        return -1;


    }

    /***
     * Compare to
     * @param pr
     * @return int
     */
    @Override
    public int compareTo(PrintRequest pr) {
        return this.getPriority() - pr.getPriority();
    }

}
