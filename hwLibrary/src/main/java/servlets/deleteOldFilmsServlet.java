package servlets;

import libraryFiles.LibraryOperations;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("deleteOldFilms")
public class deleteOldFilmsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("jsp/deleteFilmByYear.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LibraryOperations libop = new LibraryOperations();
        int age = Integer.parseInt(request.getParameter("count"));
        libop.deleteOldFilms(age);

        request.getRequestDispatcher("jsp/deleteFilmByYear.jsp").forward(request, response);
    }
}
