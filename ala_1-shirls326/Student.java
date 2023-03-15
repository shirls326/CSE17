/***
 * Class to model the entity Student that extends Person
 * @author Shirley Angos
 * @version 0.1
 * Date of creation: January 23, 2023
 * Last date Modified: January 28,2023
 */


public class Student extends Person{



    // Data members
    private int id;
    private String major;

    /***
     * Default constructor
     * No Parameters
     * Initializes id, major
     */
    public Student(){
        super();
        id = 0;
        major = null;
    }

    /***
     * Constructor with six parameters
     * @param name
     * @param address
     * @param phone
     * @param email
     * @param id
     * @param major
     */

    public Student(String name, String address, String phone, String email, int id, String major){
        super(name, address, phone, email);
        this.id = id;
        this.major = major;

    }

    
    /***
     * @param no param
     * @return the value of the data member id
     */
    public int getId() {
        return id;
    }


    /***
     * Getter for the major of a student
     * @param no param
     * no return value
     */
    public String getMajor() {
        return major;
    }

    /***
     * Setter for the id of the student
     * @param id
     * no return value
     */
    public void setId(int id) {
        this.id = id;
    }

    /***
     * Setter for the major of the student
     * @param major
     * no return value
     */
    public void setMajor(String major) {
        this.major = major;
    }
    

    
    @Override
    /***
     * Method to get the Student information
     * no param
     * @return formatted String containing the value of the data members
     */
    public String toString() {
        // TODO Auto-generated method stub
        return String.format(super.toString()+ "ID: %d\nMajor: %s\n",id,major);
    }







}