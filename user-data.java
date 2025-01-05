import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

// User class
class User {
    private String name;
    private String email;
    private String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
}

@WebServlet("/users")
public class UserDataServlet extends HttpServlet {
    private List<User> userList = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        // Initialize some users (dummy data)
        userList.add(new User("Alice", "alice@example.com", "password123"));
        userList.add(new User("Bob", "bob@example.com", "password456"));
        userList.add(new User("Charlie", "charlie@example.com", "password789"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Add the user list to the request scope
        request.setAttribute("users", userList);
        // Forward the request to the JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/userList.jsp");
        dispatcher.forward(request, response);
    }
}
