package com.web.testing.SatTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseUtils {

	public String dbURL;
	public String dbUser;
	public String dbPassword;
	public Connection connect;
	public int totalRows;

	public DataBaseUtils(String dbURL, String dbUser, String dbPassword) throws SQLException {
		this.dbURL = dbURL;
		this.dbUser = dbUser;
		this.dbPassword = dbPassword;
	}

	public Connection doConnectToDatabase()
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		connect = DriverManager.getConnection(dbURL, dbUser, dbPassword);
		return connect;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public Object[][] executeReadQuery(String query, boolean... optionalFlag) throws SQLException {
		Statement statement = connect.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		int columnCount = resultSet.getMetaData().getColumnCount();
		resultSet.last();
		int rowCount = resultSet.getRow();
		resultSet.beforeFirst();
		Object[][] mydata = new Object[rowCount][columnCount];
		int rowNumber = 0;
		while (resultSet.next()) {
			System.out.println("\n Row: " + rowNumber);
			for (int i = 0; i < columnCount; i++) {
				mydata[rowNumber][i] = resultSet.getString(i + 1);
				if(optionalFlag.length == 0) {
					System.out.println("[" + rowNumber + "]" + "[" + i + "] - [ " + resultSet.getString(i + 1) + " ]");
				}
			}
			rowNumber++;

		}
		totalRows = mydata.length;
		return mydata;
	}

	public void executeUpdateQuery(String query) throws SQLException {
		Statement statement = connect.createStatement();
		statement.executeQuery(query);
	}

	public void closeConnection() throws SQLException {
		connect.close();

	}

}
