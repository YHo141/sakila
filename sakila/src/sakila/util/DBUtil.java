package sakila.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	public Connection getConnection() throws Exception{
		final String URL="jdbc:mariadb://localhost:3306/sakila";
		final String USER = "root";
		final String PASSWORD = "java1004";
		
		Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
		conn.setAutoCommit(false);
		
		return conn;
	}
}
