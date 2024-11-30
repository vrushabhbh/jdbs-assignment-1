package JDBC_units;

import JDBC1.bean.Article;
import example.jdbc.dao.ArticalDao;
import example.jdbc.dao.Daointeface;

public class CreateUsingDao {

	public static void main(String[] args) {
		Daointeface<Article,Integer> daoRef=new ArticalDao();
		Article at=new Article(4, "vaishnavi", "painting","2024-04-18","bhoi");
 	     daoRef.Create(at);

	}

}
