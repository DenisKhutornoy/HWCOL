package com.company.libraryFiles;

import com.company.filmClasses.Film;
import com.company.participants.Actor;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class LibraryOperations {

    DBworker dBworker = new DBworker();


    public void showNewFilms()  {
        Calendar now = new GregorianCalendar();
        int year = now.get(Calendar.YEAR);
        int prevYear = year - 1;
        String serchParam = "WHERE  date >=" + prevYear;

        ArrayList<Film> films = dBworker.findFilms(serchParam);
        showResults(films);
    }

    public void showFilmInformation()  {
        String title = "\"Мы били солдатами\"";
        String serchParam = "WHERE  title = '" + title+"'";
        ArrayList<Film> films = dBworker.findFilms(serchParam);
        showResults(films);
    }
    public void showActorsWithManyRoles()  {
        int countOfRoles = 1;
        String comand = "SELECT acterID, COUNT(filmID) FROM film_library.actorsinfilm GROUP BY acterID HAVING COUNT(filmID) > "+countOfRoles;
        ArrayList<Actor> actors =dBworker.findActorsWhithManyRoles(comand);
        System.out.println(" Актеры сыгравшие более "+countOfRoles+" ролей:");
        System.out.println(actors.toString());

    }

    public void actorsAsDirectors()  {
        String comand = "SELECT * FROM film_library.actors where name  IN(SELECT name FROM film_library.directors);";
        ArrayList<Actor> actors =dBworker.findActorsWhithManyRoles(comand);
        System.out.println(" Актеры, бывшие режесерами:");
        System.out.println(actors.toString());
    }


    public void showResults(ArrayList<Film> films) {
        for (Film film : films) {
            System.out.println(film.toString());
        }
    }

    public void deleteOldFilms(int age) {
        Calendar now = new GregorianCalendar();
        int year = now.get(Calendar.YEAR);
        int yaerToDelete = year - age;
        String serchParam = "WHERE  date <=" + yaerToDelete;
        dBworker.deleteFilmsByAge(serchParam);
        System.out.println("Фильми старше "+ age +" лет удалены");
    }
}

