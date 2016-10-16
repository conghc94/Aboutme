package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Project;
import library.LibaryConnectDatabase;

public class ModelProject {
	private LibaryConnectDatabase db = new LibaryConnectDatabase();
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;

	public int getToTal() {
		int total = 0;
		String sql = "Select count(id_project) as total from projects";
		try {
			pst = db.getConnectMySQL().prepareStatement(sql);
			rs = pst.executeQuery();
			if (rs.next()) {
				total = rs.getInt("total");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return total;
	}

	public ArrayList<Project> getListForPaginator(int offset, int row_count) {
		ArrayList<Project> alProject = new ArrayList<>();
		Project project;
		String sql = "SELECT * FROM projects order by id_project desc LIMIT " + offset + "," + row_count;
		try {
			pst = db.getConnectMySQL().prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				project = new Project(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				alProject.add(project);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return alProject;
	}

	public boolean addItem(Project project) {
		boolean result = false;
		String sql = "INSERT INTO projects (name,preview_text,picture,link) values (?,?,?,?) ";
		try {
			pst = db.getConnectMySQL().prepareStatement(sql);
			pst.setString(1, project.getName());
			pst.setString(2, project.getPreview_text());
			pst.setString(3, project.getPicture());
			pst.setString(4, project.getLink());
			pst.executeUpdate();
			result = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				db.closeDB();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public boolean checkName(String name) {

		boolean kq = false;
		String sql = "SELECT * FROM projects WHERE name LIKE '" + name + "'";
		try {
			// pst=db.getConnectMySQL().prepareStatement(sql);
			// pst.setString(1, name);
			// rs=pst.executeQuery();
			System.out.println(name);
			st = db.getConnectMySQL().createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				kq = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(kq);
		return kq;

	}

	public int delProject(int idP) {
		int result = 0;
		String sql = "DELETE FROM projects WHERE id_project=? LIMIT 1";
		try {
			pst = db.getConnectMySQL().prepareStatement(sql);
			pst.setInt(1, idP);
			pst.executeUpdate();
			result = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				db.closeDB();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return result;
	}

	public Project getItemById(int idP) {
		Project project = null;
		String sql = "SELECT * FROM projects WHERE id_project=" + idP;

		try {
			st = db.getConnectMySQL().createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				project = new Project(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				db.closeDB();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return project;
	}

	public boolean editItem(Project oldNews) {

		boolean result = false;

		String query = "UPDATE projects SET name =?, preview_text =?,picture =?,link=? WHERE id_project =? LIMIT 1";
		try {
			pst = db.getConnectMySQL().prepareStatement(query);
			pst.setString(1, oldNews.getName());
			pst.setString(2, oldNews.getPreview_text());
			pst.setString(3, oldNews.getPicture());
			pst.setString(4, oldNews.getLink());
			pst.setInt(5, oldNews.getId_project());
			pst.executeUpdate();

			result = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				db.closeDB();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public ArrayList<Project> getListProject() {
		ArrayList<Project> alProject = new ArrayList<>();
		Project project;
		String sql = "SELECT * FROM projects";
		try {
			pst = db.getConnectMySQL().prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				project = new Project(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				alProject.add(project);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return alProject;
	}
}
