/***
 * @author Shirley Angos
 * @version 0.1
 * Date of creation: April 2 2023
 * Last Date Modified: April 2 2023
 * Class to model the entity flight
 */

public class Time implements Comparable<Time> {
    private int hours;
    private int minutes;

    /***
     * default constructor
     */
    public Time() {
        hours = minutes = 0;
    }

    /***
     * 1 arg constructor
     * @param time
     * @throws InvalidDateTimeException
     */
    public Time(String time) throws InvalidDateTimeException {
        String[] items = time.split(":");
        try {
            int h = Integer.parseInt(items[0]);
            int m = Integer.parseInt(items[1]);
            if (h < 0 || h > 23)
                throw new InvalidDateTimeException("Invalid hours. Hours should be from 0 to 23.");
            if (m < 0 || m > 59)
                throw new InvalidDateTimeException("Invalid minutes. Minutes should be from 0 to 59.");
            hours = h;
            minutes = m;
        } catch (NumberFormatException e) {
            System.out.println("Error: hours or minutes are not numbers.");
        }
    }

    /***
     * getter
     * @return hours
     */
    public int getHours() {
        return hours;
    }

    /***
     * getter
     * @return minutes
     */
    public int getMinutes() {
        return minutes;
    }


    /***
     * setter
     * @param h
     * @throws InvalidDateTimeException
     */
    public void setHours(int h) throws InvalidDateTimeException {
        if (h < 0 || h > 23)
            throw new InvalidDateTimeException("Invalid hours. Hours should be from 0 to 23.");
        hours = h;
    }

    /***
     * setter
     * @param m
     * @throws InvalidDateTimeException
     */

    public void setMinutes(int m) throws InvalidDateTimeException {
        if (m < 0 || m > 59)
            throw new InvalidDateTimeException("Invalid minutes. Minutes should be from 0 to 59.");
        minutes = m;
    }

    /***
     * toString
     */
    public String toString() {
        return String.format("%02d:%02d", hours, minutes);
    }

    /***
     * compareTo
     * @param time
     * @return time
     */
    public int compareTo(Time time) {
        if (this.getHours() == time.getHours()) {
            return this.getMinutes() - time.getMinutes();
        }
        return this.getHours() - time.getHours();
    }

    /***
     * equals method
     * @param obj
     * @return boolean
     */
    public boolean equals(Object obj) {
        if (obj instanceof Time) {
            Time time = (Time) obj;
            return this.hours == time.hours &&
                    this.minutes == time.minutes;
        }
        return false;
    }

    /***
     * tick method
     */
    public void tick() {
        minutes++;
        if (minutes == 60) {
            minutes = 0;
            hours++;
        }
        if (hours == 24) {
            hours = 0;
        }
    }

    /***
     * diff method
     * @param t
     * @return int
     */
    public int diff(Time t) {
        return (this.hours * 60 + this.minutes) - (t.hours * 60 + t.minutes);
    }

}
