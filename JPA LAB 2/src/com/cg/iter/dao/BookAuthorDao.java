package com.cg.iter.dao;

import java.util.List;

import com.cg.iter.entity.Book;
import com.cg.iter.exception.BookAuthorException;


public interface BookAuthorDao {

	List<Book> getAllBookDetails() throws BookAuthorException;

	List<Book> getAllBooksByAuthor(String authorName) throws BookAuthorException;

	List<Book> getAllBooksInRange(int minPrice,int maxPrice) throws BookAuthorException;

	String getAuthorsByISBN(int isbn) throws BookAuthorException;

}
