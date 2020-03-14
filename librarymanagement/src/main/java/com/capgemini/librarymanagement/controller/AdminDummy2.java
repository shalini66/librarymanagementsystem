package com.capgemini.librarymanagement.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.librarymanagement.dto.AdminBean;
import com.capgemini.librarymanagement.dto.BookBean;
import com.capgemini.librarymanagement.dto.StudentBean;
import com.capgemini.librarymanagement.factory.AdminFactory;
import com.capgemini.librarymanagement.factory.StudentFactory;
import com.capgemini.librarymanagement.service.AdminService;
import com.capgemini.librarymanagement.service.StudentService;

public class AdminDummy2 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		do{
		System.out.println("Enter 1 to admin");
		System.out.println("Enter 2 to student");
		
		int a = scanner.nextInt();
		switch (a) {
		case 1:
			doReg();
			break;
		case 2:
			doStu();
		
		default:
			System.out.println("Enter Valid Choice");
			break;
		}
	}while(true);

	}

	public static void doReg() {
		Scanner scanner = new Scanner(System.in);
		AdminService service = AdminFactory.getAdminService();
		do{
			System.out.println("Press 1 to Admin Register");
			System.out.println("Press 2 to Login");
			System.out.println("Press 3 to exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter ID");
				int regID = scanner.nextInt();
				System.out.println("Enter Name");
				String regName = scanner.next();
				System.out.println("Enter Mobile");
				long regMobile = scanner.nextLong();
				System.out.println("Enter Email");
				String regEmail = scanner.next();
				System.out.println("Enter Password");
				String regPassword = scanner.next();
				String regRole = "Admin";
				AdminBean bean = new AdminBean();
				bean.setAid(regID);
				bean.setAname(regName);
				bean.setMobile(regMobile);
				bean.setEmail(regEmail);
				bean.setPassword(regPassword);
				boolean check = service.register(bean);
				if(check) {
					System.out.println("Registered");
				} else {
					System.out.println("Email already exist");
				}	

				break;

			case 2:
				System.out.println("Enter email");
				String email = scanner.next();
				System.out.println("Enter Password");
				String password = scanner.next();
				try {
					AdminBean authBean = service.auth(email, password);
					System.out.println("Logged in");
					//Book Info write in service and imp
					do{
					System.out.println("Press 1 to Add Books");
					System.out.println("Press 2 to update");
					System.out.println("Press 3 to Search the Book by Author");
					System.out.println("Press 4 to Search the Book by Title");
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
						bean2.setId(bookId);	
						bean2.setName(bookName);
						bean2.setCategory(bookCategory);
						bean2.setAuthor(bookAuthor);
						bean2.setPublishername(bookPubName);
						boolean check2 = service.addBook(bean2);
						if(check2) {
							System.out.println("Book Added");
						} else {
							System.out.println("Book already exist");
						}
						break;
		
					case 2:
						System.out.println("Enter the updated id :");
						int bid= scanner.nextInt();

						BookBean bean3 = new BookBean();
						bean3.setId(bid);
						int updated = service.updateBook(bid);
						if (updated != 0) {
							System.out.println("Book is updated");
						} else {
							System.out.println("Book is not updated");
						}
						break;
					case 3:
						System.out.println("Search the book by the Author Name:");
						String author = scanner.next();

						BookBean bean4 = new BookBean();
						bean4.setAuthor(author);
						List<BookBean> bookauthor = service.searchBookAuthor(author);
						for (BookBean bookBean : bookauthor) {

							if (bookBean != null) {
								System.out.println("Book_Id is-->"+bookBean.getId()
								+"Book_Name is-->"+bookBean.getName()
								+"Book_Author is-->"+bookBean.getAuthor()
								+"Book_Category is-->"+bookBean.getCategory()
								+"Book_PublisherName is-->"+bookBean.getPublishername());
							} else {
								System.out.println("No books are available written by this author");
							}
						}
						break;
					case 4:
						System.out.println("  Search the book by the Book_Title :");
						String btitle = scanner.next();

						BookBean bean5 = new BookBean();
						bean5.setAuthor(btitle);
						List<BookBean> booktitle = service.searchBookAuthor(btitle);
						for (BookBean bookBean : booktitle) {	
							if (bookBean != null) {
								System.out.println("Book_Id is-->"+bookBean.getId()
								+"Book_Name is-->"+bookBean.getName()
								+"Book_Author is-->"+bookBean.getAuthor()
								+"Book_Category is-->"+bookBean.getCategory()
								+"Book_PublisherName is-->"+bookBean.getPublishername());
							} else {
								System.out.println("No books are available with this title.");
							}
						}
						break;
					case 5:
						System.out.println("Search the book by the Book_Id's :");
						String bids = scanner.next();

						BookBean bean6 = new BookBean();
						bean6.setAuthor(bids);
						List<BookBean> bookIds = service.searchBookAuthor(bids);
						for (BookBean bookBean : bookIds) {
							if (bookBean != null) {
								System.out.println("Book_Id is-->"+bookBean.getId()
								+"Book_Name is-->"+bookBean.getName()
								+"Book_Author is-->"+bookBean.getAuthor()
								+"Book_Category is-->"+bookBean.getCategory()
								+"Book_PublisherName is-->"+bookBean.getPublishername());
							} else {
								System.out.println("No books are available with this Id.");
							}
						}
						break;
					case 6:
						System.out.println("Enter the book_Id:");
						int book_Id = scanner.nextInt();
						if (book_Id == 0) {
							System.out.println("Enter the Valid Book_Id");
						} else {
							BookBean bean7 = new BookBean();
							bean7.setId(book_Id);
							boolean remove = service.removeBook(book_Id);
							if (remove) {
								System.out.println("The Book is removed");
							} else {
								System.out.println("The Book is not removed");
							}
						}
						break;
					case 7:
						LinkedList<Integer> ids = service.getBookIds();
						for (Integer integer : ids) {

							if (integer != null) {
								System.out.println(integer);
							} else {
								System.out.println("No Books Ids are available");
							}
						}
						break;
					case 8:
						LinkedList<BookBean> info = service.getBooksInfo();
						for (BookBean bookBean : info) {

							if (bookBean != null) {
								System.out.println(bookBean);
							} else {
								System.out.println("Books info is not presernt");
							}
						}
						break;
					case 9:
						doReg();

					default:
						System.out.println("Invalid Choice");
						break;
					}
				
				}while(true);
			}catch (Exception e) {
					System.out.println("Invalid Credentials");
				}

				break;
			case 3:
				doReg();
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
		} while(true);

	}


	public static void doStu(){
		Scanner scanner = new Scanner(System.in);
		StudentService service1 = StudentFactory.getStudentService();
		do {
			System.out.println("Press 1 to Student Register");
			System.out.println("Press 2 to Login");
			System.out.println("3 to main");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter ID");
				String regID = scanner.next();
				System.out.println("Enter Name");
				String regName = scanner.next();
				System.out.println("Enter Mobile");
				long regMobile = scanner.nextLong();
				System.out.println("Enter Email");
				String regEmail = scanner.next();
				System.out.println("Enter Password");
				String regPassword = scanner.next();

				StudentBean bean = new StudentBean();
				bean.setId(regID);
				bean.setName(regName);
				bean.setMobile(regMobile);
				bean.setEmail(regEmail);
				bean.setPassword(regPassword);
				boolean check = service1.register(bean);
				if(check) {
					System.out.println("Registered");
				} else {
					System.out.println("Email already exist");
				}
				break;
			case 2:
				System.out.println("Enter email");
				String email = scanner.next();
				System.out.println("Enter Password");
				String password = scanner.next();
				try {
					StudentBean studentBean = service1.auth(email, password);
					System.out.println("Logged in");

					System.out.println("Press 1 to Search the Book by Author");
					System.out.println("Press 2 to Search the Book by Title");
					System.out.println("Press 3 to Search the Book by Id");
					System.out.println("Press 4 to Get the Book Id's");
					System.out.println("Press 5 to Get the Book Information");
					System.out.println("Press 6 to main");
					int choice2 = scanner.nextInt();
					switch (choice2) {
					case 1:
						System.out.println("Search the book by the Author Name :");
						String author = scanner.next();

						BookBean bean3 = new BookBean();
						bean3.setAuthor(author);
						List<BookBean> bookauthor = service1.searchBookAuthor(author);
						for (BookBean bookBean : bookauthor) {

							if (bookBean != null) {
								System.out.println("Book_Id is-->"+bookBean.getId()
								+"Book_Name is-->"+bookBean.getName()
								+"Book_Author is-->"+bookBean.getAuthor()
								+"Book_Category is-->"+bookBean.getCategory()
								+"Book_PublisherName is-->"+bookBean.getPublishername());
							} else {
								System.out.println("No books are available written by this author");
							}
						}
						break;
					case 2:
						System.out.println("Search the book by the Book_Title :");
						String btitle = scanner.next();

						BookBean bean4 = new BookBean();
						bean4.setAuthor(btitle);
						List<BookBean> booktitle = service1.searchBookAuthor(btitle);
						for (BookBean bookBean : booktitle) {	
							if (bookBean != null) {
								System.out.println("Book_Id is-->"+bookBean.getId()
								+"Book_Name is-->"+bookBean.getName()
								+"Book_Author is-->"+bookBean.getAuthor()
								+"Book_Category is-->"+bookBean.getCategory()
								+"Book_PublisherName is-->"+bookBean.getPublishername());
							} else {
								System.out.println("No books are available with this title.");
							}
						}
						break;
					case 3:
						System.out.println("  Search the book by the Book_Id's :");
						String bids = scanner.next();

						BookBean bean5 = new BookBean();
						bean5.setAuthor(bids);
						List<BookBean> bookIds = service1.searchBookAuthor(bids);
						for (BookBean bookBean : bookIds) {
							if (bookBean != null) {
								System.out.println("Book_Id is-->"+bookBean.getId()
								+"Book_Name is-->"+bookBean.getName()
								+"Book_Author is-->"+bookBean.getAuthor()
								+"Book_Category is-->"+bookBean.getCategory()
								+"Book_PublisherName is-->"+bookBean.getPublishername());
							} else {
								System.out.println("No books are available with this Id.");
							}
						}
						break;
					case 4:
						LinkedList<Integer> ids = service1.getBookIds();
						for (Integer integer : ids) {

							if (integer != null) {
								System.out.println(integer);
							} else {
								System.out.println("No Books Ids are available");
							}
						}
						break;
					case 5:
						LinkedList<BookBean> info = service1.getBooksInfo();
						for (BookBean bookBean : info) {

							if (bookBean != null) {
								System.out.println(bookBean);
							} else {
								System.out.println("Books info is not presernt");
							}
						}
						break;
					case 6:
						doReg();
					default:
						System.out.println("Invalid Choice");
						break;
					}
				} catch (Exception e) {
					System.out.println("Invalid Credentials");
				}
				break;

			case 3:
				doReg();
			default:
				System.out.println("Invalid Choice");
				break;
			}
		} while(true);
	}
}


