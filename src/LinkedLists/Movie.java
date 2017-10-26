package LinkedLists;

import java.util.Date;

public class Movie {
    private int date;
    private String title;
    private LinkedList actors;
    private LinkedList directors;

    public Movie(){
        date = 0;
        title = null;
        actors = null;
        directors = null;
    }

    public Movie(int date, String title, LinkedList actors, LinkedList directors){
        this.actors = actors;
        this.directors = directors;
        this.date = date;
        this.title = title;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LinkedList getActors() {
        return actors;
    }

    public void setActors(LinkedList actors) {
        this.actors = actors;
    }

    public LinkedList getDirectors() {
        return directors;
    }

    public void setDirectors(LinkedList directors) {
        this.directors = directors;
    }
    public String toString(){
        return title + "! \nStaring: "+actors+"\nDirected by: "+directors+"\nReleased on: "+date+"\n";
    }
}
