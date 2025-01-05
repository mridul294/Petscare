import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Pet class to hold pet data
class Pet {
    private String id;
    private String name;
    private String type;

    public Pet(String id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}

@WebServlet("/pets")
public class PetManagementServlet extends HttpServlet {

    // Simulated database (for demonstration)
    private List<Pet> petList = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        // Initialize some sample data
        petList.add(new Pet("1", "Fluffy", "Cat"));
        petList.add(new Pet("2", "Buddy", "Dog"));
    }

    // Handle GET request: List all pets
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("<h1>Pets Care Management</h1>");
        response.getWriter().println("<h2>List of Pets:</h2>");

        if (petList.isEmpty()) {
            response.getWriter().println("<p>No pets available.</p>");
        } else {
            response.getWriter().println("<ul>");
            for (Pet pet : petList) {
                response.getWriter().println("<li>" + pet.getName() + " (" + pet.getType() + ") - ID: " + pet.getId() + "</li>");
            }
            response.getWriter().println("</ul>");
        }

        // Provide form to add a new pet
        response.getWriter().println("<h2>Add a Pet</h2>");
        response.getWriter().println("<form action='/pets' method='post'>");
        response.getWriter().println("Name: <input type='text' name='name'><br>");
        response.getWriter().println("Type: <input type='text' name='type'><br>");
        response.getWriter().println("<button type='submit'>Add Pet</button>");
        response.getWriter().println("</form>");

        // Provide form to delete a pet
        response.getWriter().println("<h2>Delete a Pet</h2>");
        response.getWriter().println("<form action='/pets' method='post'>");
        response.getWriter().println("Pet ID: <input type='text' name='id'><br>");
        response.getWriter().println("<input type='hidden' name='action' value='delete'>");
        response.getWriter().println("<button type='submit'>Delete Pet</button>");
        response.getWriter().println("</form>");
    }

    // Handle POST request: Add or delete a pet
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("delete".equalsIgnoreCase(action)) {
            // Handle pet deletion
            String id = request.getParameter("id");
            petList.removeIf(pet -> pet.getId().equals(id));
            response.getWriter().println("<h2>Pet with ID " + id + " deleted successfully.</h2>");
        } else {
            // Handle pet addition
            String name = request.getParameter("name");
            String type = request.getParameter("type");
            String id = String.valueOf(petList.size() + 1); // Generate a new ID
            petList.add(new Pet(id, name, type));
            response.getWriter().println("<h2>Pet added successfully!</h2>");
        }

        // Redirect back to the main page
        response.getWriter().println("<a href='/pets'>Go Back</a>");
    }
}
