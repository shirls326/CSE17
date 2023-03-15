/***
 * Class to model the entity Employee that extends Person
 * @author Shrley Angos
 * @version 0.1
 * Date of Creation: January 24 2023
 * Last Date Modified: January 28 2023
 */


public class Employee extends Person {

    //data members
    private int id;
    private String position;
    private double salary;


    /***
     * Default Constructor
     * no param
     * Initializes id, position, salary to null/0
     */
    public Employee(){
        super();
        id = 0;
        position = null;
        salary = 0;

    }


    /***
     * Constructor with 7 parameters
     * @param name
     * @param address
     * @param phone
     * @param email
     * @param id
     * @param position
     * @param salary
     */
    public Employee(String name, String address, String phone, String email,int id, String position, double salary){

        super(name, address, phone, email);
        this.id = id;
        this.position = position;
        this.salary = salary;

    }


    /***
     * Getter method for the id of the employee
     * no param
     * @return the value of the data member id
     */
    public int getId() {
        return id;
    }

    /***
     * Getter method for the position of the employee
     * no param
     * @return the valye of the data member position
     */
    public String getPosition() {
        return position;
    }


    /***
     * Getter method for the salary of the employee
     * no param
     * @return the value of the data member salary
     */
    public double getSalary() {
        return salary;
    }

    /***
     * Setter method for the id of the employee
     * @param id
     * no return value
     */
    public void setId(int id) {
        this.id = id;
    }


    /***
     * Setter method for the position of the employee
     * @param position
     * no return value
     */
    public void setPosition(String position) {
        this.position = position;
    }


    /***
     * Setter method for the salary of the employee
     * @param salary
     * no return value
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }


    @Override
    /***
	 * Method to get the Employee information
	 * no parameters
	 * @return formatted string containing the value of the data members
	 */
    public String toString() {
        return String.format(super.toString()+ "ID: %d\nPosition: %s\nSalary: %.2f\n",id,position,salary);
    }
    
}
