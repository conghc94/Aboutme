package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelNews;

/**
 * Servlet implementation class ControllerAdminNewsActive
 */

public class ControllerAdminNewsActive extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminNewsActive() {
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
		PrintWriter out = response.getWriter();

		int news_id = Integer.parseInt(request.getParameter("news_id"));
		int news_active = Integer.parseInt(request.getParameter("news_active"));

		ModelNews model = new ModelNews();
		model.setActive(news_id, news_active);

		int active = model.getListNewsActive(news_id);
		if (active == 1) {
			out.println("<a href=\"javascript:void(0)\" onclick=\"setActive(" + active + ", " + news_id
					+ ")\"><img alt=\"\" src=\"" + request.getContextPath() + "/templates/admin/images/tick-circle.gif\"></a>");
		} else {
			out.println("<a href=\"javascript:void(0)\" onclick=\"setActive(" + active + ", " + news_id
					+ ")\"><img alt=\"\" src=\"" + request.getContextPath() + "/templates/admin/images/minus-circle.gif\"></a>");
		}
		//request.getRequestDispatcher("/admin/indexNews.jsp").forward(request, response);
	}

}
