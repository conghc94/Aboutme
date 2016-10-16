package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.LibaryConnectDatabase;
import bean.News;

public class ModelNews {
	private LibaryConnectDatabase db=new LibaryConnectDatabase();
	private PreparedStatement pst;
	private ResultSet rs;
	private Statement st;
	
	public int getTotal() {
		int total=0;
		String sql="Select count(id_news) as total from news inner join category USING(id_cat)";
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

	public ArrayList<News> getListForPaginator(int offset, int row_count) {
		ArrayList<News> alNews=new ArrayList<>();
		News objNews;
		String sql=" SELECT id_news ,n.name,preview_text,detail_text, id_cat,picture,is_active,c.name from news as n "
					+"inner join category c using(id_cat)"
					+"order by id_news desc LIMIT "+offset+","+row_count;
					
		try {
			st=db.getConnectMySQL().createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				objNews =new News(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getString(8));
				alNews.add(objNews);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				st.close();
				db.closeDB();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return alNews;
	}

	public ArrayList<News> searchName(String searchName, String searchDM,
			String searchActive, int offset, int row_count) {
		//System.out.println(searchName+":"+searchDM+":"+searchActive+":"+offset+":"+row_count);
		ArrayList<News> alNews=new ArrayList<>();
		String sql=" SELECT id_news ,n.name,preview_text,detail_text, id_cat,picture,is_active,c.name from news as n "
				+"inner join category c using(id_cat) where 1";
		if(!searchName.equals("")){
			sql+=" AND n.name like '%"+searchName+"%'";
		}
		if(!searchDM.equals("")){
			sql+=" AND c.id_cat ="+searchDM;
		}
		if(!searchActive.equals("")){
			sql+=" AND n.is_active ="+searchActive;
		}
		sql+=" order by id_news desc LIMIT "+offset+","+row_count;
		//System.out.println(sql);
		News objNews;
					
		try {
			st=db.getConnectMySQL().createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				objNews =new News(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getString(8));
				alNews.add(objNews);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				st.close();
				db.closeDB();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return alNews;
	}

	public int getTotalSearch(String searchName, String searchDM,
			String searchActive) {
		
		int total=0;
		String sql="SELECT COUNT(id_news)as total from news as n "
				+"inner join category c using(id_cat) where 1";
		if(!searchName.equals("")){
			sql+=" AND n.name like '%"+searchName+"%'";
		}
		if(!searchDM.equals("")){
			sql+=" AND c.id_cat ="+searchDM;
		}
		if(!searchActive.equals("")){
			sql+=" AND n.is_active ="+searchActive;
		}
		System.out.println(sql);
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

	public void setActive(int id_news, int is_active) {
		String query = "UPDATE news SET is_active = ? WHERE id_news = ?";
		PreparedStatement pst;
		try {
			pst = db.getConnectMySQL().prepareStatement(query);
			if (is_active == 1) {
				pst.setInt(1, 0);
			} else {
				pst.setInt(1, 1);
			}
			pst.setInt(2, id_news);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public int getListNewsActive(int id_news) {
		int result=0;
		String sql="SELECT is_active from news where id_news="+id_news+" LIMIT 1";
		try {
			st=db.getConnectMySQL().createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				result=rs.getInt("is_active");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public boolean addItem(News news) {
		boolean result=false;
		String sql="INSERT INTO news(name,preview_text,detail_text,id_cat,picture,is_active) values(?,?,?,?,?,?)";
		try {
			pst=db.getConnectMySQL().prepareStatement(sql);
			pst.setString(1, news.getName());
			pst.setString(2,news.getPreview_text());
			pst.setString(3, news.getDetail_text());
			pst.setInt(4,news.getIdCat() );
			pst.setString(5,news.getPicture());
			pst.setInt(6,news.getIsActive());
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

	public int delNews(int nid) {
		int result=0;
		String sql="DELETE FROM news WHERE id_news=? LIMIT 1";
		try {
			pst=db.getConnectMySQL().prepareStatement(sql);
			pst.setInt(1,nid);
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

	public News getItemById(int nid) {
		News objItem=null;		
		String sql=" SELECT id_news ,c.name,preview_text,detail_text, id_cat,picture,is_active,n.name from news as n "
				+"inner join category as c using(id_cat) "
				+"where id_news=?"
				+" order by id_news desc";
		try {
			pst=db.getConnectMySQL().prepareStatement(sql);
			pst.setInt(1, nid);
			rs=pst.executeQuery();
			//System.out.println(sql);
			if(rs.next()){
				objItem=new News(nid,rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getString(8));
				
			}
		} catch (SQLException e) {
			
		
		}finally{
			try {
				
				pst.close();
				db.closeDB();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return objItem ;
	}

	public boolean editItem(News objNews) {
		boolean result=false;
		String sql="INSERT INTO news(name,preview_text,detail_text,id_cat,picture,is_active) values(?,?,?,?,?,?)";
		try {
			pst=db.getConnectMySQL().prepareStatement(sql);
			pst.setString(1, objNews.getName());
			pst.setString(2,objNews.getPreview_text());
			pst.setString(3, objNews.getDetail_text());
			pst.setInt(4,objNews.getIdCat() );
			pst.setString(5,objNews.getPicture());
			pst.setInt(6,objNews.getIsActive());
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

	public boolean delListIdDelete(String[] listIdDelete) {
		String sq="";
		//lấy danh sách id cần xóa
		if(listIdDelete.length==1){
			sq=listIdDelete[0];
		}else{
			for(int i=0;i<listIdDelete.length-1;i++){
				sq+=listIdDelete[i]+",";
			}
			sq+=listIdDelete[listIdDelete.length-1];
		}
		String sql="DELETE FROM news WHERE id_news IN ("+sq+")";
		//System.out.println(sql);
		int delete=0;
		try {
			st=db.getConnectMySQL().createStatement();
			delete=st.executeUpdate(sql);
			db.closeDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return delete!=0;
	}

	public ArrayList<News> getListNews(int offset, int row_count, int iCat) {
		ArrayList<News> alNews=new ArrayList<>();
		News objNews;
		String sql=" SELECT id_news ,n.name,preview_text,detail_text, n.id_cat,picture,is_active,c.name from news as n "
					+"inner join category c using(id_cat)"
					+" WHERE n.id_cat="+iCat+" AND is_active=1 order by id_news desc LIMIT "+offset+","+row_count;
					
		try {
			st=db.getConnectMySQL().createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				objNews =new News(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getString(8));
				alNews.add(objNews);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				st.close();
				db.closeDB();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return alNews;
	}
	public News getListDetail(int nid) {
		News objNews=null;
		String sql="SELECT * FROM news WHERE id_news=? LIMIT 1";
		
		try {
			pst=db.getConnectMySQL().prepareStatement(sql);
			pst.setInt(1, nid);
			rs=pst.executeQuery();
			System.out.println(sql);
			while(rs.next()){
				objNews=new News(nid, rs.getString(2), rs.getString(3),rs.getString(4),rs.getInt(5), rs.getString(6),rs.getInt(7),"");	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return objNews;
		
	}

	public ArrayList<News> getItemDetail(int nid, int idCat) {
		ArrayList<News> alNews=new ArrayList<>();
		News objNews;
		String sql=" SELECT id_news ,n.name,preview_text,detail_text, id_cat,picture,is_active,c.name from news as n inner join category c using(id_cat) WHERE n.id_news!="+nid+" && n.id_cat="+idCat+" order by id_news desc LIMIT 3";
		try {
			st=db.getConnectMySQL().createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()){
				objNews=new News(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getInt(5), rs.getString(6),rs.getInt(7),"");	
				alNews.add(objNews);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				st.close();
				db.closeDB();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return alNews;
	}
		
	

}
