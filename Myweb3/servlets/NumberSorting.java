package servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/sortNumbers")
public class NumberSorting extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        List<String> list = new ArrayList<>();
        String requestNumbers = request.getParameter("numbers");

        if (requestNumbers != null) {
            list = Arrays.stream(requestNumbers.split(","))
                    .sorted()
                    .collect(Collectors.toList());
        }

        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = null;
        try {
            pw = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        pw.println(list);
        pw.close();
    }
}
