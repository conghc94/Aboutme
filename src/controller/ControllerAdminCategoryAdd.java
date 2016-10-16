package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelCategory;
import bean.Category;

/**
 * Servlet implementation class ControllerAdminCategoryAdd
 */

public class ControllerAdminCategoryAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminCategoryAdd() {
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
		ModelCategory modelCat=new ModelCategory();
		if(request.getParameter("them")!=null){
			String username= new String(request.getParameter("tentin").getBytes("ISO-8859-1"),"UTF-8");
			if(modelCat.checkName(username)){
				response.sendRedirect(request.getContextPath()+"/admin/addCat?msg=1");
			}else{
				Category cat=new Category(0, username);
				int result=modelCat.addCat(cat);
				if(result>0){
					response.sendRedirect(request.getContextPath()+"/admin/category?msg=1");
				}else{
					response.sendRedirect(request.getContextPath()+"/admin/addCat?msg=1");
				}
			}
		}else{
			RequestDispatcher rd=request.getRequestDispatcher("/admin/addCat.jsp");
			rd.forward(request, response);
		}
	}

}
