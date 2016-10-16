package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelSaying;
import bean.Saying;

/**
 * Servlet implementation class ControllerAdminSayingAdd
 */

public class ControllerAdminSayingAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminSayingAdd() {
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
		if(request.getParameter("them")!=null){
			String content=new String(request.getParameter("content").getBytes("ISO-8859-1"),"UTF-8");
			String author=new String(request.getParameter("author").getBytes("ISO-8859-1"),"UTF-8");
			if(modelSaying.checkSaying(content)){
				response.sendRedirect(request.getContextPath()+"/admin/addSaying?msg=1");
			}else{
				Saying objSaying=new Saying(0, content, author);
				int result=modelSaying.addSaying(objSaying);
				if(result>0){
					response.sendRedirect(request.getContextPath()+"/admin/saying?msg=1");

				}else{
					response.sendRedirect(request.getContextPath()+"/admin/addSaying?msg=1");

				}
			}
		}else{
			request.getRequestDispatcher("/admin/addSaying.jsp").forward(request, response);
		}
	}

}
