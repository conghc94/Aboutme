package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Category;
import model.ModelCategory;

/**
 * Servlet implementation class ControllerAdminCategoryEdit
 */
@WebServlet("/ControllerAdminCategoryEdit")
public class ControllerAdminCategoryEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminCategoryEdit() {
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
		response.setContentType("text/html");
		ModelCategory modelCat=new ModelCategory();
		int idC=Integer.parseInt(request.getParameter("idC"));
		if(request.getParameter("sua")!=null){
			String username= new String(request.getParameter("tentin").getBytes("ISO-8859-1"),"UTF-8");
			Category cat=new Category(idC,username);
			int result=modelCat.editCat(cat);
			if(result>0){
				response.sendRedirect(request.getContextPath()+"/admin/category?mseg=1");

			}else{
				response.sendRedirect(request.getContextPath()+"/admin/editCat?msg=1");

			}
					
		}else{
			Category alcat=modelCat.getIdCat(idC);
			request.setAttribute("alCat",alcat);
			RequestDispatcher rd=request.getRequestDispatcher("/admin/editCat.jsp");
			rd.forward(request, response);
		}
	}

}
