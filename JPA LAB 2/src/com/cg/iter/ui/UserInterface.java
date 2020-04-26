package com.cg.iter.ui;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.cg.iter.entity.Book;
import com.cg.iter.exception.BookAuthorException;
import com.cg.iter.service.BookAuthorService;
import com.cg.iter.service.BookAuthorServiceImpl;


public class UserInterface {

	public static void main(String[] args) throws BookAuthorException{
		// TODO Auto-generated method stub
		do {
			BookAuthorService service=new BookAuthorServiceImpl();
			Scanner sc= new Scanner(System.in);
			int choice = 0;
			
				choice = getChoice(sc);
				switch (choice) {
				case 1:
					
					List<Book> bookList=service.getAllBooksDetail();
					System.out.println("Book Details:");
					System.out.println(bookList);
					break;
				
				case 2:
					
					try {
						System.out.println("Enter Author Name:");
						String authorName=sc.next();
						List<Book> bookByAuthor;
						bookByAuthor = service.getAllBookByAuthor(authorName);
						System.out.println(bookByAuthor);
					} catch (BookAuthorException e1) {
						// TODO Auto-generated catch block
						System.out.println("No books exist with given author name");
					} catch ( InputMismatchException e) {
						System.out.println("Enter valid input");
					}
					
					break;
					
				case 3:
					
					try {
						List<Book> bookByPriceRange;
						System.out.println("Enter min price");
						int minPrice=sc.nextInt();
						System.out.println("Enter max price");
						int maxPrice=sc.nextInt();
						bookByPriceRange = service.getAllBooksInRange(minPrice, maxPrice);
						System.out.println("Book Details:");
						System.out.println(bookByPriceRange);
					} catch (BookAuthorException e) {
						// TODO Auto-generated catch block
						System.out.println("No books exist within given range");
					} catch ( InputMismatchException e) {
						System.out.println("Enter valid input");
					}
					
					
					break;
					
				case 4:
					
					try {
						System.out.println("Enter book ISBN");
						int isbn= sc.nextInt();
						String author;
						author = service.getAuthorsByISBN(isbn);
						System.out.println("Book isbn: "+isbn);
						System.out.println("Author Name :"+author);
					} catch (BookAuthorException e) {
						// TODO Auto-generated catch block
						System.out.println("please enter a valid isbn");
					}	catch ( InputMismatchException e) {
						System.out.println("Enter valid input");
					}
					
					break;
					
				case 5:
					
					System.out.println("Exiting..");
					System.exit(0);
					break;
					
				default:
					System.out.println("Please choose valid option ");
					break;	
				}
			}while(true);
	}
	
		
			private static int getChoice(Scanner sc) {
				int choice = 0;
			System.out.println("Enter your option");
			System.out.println("1-All books");
			System.out.println("2-All books written by given author name");
			System.out.println("3-All books in particular price range");
			System.out.println("4-Author Name by book id");
			System.out.println("5-Exit");
			try {
				choice = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Enter valid choice");
				sc.hasNextLine();
			}
			return choice;
	}
}


