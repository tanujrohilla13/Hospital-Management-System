package icsd;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.UserClass;
import oracle.jdbc.pool.OracleDataSource;
import util.DBHandler;

/**
 * Servlet implementation class UserAuth
 */
public class UserAuth extends HttpServlet {
	
	
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rset = null;

	public Connection getDBCon()
	{
		Connection con = null;
		
		try {
			OracleDataSource ods = new OracleDataSource();
			ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
			con = ods.getConnection("tanuj","icsd");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("connextion establish");
		return con;
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBHandler objDB = new DBHandler();
		
		String strFullName = request.getParameter("fullname");
		String strEmail = request.getParameter("email");
		String strPassword = request.getParameter("password");
		
		
		
		boolean f = objDB.InsertIntoUserDetail(strFullName, strEmail, strPassword);
		
		HttpSession session = request.getSession();
		
		if(f)
		{
			session.setAttribute("sucmsg", "Register Successfull");
			response.sendRedirect(request.getContextPath()+"/signup.jsp");
		}else
		{
			session.setAttribute("errormsg", "something wrong on server");
			response.sendRedirect(request.getContextPath()+"/signup.jsp");
		}
		
//		HttpSession session = request.getSession();
//		response.sendRedirect(request.getContextPath()+"/user_login.jsp");
		
//		PrintWriter out = response.getWriter();
//		out.println("<html><head><title> error page</head></title><body>");
//		out.println("<a href=\"UserLogin.html\">Back To User Login Page</a>");
//		out.println("</body></html>");
		
		
	}

}
