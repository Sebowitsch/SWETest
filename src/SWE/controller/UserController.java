package SWE.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SWE.dao.UserDAO;
import SWE.models.User;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String URI = request.getRequestURI();
		String requestURI = URI.substring( URI.lastIndexOf("/") + 1 );

		String forward="";
		
		if (requestURI.compareTo("login")==0){
			forward = "/userlogin.jsp";
			request.setAttribute("title", "Login");
		} 
		else if (requestURI.compareTo("access")==0){
			UserDAO dao = new UserDAO();
			
			String username = request.getParameter("username");
			String pw = request.getParameter("password");
			
			if(dao.checkLogin(username, pw))
			{
				request.getSession(true).setAttribute("username", username);
				System.out.println("Test1");
				request.getRequestDispatcher("/home").forward(request, response);
				
				
			}
			else
			{
				request.setAttribute("error", "Login failed");
				forward = "/userlogin.jsp";
			}
		} 
		else if (requestURI.compareTo("logout")==0){
			forward = "/userlogin.jsp";
			request.setAttribute("title", "Login");
			request.setAttribute("error", "Logout successful!");
			request.getSession(false).removeAttribute("username");
		} 
		/*else if (requestURI.compareTo("daten")==0){
			forward = "/showArticle.jsp";
			request.setAttribute("title", "Artikel anzeigen");
		}*/
		else if (requestURI.compareTo("register")==0){
			forward = "/userRegister.jsp";
			request.setAttribute("title", "Benutzer anlegen");
		}
		else if (requestURI.compareTo("newUser")==0){
			UserDAO dao = new UserDAO();
			
			String username = request.getParameter("username");
			String pw = request.getParameter("password");
			String vorname = request.getParameter("firstname");
			String nachname = request.getParameter("lastname");
			
			if(dao.saveUser(new User(username, pw, vorname, nachname)) == -1)
			{
				System.out.println("Database Insert Error!");
				request.setAttribute("print", "Beim Anlegen des Users ist ein Fehler aufgetreten!");
			}
			else
			{
				request.setAttribute("print", "User angelegt!");
			}
			
			forward = "/userRegisterSuccess.jsp";
			request.setAttribute("title", "Benutzer anlegen");
		}
		
		
		System.out.println("Test2");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
		if(dispatcher != null) dispatcher.include(request, response);
		
		dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/" + forward);
		if (dispatcher != null)	dispatcher.include(request, response);

		dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/footer.jsp");
		if (dispatcher != null)	dispatcher.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
