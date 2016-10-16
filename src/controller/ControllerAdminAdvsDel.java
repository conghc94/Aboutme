package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelAdvs;

/**
 * Servlet implementation class ControllerAdminAdvsDel
 */

public class ControllerAdminAdvsDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminAdvsDel() {
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
		ModelAdvs modelAdvs=new ModelAdvs();
		int idA=Integer.parseInt(request.getParameter("idA"));
		int result=modelAdvs.delAdvs(idA);
		if(result>0){
			response.sendRedirect(request.getContextPath()+"/admin/advs?del=1");
		}else{
			response.sendRedirect(request.getContextPath()+"/admin/advs?del=0");
		}
	}

}
