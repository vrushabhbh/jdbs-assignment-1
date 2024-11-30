package example.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import JDBC1.bean.Article;
import JDBC_units.JdbcUtils;

public class ArticalDao implements Daointeface<Article, Integer> {

	@Override
	public Collection<Article> retrieveAll() {
		Collection<Article> allArticles = new ArrayList<Article>();
		String sqlQuery="select * from article_master";
		try(Connection conn=JdbcUtils.getConnection();
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(sqlQuery);
				){
			while(rs.next()) {
				 int id=rs.getInt(1);
				 String name =rs.getString(2);
				 String category =rs.getString(3);
				 String datecreated=rs.getString(4);
				 String creatorName=rs.getString(5); 
				 Article at=new Article(id, name, category, datecreated, creatorName);
				 allArticles.add(at);
			}
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return allArticles;
	}

	@Override
	public void Create(Article newArticles) {
		String sqlQuery="Insert into article_master values(?,?,?,?,?)";
		try (Connection conn = JdbcUtils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sqlQuery)){
			 int id=newArticles.getId();
			 String name =newArticles.getName();
			 String category =newArticles.getCategory();
			 String datecreated=newArticles.getDatecreated();
			 String creatorName=newArticles.getCreatorName(); 
			 
			 pstmt.setInt(1, id);
			 pstmt.setString(2, name);
			 pstmt.setString(3, category);
			 pstmt.setString(4, datecreated);
			 pstmt.setString(5, creatorName);
			 int updateCount=pstmt.executeUpdate();
			 System.out.println(updateCount+"record inserted");
		}catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void delete(Integer id) {
		String sqlQuery=
				"delete from article_master where id=?";
		try (Connection conn = JdbcUtils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sqlQuery)){
				pstmt.setInt(1,id);
				int deleteCount=pstmt.executeUpdate();
				System.out.println(deleteCount+"record deleted");
		}catch(Exception Ex){
			Ex.printStackTrace();
		}
		
	}

	@Override
	public void update(Article modifiedArticle) {
		String sqlQuery=
				"Update article_master set name=?,category=?,datecreated=?,creatorName=? where id=?";
		try (Connection conn = JdbcUtils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sqlQuery)){
			 int id=modifiedArticle.getId();
			 String name =modifiedArticle.getName();
			 String category =modifiedArticle.getCategory();
			 String datecreated=modifiedArticle.getDatecreated();
			 String creatorName=modifiedArticle.getCreatorName(); 
			 
			 pstmt.setInt(5, id);
			 pstmt.setString(1, name);
			 pstmt.setString(2, category);
			 pstmt.setString(3, datecreated);
			 pstmt.setString(4, creatorName);
			 
			 int updateCount=pstmt.executeUpdate();
			 System.out.println(updateCount+"record updated");
			 
		}catch(Exception Ex){
			Ex.printStackTrace();
		}
		
		
	}

	@Override
	public Article retrieveOne(Integer Key) {
		Article foundarticle=null;
		String sqlQuery="select * from article_master where id=?";
		try (Connection conn = JdbcUtils.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
				){
			pstmt.setInt(1, Key);
			ResultSet rst=pstmt.executeQuery();
			if(rst.next())
			{
				 int id=rst.getInt(1);
				 String name =rst.getString(2);
				 String category =rst.getString(3);
				 String datecreated=rst.getString(4);
				 String creatorName=rst.getString(5);
				 foundarticle=new Article(id, name, category, datecreated, creatorName);
			}
		}catch(Exception Ex) {
			Ex.printStackTrace();
		}
		
		return  foundarticle;
	}
}



