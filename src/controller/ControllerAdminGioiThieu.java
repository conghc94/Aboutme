package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.AboutMe;
import library.LibraryPermission;
import model.ModelAboutMe;

/**
 * Servlet implementation class ControllerAdminGioiThieu
 */

public class ControllerAdminGioiThieu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminGioiThieu() {
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
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/hml");
		LibraryPermission lbper=new LibraryPermission();
		if(lbper.isLogin(request, response)){
			return;
		}
		ModelAboutMe modelAboutMe=new ModelAboutMe();
		if(request.getParameter("sua")!=null){
			String tentin= new String(request.getParameter("tentin").getBytes("ISO-8859-1"),"UTF-8");
			String detail= new String(request.getParameter("chitiet").getBytes("ISO-8859-1"),"UTF-8");
			AboutMe aboutMe=new AboutMe(0,tentin , detail);
			int result=modelAboutMe.editAboutMe(aboutMe);
				if(result>0){
					response.sendRedirect(request.getContextPath()+"/admin/gioithieu?msg=1");

				}else{
					response.sendRedirect(request.getContextPath()+"/admin/gioithieu?msg=0");
				}
			
		}else{
			AboutMe aboutme=modelAboutMe.getListAboutMe();
			request.setAttribute("aboutme", aboutme);
			RequestDispatcher rd=request.getRequestDispatcher("/admin/gioithieu.jsp");
			rd.forward(request, response);
		}
	}

}
