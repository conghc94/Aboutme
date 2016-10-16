package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import library.LibaryConnectDatabase;
import bean.Contact;

public class ModelContact {
 private LibaryConnectDatabase db=new LibaryConnectDatabase();
 
 private ResultSet rs;
 private PreparedStatement pst;
	public int getToTal() {
		int total=0;
		String sql="SELECT COUNT(id_contact)as total from contact ";
		try {
			pst=db.getConnectMySQL().prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				total=rs.getInt("total");
			}
		} catch (SQLException e) {
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
	public ArrayList<Contact> getListForPaginator(int offset, int row_count) {
		ArrayList<Contact> alContact=new ArrayList<>();
		Contact contact;
		String sql="SELECT * FROM contact order by id_contact desc LIMIT "+offset+","+row_count;
		try {
			pst=db.getConnectMySQL().prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				contact=new Contact(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(6));
				alContact.add(contact);
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
		
		return alContact;
	}
	public int addContact(Contact contact) {
		int result=0;
		String sql="INSERT INTO contact(fullname,email,address,phone,content) values(?,?,?,?,?)";
		try {
			pst=db.getConnectMySQL().prepareStatement(sql);
			pst.setString(1,contact.getFullname());
			pst.setString(2,contact.getEmail());
			pst.setString(3, contact.getAddress());
			pst.setString(4,contact.getPhone());
			pst.setString(5,contact.getContent());
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
	public int delContact(int idC) {
		int result=0;
		String sql="DELETE FROM contact WHERE id_contact=? LIMIT 1";
		try {
			pst=db.getConnectMySQL().prepareStatement(sql);
			pst.setInt(1,idC);
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
	public int editContact(Contact objContact) {
		int result=0;
		String sql="UPDATE contact SET fullname=? ,email=?,address=?,phone=?,content=? where id_contact=? LIMIT 1";
		try {
			pst=db.getConnectMySQL().prepareStatement(sql);
			pst.setString(1,objContact.getFullname());
			pst.setString(2,objContact.getEmail());
			pst.setString(3,objContact.getAddress());
			pst.setString(4,objContact.getPhone());
			pst.setString(5,objContact.getContent());
			pst.setInt(6,objContact.getIdContact());
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
	public Contact getIdContact(int idC) {
		Contact contact=null;
		String sql="SELECT * FROM contact WHERE id_contact=? LIMIT 1";
		try {
			pst=db.getConnectMySQL().prepareStatement(sql);
			pst.setInt(1,idC);
			rs=pst.executeQuery();
			while(rs.next()){
				contact=new Contact(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
				
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
		
		return contact;
	}

}
