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
 * Servlet implementation class ControllerAdminNewsSearch
 */

public class ControllerAdminNewsSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminNewsSearch() {
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
		
		if(request.getParameter("search")!=null){
			ModelNews modelNews=new ModelNews();
			ModelCategory mCat = new ModelCategory();
			ArrayList<Category> listCat = mCat.getListCat();
			request.setAttribute("listCat", listCat);
			String searchName=new String(request.getParameter("searchName").getBytes("ISO-8859-1"),"UTF-8");
			String searchDM=new String(request.getParameter("searchDM").getBytes("ISO-8859-1"),"UTF-8");
			if("".equals(searchDM))request.setAttribute("searchDM", "");
			else request.setAttribute("searchDM",searchDM);
			String searchActive=new String(request.getParameter("searchActive").getBytes("ISO-8859-1"),"UTF-8");
			if(searchName.equals("")&&searchDM.equals("")&&searchActive.equals("")){
				response.sendRedirect(request.getContextPath()+"/admin/news");
				return;
			}
			request.setAttribute("searchName", searchName);
			
			request.setAttribute("searchActive",searchActive);
			//.. total offset
			int offset;
			int row_count=4;
			int currentPage=1;
			offset = (currentPage - 1) * row_count;
			int total = modelNews.getTotalSearch(searchName, searchDM,searchActive);
			int numberOfPage=(int)Math.ceil((float)total/row_count);
			request.setAttribute("numberOfPage", numberOfPage);
			if (request.getParameter("page") != null) {
				currentPage = Integer.parseInt(request.getParameter("page"));
			}
			request.setAttribute("currentPage", currentPage);
			ArrayList<News> alNews = modelNews.searchName(searchName, searchDM,searchActive, offset, row_count);
			System.out.println(alNews.size());
			if(alNews.size()!=0){
				request.setAttribute("alNews",alNews);
				request.getRequestDispatcher("/admin/indexNews.jsp").forward(request, response);
			}else{
				response.sendRedirect(request.getContextPath()+"/admin/news?msg=1");
			}
		} else if(request.getParameter("showall")!=null){
			response.sendRedirect(request.getContextPath()+"/admin/news?msg=1");
		}
	}

}
