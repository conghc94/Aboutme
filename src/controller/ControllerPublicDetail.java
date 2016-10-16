package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.News;
import model.ModelNews;

/**
 * Servlet implementation class ControllerPublicDetail
 */

public class ControllerPublicDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerPublicDetail() {
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
		int nid=Integer.parseInt(request.getParameter("nid"));
		News obj=mn.getListDetail(nid);
		request.setAttribute("obj",obj);
		request.setAttribute("alNews",mn.getItemDetail(nid,obj.getIdCat()));
		request.getRequestDispatcher("/news_detail.jsp").forward(request, response);
	}

}
