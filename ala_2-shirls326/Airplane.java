/***
 * @author Shirley Angos
 * @version 0.1
 * Date of Creation:
 * Last Modified:
 * Class to represent the entity Airplane
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;


public class Airplane {
    private char[][] seatMap;

    /***
     * 0 arg constructor
     * return void
     */
    public Airplane() {
        seatMap = new char[9][8];
        for (int i = 0; i < seatMap.length; i++) {
            for (int j = 0; j < seatMap[i].length; j++) {
                seatMap[i][j] = '.';
            }
        }

    }

    /***
     * 1 arg constructor
     * @param filename
     * @return void
     */
    public Airplane(String filename) {
        seatMap = new char[9][8];
        readMap(filename);

    }

    /***
     * Method to read the file fileName
     * @param filename
     * return void
     */

    private void readMap(String filename) {
        
        File f = new File(filename);

        try {
            Scanner fScan = new Scanner(f);
            for (int i = 0; i < seatMap.length; i++) {
                for (int j = 0; j < seatMap[i].length; j++) {
                    seatMap[i][j] = fScan.next().charAt(0);
                }
            }

            fScan.close(); // MUST CLOSE OR ELSE NOTHING IS SAVED

        } catch (FileNotFoundException fnf) {
            System.out.println(fnf.getMessage());
            for (int i = 0; i < seatMap.length; i++) {
                for (int j = 0; j < seatMap[i].length; j++) {
                    seatMap[i][j] = '.';
                }
            }

        }

    }

    /***
     * method to check seatNumber
     * @param seatNum
     * @return true or false
     * @throws InvalidSeatException
     */

    private boolean checkSeatNumber(String seatNum) throws InvalidSeatException { // should have throw and a regular
                                                                                  // exception

        if (seatNum.matches("[1-9][A-H]")) {
            return true;
        } else {
            throw new InvalidSeatException();
        }

    }

    /***
     * Method to reserve a seat
     * @param seatNum
     * @return boolean true or false
     * @throws InvalidSeatException
     */

    public boolean reserveSeat(String seatNum) throws InvalidSeatException { // does not create new exception

        checkSeatNumber(seatNum); // returns true or breaks
        // 6F --- > row = 5, col = 5
        // '6' - '1' = '5'
        // 'F' - 'A'

        char row = seatNum.charAt(0);
        char col = seatNum.charAt(1);

        int r = row - '1';
        int c = col - 'A';

        if (seatMap[r][c] == '.') {
            seatMap[r][c] = 'X';
            return true;
        } else {
            throw new InvalidSeatException("ERROR: Seat already taken!"); // question
        }

    }

    /***
     * Method to free a seat
     * @param seatNum
     * @return boolean value true or false
     * @throws InvalidSeatException
     */

    public boolean freeSeat(String seatNum) throws InvalidSeatException {

        // literally the same thing as the previous method
        checkSeatNumber(seatNum);
        char row = seatNum.charAt(0);
        char col = seatNum.charAt(1);
        int r = row - '1';
        int c = col - 'A';

        if (seatMap[r][c] == 'X') {
            seatMap[r][c] = '.';
            return true;
        } else {
            throw new InvalidSeatException("ERROR: Seat is already free!"); // question
        }

    }

    /***
     * Method to save the seat map
     * @param filename
     * return void
     */

    public void saveMap(String filename) {

        try {
            File f = new File(filename);
            PrintWriter p = new PrintWriter(f);

            for (char[] row : seatMap) {
                for (char c : row) {
                    p.print(c + " ");
                }
                p.println();
            }

            p.close();

        } catch (FileNotFoundException e) { // catch statement if it couldn't find the ifle

            System.out.println("ERROR: File not found");

        }

    }

    
    @Override
    /***
     * Method toString
     * @param none
     * @return void
     */
    public String toString() {

        String out = "\tA\tB\tC\tD\tE\tF\tG\tH\n";

        for (int i = 0; i < seatMap.length; i++) {

            out += (i + 1) + "\t";
            for (int j = 0; j < seatMap[i].length; j++) {
                out += seatMap[i][j] + "\t";

            }
            out += "\n";

        }

        return out;

    }

}