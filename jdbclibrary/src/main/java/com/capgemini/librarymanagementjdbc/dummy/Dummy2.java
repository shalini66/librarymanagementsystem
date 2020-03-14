package com.capgemini.librarymanagementjdbc.dummy;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import com.capgemini.librarymanagementjdbc.dto.AdminBean;

public class Dummy2 {
public static void main(String[] args) {
	try(FileInputStream	fin = new FileInputStream("dburl.properties")){

		Properties pro = new Properties();
		pro.load(fin);

		Class.forName(pro.getProperty("path")).newInstance();
		try(Connection conn = DriverManager.getConnection(pro.getProperty("dburl"),pro)){
			String query = "insert into admin values (?,?,?,?,?)";
			try(PreparedStatement pstmt = conn.prepareStatement(query)){
				AdminBean info = new AdminBean();
				pstmt.setInt(1, info.getAid());
				pstmt.setString(2, info.getAname());
				pstmt.setLong(3, info.getMobile());
				pstmt.setString(4, info.getEmail());
				pstmt.setString(5, info.getPassword());
				int count = pstmt.executeUpdate();
				System.out.println("no of rows afftected---"+count);
			
			}
		}

	}catch(Exception e) {
		e.printStackTrace();
	}
}
}
