import java.util.Comparator;

public class PrintRequest implements Comparable<PrintRequest> {

    private int id;
    private int group;
    private double size;


    public PrintRequest(int id, int group, double size){
        this.id = id;
        this.group = group;
        this.size = size;


    }

    public int getId() {
        return id;
    }

    public int getGroup() {
        return group;
    }

    public double getSize() {
        return size;
    }

    @Override
    public String toString() {
        String unit = " ";
        double temp = size;

        if(size > 1000000000){
            unit = "GB";
            temp = size /1000000000;
        }

        return ""; // come back to it
    }

    @Override
    public int compareTo(PrintRequest pr) {
        if(group == pr.group){
            return 0;

        } else if(group > pr.group){
            return 1;

        } else return -1;
    }









    
}
