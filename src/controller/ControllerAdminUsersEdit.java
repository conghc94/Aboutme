package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import library.LibraryString;
import model.ModelUsers;
import bean.Users;

/**
 * Servlet implementation class ControllerAdminUsersEdit
 */

public class ControllerAdminUsersEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminUsersEdit() {
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
		ModelUsers mUser=new ModelUsers();
		HttpSession session=request.getSession();
		Users objSUser=(Users)session.getAttribute("objSUser");
		if(session.getAttribute("objSUser")!=null){
			if(objSUser.getUsername().equals("admin")){
				int idU = Integer.parseInt(request.getParameter("idU"));
				System.out.println("id"+idU);
				if(request.getParameter("sua")!=null){
				
					String password_new="";
					String ten=new String(request.getParameter("tentin").getBytes("ISO-8859-1"),"UTF-8");
					String password=new String(request.getParameter("password").getBytes("ISO-8859-1"),"UTF-8");
					String fullname=new String(request.getParameter("fullname").getBytes("ISO-8859-1"),"UTF-8");
						if("".equals(password)){
							Users objUser=mUser.getListByItem(idU);
							password_new=objUser.getPassword();
						}else{
							LibraryString lString=new LibraryString();
							password_new=lString.md5(password);
						}
					Users objUser=new Users(idU,ten,password_new,fullname);
					int result=mUser.editItem(objUser);
						if(result>0){
							response.sendRedirect(request.getContextPath()+"/admin/indexUsers?mseg=1");
						}else{
							response.sendRedirect(request.getContextPath()+"/admin/editUsers?msg=0");
						}
				}else{
					Users itemUser=mUser.getListByItem(idU);
					request.setAttribute("objUser", itemUser);
					RequestDispatcher rd=request.getRequestDispatcher("/admin/editUsers.jsp");
					rd.forward(request, response);
				}
			}else{
				response.sendRedirect(request.getContextPath()+"/admin/indexUsers?er=1");

			}
		}else{
			response.sendRedirect(request.getContextPath()+"/admin/login?msg=1");
		}
		
	}

}
