package libraryFiles;


import filmClasses.Film;
import participants.Actor;
import participants.Director;


import java.sql.*;
import java.util.ArrayList;

public class DBworker {
    String url = "jdbc:mysql://localhost:3306/film_library?useSSL=false";
    String user = "root";
    String pass = "123456789";


    private Connection createConection() {
        Connection mycon = null;
        try {
            mycon = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mycon;
    }

    private void closeConection(Connection mycon, Statement state) {

        try {
            state.close();
            mycon.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<Film> findFilms(String serchparam) {
        ArrayList<Film> films = new ArrayList<>();
        try {
            Connection mycon = createConection();
            Statement state = mycon.createStatement();

            String comand = "SELECT * FROM film_library.films " + serchparam;
            ResultSet rs = state.executeQuery(comand);
            while (rs.next()) {
                String title = rs.getString("title");
                String country = rs.getString("country");
                int year = rs.getInt("date");
                int filmIndex = rs.getInt("id");
                ArrayList<Actor> actors = makeActorsList(filmIndex);
                int directorId = rs.getInt("director");
                Director director = findDirector(directorId);
                Film film = new Film(title, country, year, director, actors);
                films.add(film);
            }

            closeConection(mycon, state);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return films;
    }


    private ArrayList<Actor> makeActorsList(int filmIndex) {
        ArrayList<Actor> actors = new ArrayList<>();
        try {
            Connection mycon = createConection();
            Statement state = mycon.createStatement();
            String comand = "SELECT * FROM film_library.actorsinfilm WHERE  filmID = " + filmIndex;
            ResultSet rs = state.executeQuery(comand);
            while (rs.next()) {
                int actorIndex = rs.getInt("acterID");
                Actor actor = findActor(actorIndex);
                actors.add(actor);
            }
            closeConection(mycon, state);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actors;
    }

    private Director findDirector(int directorId) {
        Director director = null;
        try {
            Connection mycon = createConection();
            Statement state = mycon.createStatement();
            String comand = "SELECT * FROM film_library.directors WHERE  id = " + directorId;
            ResultSet rs = state.executeQuery(comand);
            while (rs.next()) {
                String name = rs.getString("name");
                int year = rs.getInt("year");
                director = new Director(name, year);
            }
            closeConection(mycon, state);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return director;
    }

    private Actor findActor(int actorId) {
        Actor actor = null;
        try {
            Connection mycon = createConection();
            Statement state = mycon.createStatement();
            String comand = "SELECT * FROM film_library.actors WHERE  id = " + actorId;
            ResultSet rs = state.executeQuery(comand);
            while (rs.next()) {
                String name = rs.getString("name");
                int year = rs.getInt("year");
                actor = new Actor(name, year);
            }
            closeConection(mycon, state);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actor;
    }

    public ArrayList<Actor> findActorsWhithManyRoles(String comand) {
        ArrayList<Actor> actors = new ArrayList<>();
        try {
            Connection mycon = createConection();
            Statement state = mycon.createStatement();

            ResultSet rs = state.executeQuery(comand);
            while (rs.next()) {
                int actorIndex = rs.getInt(1);
                Actor actor = findActor(actorIndex);
                actors.add(actor);
            }
            closeConection(mycon, state);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actors;

    }

    public void deleteFilmsByAge(String serchParam) {
        try {
            Connection mycon = createConection();
            Statement state = mycon.createStatement();
            String comand = "DELETE FROM film_library.films " + serchParam;
            state.execute(comand);
            closeConection(mycon, state);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


