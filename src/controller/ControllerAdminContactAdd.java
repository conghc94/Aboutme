package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Contact;
import model.ModelContact;

/**
 * Servlet implementation class ControllerAdminContactAdd
 */

public class ControllerAdminContactAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminContactAdd() {
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
		if(request.getParameter("them")!=null){
			String fullname=new String(request.getParameter("fullname").getBytes("ISO-8859-1"),"UTF-8");
			String email=new String(request.getParameter("email").getBytes("ISO-8859-1"),"UTF-8");
			String address=new String(request.getParameter("address").getBytes("ISO-8859-1"),"UTF-8");
			String phone=new String(request.getParameter("phone").getBytes("ISO-8859-1"),"UTF-8");
			String content=new String(request.getParameter("content").getBytes("ISO-8859-1"),"UTF-8");
			Contact contact=new Contact(0, fullname, email, address, phone, content);
			int result=modelContact.addContact(contact);
			if(result>0){
				response.sendRedirect(request.getContextPath()+"/admin/contact?msg=1");
			}else{
				response.sendRedirect(request.getContextPath()+"/admin/addContact?msg=1");

			}
		}else{
			request.getRequestDispatcher("/admin/addContact.jsp").forward(request, response);
		}
	}

}
