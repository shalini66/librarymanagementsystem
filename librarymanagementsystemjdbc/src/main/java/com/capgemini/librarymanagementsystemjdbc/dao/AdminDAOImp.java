package com.capgemini.librarymanagementsystemjdbc.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import com.capgemini.librarymanagementsystemjdbc.exception.AdminException;
import com.capgemini.librarymanagementsystemjdbc.dto.AdminBean;
import com.capgemini.librarymanagementsystemjdbc.dto.BookBean;

public class AdminDAOImp implements AdminDAO{

//	@Override
//	public boolean register(AdminBean info) {
//		try(FileInputStream	fin = new FileInputStream("dburl.properties")){
//
//			Properties pro = new Properties();
//			pro.load(fin);
//
//			Class.forName(pro.getProperty("path")).newInstance();
//			try(Connection conn = DriverManager.getConnection(pro.getProperty("dburl"), pro)){
//				String query = pro.getProperty("register_admin");
//				try(PreparedStatement pstmt = conn.prepareStatement(query)){
//					pstmt.setString(1, info.getAname());
//					pstmt.setInt(2, info.getAid());
//					pstmt.setLong(3, info.getMobile());
//					pstmt.setString(4, info.getEmail());
//					pstmt.setString(5, info.getPassword());
//					int count = pstmt.executeUpdate();
//				}
//			}
//
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return false;
//
//	}

//	@Override
//	public AdminBean auth(String email, String password) {
//		AdminBean bean = new AdminBean();
//
//		try(FileInputStream fin = new FileInputStream("dburl.properties")){
//			Properties pro = new Properties();
//			pro.load(fin);
//
//			Class.forName(pro.getProperty("path")).newInstance();
//			try(Connection conn = DriverManager.getConnection(pro.getProperty("dburl"), pro)){
//				String query = pro.getProperty("auth_admin");
//				try(PreparedStatement pstmt = conn.prepareStatement(query)){ 
//					pstmt.setString(1, email);
//					pstmt.setString(2, password); 
//
//					ResultSet rs = pstmt.executeQuery();
//					
//					if(rs.next()) {
//						if(rs.equals(bean.getEmail().equals(email)&&bean.getPassword().equals(password))/*bean2.contains(email.equals(email)) && password.equals(password)*//*bean.getEmail().equals(email)&&bean.getPassword().equals(password)*//*bean2.contains(bean.getEmail().equals(email)&&bean.getPassword().equals(password))*/){
//							System.out.println("login successful");
//							return bean;
//						}
//					}
//					throw new AdminException("invalid email and password");	
//				} 
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return bean;
//	}

	@Override
	public boolean addBook(BookBean book) {
		try(FileInputStream	fin = new FileInputStream("dburl.properties")){

			Properties pro = new Properties();
			pro.load(fin);

			Class.forName(pro.getProperty("path")).newInstance();
			try(Connection conn = DriverManager.getConnection(pro.getProperty("dburl"), pro)){
				String query = pro.getProperty("add_book");
				try(PreparedStatement pstmt = conn.prepareStatement(query)){
					pstmt.setString(1, book.getBname());
					pstmt.setInt(2, book.getBid());
					pstmt.setString(3, book.getAuthor());
					pstmt.setString(4, book.getCategory());
					pstmt.setString(5, book.getPublishername());
					int count = pstmt.executeUpdate();
				}
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public BookBean searchBookTitle(String bname) {
		BookBean bean = new BookBean();
		try(FileInputStream	fin = new FileInputStream("dburl.properties")){

			Properties pro = new Properties();
			pro.load(fin);

			Class.forName(pro.getProperty("path")).newInstance();
			try(Connection conn = DriverManager.getConnection(pro.getProperty("dburl"), pro)){
				String query = pro.getProperty("search_book_name");
				try(PreparedStatement pstmt = conn.prepareStatement(query)){
					pstmt.setString(1, bname);
					ResultSet rs = pstmt.executeQuery();
					if(rs.next()) {	
						bean.setBid(rs.getInt("bid"));
						bean.setBname(rs.getString("bname"));
						bean.setAuthor(rs.getString("author"));
						bean.setCategory(rs.getString("category"));
						bean.setPublishername(rs.getString("publishername"));
						return bean;
					} else {
						System.out.println("book not found");
					}
				}
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public BookBean searchBookAuthor(String bAuthor) {
		BookBean bean = new BookBean();
		try(FileInputStream	fin = new FileInputStream("dburl.properties")){

			Properties pro = new Properties();
			pro.load(fin);

			Class.forName(pro.getProperty("path")).newInstance();
			try(Connection conn = DriverManager.getConnection(pro.getProperty("dburl"), pro)){
				String query = pro.getProperty("search_book_author");
				try(PreparedStatement pstmt = conn.prepareStatement(query)){
					pstmt.setString(1, bAuthor);
					ResultSet rs = pstmt.executeQuery();
					if(rs.next()) {	
						bean.setBid(rs.getInt("bid"));
						bean.setBname(rs.getString("bname"));
						bean.setAuthor(rs.getString("author"));
						bean.setCategory(rs.getString("category"));
						bean.setPublishername(rs.getString("publishername"));
						return bean;
					} else {
						System.out.println("book not found");
					}
				}
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public BookBean searchBookType(int bookType) {
		BookBean bean = new BookBean();
		try(FileInputStream	fin = new FileInputStream("dburl.properties")){

			Properties pro = new Properties();
			pro.load(fin);

			Class.forName(pro.getProperty("path")).newInstance();
			try(Connection conn = DriverManager.getConnection(pro.getProperty("dburl"), pro)){
				String query = pro.getProperty("search_book_id");
				try(PreparedStatement pstmt = conn.prepareStatement(query)){
					pstmt.setInt(1, bookType);
					ResultSet rs = pstmt.executeQuery();
					if(rs.next()) {	
						bean.setBid(rs.getInt("bid"));
						bean.setBname(rs.getString("bname"));
						bean.setAuthor(rs.getString("author"));
						bean.setCategory(rs.getString("category"));
						bean.setPublishername(rs.getString("publishername"));
						return bean;
					} else {
						System.out.println("book not found");
					}
				}
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateBook(BookBean bean) {

		try(FileInputStream fin = new FileInputStream("dburl.properties")){

			Properties pro = new Properties(); pro.load(fin);

			//Class.forName(pro.getProperty("path")).newInstance();
			Class.forName("com.mysql.jdbc.Driver").newInstance(); String dburl=
					"jdbc:mysql://localhost:3306/library_management_system?user=root&password=root";
			try(Connection conn = DriverManager.getConnection(dburl)){
				/* String query ="update book set bname='chemistry' where bname=?"; */ 
				String query ="update book set bname=? where bname=?";
				try(PreparedStatement pstmt = conn.prepareStatement(query)){ 
					pstmt.setString(1, bean.getBname());
					pstmt.setString(2, bean.getBname());
					int rs = pstmt.executeUpdate();	
					if (rs != 0) {
						return true;
					} else {
						return false;
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean removeBook(int bid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LinkedList<Integer> getBookIds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<BookBean> getBooksInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean issueBook(int bid) {
		// TODO Auto-generated method stub
		return false;
	}

}
