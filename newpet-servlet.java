import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addPet")
public class AddPetServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String petName = request.getParameter("name");
        String petType = request.getParameter("type");

        response.setContentType("text/html");
        response.getWriter().println("<h1>Pet Added Successfully</h1>");
        response.getWriter().println("<p>Name: " + petName + "</p>");
        response.getWriter().println("<p>Type: " + petType + "</p>");
    }
}
