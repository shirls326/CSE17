import java.util.Comparator;

public class ComparatorByTitle implements Comparator<Note>{

    public int compare(Note note1, Note note2){
       return note1.getTitle().compareTo(note2.getTitle());

    }
    
    
}
