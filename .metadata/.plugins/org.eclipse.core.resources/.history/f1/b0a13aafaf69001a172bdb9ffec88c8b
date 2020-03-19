package com.capgemini.librarymanagement.controller;

import java.util.Scanner;

import com.capgemini.librarymanagement.dto.StudentBean;
import com.capgemini.librarymanagement.factory.StudentFactory;
import com.capgemini.librarymanagement.service.StudentService;

public class StudentController {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StudentService service = StudentFactory.getStudentService();
		do {
			System.out.println("Press 1 to Register");
			System.out.println("Press 2 to Login");
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
					StudentBean studentBean = service.auth(email, password);
					System.out.println("Logged in");
				} catch (Exception e) {
					System.out.println("Invalid Credentials");
				}
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
		} while(true);
	}
}
