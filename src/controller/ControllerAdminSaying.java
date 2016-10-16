package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.LibraryPermission;
import model.ModelSaying;

/**
 * Servlet implementation class ControllerAdminSaying
 */

public class ControllerAdminSaying extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminSaying() {
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
		LibraryPermission lbper=new LibraryPermission();
		if(lbper.isLogin(request, response)){
			return;
		}
		ModelSaying modelSaying=new ModelSaying();
		int row_count=4;
		//Lấy tổng  số tin
		int total=modelSaying.getToTal();
		//chia số trang
		int numberOfPage=(int)Math.ceil((float)total/row_count);
		request.setAttribute("numberOfPage", numberOfPage);
		int currentPage=1;
		if (request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		int offset = (currentPage - 1) * row_count;
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("alSaying",modelSaying.getListForPaginator(offset, row_count));
		RequestDispatcher rd=request.getRequestDispatcher("/admin/indexSaying.jsp");
		rd.forward(request, response);
	}

}
