package com.capgemini.librarymanagement.controller;

import java.util.Scanner;

import com.capgemini.librarymanagement.dto.BookBean;
import com.capgemini.librarymanagement.factory.BookFactory;
import com.capgemini.librarymanagement.service.BookService;

public class BookController {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BookService service = BookFactory.getBookService();
		System.out.println("Press 1 to add book");
		System.out.println("press 2 to issue book");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Enter ID");
			int regID = scanner.nextInt();
			System.out.println("Enter Name");
			String regName = scanner.next();
			System.out.println("Enter Author");
			long regAuthor = scanner.nextLong();
			System.out.println("Enter Category");
			String regCategory = scanner.next();
			System.out.println("Enter Publisher Name");
			String regPublishername = scanner.next();
			
			BookBean bean = new BookBean();
	
			break;

		default:
			break;
		}
		
	}
}
