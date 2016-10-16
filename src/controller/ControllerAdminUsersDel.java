package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Users;
import model.ModelUsers;

/**
 * Servlet implementation class ControllerAdminUsersDel
 */
@WebServlet("/ControllerAdminUsersDel")
public class ControllerAdminUsersDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminUsersDel() {
        super();
        
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
		HttpSession session=request.getSession();
		Users objSUser=(Users)session.getAttribute("objSUser");
		if(session.getAttribute("objSUser")!=null){
			if(objSUser.getUsername().equals("admin")){
				int idU=Integer.parseInt(request.getParameter("idU"));
				int result=modelUsers.delUser(idU);
				if(result>0){
					response.sendRedirect(request.getContextPath()+("/admin/indexUsers?err=1"));
				}else{
					response.sendRedirect(request.getContextPath()+("/admin/indexUsers?err=0"));
				}
			}else{
				response.sendRedirect(request.getContextPath()+("/admin/indexUsers?e=1"));
			}
		}else{
			response.sendRedirect(request.getContextPath()+("/admin/login?e=1"));
		}
		
	}

}
