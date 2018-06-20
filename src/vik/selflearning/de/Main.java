package vik.selflearning.de;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static final String USERNAME = "dbuster";
	public static final String PASSWORD = "dbpassword";
	public static final String CONN_STRING = "jdbc:mysql://localhost/explorecalifornia";

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		try {
			conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			resultSet = stmt.executeQuery("SELECT * FROM states");

			resultSet.last();
			System.out.println("Total no. of rows: " + resultSet.getRow());
		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			if (resultSet != null) {
				resultSet.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}

}
