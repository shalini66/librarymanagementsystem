package com.capgemini.librarymanagement.controller;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.librarymanagement.dto.AdminBean;
import com.capgemini.librarymanagement.dto.BookBean;
import com.capgemini.librarymanagement.dto.StudentBean;
import com.capgemini.librarymanagement.exception.ValidationException;
import com.capgemini.librarymanagement.factory.AdminFactory;
import com.capgemini.librarymanagement.factory.StudentFactory;
import com.capgemini.librarymanagement.service.AdminService;
import com.capgemini.librarymanagement.service.StudentService;
import com.capgemini.librarymanagement.validation.ValidationAdminStudent;

public class TestProject {
	private static long regMobile;

	public static void main(String[] args) {
		doReg();
	}

	public static void doReg() {

		boolean flag = false;

		int regId = 0; 
		String regName = "aaa"; 
		String mobile = "7330083533";
		String email1 = "shalini606@gmail.com";
		String password1 = "123456789";



		ValidationAdminStudent validation = new ValidationAdminStudent();

		Scanner scanner = new Scanner(System.in);

		do {
			System.out.println("Press 1 to Admin");
			System.out.println("Press 2 to Student");

			int i = scanner.nextInt();
			switch(i) {
			case 1:
				AdminService service = AdminFactory.getAdminService();
				do{
					System.out.println("Press 1 to Admin Register");
					System.out.println("Press 2 to Login");
					System.out.println("Press 3 to exit");
					int choice = scanner.nextInt();
					switch (choice) {
					case 1:
						do {
							try {
								System.out.println("Enter ID :");
								int regId1 = scanner.nextInt();
								validation.validatedId(regId1);
								flag = true;
							} catch (InputMismatchException e) {
								flag = false;
								System.err.println("Id should contains only digits");
							} catch (ValidationException e) {
								flag = false;
								System.err.println(e.getMessage());
							}
						} while (!flag);



						do {
							try {
								System.out.println("Enter Name :");
								String regName1 = scanner.next();
								validation.validatedName(regName1);
								flag = true;
							} catch (InputMismatchException e) {
								flag = false;
								System.err.println("Name should contains only Alphabates");
							} catch (ValidationException e) {
								flag = false;
								System.err.println(e.getMessage());
							}
						} while (!flag);



						do {
							try {
								System.out.println("Enter Mobile :");
								String regMobile = scanner.next();
								validation.validatedMobile(regMobile);
								flag = true;
							} catch (InputMismatchException e) {
								flag = false;
								System.err.println("Mobile Number  should contains only numbers");
							} catch (ValidationException e) {
								flag = false;
								System.err.println(e.getMessage());
							}
						} while (!flag);



						do {
							try {
								System.out.println("Enter Email :");
								String regEmail = scanner.next();
								validation.validatedEmail(regEmail);
								flag = true;
							} catch (InputMismatchException e) {
								flag = false;
								System.err.println("Email should be proper ");
							} catch (ValidationException e) {
								flag = false;
								System.err.println(e.getMessage());
							}
						} while (!flag);



						do {
							try {
								System.out.println("Enter Password :");
								String regPassword = scanner.next();
								validation.validatedPassword(regPassword);
								flag = true;
							} catch (InputMismatchException e) {
								flag = false;
								System.err.println("Enter correct Password ");
							} catch (ValidationException e) {
								flag = false;
								System.err.println(e.getMessage());
							}
						} while (!flag);

						AdminBean bean = new AdminBean();
						bean.setAid(regId);
						bean.setAname(regName);
						bean.setMobile(regMobile);
						bean.setEmail(email1);
						bean.setPassword(password1);

						boolean check = service.register(bean);
						if(check) {
							System.out.println("Registered");
						} else {
							System.out.println("Email already exist");
						}	

						break;

					case 2:
						System.out.println("Enter email :");
						String email = scanner.next();
						System.out.println("Enter Password :");
						String password = scanner.next();
						try {
							AdminBean authBean = service.auth(email1, password1);
							System.out.println("Logged in");

							do {
							System.out.println("Press 1 to Add Books");
							System.out.println("Press 2 to update");
							System.out.println("Press 3 to Search the Book by Author");
							System.out.println("Press 4 to Search the Book by Title");
							System.out.println("Press 5 to Search the Book by Id");
							System.out.println("Press 6 to remove the Books");
							System.out.println("Press 7 to Get the Book Id's");
							System.out.println("Press 8 to Get the Book Information");
							System.out.println("Press 9 to Issue the Book");
							System.out.println("Press 10 to main");

							int choice1 = scanner.nextInt();
							switch (choice1) {
							case 1:
								System.out.println("Enter ID :");
								int bookId = scanner.nextInt();
								System.out.println("Enter Book Name :");
								String bookName = scanner.next();
								System.out.println("Enter Author :");
								String bookAuthor = scanner.next();
								System.out.println("Enter Category :");
								String bookCategory = scanner.next();
								System.out.println("Enter Publisher Name :");
								String bookPublisher = scanner.next();

								BookBean bean1 = new BookBean();
								bean1.setId(bookId);	
								bean1.setName(bookName);
								bean1.setCategory(bookCategory);
								bean1.setAuthor(bookAuthor);
								bean1.setPublishername(bookPublisher);

								boolean check2 = service.addBook(bean1);
								if(check2) {
									System.out.println("Book Added");
								} else {
									System.out.println("Book already exist");
								}
								break;
							case 2:
								System.out.println("Enter the updated id :");
								int bid= scanner.nextInt();

								BookBean bean2 = new BookBean();
								bean2.setId(bid);
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

								BookBean bean3 = new BookBean();
								bean3.setAuthor(author);
								List<BookBean> bookauthor = service.searchBookAuthor(author);
								for (BookBean bookBean : bookauthor) {

									if (bookBean != null) {
										System.out.println("Book_Id is-->"+bookBean.getId());
										System.out.println("Book_Name is-->"+bookBean.getName());
										System.out.println("Book_Author is-->"+bookBean.getAuthor());
										System.out.println("Book_Category is-->"+bookBean.getCategory());
										System.out.println("Book_PublisherName is-->"+bookBean.getPublishername());
									} else {
										System.out.println("No books are available written by this author");
									}
								}
								break;
							case 4:
								System.out.println("  Search the book by the Book_Title :");
								String btitle = scanner.next();

								BookBean bean4 = new BookBean();
								bean4.setAuthor(btitle);
								List<BookBean> booktitle = service.searchBookAuthor(btitle);
								for (BookBean bookBean : booktitle) {	
									if (bookBean != null) {
										System.out.println("Book_Id is-->"+bookBean.getId());
										System.out.println("Book_Name is-->"+bookBean.getName());
										System.out.println("Book_Author is-->"+bookBean.getAuthor());
										System.out.println("Book_Category is-->"+bookBean.getCategory());
										System.out.println("Book_PublisherName is-->"+bookBean.getPublishername());
									} else {
										System.out.println("No books are available with this title.");
									}
								}
								break;
							case 5:
								System.out.println("Search the book by the Book_Id's :");
								String bids = scanner.next();

								BookBean bean5 = new BookBean();
								bean5.setAuthor(bids);
								List<BookBean> bookIds = service.searchBookAuthor(bids);
								for (BookBean bookBean : bookIds) {
									if (bookBean != null) {
										System.out.println("Book_Id is-->"+bookBean.getId());
										System.out.println("Book_Name is-->"+bookBean.getName());
										System.out.println("Book_Author is-->"+bookBean.getAuthor());
										System.out.println("Book_Category is-->"+bookBean.getCategory());
										System.out.println("Book_PublisherName is-->"+bookBean.getPublishername());
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
									BookBean bean6 = new BookBean();
									bean6.setId(book_Id);
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
								System.out.println("Enter Book_ID :");
								int iId = scanner.nextInt();
								BookBean bean9 = new BookBean();
								bean9.setId(iId);
								boolean check3 = service.issueBook(iId);
								if (check3) {
									System.out.println("Book Issued");
								} else {
									System.out.println("Book is not Issued");
								}
								break;
							case 10:
								doReg();
							default:
								System.out.println("Invalid Choice");
								break;
							}
						}while(true);
					} catch (Exception e) {
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

			case 2:
				StudentService service1 = StudentFactory.getStudentService();
				do {
					System.out.println("Press 1 to Student Register");
					System.out.println("Press 2 to Student Login");
					System.out.println("3 to main");
					int choice = scanner.nextInt();
					switch (choice) {
					case 1:
						do {
							try {
								System.out.println("Enter ID :");
								int regS_Id1 = scanner.nextInt();
								validation.validatedId(regS_Id1);
								flag = true;
							} catch (InputMismatchException e) {
								flag = false;
								System.err.println("Id should contains only digits");
							} catch (ValidationException e) {
								flag = false;
								System.err.println(e.getMessage());
							}
						} while (!flag);




						do {
							try {
								System.out.println("Enter Name :");
								String regS_Name1 = scanner.next();
								validation.validatedName(regS_Name1);
								flag = true;
							} catch (InputMismatchException e) {
								flag = false;
								System.err.println("Name should contains only Alphabates");
							} catch (ValidationException e) {
								flag = false;
								System.err.println(e.getMessage());
							}
						} while (!flag);


						do {
							try {
								System.out.println("Enter Mobile :");
								String regMobile = scanner.next();
								validation.validatedMobile(regMobile);
								flag = true;
							} catch (InputMismatchException e) {
								flag = false;
								System.err.println("Mobile Number  should contains only numbers");
							} catch (ValidationException e) {
								flag = false;
								System.err.println(e.getMessage());
							}
						} while (!flag);


						do {
							try {
								System.out.println("Enter Email :");
								String regEmail = scanner.next();
								validation.validatedEmail(regEmail);
								flag = true;
							} catch (InputMismatchException e) {
								flag = false;
								System.err.println("Email should be proper ");
							} catch (ValidationException e) {
								flag = false;
								System.err.println(e.getMessage());
							}
						} while (!flag);
						
						do {
							try {
								System.out.println("Enter Password :");
								String regPassword = scanner.next();
								validation.validatedPassword(regPassword);
								flag = true;
							} catch (InputMismatchException e) {
								flag = false;
								System.err.println("Enter correct Password ");
							} catch (ValidationException e) {
								flag = false;
								System.err.println(e.getMessage());
							}
						} while (!flag);

						StudentBean bean1 = new StudentBean();
						//bean1.setId(regId);
						bean1.setName(regName);
						bean1.setMobile(regMobile);
						bean1.setEmail(email1);
						bean1.setPassword(password1);

						boolean check = service1.register(bean1);
						if(check) {
							System.out.println("Registered");
						} else {
							System.out.println("Email already exist");
						}
						break;
					case 2:
						System.out.println("Enter email :");
						String email = scanner.next();
						System.out.println("Enter Password :");
						String password = scanner.next();
						try {
							StudentBean studentBean = service1.auth(email1, password1);
							System.out.println("Logged in");

							System.out.println("Press 1 to Search the Book by Author");
							System.out.println("Press 2 to Search the Book by Title");
							System.out.println("Press 3 to Search the Book by Id");
							System.out.println("Press 4 to Get the Book Id's");
							System.out.println("Press 5 to Get the Book Information");
							System.out.println("Press 6 to Request the Book");
							System.out.println("Press 7 to Return the Book");
							System.out.println("Press 8 to main");
							int choice2 = scanner.nextInt();
							switch (choice2) {
							case 1:
								System.out.println("Search the book by the Author Name :");
								String author = scanner.next();

								BookBean bean2 = new BookBean();
								bean2.setAuthor(author);
								List<BookBean> bookauthor = service1.searchBookAuthor(author);
								for (BookBean bookBean : bookauthor) {

									if (bookBean != null) {
										System.out.println("Book_Id is-->"+bookBean.getId());
										System.out.println("Book_Name is-->"+bookBean.getName());
										System.out.println("Book_Author is-->"+bookBean.getAuthor());
										System.out.println("Book_Category is-->"+bookBean.getCategory());
										System.out.println("Book_PublisherName is-->"+bookBean.getPublishername());
									} else {
										System.out.println("No books are available written by this author");
									}
								}
								break;
							case 2:
								System.out.println("Search the book by the Book_Title :");
								String btitle = scanner.next();

								BookBean bean3 = new BookBean();
								bean3.setAuthor(btitle);
								List<BookBean> booktitle = service1.searchBookAuthor(btitle);
								for (BookBean bookBean : booktitle) {	
									if (bookBean != null) {
										System.out.println("Book_Id is-->"+bookBean.getId());
										System.out.println("Book_Name is-->"+bookBean.getName());
										System.out.println("Book_Author is-->"+bookBean.getAuthor());
										System.out.println("Book_Category is-->"+bookBean.getCategory());
										System.out.println("Book_PublisherName is-->"+bookBean.getPublishername());
									} else {
										System.out.println("No books are available with this title.");
									}
								}
								break;
							case 3:
								System.out.println("  Search the book by the Book_Id's :");
								String bids = scanner.next();

								BookBean bean4 = new BookBean();
								bean4.setAuthor(bids);
								List<BookBean> bookIds = service1.searchBookAuthor(bids);
								for (BookBean bookBean : bookIds) {
									if (bookBean != null) {
										System.out.println("Book_Id is-->"+bookBean.getId());
										System.out.println("Book_Name is-->"+bookBean.getName());
										System.out.println("Book_Author is-->"+bookBean.getAuthor());
										System.out.println("Book_Category is-->"+bookBean.getCategory());
										System.out.println("Book_PublisherName is-->"+bookBean.getPublishername());
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
								System.out.println("Enter the Book Requested_id :");
								int reqId= scanner.nextInt();
								System.out.println("Enter the Author Name :");
								String reqAuthor = scanner.next();

								BookBean bean5 = new BookBean();
								bean5.setId(reqId);
								bean5.setAuthor(reqAuthor);
								boolean requested = service1.requestBook(reqId, reqAuthor);
								if (requested != false) {
									System.out.println("Book is Requested");
								} else {
									System.out.println("Book is not Requested");
								}	
								break;
							case 7:
								System.out.println("Enter the Book Requested_id :");
								int returnId= scanner.nextInt();

								BookBean bean6 = new BookBean();
								bean6.setId(returnId);

								boolean returned = service1.returnBook(returnId);
								if (returned != false) {
									System.out.println("Book is Requested");
								} else {
									System.out.println("Book is not Requested");
								}	
								break;
							case 8:
								doReg();
							default:
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
		}while(true);

	}

}