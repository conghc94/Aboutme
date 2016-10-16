package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.LibaryConnectDatabase;
import bean.Saying;

public class ModelSaying {
	private LibaryConnectDatabase db=new LibaryConnectDatabase();
	private Statement st;
	private ResultSet rs;
	private PreparedStatement pst;
	public int getToTal() {
		int total=0;
		String sql="SELECT COUNT(id_saying) as total FROM saying";
		try {
			pst=db.getConnectMySQL().prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				total=rs.getInt("total");
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
		return total;
	}
	public ArrayList<Saying> getListForPaginator(int offset, int row_count) {
		ArrayList<Saying> alSaying=new ArrayList<>();
		Saying objSaying;
		String sql="SELECT * FROM saying order by id_saying desc LIMIT "+offset+","+row_count;
		try {
			pst=db.getConnectMySQL().prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				objSaying=new Saying(rs.getInt(1),rs.getString(2),rs.getString(3));
				alSaying.add(objSaying);
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
		return alSaying;
	}
	public boolean checkSaying(String content) {
		boolean kq=false;
		String sql="SELECT * FROM saying WHERE content LIKE '"+content+"'";
		try {
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
		
		return kq;
	}
	public int addSaying(Saying objSaying) {
		int result=0;
		String sql="INSERT INTO saying(content,author) values(?,?)";
		try {
			pst=db.getConnectMySQL().prepareStatement(sql);
			pst.setString(1,objSaying.getContent());
			pst.setString(2,objSaying.getAuthor());
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
	public int delSaying(int idS) {
		int result=0;
		String sql="DELETE FROM saying WHERE id_saying=? LIMIT 1";
		try {
			pst=db.getConnectMySQL().prepareStatement(sql);
			pst.setInt(1,idS);
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
	public int editContact(Saying objSaying) {
		int result=0;
		String sql="UPDATE saying SET content=?,author=? where id_saying=? LIMIT 1";
		try {
			pst=db.getConnectMySQL().prepareStatement(sql);
			pst.setString(1,objSaying.getContent());
			pst.setString(2,objSaying.getAuthor());
			pst.setInt(3,objSaying.getIdSaying());
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
	public Saying getIdContact(int idS) {
		Saying saying=null;
		String sql="SELECT * FROM saying WHERE id_saying=? LIMIT 1";
		try {
			pst=db.getConnectMySQL().prepareStatement(sql);
			pst.setInt(1,idS);
			rs=pst.executeQuery();
			while(rs.next()){
				saying=new Saying(rs.getInt(1),rs.getString(2),rs.getString(3));
				
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
		
		return saying;
	}
	public ArrayList<Saying> getListSaying() {
		ArrayList<Saying> alSaying=new ArrayList<>();
		Saying saying;
		String sql="SELECT * FROM saying order by Rand() DESC LIMIT 3 ";
		try {
			pst=db.getConnectMySQL().prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				saying=new Saying(rs.getInt(1),rs.getString(2),rs.getString(3));
				alSaying.add(saying);
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
		return alSaying;
	}

}
