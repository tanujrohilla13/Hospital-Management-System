package icsd;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.UserClass;
import util.DBHandler;

/**
 * Servlet implementation class AddSpecialist
 */
public class AddSpecialist extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String specName =request.getParameter("specName");
		
		HttpSession session = request.getSession();
		DBHandler dbh = new DBHandler();
		
		boolean f = dbh.addSpecialist(specName);
		if(f)
		{
			session.setAttribute("succMsg", "Specialist Added");
			response.sendRedirect(request.getContextPath()+"/adminIndex.jsp");
		}
		else
		{
			session.setAttribute("errorMsg", "something went wrong on server");
			response.sendRedirect(request.getContextPath()+"/adminIndex.jsp");
		}
	
	}

}
