package JDBC_units;

import java.util.Collection;

import JDBC1.bean.Article;
import example.jdbc.dao.ArticalDao;
import example.jdbc.dao.Daointeface;

public class RetriveAllUsingDau {
	public static void main(String[] args) {
		Daointeface<Article,Integer> daoRef=new ArticalDao();
		Collection <Article> allavailablearticles=daoRef.retrieveAll();
		for (Article currentArticle:allavailablearticles)
			System.out.println(currentArticle);
	}

}
