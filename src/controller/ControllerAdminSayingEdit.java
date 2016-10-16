package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelSaying;
import bean.Saying;

/**
 * Servlet implementation class ControllerAdminSayingEdit
 */

public class ControllerAdminSayingEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminSayingEdit() {
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
		int idS=Integer.parseInt(request.getParameter("idS"));
		
		if(request.getParameter("sua")!=null){
			
			String content = new String(request.getParameter("content").getBytes("ISO-8859-1"),"UTF-8");
			String author= new String(request.getParameter("author").getBytes("ISO-8859-1"),"UTF-8");
			Saying objSaying=new Saying(idS, content, author);
			
			
			int result=modelSaying.editContact(objSaying);
			if(result>0){
				
				response.sendRedirect(request.getContextPath()+"/admin/saying?mseg=1");

			}else{
				
				response.sendRedirect(request.getContextPath()+"/admin/editSaying?msg=1");

			}
					
		}else{
			Saying alSaying =modelSaying.getIdContact(idS);
			request.setAttribute("al",alSaying);
			RequestDispatcher rd=request.getRequestDispatcher("/admin/editSaying.jsp");
			rd.forward(request, response);
		}
		
	}

}
