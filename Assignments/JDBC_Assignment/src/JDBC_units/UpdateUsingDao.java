package JDBC_units;

import JDBC1.bean.Article;
import example.jdbc.dao.ArticalDao;
import example.jdbc.dao.Daointeface;

public class UpdateUsingDao {

	public static void main(String[] args) {
		Daointeface<Article,Integer> daoRef=new ArticalDao();
		Article at= daoRef. retrieveOne(3);
		at.setName("Sid");
		at.setCategory("sculpture");
		at.setDatecreated("2025-08-12");
		at.setCreatorName("Sahil");
		daoRef.update(at);
	}

}
