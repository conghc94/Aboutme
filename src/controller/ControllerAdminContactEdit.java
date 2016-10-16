package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelContact;
import bean.Contact;

/**
 * Servlet implementation class ControllerAdminContactEdit
 */

public class ControllerAdminContactEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminContactEdit() {
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
		int idC=Integer.parseInt(request.getParameter("idC"));
		
		if(request.getParameter("sua")!=null){
			
			String fullname= new String(request.getParameter("fullname").getBytes("ISO-8859-1"),"UTF-8");
			String email= new String(request.getParameter("email").getBytes("ISO-8859-1"),"UTF-8");
			String address= new String(request.getParameter("address").getBytes("ISO-8859-1"),"UTF-8");
			String phone= new String(request.getParameter("phone").getBytes("ISO-8859-1"),"UTF-8");
			String content= new String(request.getParameter("content").getBytes("ISO-8859-1"),"UTF-8");
			System.out.println(address);
			System.out.println(phone);
			Contact objContact=new Contact(idC, fullname, email, address, phone, content);
			int result=modelContact.editContact(objContact);
			if(result>0){
				
				response.sendRedirect(request.getContextPath()+"/admin/contact?mseg=1");

			}else{
				
				response.sendRedirect(request.getContextPath()+"/admin/editContact?msg=1");

			}
					
		}else{
			Contact alContact =modelContact.getIdContact(idC);
			request.setAttribute("alContact",alContact);
			RequestDispatcher rd=request.getRequestDispatcher("/admin/editContact.jsp");
			rd.forward(request, response);
		}
		
	}

}
