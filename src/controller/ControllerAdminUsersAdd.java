package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.LibraryString;
import model.ModelUsers;
import bean.Users;

/**
 * Servlet implementation class ControllerAdminUsersAdd
 */

public class ControllerAdminUsersAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminUsersAdd() {
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
		if(request.getParameter("them")!=null){
			String username= new String(request.getParameter("tentin").getBytes("ISO-8859-1"),"UTF-8");
			String password= new String(request.getParameter("password").getBytes("ISO-8859-1"),"UTF-8");
			String password_new=lbString.md5(password);
			String fullname= new String(request.getParameter("fullname").getBytes("ISO-8859-1"),"UTF-8");
			if(modelUsers.checkUserName(username)){
				response.sendRedirect(request.getContextPath()+"/admin/addUsers?msg=1");
			}else{
				Users user=new Users(0, username, password_new, fullname);
				int result=modelUsers.addUsers(user);
				if(result>0){
					response.sendRedirect(request.getContextPath()+"/admin/indexUsers?msg=1");
				}else{
					response.sendRedirect(request.getContextPath()+"/admin/addUsers?msg=1");
				}
			}
		}else{
			RequestDispatcher rd=request.getRequestDispatcher("/admin/addUsers.jsp");
			rd.forward(request, response);
		}
		
	}

}
