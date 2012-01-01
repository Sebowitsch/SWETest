package SWE.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SWE.dao.ArticleDAO;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class ArticleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleController() {
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
		
		if (requestURI.compareTo("recent")==0){
			forward = "/showArticles.jsp";
			request.setAttribute("title", "Neueste Artikel");
		} 
		else if (requestURI.compareTo("show")==0){			
			forward = "/showArticle.jsp";
			
			int id = Integer.parseInt(request.getParameter("articleID"));
			ArticleDAO dao = new ArticleDAO();
			request.setAttribute("article", dao.getArticleById(id));
		} 
		else {
			System.out.println("Test3");
			forward = "/showArticles.jsp";
			request.setAttribute("title", "Alle Artikel");
			
			ArticleDAO dao = new ArticleDAO();
			request.setAttribute("articles", dao.recentArticles());
		}
		
		System.out.println("Test4");
		
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
