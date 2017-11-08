package com.train.my.a_datasource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

import com.train.utils.JdbcUtils;

public class MyDataSource {
	
	static LinkedList<Connection> pool = new LinkedList<>();
	static {
		for(int i=0; i<3; i++) {
			try {
				Connection conn = JdbcUtils.getConnection();
				pool.addLast(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static Connection getConnection() {
		
		if(pool.isEmpty()) {
			for(int i=0; i<3; i++) {
				try {
					Connection conn = JdbcUtils.getConnection();
					pool.addLast(conn);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		System.out.println("get a Connection from Pool");
		
		return pool.removeFirst();
	}
	
	public static void addBack(Connection conn) {
		pool.addLast(conn);
		System.out.println("Return a Connection to Pool");
	}

}
