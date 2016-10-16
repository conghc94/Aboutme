package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelCategory;

/**
 * Servlet implementation class ControllerAdminCategoryDel
 */

public class ControllerAdminCategoryDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminCategoryDel() {
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
		int idC=Integer.parseInt(request.getParameter("idC"));
		ModelCategory modelCat=new ModelCategory();
		int result=modelCat.delCat(idC);
		if(result>0){
			response.sendRedirect(request.getContextPath()+"/admin/category?msge=1");
		}else{
			response.sendRedirect(request.getContextPath()+"/admin/category?msge=0");

		}
	}

}
