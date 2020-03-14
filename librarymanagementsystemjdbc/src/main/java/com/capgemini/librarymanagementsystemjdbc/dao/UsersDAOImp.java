package com.capgemini.librarymanagementsystemjdbc.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Scanner;

import com.capgemini.librarymanagementsystemjdbc.dto.BookBean;
import com.capgemini.librarymanagementsystemjdbc.dto.UsersBean;
import com.capgemini.librarymanagementsystemjdbc.exception.AdminException;
import com.capgemini.librarymanagementsystemjdbc.factory.AdminFactory;
import com.capgemini.librarymanagementsystemjdbc.factory.StudentFactory;
import com.capgemini.librarymanagementsystemjdbc.service.AdminService;
import com.capgemini.librarymanagementsystemjdbc.service.StudentService;
import com.capgemini.librarymanagementsystemjdbc.service.StudentServiceImp;
import com.mysql.jdbc.Driver;

public class UsersDAOImp implements UsersDAO {

	@Override
	public boolean register(UsersBean info) {
		try (FileInputStream fin = new FileInputStream("dburl.properties")) {

			Properties pro = new Properties();
			pro.load(fin);

			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/library_management_system";
			try (Connection conn = DriverManager.getConnection(dburl, "root", "root")) {
				String query = "insert into users values(?,?,?,?,?,?)";
				try (PreparedStatement pstmt = conn.prepareStatement(query);) {
					pstmt.setInt(1, info.getId());
					pstmt.setString(2, info.getName());
					pstmt.setLong(3, info.getMobile());
					pstmt.setString(4, info.getEmail());
					pstmt.setString(5, info.getPassword());
					pstmt.setString(6, info.getRole());
					int count = pstmt.executeUpdate();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String auth(String email, String password) {
		Scanner scanner = new Scanner(System.in);
		try (FileInputStream fin = new FileInputStream("dburl.properties")) {
			Properties pro = new Properties();
			pro.load(fin);

			Class.forName(pro.getProperty("path")).newInstance();
			try (Connection conn = DriverManager.getConnection(pro.getProperty("dburl"), pro)) {
				String query = pro.getProperty("auth");
				try (PreparedStatement pstmt = conn.prepareStatement(query)) {
					pstmt.setString(1, email);
					pstmt.setString(2, password);

					ResultSet rs = pstmt.executeQuery();
					while(rs.next()) {
						String role =  rs.getString("role");
						if(role.equals("admin")) {
							AdminService service2 = AdminFactory.getAdminService();
							System.out.println("Press 1 to Add Books");
							System.out.println("Press 2 to update");
							System.out.println("Press 3 to Search the Book by bookName");
							System.out.println("Press 4 to Search the Book by author");
							System.out.println("Press 5 to Search the Book by Id");
							System.out.println("Press 6 to remove the Books");
							System.out.println("Press 7 to Get the Book Id's");
							System.out.println("Press 8 to Get the Book Information");
							System.out.println("Press 9 to main");
							int choice1 = scanner.nextInt();
							switch (choice1) {
							case 1:
								System.out.println("Enter ID");
								int bookId = scanner.nextInt();
								System.out.println("Enter Book Name");
								String bookName = scanner.next();
								System.out.println("Enter Author");
								String bookAuthor = scanner.next();
								System.out.println("Enter Category");
								String bookCategory = scanner.next();
								System.out.println("Enter Publisher Name");
								String bookPubName = scanner.next();

								BookBean bean2 = new BookBean();	
								bean2.setBname(bookName);
								bean2.setBid(bookId);
								bean2.setAuthor(bookAuthor);
								bean2.setCategory(bookCategory);
								bean2.setPublishername(bookPubName);
								boolean check2 = service2.addBook(bean2);
								if(check2) {
									System.out.println("Book already exist");
								} else {
									System.out.println("Book Added");
								}
								break;
							case 2:
								System.out.println("No implementation");
								break;
							case 3:
								System.out.println("Enter book Name");
								String bookName1 = scanner.next();
								BookBean bean3 = new BookBean();
								bean3.setBname(bookName1);
								BookBean list = service2.searchBookTitle(bookName1);
								if(list!=null) {
									System.out.println(list.getBid());
									System.out.println(list.getBname());
									System.out.println(list.getAuthor());
									System.out.println(list.getCategory());
									System.out.println(list.getPublishername());
									System.out.println(list);
								} else {
									System.out.println("Book Not Found");
								}
								break;
							case 4:
								System.out.println("Enter Book author");
								String author = scanner.next();
								BookBean bean4 = new BookBean();
								bean4.setAuthor(author);
								BookBean list1 = service2.searchBookAuthor(author);
								if(list1!=null) {
									System.out.println(list1.getBid());
									System.out.println(list1.getBname());
									System.out.println(list1.getAuthor());
									System.out.println(list1.getCategory());
									System.out.println(list1.getPublishername());
									System.out.println(list1);
								} else {
									System.out.println("Book Not Found");
								}
								break;
							case 5:
								System.out.println("Enter Book id");
								int id = scanner.nextInt();
								BookBean bean5 = new BookBean();
								bean5.setBid(id);
								BookBean list2 = service2.searchBookType(id);
								if(list2!=null) {
									System.out.println(list2.getBid());
									System.out.println(list2.getBname());
									System.out.println(list2.getAuthor());
									System.out.println(list2.getCategory());
									System.out.println(list2.getPublishername());
									System.out.println(list2);
								} else {
									System.out.println("Book Not Found");
								}
								break;
							case 6:
								System.out.println("Enter New Book Name to Update");
								String bname1 = scanner.next();
								System.out.println("Enter Book Name to Update");
								String bname2 = scanner.next();
								BookBean bean6 = new BookBean();
								bean6.setBname(bname1);
								bean6.setBname(bname2);
								boolean b = service2.updateBook(bean6);
								if(b) {
									System.out.println("Book Updated");
								} else {
									System.out.println("Book Not Update");
								}
							default:
								System.out.println("Invalid choice");
								break;
							} 
						}while(true);

					}

				} 
			}
			/*
			 * for(UsersBean bean : list) {
			 * 
			 * if(bean.getEmail().equals(email)&&bean.getPassword().equals(password)) {
			 * return rs.getString("role"); }
			 * 
			 * if(rs.getString("email").equals(email)&&rs.getString("password").equals(
			 * password)) { return rs.getString("role"); } } throw new
			 * AdminException("invalid email and password");
			 */
		}

	}
}
}

static boolean addBook(BookBean book) {
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

static BookBean searchBookTitle(String bname) {
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

				} else {
					System.out.println("book not found");
				}
			}
		}

	}catch(Exception e) {
		e.printStackTrace();
	}
	return bean;

}


static BookBean searchBookAuthor(String bAuthor) {
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

				} else {
					System.out.println("book not found");
				}
			}
		}

	}catch(Exception e) {
		e.printStackTrace();
	}
	return bean;

}


static BookBean searchBookType(int bookType) {
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

				} else {
					System.out.println("book not found");
				}
			}
		}

	}catch(Exception e) {
		e.printStackTrace();
	}
	return bean;

}


static boolean updateBook(BookBean bean) {

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

			}
		}
	} catch(Exception e) {
		e.printStackTrace();
	}
	return false;

}
}
