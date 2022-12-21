package icsd;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminLoginAuth
 */
public class AdminLoginAuth extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		
		if("admin@gmail.com".equals(email) && "icsd".equals(password))
		{
			session.setAttribute("adminSession",email);
			response.sendRedirect(request.getContextPath()+"/adminIndex.jsp");	
		}
		else
		{
			session.setAttribute("errormsg","Invalid Username & Password");
			response.sendRedirect(request.getContextPath()+"/admin_login.jsp");
		}

	}

}
