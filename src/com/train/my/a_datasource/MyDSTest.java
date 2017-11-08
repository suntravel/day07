package com.train.my.a_datasource;

import java.sql.Connection;

public class MyDSTest {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		MyDataSource ds = new MyDataSource();
		
		Connection conn=ds.getConnection();
		System.out.println(conn);
		
		ds.addBack(conn);
	}
}
