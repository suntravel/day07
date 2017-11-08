package com.train.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class JdbcUtils {

	static final String DRIVECLASS;
	static final String URL;
	static final String USER;
	static final String PASSWORD;

	// Static Block
	static {
		// Resource Bundle
		ResourceBundle myResource = ResourceBundle.getBundle("jdbc");

		DRIVECLASS = myResource.getString("driverClass");
		URL = myResource.getString("url");
		USER = myResource.getString("user");
		PASSWORD = myResource.getString("password");
	}

	static {
		// register driver
		try {
			Class.forName(DRIVECLASS);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// get Connection
	public static Connection getConnection() throws SQLException {

		// Get Connection
		return DriverManager.getConnection(URL, USER, PASSWORD);

	}

	/**
	 * 
	 * @param conn
	 *            Connection
	 * @param st
	 *            Statement
	 * @param rs
	 *            ResultSet
	 */
	public static void closeRescource(Connection conn, Statement st, ResultSet rs) {

		closeResultSet(rs);
		closeStatement(st);
		closeConnection(conn);

	}

	/**
	 * release Connection
	 * 
	 * @param conn
	 */
	public static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			conn = null;
		}
	}

	/**
	 * Release Statement
	 * 
	 * @param st
	 */
	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			st = null;
		}
	}

	/**
	 * Release ResultSet
	 * 
	 * @param rs
	 */
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			rs = null;
		}
	}

}
