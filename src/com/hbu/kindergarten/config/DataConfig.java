package com.hbu.kindergarten.config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DataConfig {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	static {
		InputStream input = DataConfig.class.getClassLoader().getResourceAsStream("data.properties");
		Properties prop = new Properties();
		try {
			prop.load(input);
		} catch (IOException e) {
			System.out.println("数据库配置文件加载失败");
			e.printStackTrace();
		}
		driver = "com.mysql.cj.jdbc.Driver";
		url = prop.getProperty("url");
		user = prop.getProperty("user");
		password = prop.getProperty("password");
		try {
			Class.forName(driver);
			System.out.println("数据库配置完成");
		} catch (ClassNotFoundException e) {
			System.out.println("数据库配置失败");
		}

	}

	public static Connection getConn() {
		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static void main(String[] args) {
		System.out.println(url + user + password);
		Connection conn = getConn();
		String sql="select * from role";
		try {
			Statement statement = conn.createStatement();
			  ResultSet rs = statement.executeQuery(sql);
			  while (rs.next()) {
				System.out.println(rs.getString("roleName"));
				
			}
			  rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}
}
