package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelCategory;
import model.ModelNews;
import bean.Category;
import bean.News;

/**
 * Servlet implementation class ControllerPublicNews
 */

public class ControllerPublicNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerPublicNews() {
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
		request.setAttribute("setActiveNews","true");
		ModelNews mn=new ModelNews();
		ModelCategory mc = new ModelCategory();
		int offset=0;
		int row_count=5;
		ArrayList<ArrayList<News>> alNews=new ArrayList<ArrayList<News>>();
		ArrayList<Category> alCat=mc.getListCat();
		for(Category objCategory:alCat){
			ArrayList<News> list=mn.getListNews(offset,row_count,objCategory.getIdCat());
			alNews.add(list);
		}
		request.setAttribute("alNews",alNews);
		request.setAttribute("alCat",alCat );
		request.getRequestDispatcher("/news.jsp").forward(request, response);
	}

}
