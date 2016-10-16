package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.LibaryConnectDatabase;
import bean.Advs;

public class ModelAdvs {
	private Statement st;
	private LibaryConnectDatabase db=new LibaryConnectDatabase();
	private PreparedStatement pst;
	private ResultSet rs;
	public int getToTal() {
		int total=0;
		String sql="Select count(id_advs) as total from advs";
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

	public ArrayList<Advs> getListForPaginator(int offset, int row_count) {
		ArrayList<Advs> alAdvs=new ArrayList<>();
		Advs objAdvs;
		String sql="SELECT * FROM advs order by id_advs desc LIMIT "+offset+","+row_count;
		try {
			pst=db.getConnectMySQL().prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				objAdvs=new Advs(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4));
				alAdvs.add(objAdvs);
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
		
		
		return alAdvs;
	}

	public boolean checkName(String name) {
		boolean kq=false;
		String sql="SELECT * FROM advs WHERE name LIKE '"+name+"'";
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
				rs.close();
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(kq);
		
		return false;
	}

	public boolean addItem(Advs advs) {
		boolean result=false;
		String sql="INSERT INTO advs (name,banner,link) values (?,?,?) ";
		try {
			pst=db.getConnectMySQL().prepareStatement(sql);
			pst.setString(1,advs.getName());
			pst.setString(2,advs.getBanner());
			pst.setString(3,advs.getLink());
			pst.executeUpdate();
			result=true;
			
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

	public int delAdvs(int idA) {
		int result=0;
		String sql="DELETE FROM advs WHERE id_advs=? LIMIT 1";
		try {
			pst=db.getConnectMySQL().prepareStatement(sql);
			pst.setInt(1, idA);
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

	public Advs getItemById(int idA) {
		Advs advs=null;
		String sql="SELECT * FROM advs WHERE id_advs="+idA;
		
		try {
			st=db.getConnectMySQL().createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				advs=new Advs(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
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
		return advs;
	}

	public boolean editItem(Advs oldAdvs) {
		// TODO Auto-generated method stub
		boolean result = false;
		
		String query = "UPDATE advs SET name =?,banner =?,link=? WHERE id_advs =? LIMIT 1";
		try {
			pst = db.getConnectMySQL().prepareStatement(query);
			pst.setString(1, oldAdvs.getName());
			pst.setString(2, oldAdvs.getBanner());
			pst.setString(3, oldAdvs.getLink());
			pst.setInt(4,oldAdvs.getId_advs());
			pst.executeUpdate();
			result =true;
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

	public ArrayList<Advs> getListAdvs() {
		ArrayList<Advs> alAdvs=new ArrayList<>();
		Advs alAd=null;
		String sql="SELECT * FROM advs order by Rand() DESC LIMIT 2";
		
		try {
			pst=db.getConnectMySQL().prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				alAd=new Advs(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4));
				alAdvs.add(alAd);
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
		return alAdvs;
	}

}
