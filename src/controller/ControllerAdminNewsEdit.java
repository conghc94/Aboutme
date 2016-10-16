package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelCategory;
import model.ModelNews;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import bean.Category;
import bean.News;

/**
 * Servlet implementation class ControllerAdminNewsEdit
 */

public class ControllerAdminNewsEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAdminNewsEdit() {
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
		ModelNews mn = new ModelNews();
		ModelCategory mCat = new ModelCategory();
		ArrayList<Category> listCat = mCat.getListCat();
		request.setAttribute("listCat", listCat);
		int nid = Integer.parseInt(request.getParameter("nid"));
		News oldNews = mn.getItemById(nid);
		News news;
		ModelCategory mc = new ModelCategory();
		request.setAttribute("alCat", mc.getListCat());
		String name = "";
		String preview_text = "";
		String detail_text = "";
		int id_cat = 0;
		int is_active=0;
		String picture = "noImage.jpg";
		if (request.getParameter("delImage") != null) {
			if (!oldNews.getPicture().equals("noImage.jpg")) {
				Path path = Paths.get(request.getServletContext().getRealPath("") + File.separator + "files"
						+ File.separator + oldNews.getPicture());
				Files.delete(path);
				oldNews.setPicture(picture);
				mn.editItem(oldNews);
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
							case "preview_text":
								preview_text = fieldValue;
								break;
							case "detail_text":
								detail_text = fieldValue;
								break;
							case "id_cat":
								id_cat = Integer.parseInt(fieldValue);
								break;
							case "trangthai":
								is_active = Integer.parseInt(fieldValue);
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
					news = new News(nid, name, preview_text, detail_text, id_cat, picture,is_active,"");
					if (!"noImage.jpg".equals(oldNews.getPicture())) {
						Path path = Paths.get(request.getServletContext().getRealPath("") + File.separator + "files"
								+ File.separator + oldNews.getPicture());
						Files.delete(path);
						
					}
				} else {
					news = new News(nid, name, preview_text, detail_text, id_cat, oldNews.getPicture(),is_active,"");
				}

				if (mn.editItem(news)) {
					response.sendRedirect(request.getContextPath() + "/admin/news?emsg=1");
				} else {
					response.sendRedirect(request.getContextPath() + "/admin/editNews?msg=0");
				}
			} else {
				System.err.println("Form không thỏa mãn");
			}
		} else {
			request.setAttribute("objNews", oldNews);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/editNews.jsp");
			rd.forward(request, response);
		}
	}
	

}
