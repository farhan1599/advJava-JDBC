package demo.jdbc;

import java.sql.Connection;
import java.sql.Statement;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionPool_Demo {

	public static void main(String[] args) {
		DataSource dataSource = initializeDataSource();
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate("insert into ACCOUNT values(33003011,'Pawan',5100.0)");
			System.out.println("Row updated...");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	private static DataSource initializeDataSource() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:mysql://localhost:3306/test");
		config.setUsername("root");
		config.setPassword("farhanmySQL");
		config.setMaximumPoolSize(10);
		config.setMaxLifetime(60000);
		HikariDataSource dataSource = new HikariDataSource(config);
		return dataSource;
	}

}
