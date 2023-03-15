

public class Note implements Comparable<Note>{
    private Date date;
    private String title;
    private String description;

    public Note(Date date, String title, String description){
        
        this.date = date; // come back to 
        this.title = title;
        this.description = description;

    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }
    
    public String getTitle() {
        return title;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }

    @Override
    public int compareTo(Note o) {
        // TODO Auto-generated method stub
        return 0;
    }

    

    
}
