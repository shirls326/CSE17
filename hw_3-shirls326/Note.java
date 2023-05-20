/***
 * @author Shirley Angos
 * @version 0.1
 * Date of creation: March 15 2023
 * Last Date Modified: March 15 2023
 * Class to model Note
 */

public class Note implements Comparable<Note>{
    private Date date;
    private String title;
    private String description;


    /***
     * 3 arg constructor
     * @param date
     * @param title
     * @param description
     */
    public Note(Date date, String title, String description){
        
        this.date = date; 
        this.title = title;
        this.description = description;

    }

    
    /***
     * getter method
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /***
     * getter method
     * @return description
     */
    public String getDescription() {
        return description;
    }
    
    /***
     * getter method
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /***
     * setter method
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }
    /***
     * Setter method
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /***
     * setter method
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /***
     * toString
     * @return string
     */
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("%-15s\t%-20s\t%-10s", date,title,description);
    }

    /***
     * equals
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Note){
            Note n = (Note)obj;
            return getTitle().equals((n).getTitle()) && getDate().equals(n.getDate()) && getDescription().equals(n.getDescription());
        }
        return false; // if it isn't a note, they arent even equal therefore return false
    }
    
    /***
     * compareTo
     * @param o
     * @return int
     */

    @Override
    public int compareTo(Note o) {
        // TODO Auto-generated method stub
        return this.getDate().compareTo(o.getDate());
    }

    

    
}
