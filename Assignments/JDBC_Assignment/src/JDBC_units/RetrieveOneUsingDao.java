package JDBC_units;

import JDBC1.bean.Article;
import example.jdbc.dao.ArticalDao;
import example.jdbc.dao.Daointeface;

public class RetrieveOneUsingDao {

	public static void main(String[] args) {
		Daointeface<Article,Integer> daoRef=new ArticalDao();
		Article Articleobj=daoRef.retrieveOne(3);
		 if(Articleobj!=null)
  		   System.out.println(Articleobj);
  	   else
  		   System.out.println("Article with given Key does not exist");
	}
	}

