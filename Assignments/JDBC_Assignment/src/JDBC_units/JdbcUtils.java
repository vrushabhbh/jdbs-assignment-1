package JDBC_units;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtils {

	public static Connection getConnection()throws Exception {
		String url="jdbc:mysql://localhost:3306/article_master";
		String uid="root";
		String pwd="password";
		Connection  dbConnection=DriverManager.getConnection(url,uid,pwd);
		return dbConnection;

	}

}
