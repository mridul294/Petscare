import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

// User class to hold user details
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

@WebServlet("/user")
public class UserRegistrationServlet extends HttpServlet {

    private User registeredUser = null; // Temporarily store the registered user

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        if (registeredUser != null) {
            // Forward to profile JSP if user is registered
            request.setAttribute("user", registeredUser);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/profile.jsp");
            dispatcher.forward(request, response);
        } else {
            // Redirect to registration form if no user is registered
            response.sendRedirect("/register.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Collect user data from the registration form
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Save the user data
        registeredUser = new User(name, email, password);

        // Redirect to the profile page
        response.sendRedirect("/user");
    }
}
