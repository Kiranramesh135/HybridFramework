package com.hybridframework.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DbReader {

	public static final String DB_URL = "jdbc:postgresql://localhost:5432/TestDb";
	public static final String UNAME = "postgres";
	public static final String PWD = "12345";

	public static Object[][] readDB() {

		Object[][] data = null;
		int columnCount = 0;
		int rowCount = 0;
		int count = 0;

		try {
			Connection conn = DriverManager.getConnection(DB_URL, UNAME, PWD);
			Statement stmt = conn.createStatement();
			String sql1 = "SELECT COUNT(*) FROM userdetail";
			String sql2 = "SELECT * FROM userdetail ORDER BY empname;";

			// to get the number of entries present in the table
			ResultSet rs = stmt.executeQuery(sql1);
			rs.next();
			rowCount = Integer.parseInt(rs.getString(1));
			System.out.println("Row count = " + rowCount);

			// to get all the data present in the table
			rs = stmt.executeQuery(sql2);
			ResultSetMetaData metaData = rs.getMetaData();
			columnCount = metaData.getColumnCount();
			System.out.println("Column count = " + columnCount);
			data = new Object[rowCount][columnCount];

			while (rs.next()) {

				for (int i = 0; i < columnCount; i++) {

					data[count][i] = rs.getString(i + 1);

				}
				count++;
				System.out.println();

			}

		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}

		return data;
	}

}
