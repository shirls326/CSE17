/***
 * Class to model the entity Faculty that extends Employee
 * @author Shirley Angos
 * @version 0.1
 * Date of creation: January 23, 2023
 * Last date Modified: January 28,2023
 */

public class Faculty extends Employee{

    // Data members
    private String rank;


    /***
     * Default constructor
     * no parameters
     * Initializes rank to null
     */

    public Faculty(){
        super();
        rank = null;

    }

    /***
     * Constructor with 8 parameters
     * @param name
     * @param address
     * @param phone
     * @param email
     * @param id
     * @param position
     * @param salary
     * @param rank
     */
    public Faculty(String name, String address, String phone, String email, int id, String position, double salary, String rank){

        super(name, address, phone, email, id, position, salary);
        this.rank = rank;

    }

    /***
     * Getter method for rank
     * no param
     * @return the value of the data member rank
     */
    public String getRank() {
        return rank;
    }
    /***
     * Setter method for the rank of a faculty
     * @param rank
     * no return valye
     */
    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    /***
	 * Method to get the Faculty information
	 * no parameters
	 * @return formatted string containing the value of the data members
	 */
    public String toString() {
    
        return String.format(super.toString()+ "Rank: %s\n",rank);
    }


}