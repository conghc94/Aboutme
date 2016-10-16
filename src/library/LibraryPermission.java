package library;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Users;

public class LibraryPermission {
	public boolean isLogin(HttpServletRequest request, HttpServletResponse response) {
		
			HttpSession session = request.getSession();
			Users objSUser =(Users) session.getAttribute("objSUser");
			if(objSUser == null){
				try {
					response.sendRedirect(request.getContextPath()+"/admin/login");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;
			}else{
				return false;
			}
			
		}
}
