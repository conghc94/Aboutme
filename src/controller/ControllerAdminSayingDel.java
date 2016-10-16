package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelSaying;

/**
 * Servlet implementation class ControllerAdminSayingDel
 */

public class ControllerAdminSayingDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminSayingDel() {
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
		int result=modelSaying.delSaying(idS);
		if(result>0){
			response.sendRedirect(request.getContextPath()+"/admin/saying?msge=1");
		}else{
			response.sendRedirect(request.getContextPath()+"/admin/saying?msge=0");

		}
	}

}
