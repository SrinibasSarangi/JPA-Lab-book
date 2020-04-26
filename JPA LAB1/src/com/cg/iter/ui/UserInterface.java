package com.cg.iter.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.cg.iter.entity.Author;
import com.cg.iter.service.AuthorService;
import com.cg.iter.service.AuthorServiceImpl;

public class UserInterface {

	public static void main(String[] args) {
		do {
		AuthorService service = new AuthorServiceImpl();
		Scanner sc = new Scanner(System.in);
		int choice = 0;
			choice = getChoice(sc);
			switch (choice) {
			case 1:
				Author author;	
					author = new Author();
					System.out.println("Enter First Name :");
					author.setFirstName(sc.next());
					System.out.println("Enter Middle Name");
					author.setMiddleName(sc.next());
					System.out.println("Enter Last Name");
					author.setLastName(sc.next());
					System.out.println("Enter Phone number");
					author.setPhoneNo(sc.nextLong());
					
					boolean success = service.create(author);
					if(success)
						System.out.println("Author added");
					else
						System.out.println("Could not add author");
					break;
			
			case 2:
				int id;
				
					System.out.println("Update Author !");
					System.out.println("Enter Author ID :");
					id = sc.nextInt();
					author = service.findauthor(id);
					if(author != null) {
						System.out.println("Author exist");
					System.out.println(author.toString());
					
					author.setAuthorId(author.getAuthorId());
					System.out.println("Enter First Name :");
					author.setFirstName(sc.next());
					System.out.println("Enter Middle Name");
					author.setMiddleName(sc.next());
					System.out.println("Enter Last Name");
					author.setLastName(sc.next());
					System.out.println("Enter Phone number");
					author.setPhoneNo(sc.nextLong());
					
					Author update = service.update(author);
					if(update!=null)
						System.out.println("Author Updated");
					else
						System.out.println("Could not update author");
					}
					
				
				break;
					
			case 3:
				
				try {
					System.out.println("Enter Author ID :");
					id = sc.nextInt();
					boolean delete = service.deleteauthor(id);
					if(delete)
						System.out.println("Author deleted");
					else
						System.out.println("Could not delete author");
					
				} catch (InputMismatchException e) {
					
					System.out.println("Enter valid data");
				}
				break;
				
			case 4:
				
				System.out.println("Exiting...");
				System.exit(0);
				break;
				
			default:
				System.out.println("Enter 1-5 only");
				break;
			}
		}while(true);

	}	
	private static int getChoice(Scanner sc) {
		int choice = 0;
		System.out.println("----MENU------");
		System.out.println("1) Add New Author");
		System.out.println("2) Update Author");
		System.out.println("3) Delete Author");
		System.out.println("4) Exit");
		System.out.println(" * * Enter your choice * *");
		try {
			choice = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Enter valid choice");
			sc.hasNextLine();
		}
		return choice;
	}
}
