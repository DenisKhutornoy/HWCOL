package servlets;


import filmClasses.Film;
import libraryFiles.LibraryOperations;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ShowFilmInformation")
public class ShowFilmInformationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("jsp/ShowFilmInformation.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LibraryOperations libop = new LibraryOperations();
        String name ="\""+ request.getParameter("filmName")+"\"";

        ArrayList<Film> films = libop.showFilmInformation(name);
        request.setAttribute("films", films);
        request.getRequestDispatcher("jsp/ShowFilmInformation.jsp").forward(request, response);
    }
}
