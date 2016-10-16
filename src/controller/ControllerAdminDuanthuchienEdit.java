package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelProject;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import bean.Project;

/**
 * Servlet implementation class ControllerAdminDuanthuchienEdit
 */

public class ControllerAdminDuanthuchienEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminDuanthuchienEdit() {
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
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		ModelProject mP= new ModelProject();
		int idP = Integer.parseInt(request.getParameter("idP"));
		
		Project oldProject = mP.getItemById(idP);
		
		Project project;
		String name = "";
		String preview_text = "";
		String picture = "noImage.jpg";
		String link="";
		
		if (request.getParameter("delImage") != null) {
			if (!oldProject.getPicture().equals("noImage.jpg")) {
				Path path = Paths.get(request.getServletContext().getRealPath("") + File.separator + "files"
						+ File.separator + oldProject.getPicture());
				Files.delete(path);
				oldProject.setPicture(picture);
				mP.editItem(oldProject);
				
			}
		}
		if ("submit".equals(request.getParameter("type"))) {
			
			if (ServletFileUpload.isMultipartContent(request)) {
				try {
					DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
					ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
					List<FileItem> formItems = upload.parseRequest(request);
					for (FileItem fileItem : formItems) {
						if (fileItem.isFormField()) {
							String fieldname = fileItem.getFieldName();
							String fieldValue = new String(fileItem.getString().getBytes("ISO-8859-1"), "UTF-8");
							switch (fieldname) {
							case "tentin":
								name = fieldValue;
								break;
							case "mota":
								preview_text = fieldValue;
								break;
							case "link":
								link = fieldValue;
								break;
							default:
								break;
							}
						} else {
							if (!fileItem.getName().equals("")) {
								picture = fileItem.getName();
								picture = FilenameUtils.getBaseName(picture) + "-" + System.nanoTime() + "."
										+ FilenameUtils.getExtension(picture);
								String pathname = request.getServletContext().getRealPath("") + File.separator + "files"
										+ File.separator + picture;
								File file = new File(pathname);
								
								fileItem.write(file);
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (!"noImage.jpg".equals(picture)) {
					project = new Project(idP, name, preview_text, picture, link);
					if (!"noImage.jpg".equals(oldProject.getPicture())) {
						Path path = Paths.get(request.getServletContext().getRealPath("") + File.separator + "files"
								+ File.separator + oldProject.getPicture());
						Files.delete(path);
					}
				} else {
					project = new Project(idP, name,preview_text, oldProject.getPicture(), link);
				}
				if (mP.editItem(project)) {
					response.sendRedirect(request.getContextPath() + "/admin/duanthuchien?emsg=1");
				} else {
					response.sendRedirect(request.getContextPath() + "/admin/editProject?msg=0");
				}
			} else {
				System.err.println("Form không thỏa mãn");
			}
		} else {
			request.setAttribute("oldProject", oldProject);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/editProject.jsp");
			rd.forward(request, response);
		}
	}
	}


