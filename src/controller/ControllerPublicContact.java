package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Contact;
import model.ModelAdvs;
import model.ModelContact;
import model.ModelSaying;

/**
 * Servlet implementation class ControllerPublicContact
 */

public class ControllerPublicContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerPublicContact() {
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
		
		ModelSaying modelSaying=new ModelSaying();
		request.setAttribute("alSaying",modelSaying.getListSaying());
		ModelAdvs modelAdvs=new ModelAdvs();
		
		request.setAttribute("alAdvs", modelAdvs.getListAdvs());
		ModelContact mc=new ModelContact();
		request.setAttribute("setActiveContact", "true");
			if(request.getParameter("send")!=null){
				String name=new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
				String email=new String(request.getParameter("email").getBytes("ISO-8859-1"),"UTF-8");
				String address=new String(request.getParameter("address").getBytes("ISO-8859-1"),"UTF-8");
				String phone=new String(request.getParameter("phone").getBytes("ISO-8859-1"),"UTF-8");
				String message=new String(request.getParameter("message").getBytes("ISO-8859-1"),"UTF-8");
				Contact contact=new Contact(0, name, email, address, phone, message);
				int result=mc.addContact(contact);
				if(result>0){
					response.sendRedirect(request.getContextPath()+"/contact?msg=1");
				}else{
					response.sendRedirect(request.getContextPath()+"/contact?msg=0");

				}

			}else{
				request.getRequestDispatcher("/contact.jsp").forward(request, response);
			}
		
	}

}
