package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelContact;

/**
 * Servlet implementation class ControllerAdminContactDel
 */

public class ControllerAdminContactDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminContactDel() {
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
		ModelContact modelContact=new ModelContact();
		System.out.println("1");
		int idC=Integer.parseInt(request.getParameter("idC"));
		int result=modelContact.delContact(idC);
		
		if(result>0){
			System.out.println("Đã vào");
			response.sendRedirect(request.getContextPath()+"/admin/contact?msge=1");

		}else{
			System.out.println("Chưa vào");
			response.sendRedirect(request.getContextPath()+"/admin/contact?msge=0");
		}
	}

}
