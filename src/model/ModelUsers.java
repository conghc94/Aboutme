package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Users;
import library.LibaryConnectDatabase;

public class ModelUsers {
	private LibaryConnectDatabase db=new LibaryConnectDatabase();
	private Statement st;
	private ResultSet rs;
	private PreparedStatement pst;
	public int getToTal() {
		int total=0;
		String sql="Select count(id_user) as total from users";
		try {
			pst=db.getConnectMySQL().prepareStatement(sql);
			rs=pst.executeQuery();
			if(rs.next()){
				total=rs.getInt("total");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return total;
	}
	public ArrayList<Users> getListForPaginator(int offset, int row_count) {
		ArrayList<Users> alUsers=new ArrayList<>();
		Users user;
		String sql="SELECT * FROM users order by id_user desc LIMIT "+offset+","+row_count;
		try {
			pst=db.getConnectMySQL().prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				user=new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
				alUsers.add(user);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generatced catch block
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
		
		return alUsers;
	}
	public boolean checkUserName(String username) {
		boolean result=false;
		String sql="SELECT * FROM users WHERE username LIKE '"+username+"'";
		try {
			st=db.getConnectMySQL().createStatement();
			rs=st.executeQuery(sql);
			if(rs.next()){
				result=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return result;
	}
	public int addUsers(Users user) {
		int result=0;
		String query="INSERT INTO users(username,password,fullname) value(?,?,?) ";
		try {
			pst=db.getConnectMySQL().prepareStatement(query);
			pst.setString(1,user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setString(3,user.getFullname());
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
	public int  delUser(int idU) {
		
		int result=0;
		String sql="DELETE FROM users WHERE id_user=? LIMIT 1";
		try {
			pst=db.getConnectMySQL().prepareStatement(sql);
			pst.setInt(1,idU);
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
	public Users getListByItem(int uid) {
		Users objUser=null;	
		String sql="Select*from users where id_user=? LIMIT 1";
		try {
			pst=db.getConnectMySQL().prepareStatement(sql);
			pst.setInt(1, uid);
			rs=pst.executeQuery();
			if(rs.next()){
				objUser=new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
				
			}
		} catch (SQLException e) {
			
		
		}finally{
			try {
				rs.close();
				pst.close();
				db.closeDB();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	return objUser;
	}
	public int editItem(Users objUser) {
		int result=0;
		String sql="UPDATE users SET username=?, password=?, fullname=? WHERE id_user=? LIMIT 1" ;
		try {
			pst=db.getConnectMySQL().prepareStatement(sql);
			pst.setString(1, objUser.getUsername());
			pst.setString(2, objUser.getPassword());
			pst.setString(3,objUser.getFullname());
			pst.setInt(4, objUser.getIdUsers());
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
		}
		
		return result;
	}
	public Users checkLogin(String username, String password_new) {
		Users objUser = null;
		
		String query = "SELECT * FROM users WHERE username =? && password =? LIMIT 1";
		try {
			pst = db.getConnectMySQL().prepareStatement(query);
			pst.setString(1,username);
			pst.setString(2, password_new);
			rs = pst.executeQuery();
			if(rs.next()){
				objUser = new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		return objUser;
		
		
	}

}
