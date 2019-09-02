package servlets;

import textfiles.Text;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/findWord")
public class FindWord extends HttpServlet {
    private Text text = new Text();

    public void doPost(HttpServletRequest request, HttpServletResponse response) {

        String requestWord = request.getParameter("word");
        int quantity = text.findQuantity(requestWord);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = null;
        try {
            pw = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        pw.println(requestWord + "=" + quantity);
        pw.close();
    }
}
