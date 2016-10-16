package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.AboutMe;
import model.ModelAboutMe;
import model.ModelAdvs;
import model.ModelSaying;

/**
 * Servlet implementation class ControllerPublicAboutme
 */

public class ControllerPublicAboutme extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerPublicAboutme() {
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
		ModelAboutMe modelAboutMe=new ModelAboutMe();
		AboutMe alAboutMe=modelAboutMe.getListAboutMe();
		ModelSaying modelSaying=new ModelSaying();
		request.setAttribute("alSaying",modelSaying.getListSaying());
		ModelAdvs modelAdvs=new ModelAdvs();
		request.setAttribute("alAdvs", modelAdvs.getListAdvs());
		request.setAttribute("setActiveAboutMe", "true");
		request.setAttribute("alAboutme",alAboutMe);
		request.getRequestDispatcher("/about.jsp").forward(request, response);
	}

}
