package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import entity.Specalist;
import entity.UserClass;
import oracle.jdbc.pool.OracleDataSource;

//****************************************************************************
public class DBHandler {
	
	Connection con=null;
	ResultSet rset=null;
	PreparedStatement stmt=null;

	public Connection getDBCon() {
		Connection con = null;
		try {
			OracleDataSource ods = new OracleDataSource();
			ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
			con = ods.getConnection("tanuj", "icsd");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

//****************************************************************************
	public boolean InsertIntoUserDetail(String strFullName, String strEmail, String strPassword) {
		Connection con = getDBCon();
		boolean f = false;
		try {

			PreparedStatement stmt = con.prepareStatement("insert into user_dlts values(?,?,?,?)");

			int  intId=getMaxid("user_dlts","id");
//			intId++;
			String strId=String.valueOf(intId);
			
			stmt.setString(1,strId);
			stmt.setString(2, strFullName);
			stmt.setString(3, strEmail);
			stmt.setString(4, strPassword);

		
		int i=	stmt.executeUpdate();
			if(i==1)
			{
			f=true;
			}
			
			
		} catch (SQLException e) {

			e.printStackTrace(); 
		}
		return f;

	}
//******************************************************************************
	public int getMaxid(String StrTblMovies,String StrMovieid)
	{
		int maxid=0;
		Connection con=getDBCon();
		try {
			try
			{
			PreparedStatement  stmt=con.prepareStatement("select max("+StrMovieid+") as res from "+StrTblMovies);
			ResultSet rset=stmt.executeQuery();
			if(rset.next())
			{
				maxid=rset.getInt("res");
				maxid+=1;
			}
			else
			{
				maxid=1;
			}
			}
			catch(NullPointerException npe)
			{
				maxid=1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//select max(movieid) as res from tblmovies;
		return maxid;
	}
	
//*****************************************************************************************************
	
	public UserClass login(String em, String pass)
	{
		Connection con = getDBCon();
		UserClass u=null;
		try {
			stmt = con.prepareStatement("select * from user_dlts where email=? and password=?");
			
			stmt.setString(1, em);
			stmt.setString(2, pass);
			
			rset = stmt.executeQuery();
			
			while(rset.next())
			{
				u= new UserClass();
				u.setId(rset.getInt(1));
				u.setFullname(rset.getString(2));
				u.setEmail(rset.getString(3));
				u.setPassword(rset.getString(4));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

//********************************************************************************************
	
	public boolean addSpecialist(String spec)
	{
		boolean f = false;
		Connection con = getDBCon();
		try {
			stmt = con.prepareStatement("insert into specialist(spec_name) values(?)");
			stmt.setString(1,spec);
			int i = stmt.executeUpdate();
			if(i==1)
			{
				f=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	    
	}
	
//************************************************************************************************
	
	public List<Specalist> getAllSpecialist()
	{
		List<Specalist> list = new ArrayList<Specalist>();
		Specalist s = null;
		
		try {
			

			 stmt = con.prepareStatement("select * from specialist");
			rset = stmt.executeQuery();

			while (rset.next()) {

			s.setSpecialistName(rset.getString(1));
			list.add(s);

			}

			} catch (Exception e) {
			e.printStackTrace();
			}

			return list;
			
	}
}
