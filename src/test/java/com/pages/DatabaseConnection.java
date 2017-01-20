package com.pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
	
	public static Connection conn;
	public static ResultSet rs;
	
	public static void createconnection() throws Exception{

	
	//Creating a connection to the database
	 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
	 conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-7OHELTQ\\SQLEXPRESS;databaseName=TestingDB;integratedSecurity=true");
	
	}

	public static void executeqry() throws SQLException
	{
	//Executing SQL query and fetching the result
	Statement st = conn.createStatement();
	String sqlStr = "select * from product_detail";
	rs = st.executeQuery(sqlStr);
	
	}
	
	public static String increment1() throws Exception
	{
		rs.next();
		return rs.getString("Product_id");
	}
}
