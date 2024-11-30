package JDBC_units;

import JDBC1.bean.Article;
import example.jdbc.dao.ArticalDao;
import example.jdbc.dao.Daointeface;

public class DeleteUsingDao {

	public static void main(String[] args) {
		Daointeface<Article,Integer> daoRef=new ArticalDao();
		daoRef.delete(1);

	}

}
