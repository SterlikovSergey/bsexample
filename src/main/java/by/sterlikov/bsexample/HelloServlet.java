package by.sterlikov.bsexample;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "loginServlet", value = "/login")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World! after button submit ";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        var login = request.getParameter("login");
        var password = request.getParameter("password");
        var currLogin = request.getServletContext().getInitParameter("currLogin");
        var currPass = request.getServletContext().getInitParameter("currPass");


        PrintWriter writer = response.getWriter();
        writer.println("<!doctype html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "  <meta charset=\"utf-8\">\n" +
                "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "  <title>Login form</title>\n" +
                "  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65\" crossorigin=\"anonymous\">\n" +
                "</head>\n" +
                "<body>"
        );
        writer.println("<h1>" + login + "</h1>");
        writer.println("<h1>" + password + "</h1>");
        writer.println("</body></html>");

/*        if(login.equals(currLogin) && password.equals(currPass)){
            response.sendRedirect("success.html");
        } else {
            response.sendRedirect("error.html");
        }*/

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + request.getParameter("login") + " " + request.getParameter("password")  + "</h1> ");
        out.println("</body></html>");
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1> ");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}