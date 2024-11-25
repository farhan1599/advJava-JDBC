package demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update_Emp {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String username = "system";
		String password = "farhanSQL";
		Connection connection = null;
		Statement statement = null;

		try {
			connection = DriverManager.getConnection(url, username, password);
			statement = connection.createStatement();
			String query = "update emp set ename='Sam',sal=4600.0 where empno=7653";
			int count = statement.executeUpdate(query);
			System.out.println(count + " rows updated");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
