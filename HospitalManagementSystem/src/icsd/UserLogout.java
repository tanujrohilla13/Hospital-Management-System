package icsd;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserLogout
 */
public class UserLogout extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		HttpSession session  = request.getSession();
		session.removeAttribute("UserSession");
		session.setAttribute("sucmsg", "User Logout Successfully");
		response.sendRedirect("user_login.jsp");
		
	}


	

}
