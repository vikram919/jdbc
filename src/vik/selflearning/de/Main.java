package vik.selflearning.de;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import vik.selflearning.tables.Tours;

public class Main {

	public static final String USERNAME = "dbuster";
	public static final String PASSWORD = "dbpassword";
	public static final String CONN_STRING = "jdbc:mysql://localhost/explorecalifornia";

	public static void main(String[] args) throws SQLException {

		try (Connection conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet resultSet = stmt.executeQuery("SELECT * FROM tours");) {
			/** scroll to the end of the rows*/
			resultSet.last();
			/** gets the index of the last row and get the index of the row*/
			System.out.println("Total no. of rows: " + resultSet.getRow());
			
			/**scroll again to the top of the rows*/
			resultSet.beforeFirst();
			Tours.displayData(resultSet);
		} catch (SQLException e) {
			processSQLError(e);
		}
	}

	public static void processSQLError(SQLException e) {
		System.err.println("Error message: " + e.getMessage());
		System.err.println("Error code: " + e.getErrorCode());
		System.err.println("SQL state: " + e.getSQLState());
	}

}
