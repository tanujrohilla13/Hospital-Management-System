package icsd;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.UserClass;
import oracle.jdbc.pool.OracleDataSource;
import util.DBHandler;

/**
 * Servlet implementation class UserLoginAuth
 */
public class UserLoginAuth extends HttpServlet {
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rset = null;

//	public Connection getDBCon()
//	{
//		Connection con = null;
//		
//		try {
//			OracleDataSource ods = new OracleDataSource();
//			ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
//			con = ods.getConnection("tanuj","icsd");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("connextion establish");
//		return con;
//	};
	

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		String strunm = request.getParameter("email");
		String strpwd = request.getParameter("password");
		
		
			
			HttpSession session = request.getSession();
			DBHandler dbh = new DBHandler();
			
			UserClass user = dbh.login(strunm, strpwd);
		
			if(user!=null)
			{
				session.setAttribute("UserSession", user);
				response.sendRedirect(request.getContextPath()+"/Index.jsp");
			}
			else
			{
				session.setAttribute("errormsg", "Enter valid username & password");
				response.sendRedirect(request.getContextPath()+"/user_login.jsp");
			}
		 
		
	
	}
}
