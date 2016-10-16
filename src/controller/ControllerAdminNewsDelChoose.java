package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelNews;

/**
 * Servlet implementation class ControllerAdminNewsDelChoose
 */

public class ControllerAdminNewsDelChoose extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminNewsDelChoose() {
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
		ModelNews mn=new ModelNews();
		if(request.getParameter("dels")!=null){
			String[] listIdDelete = request.getParameterValues("check");
			System.out.println("id:"+listIdDelete);
			if(mn.delListIdDelete(listIdDelete)){
				response.sendRedirect(request.getContextPath()+"/admin/news?suss=1");
			}else{
				response.sendRedirect(request.getContextPath()+"/admin/news?suss=0");

			}
		}else{
			request.getRequestDispatcher("/admin/indexNews.jsp").forward(request, response);
		}
	}

}
