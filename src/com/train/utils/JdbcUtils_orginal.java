package com.train.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils_orginal {

	// get Connection
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		// register driver
		Class.forName("com.mysql.jdbc.Driver");

		// Get Connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://10.49.89.108:3306/day06", "lvlu", "MyNewPass1!");

		return conn;
	}

	/**
	 * 
	 * @param conn Connection
	 * @param st Statement
	 * @param rs ResultSet
	 */
	public static void closeRescource(Connection conn, Statement st, ResultSet rs) {
		
		closeResultSet(rs);
		closeStatement(st);
		closeConnection(conn);

	}
	
	/**
	 * release Connection
	 * @param conn
	 */
	public static void closeConnection(Connection conn) {
		if(conn != null ) {
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
	 * @param st
	 */
	public static void closeStatement(Statement st) {
		if(st != null ) {
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
	 * @param rs
	 */
	public static void closeResultSet(ResultSet rs) {
		if(rs != null ) {
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
