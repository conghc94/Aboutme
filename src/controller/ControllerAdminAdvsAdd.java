package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelAdvs;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import bean.Advs;

/**
 * Servlet implementation class ControllerAdminAdvsAdd
 */

public class ControllerAdminAdvsAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminAdvsAdd() {
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
		String name = "";
		String bannner = "";
		String link="";
		if (!"load".equals(request.getParameter("type"))) {
			System.out.println("vo0");
			if (ServletFileUpload.isMultipartContent(request)) {
				System.out.println("vo");
				DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
				try {
					List<FileItem> formItems = upload.parseRequest(request);
					for (FileItem fileItem : formItems) {
						if (fileItem.isFormField()) {
							String fieldname = fileItem.getFieldName();
							String fieldValue = new String(fileItem.getString().getBytes("ISO-8859-1"), "UTF-8");
							switch (fieldname) {
							case "name":
								name = fieldValue;
								break;
							case "bannner":
								bannner = fieldValue;
								break;
							case "link":
								link = fieldValue;
								break;
							
							default:
								break;
							}
						} else {
							bannner = fileItem.getName();
							if (!bannner.equals("")) {
								bannner = FilenameUtils.getBaseName(bannner) + "-" + System.nanoTime() + "."
										+ FilenameUtils.getExtension(bannner);
								String pathname = request.getServletContext().getRealPath("") + File.separator + "files"
										+ File.separator + bannner;
								File file = new File(pathname);
								fileItem.write(file);
							}
							else{
								bannner = "noImage.jpg";
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("Name"+name);
				ModelAdvs mn = new ModelAdvs();
				if(mn.checkName(name)){
					//trung ten thi ko them
					response.sendRedirect(request.getContextPath() + "/admin/addAdvs?type=load&msg=0");
				}else{
					//ko trung thi them
					Advs advs = new Advs(0, name,bannner, link);
					if(mn.addItem(advs)){
						response.sendRedirect(request.getContextPath() + "/admin/advs?msg=1");
					}
					else{
						response.sendRedirect(request.getContextPath() + "/admin/addAdvs?msg=0");
					}
				}
				
				
//				if (mn.addItem(project)&&name.equals(mn.getName(name))) {
//					response.sendRedirect(request.getContextPath() + "/admin/duanthuchien?msg=1");
//				} else {
//					response.sendRedirect(request.getContextPath() + "/admin/addProject?msg=0");
//				}
			} else {
				System.out.println("Form không thỏa mãn upload");
			}

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/addAdvs.jsp");
			rd.forward(request, response);
		}
	}

}
