package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.LibaryConnectDatabase;
import bean.Category;

public class ModelCategory {
	private LibaryConnectDatabase db=new LibaryConnectDatabase();
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	public ArrayList<Category> getListCat() {
		ArrayList<Category> alCat=new ArrayList<>();
		Category cat;
		String sql="SELECT * FROM category ";
		try {
			st=db.getConnectMySQL().createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				cat=new Category(rs.getInt(1),rs.getString(2));
				alCat.add(cat);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return alCat;
	}
	public int addCat(Category cat) {
		int result=0;
		String query="INSERT INTO category(name) value(?) ";
		try {
			pst=db.getConnectMySQL().prepareStatement(query);
			pst.setString(1,cat.getName());
			pst.executeUpdate();
			result=1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
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
	public int delCat(int idC) {
		int result=0;
		String sql="DELETE FROM category WHERE id_cat=?";
		try {
			pst=db.getConnectMySQL().prepareStatement(sql);
			pst.setInt(1, idC);
			pst.executeUpdate();
			result=1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			db.closeDB();
		}
		
		return result;
	}
	public boolean checkName(String username) {
		boolean kq=false;
		String sql="SELECT * FROM category WHERE name LIKE '"+username+"'";
		try {

			System.out.println(username);
			st = db.getConnectMySQL().createStatement();
			rs=st.executeQuery(sql);
			if(rs.next()){
				kq=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				db.closeDB();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(kq);
		return kq;
	}
	public Category getIdCat(int idC) {
		Category cat=null;
		String sql="SELECT * FROM category WHERE id_cat= "+idC;
		try {
			st=db.getConnectMySQL().createStatement();
			rs=st.executeQuery(sql);
			if(rs.next()){
				cat=new Category(rs.getInt(1),rs.getString(2));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				st.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return cat;
	}
	public int editCat(Category cat) {
		int result=0;
		String sql="UPDATE category SET name=? WHERE id_cat=? LIMIT 1";
		
		try {
			pst=db.getConnectMySQL().prepareStatement(sql);
			pst.setString(1,cat.getName());
			pst.setInt(2,cat.getIdCat());
			pst.executeUpdate();
			result=1;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
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
	public int getToTal() {
		int total=0;
		String sql="Select count(id_cat) as total from category";
		try {
			pst=db.getConnectMySQL().prepareStatement(sql);
			rs=pst.executeQuery();
			if(rs.next()){
				total=rs.getInt("total");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return total;
	}
	public ArrayList<Category> getListForPaginator(int offset, int row_count) {
		ArrayList<Category> alCat=new ArrayList<>();
		Category cat;
		String sql="SELECT * FROM category order by id_cat desc LIMIT "+offset+","+row_count;
		try {
			pst=db.getConnectMySQL().prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				cat=new Category(rs.getInt(1),rs.getString(2));
				alCat.add(cat);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return alCat;
		
	}
	
}
