import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listPets")
public class ListPetsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<h1>List of Pets</h1>");
        // Mock pet data
        response.getWriter().println("<ul>");
        response.getWriter().println("<li>Fluffy - Cat</li>");
        response.getWriter().println("<li>Buddy - Dog</li>");
        response.getWriter().println("</ul>");
    }
}


