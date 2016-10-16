package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import library.LibraryString;
import model.ModelUsers;
import bean.Users;

/**
 * Servlet implementation class ControllerAdminLogin
 */

public class ControllerAdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModelUsers modelUsers=new ModelUsers();
		LibraryString lbString=new LibraryString();
		if(request.getParameter("login")!=null){
			String username=new String(request.getParameter("tentin").getBytes("ISO-8859-1"),"UTF-8");
			String password=new String(request.getParameter("password").getBytes("ISO-8859-1"),"UTF-8");
			String password_new =lbString.md5(password);
			System.out.println("username:"+username+"Password:"+password_new);
			
			
			Users objSUser=modelUsers.checkLogin(username,password_new);
			System.out.println(objSUser);
			if(objSUser!=null){
				HttpSession session=request.getSession();
				session.setAttribute("objSUser",objSUser);
				response.sendRedirect(request.getContextPath()+"/admin/index?mgs=1");
			}else{
				response.sendRedirect(request.getContextPath()+"/admin/login?mgs=1");
			}
		}else{
				request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
		}
	}

}
