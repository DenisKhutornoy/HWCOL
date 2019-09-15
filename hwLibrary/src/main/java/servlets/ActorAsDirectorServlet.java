package servlets;



import libraryFiles.LibraryOperations;
import participants.Actor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ActorAsDirector")
public class ActorAsDirectorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("jsp/ActorAsDirector.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LibraryOperations libop = new LibraryOperations();
        ArrayList<Actor> actors = libop.actorsAsDirectors();

        request.setAttribute("actors", actors);
        request.getRequestDispatcher("jsp/ActorAsDirector.jsp").forward(request, response);
    }
}
