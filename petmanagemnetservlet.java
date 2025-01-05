import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet("/pets")
public class PetManagementServlet extends HttpServlet {

    private List<Pet> petList = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        petList.add(new Pet("1", "Fluffy", "Cat"));
        petList.add(new Pet("2", "Buddy", "Dog"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setAttribute("pets", petList); // Pass the pet list to JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pets.jsp");
        dispatcher.forward(request, response); // Forward request to JSP
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("delete".equalsIgnoreCase(action)) {
            String id = request.getParameter("id");
            petList.removeIf(pet -> pet.getId().equals(id));
        } else {
            String name = request.getParameter("name");
            String type = request.getParameter("type");
            String id = String.valueOf(petList.size() + 1);
            petList.add(new Pet(id, name, type));
        }

        response.sendRedirect("/pets"); // Redirect to GET request to refresh data
    }
}

// Pet Class (if not defined earlier)
class Pet {
    private String id;
    private String name;
    private String type;

    public Pet(String id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getType() { return type; }
}
