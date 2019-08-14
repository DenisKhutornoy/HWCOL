package com.company.filmClasses;

import com.company.participants.Actor;
import com.company.participants.Director;

import java.util.ArrayList;

public class Film {
    private String title;
    private  String country;
    private int year;
    private Director director;
    private ArrayList<Actor> actors;


    public Film(String title, String country, int year, Director director, ArrayList<Actor> actors) {
        this.title = title;
        this.country = country;
        this.year = year;
        this.director = director;
        this.actors = actors;
    }



    public String toString() {

        return "Фильм "+title + " " + year + " года "+country+ " режисер: " +director.toString()+ "В фильме снимались : "+ actors.toString();
    }
}
