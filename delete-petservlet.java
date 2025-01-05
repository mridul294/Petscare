import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deletePet")
public class DeletePetServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String petId = request.getParameter("id");

        response.setContentType("text/html");
        response.getWriter().println("<h1>Pet Deleted Successfully</h1>");
        response.getWriter().println("<p>Pet ID: " + petId + "</p>");
    }
}
