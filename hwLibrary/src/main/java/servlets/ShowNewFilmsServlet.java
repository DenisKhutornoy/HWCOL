package servlets;


import filmClasses.Film;
import libraryFiles.LibraryOperations;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ShowNewFilms")
public class ShowNewFilmsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("jsp/ShowNewFilms.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LibraryOperations libop = new LibraryOperations();
        List<Film> films = libop.showNewFilms();
        request.setAttribute("films", films);
        request.getRequestDispatcher("jsp/ShowNewFilms.jsp").forward(request, response);


    }
}
