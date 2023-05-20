/***
 * @author Shirley Angos
 * @version 0.1
 * Date of creation: April 20 2023
 * Last Date modified: April 24 2023
 * Class to model entity Country
 */

import java.util.ListIterator;

public class Country {
    //data types
    private String name;
    private ArrayList<Pair<Integer,Double>> carbonEmissions;
    private ArrayList<Pair<Integer,Double>> carbonCapita;


    // The constructor sets the name of the country and creates 
    //empty instances of the ArrayList class for carbonEmission and carbonCapita.
    /***
     * 1 arg constructor
     * @param name
     */
    public Country(String name){
        this.name = name;
        carbonEmissions = new ArrayList<Pair<Integer,Double>>();
        carbonCapita = new ArrayList<Pair<Integer,Double>>();

    }

    /***
     * Getter 
     * @return name
     */
    public String getName() {
        return name;
    }

    /***
     * Setter
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /***
     * Adding pair to carbonEmissions
     * @param year
     * @param tons
     */
    public void addCarbonEmission(int year, double tons){
        Pair<Integer,Double> p = new Pair<>(year,tons);
        carbonEmissions.add(p);
    }



    /***
     * Adding pair to carbonCapita
     * @param year
     * @param tons
     */
    public void addCarbonCapita(int year, double tons){
        Pair<Integer,Double> p = new Pair<>(year,tons);
        carbonCapita.add(p);

    }

    // returns an iterator pointing to the country's carbon emissions in ton at the given year
    /***
     * method to getEmissions
     * @param year
     * @return iter pointing to the country's carbon emissions in tons at the given year
     */
    public ListIterator<Pair<Integer,Double>> getEmission(int year){
        ListIterator<Pair<Integer,Double>> it = carbonEmissions.listIterator();
        int i = 0;
        while(it.hasNext()){
            if(it.next().getFirst() == year){
                return carbonEmissions.listIterator(i);
            }
            i++;
        }


        return null;


    }
    // returns an interator pointing to the country's carbon emissions per capita at the given year
    /***
     * method to iterator pointing getCapita
     * @param year
     * @return
     */
    public ListIterator<Pair<Integer,Double>> getCapita(int year){

        for (int i = 0; i < carbonCapita.size(); i++) {
            if(carbonCapita.get(i).getFirst().equals(year)){
                return carbonCapita.listIterator(i);
            }
        }

        return null;


    }


    /***
     * toString
     * @return toString
     */
    @Override
    public String toString() {
        return String.format("%-10s\t%-10s\t%-10s\n",name,carbonEmissions,carbonCapita);
    }

    /***
     * Equals
     * @return if the country's are the same
     */
    @Override
    public boolean equals(Object obj) {

        if(obj instanceof Country){
            Country c = (Country)obj;
            return this.name.equals(c.getName());

        }
       
        return false;
    }

    






    
}
