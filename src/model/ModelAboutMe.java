package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import library.LibaryConnectDatabase;
import bean.AboutMe;

public class ModelAboutMe {
	private LibaryConnectDatabase db=new LibaryConnectDatabase();
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public AboutMe getListAboutMe() {
		
		AboutMe aboutme=null;
		String sql="Select*from aboutme";
		try {
			st=db.getConnectMySQL().createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				aboutme=new AboutMe(rs.getInt(1), rs.getString(2),rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			try {
				st.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	return aboutme;
	}
	public int editAboutMe(AboutMe aboutMe) {
		int result=0;
		String sql="UPDATE aboutme set name=?,detail_text=? WHERE id_aboutme=? LIMIT 1";
		try {
			pst=db.getConnectMySQL().prepareStatement(sql);
			
			pst.setString(1,aboutMe.getName() );
			pst.setString(2, aboutMe.getDetailText());
			pst.setInt(3,aboutMe.getIdAboutMe());
			
			pst.executeUpdate();
			result=1;
		} catch (SQLException e) {
		}finally{
			try {
				pst.close();
				db.closeDB();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
