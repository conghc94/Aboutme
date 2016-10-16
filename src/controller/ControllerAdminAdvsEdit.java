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

import model.ModelAdvs;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import bean.Advs;

/**
 * Servlet implementation class ControllerAdminAdvsEdit
 */

public class ControllerAdminAdvsEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminAdvsEdit() {
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
		ModelAdvs mA= new ModelAdvs();
		int idA = Integer.parseInt(request.getParameter("idA"));
		
		Advs oldAdvs = mA.getItemById(idA);
		
		Advs advs;
		String name = "";
		String banner = "noImage.jpg";
		String link="";
		
		if (request.getParameter("delImage") != null) {
			if (!oldAdvs.getBanner().equals("noImage.jpg")) {
				Path path = Paths.get(request.getServletContext().getRealPath("") + File.separator + "files"
						+ File.separator + oldAdvs.getBanner());
				Files.delete(path);
				oldAdvs.setBanner(banner);
				mA.editItem(oldAdvs);
				
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
							case "name":
								name = fieldValue;
								break;
							case "link":
								link = fieldValue;
								break;
							default:
								break;
							}
						} else {
							if (!fileItem.getName().equals("")) {
								banner = fileItem.getName();
								banner = FilenameUtils.getBaseName(banner) + "-" + System.nanoTime() + "."
										+ FilenameUtils.getExtension(banner);
								String pathname = request.getServletContext().getRealPath("") + File.separator + "files"
										+ File.separator + banner;
								File file = new File(pathname);
								
								fileItem.write(file);
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (!"noImage.jpg".equals(banner)) {
					advs = new Advs(idA, name, banner, link);
					if (!"noImage.jpg".equals(oldAdvs.getBanner())) {
						Path path = Paths.get(request.getServletContext().getRealPath("") + File.separator + "files"
								+ File.separator + oldAdvs.getBanner());
						Files.delete(path);
					}
				} else {
					advs = new Advs(idA, name, oldAdvs.getBanner(), link);
				}
				if (mA.editItem(advs)) {
					response.sendRedirect(request.getContextPath() + "/admin/advs?emsg=1");
				} else {
					response.sendRedirect(request.getContextPath() + "/admin/editAdvs?msg=0");
				}
			} else {
				System.err.println("Form không thỏa mãn");
			}
		} else {
			request.setAttribute("oldAdvs", oldAdvs);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/editAdvs.jsp");
			rd.forward(request, response);
		}
	}

}
