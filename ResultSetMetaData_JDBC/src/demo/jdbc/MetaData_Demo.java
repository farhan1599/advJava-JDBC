package demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MetaData_Demo {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String username = "system";
		String password = "farhanSQL";
		Connection connection = null;
		Statement statement = null;

		try {
			connection = DriverManager.getConnection(url, username, password);
			statement = connection.createStatement();
			String query = "select *from emp";
			ResultSet resultSet = statement.executeQuery(query);
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			int columnsCount = resultSetMetaData.getColumnCount();
			for (int index = 1; index <= columnsCount; index++) {
				System.out.println("column number :" + index);
				System.out.println("column name :" + resultSetMetaData.getColumnName(index));
				System.out.println("column type :" + resultSetMetaData.getColumnTypeName(index));
				System.out.println("column size :" + resultSetMetaData.getColumnDisplaySize(index));
				System.out.println("=========================================");
			}
			resultSet.close();

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
