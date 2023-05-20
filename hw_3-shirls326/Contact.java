/***
 * @author Shirley Angos
 * @version 0.1
 * Date of creation: March 15 2023
 * Last Date Modified: March 15 2023
 * Class to model ComparatorByEmail
 */

public class Contact implements Comparable<Contact> {
    private String name;
    private String phone;
    private String email;

    /***
     * 3 arg constructor
     * @param name
     * @param phone
     * @param email
     */
    public Contact(String name, String phone, String email){
        this.name = name;
        this.phone = phone;
        this.email = email;
    }


    /***
     * getter method
     * @return name
     */
    public String getName() {
        return name;
    }
    /***
     * getter method
     * @return phone
     */
    public String getPhone() {
        return phone;
    }
    /***
     * getter method
     * @return email
     */
    public String getEmail() {
        return email;
    }
    /***
     * Setter method
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /***
     * Setter method
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    /***
     * Setter method
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /***
     * toString
     * @return String
     */
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("%-20s\t%-20s\t%-10s", name,phone,email);
    }
    /***
     * tostring 
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Contact){

            Contact c = (Contact)obj;
            return (getName().equals(c.getName())) && (getPhone().equals(c.getPhone())) && (getEmail().equals(c.getEmail())); // has to check everything to make sure everything is equal

        }
        return false;
    }

    /***
     * compareTo method
     * @param o
     * @return int
     */
    @Override
    public int compareTo(Contact o) {
        
        return this.getName().compareTo( o.getName());
    
    }
    
    
}
