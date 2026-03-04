package domain.entities;

import java.time.LocalDateTime;

public class Note {
    //Atributes
    private int id;
    private String title;
    private String description;
    private LocalDateTime date;

    //Constructor
    public Note(String title, String description){
        this.title = title;
        this.description = description;
        date = LocalDateTime.now();
    }

    //Getters & Setters
    public int  getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString(){
        return "ID: " + id + " Title: " + title +
                "\nDescription: " + description + "\nDate: " + date;
    }


}
