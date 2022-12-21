package icsd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ICSDAuthSupport {

	public static HttpSession doCheckAuth(HttpServletRequest request) throws ICSDAuthException
	{
	
		HttpSession session = request.getSession(false);
		if(session==null)
		{
			throw new ICSDAuthException("invalid user , pls login first");
		}
		return session;
	}


} 
