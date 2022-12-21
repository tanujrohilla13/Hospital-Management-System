package icsd;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class adminIndex
 */
public class adminIndex extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		try {
				ICSDAuthSupport.doCheckAuth(request);

		//	request.setAttribute("lstCat", lst);
			RequestDispatcher rd =request.getRequestDispatcher("/adminIndex.jsp");
			rd.forward(request, response);
		} catch (ICSDAuthException e) {
			out.println("<html><head><title> error page</head></title><body>");
			out.println("<a href='admin_login.jsp'>"+e.getMessage()+"</a>");
			e.getMessage();
			out.println("</body></html>");
		}
}

}
