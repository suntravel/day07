package com.jdbc.train;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

//import com.mysql.jdbc.Driver;
import com.train.utils.JdbcUtils;

//import com.mysql.jdbc.Connection;

public class HelloJdbc {
	
	@Test
	public void f1() {
		System.out.println("Hello World!");
	}
	
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void f2() throws Exception{
		
		//register driver
		Class.forName("com.mysql.jdbc.Driver");//加载类到内存中，使得static块能够运行一次
		//DriverManager.registerDriver(new Driver());
		
		//Get Connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://10.49.89.108:3306/day06", "lvlu", "MyNewPass1!");
		
		//Write SQL Statement
		String sql = "select * from category;";
		
		PreparedStatement st = conn.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getString("cid")+":"+rs.getString("cname"));
		}
		
		rs.close();
		st.close();
		conn.close();
	}
	
	@Test
	public void f3() {
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtils.getConnection();
			
			String sql = "insert into category value(?,?);";
			
			st = conn.prepareStatement(sql);
			
			st.setString(1, "c007");
			st.setString(2, "LucaTest");
			
			int i = st.executeUpdate();
			
			if(i==1) {
				System.out.println("Success");
			}else {
				System.out.println("Failed");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.closeRescource(conn, st, rs);
		}
				
	}
	
	@Test
	public void f4() {
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			conn=JdbcUtils.getConnection();
			
			String sql = "update category set cname = ? where cid = ?";
			st = conn.prepareStatement(sql);
			st.setString(1, "LucaTest1");
			st.setString(2, "c006");
			
			int i = st.executeUpdate();
			
			if(i==1) {
				System.out.println("scuccess");
			}else {
				System.out.println("failed");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.closeRescource(conn, st, rs);
		}
		
	}


}
