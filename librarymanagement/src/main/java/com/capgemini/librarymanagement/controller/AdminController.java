package com.capgemini.librarymanagement.controller;

import java.util.Scanner;

import com.capgemini.librarymanagement.dao.AdminDAO;
import com.capgemini.librarymanagement.dao.AdminDAOImp;
import com.capgemini.librarymanagement.dto.AdminBean;
import com.capgemini.librarymanagement.dto.BookBean;
import com.capgemini.librarymanagement.factory.AdminFactory;
import com.capgemini.librarymanagement.service.AdminService;


public class AdminController {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		AdminService service = AdminFactory.getAdminService();
		do{
			System.out.println("Press 1 to Register");
			System.out.println("Press 2 to Login");
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
				} catch (Exception e) {
					System.out.println("Invalid Credentials");
				}
				break;
				
			default:
				System.out.println("Invalid Choice");
				break;
			}
		}while(true);	
	}
}