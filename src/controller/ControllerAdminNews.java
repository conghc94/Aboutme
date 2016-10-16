package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Category;
import library.LibraryPermission;
import model.ModelCategory;
import model.ModelNews;

/**
 * Servlet implementation class ControllerAdminNews
 */

public class ControllerAdminNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminNews() {
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
		LibraryPermission lPer = new LibraryPermission();
		if (lPer.isLogin(request, response)) {
			return;
		}

		ModelNews mNews = new ModelNews();
		
		int row_count = 3; // Row per pager
		int total = mNews.getTotal();
		int numberOfPage = (int) Math.ceil((float) total / row_count);
		request.setAttribute("numberOfPage", numberOfPage);
		// CurrentPage
		int currentPage = 1;
		if (request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		int offset = (currentPage - 1) * row_count;
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("alNews", mNews.getListForPaginator(offset, row_count));
		ModelCategory mCat = new ModelCategory();
		ArrayList<Category> listCat = mCat.getListCat();
		request.setAttribute("listCat", listCat);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/indexNews.jsp");
		rd.forward(request, response);
	}

}
